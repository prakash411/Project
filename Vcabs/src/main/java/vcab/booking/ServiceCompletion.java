package vcab.booking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vcab.dbconnection.DbConnection;

/**
 * Servlet implementation class ServiceCompletion
 */
@WebServlet("/ServiceCompletion")
public class ServiceCompletion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String dbDriver = "com.mysql.jdbc.Driver";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceCompletion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Float Dlat=Float.parseFloat(request.getParameter("Dlat"));
		Float Dlng=Float.parseFloat(request.getParameter("Dlng"));
		HttpSession session =request.getSession();
		UpdatepayDao rDao=new UpdatepayDao();
		rDao.DriverStatus( session.getAttribute("Dname").toString(),"free");		
		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
		String sql = "update booking,drivers set booking.service='end', drivers.lat=? ,drivers.lng=? where booking.asigned_driver=? and drivers.name=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setFloat(1,Dlat);
			ps.setFloat(2,Dlng);
			ps.setString(3,session.getAttribute("Dname").toString());
			ps.setString(4,session.getAttribute("Dname").toString());
			ps.executeUpdate();
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		response.sendRedirect("Dindex");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
