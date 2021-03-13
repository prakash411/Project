package vcab.login;
import vcab.driver_registration.DMember;
import vcab.dbconnection.DbConnection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;



public class DriverLoginDao {

	
	public List<DMember> validate(LoginMembers member) {
		
		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
		String sql = "SELECT name,phone,email,vehicle_plate_number,password FROM drivers where phone=? and password=? ";
		PreparedStatement ps;
		ResultSet rs=null;
		List<DMember> users = new ArrayList<DMember>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getUser_id());
			ps.setString(2, member.getPassword());
			rs = ps.executeQuery();
			if(rs.next()) {
		        users.add(new DMember( rs.getString("name"), rs.getString("phone"), rs.getString("email"),rs.getString("vehicle_plate_number"), rs.getString("password")));
		     }
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	}
}