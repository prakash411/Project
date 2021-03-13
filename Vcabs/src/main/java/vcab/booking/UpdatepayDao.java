package vcab.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import vcab.dbconnection.DbConnection;

public class UpdatepayDao {
	
	private String dbDriver = "com.mysql.jdbc.Driver";
	
	public boolean PayStatus(int booking_id,int otp) {
		
		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
		String sql = "update booking set payment_status='PaySuccess',service='started',otp=? where booking_id=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,otp);
			ps.setInt(2,booking_id);
			ps.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}
	
	public boolean DriverStatus(String name,String status) {
		
		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
		String sql = "update drivers set status=? where name=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,status);
			ps.setString(2,name);
			ps.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}
}
