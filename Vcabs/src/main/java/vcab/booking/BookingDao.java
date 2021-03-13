package vcab.booking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import vcab.dbconnection.DbConnection;

public class BookingDao {
	
	
	
	
		
	public List<String> findDriver(Float lat, Float lng,String cartype) {
		
		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
		 List<String> l=new ArrayList<String>(); 
		String sql = "SELECT name,phone,email,vehicle_plate_number,dp,( 3959 * acos( cos( radians(?) ) * cos( radians( lat ) ) * cos( radians( lng ) - radians(?) ) + sin(radians(?)) * sin(radians(lat)))) AS distance FROM drivers where status='free' and vehicle_type=?  HAVING distance < 25 ORDER BY distance  LIMIT 0, 1 ;";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setFloat(1, lat);
			ps.setFloat(2, lng);
			ps.setFloat(3, lat);
			ps.setString(4, cartype);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				l.add(rs.getString(1));
				l.add(rs.getString(2));
				l.add(rs.getString(3));
				l.add(rs.getString(4));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	public boolean book(String name,String phone,String pickup, String destination,String cartype, Float amount, String Drivname) {
		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
		String sql = "INSERT INTO booking" +
	            "  (user_name,user_phone, pickup, destination,car_type, amount,asigned_driver) VALUES " +
	            " (?,?,?,?,?,?,?);";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,phone);
			ps.setString(3,pickup);
			ps.setString(4,destination);
			ps.setString(5,cartype);
			ps.setFloat(6, amount);
			ps.setString(7,Drivname);
			ps.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}

	public int bookId(String name) {
		int id = 0;
		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
		String sql = "SELECT booking_id FROM booking where user_name=? ;";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} 
		return id;
	}
	
}
