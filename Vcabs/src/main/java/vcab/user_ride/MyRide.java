package vcab.user_ride;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * Servlet implementation class aaa
 */
@WebServlet("/MyRide")
public class MyRide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyRide() {
        super();
        // TODO Auto-generated constructor stub
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
		String sql = "SELECT asigned_driver FROM booking where user_name=? and service='started'";
////	String sql = "SELECT drivers.name, drivers.phone, drivers.vehicle_plate_number, drivers.dp, drivers.lat, drivers.lng FROM drivers where booking.user_name=? and  booking.service='started' ";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setNString(1,session.getAttribute("Uname").toString());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{	
				session.setAttribute("UDname",rs.getString(1));
					String sql2 = "SELECT drivers.phone, drivers.vehicle_plate_number,booking.pickup,booking.destination FROM drivers,booking where drivers.name=? ";
					PreparedStatement ps2;
					try {
						ps2 = con.prepareStatement(sql2);
						ps2.setNString(1,session.getAttribute("UDname").toString());
						ResultSet rs2 = ps2.executeQuery();
						if(rs2.next())
						{					
										session.setAttribute("UDphone",rs2.getString(1));
										session.setAttribute("UDvpn",rs2.getString(2));
										session.setAttribute("pickup",rs2.getString(3));
										session.setAttribute("destination",rs2.getString(4));
						}
						else {
							session.setAttribute("UDphone","");
							session.setAttribute("UDvpn","");
							session.setAttribute("pickup","");
							session.setAttribute("destination","");
						}
					} 
					catch (SQLException e) {
						e.printStackTrace();
					}
				
			}
			else {
				session.setAttribute("UDname","");
				session.setAttribute("UDphone","");
				session.setAttribute("UDvpn","");
				session.setAttribute("pickup","");
				session.setAttribute("destination","");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			out.print(session.getAttribute("Uname").toString());
		}
		
//		out.print(session.getAttribute("UDname").toString());
		RequestDispatcher rd=request.getRequestDispatcher("paysuccess.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
