package vcab.user_profile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vcab.dbconnection.DbConnection;

/**
 * Servlet implementation class Udp
 */
@WebServlet("/Udp")
public class Udp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =req.getSession();
		System.out.print(session.getAttribute("Uname").toString());
		byte[] img=null;
		ServletOutputStream sos=null;
		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
		String sql = "select dp from users where name=?;";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,session.getAttribute("Uname").toString());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				img=rs.getBytes(1);
			}
			sos=resp.getOutputStream();
			sos.write(img);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
