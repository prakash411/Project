package vcab.driver_profile;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.MultipartConfig;

import vcab.dbconnection.DbConnection;
import vcab.driver_registration.DMember;

@MultipartConfig(maxFileSize = 16177215) 
public class DriverProfileDao {
	
	
	
	
	
	public int update(DpMember member,InputStream inputStream)
	{
		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
		int result = 1;
		if (inputStream != null) {
			String sql = "update drivers set name=? ,phone=? ,email=?,vehicle_plate_number=?,dp=? where password=? ;";
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, member.getUname());
				ps.setString(2, member.getPhone());
				ps.setString(3, member.getEmail());
				ps.setString(4, member.getVpn());
				ps.setBlob(5, inputStream);
				ps.setString(6, member.getPassword());
				int i = ps.executeUpdate();
		        if (i > 0) {
		            System.out.println("success");
		        } else {
		        	result=0;
		            System.out.println("stuck somewhere");
		        }
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result=0;
			}
		}
		else {
			String sql = "update drivers set name=? ,phone=? ,email=?,vehicle_plate_number=? where password=? ;";
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, member.getUname());
				ps.setString(2, member.getPhone());
				ps.setString(3, member.getEmail());
				ps.setString(4, member.getVpn());
				ps.setString(5, member.getPassword());
				int i = ps.executeUpdate();
		        if (i > 0) {
		            System.out.println("success");
		        } else {
		        	result=0;
		            System.out.println("stuck somewhere");
		        }
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result=0;
			}
		}
		return result;
	}
}
