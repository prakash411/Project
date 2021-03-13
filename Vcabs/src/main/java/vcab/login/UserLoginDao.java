package vcab.login;
import vcab.dbconnection.DbConnection;
import vcab.user_registration.UMember;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;



public class UserLoginDao {
	
	
	public List<UMember> validate(LoginMembers member) {
		
		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
		String sql = "SELECT name,phone,email,password,dp FROM users where phone=? and password=? ";
		PreparedStatement ps;
		ResultSet rs=null;
		List<UMember> users = new ArrayList<UMember>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getUser_id());
			ps.setString(2, member.getPassword());
			rs = ps.executeQuery();
			if(rs.next()) {
		        users.add(new UMember( rs.getString("name"), rs.getString("phone"), rs.getString("email"), rs.getString("password")));
		     }
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	}
}