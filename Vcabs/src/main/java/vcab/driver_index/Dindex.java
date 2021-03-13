package vcab.driver_index;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vcab.dbconnection.DbConnection;

@WebServlet("/Dindex")
public class Dindex extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dindex() {
        super(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		PrintWriter out = response.getWriter();
		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
			String sql = "SELECT booking.user_name, booking.user_phone, booking.pickup,booking.destination,drivers.lat,drivers.lng,booking.otp FROM booking,drivers where booking.asigned_driver=? and booking.payment_status='PaySuccess' and booking.service='started' and drivers.name=?; ";
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				ps.setNString(1,session.getAttribute("Dname").toString());
				ps.setNString(2,session.getAttribute("Dname").toString());
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					
					session.setAttribute("DUname",rs.getString(1));
					session.setAttribute("DUphone",rs.getString(2));
					session.setAttribute("pickup",rs.getString(3));
					session.setAttribute("destination",rs.getString(4));
					session.setAttribute("lat",rs.getFloat(5));
					session.setAttribute("lng",rs.getFloat(6));
					session.setAttribute("otp",rs.getInt(7));
				}
				else {
					session.setAttribute("DUname","");
					session.setAttribute("DUphone","");
					session.setAttribute("pickup","");
					session.setAttribute("destination","");
					session.setAttribute("lat","");
					session.setAttribute("lng","");
					session.setAttribute("otp","");
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			
				RequestDispatcher rd=request.getRequestDispatcher("Dindex.jsp");
				rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);			
	}

}
