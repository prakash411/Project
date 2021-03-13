package vcab.user_profile;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.MultipartConfig;

import vcab.dbconnection.DbConnection;

@MultipartConfig(maxFileSize = 16177215) 
public class UserProfileDao {
	
	
	
	
	
	public int update(UpMember member,InputStream inputStream)
	{
		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
		int result = 1;
		System.out.println(inputStream);
		if (inputStream != null) {
			String sql = "update users set name=? ,email=?,dp=? where password=? ;";
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, member.getUname());
				ps.setString(2, member.getEmail());
				ps.setBlob(3, inputStream);
				ps.setString(4, member.getPassword());				
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
			String sql = "update users set name=? ,email=? where password=? ;";
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, member.getUname());
				ps.setString(2, member.getEmail());
				ps.setString(3, member.getPassword());
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
