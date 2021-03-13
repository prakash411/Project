package vcab.driver_registration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import vcab.dbconnection.DbConnection;
import vcab.user_registration.UMember;


public class DriverRegisterDao {
		
	
		
	
		
		
	public int insert(DMember member) throws IOException
	{
		File image = new File("E:/Project-Back-Up/Vcabs/src/main/webapp/images/driver.PNG");
		FileInputStream fis = new FileInputStream ( image );
		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
		int result = 1;
		String sql = "INSERT INTO drivers" +
		            "  (name, phone, email,vehicle_plate_number, password,dp) VALUES " +
		            " (?,?,?,?,?,?);";
			
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, member.getUname());
		ps.setString(2, member.getPhone());
		ps.setString(3, member.getEmail());
		ps.setString(4, member.getVpn());
		ps.setString(5, member.getPassword());
		ps.setBinaryStream (6,fis,fis.available());
		ps.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
		
}
