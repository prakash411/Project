package vcab.feedback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import vcab.dbconnection.DbConnection;

public class FeedbackDao {
	
	
	
	

	public boolean insert(String name, String contact, String experience, String comments) {

		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
		String sql = "INSERT INTO feedback" +
	            "  (name, phone,experience, comments) VALUES " +
	            " (?,?,?,?);";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,name );
			ps.setString(2,contact);
			ps.setString(3,experience );
			ps.setString(4,comments);
			ps.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
}
