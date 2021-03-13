package vcab.booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Booking
 */
@WebServlet("/Booking")
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Booking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		BookingDao rDao=new BookingDao();
		PrintWriter out = response.getWriter();
		
		Float lat=Float.parseFloat(request.getParameter("lat"));
		Float lng=Float.parseFloat(request.getParameter("lng"));
		try {
			Float amount=Float.parseFloat(request.getParameter("amount"));
			session.setAttribute("amt",amount);

			int type = Integer.parseInt(request.getParameter("cartype"));
			String cartype="";
			String pickup = request.getParameter("pickup");
			String destination = request.getParameter("destination");
			session.setAttribute("pickup",pickup);
			session.setAttribute("destination",destination);
			
			if(type==10)
				cartype="micro";
			else if(type==11)
				cartype="mini";
			else
				cartype="prime";
			
			if(session.getAttribute("Uname")==null) {
				out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
				out.println("<jsp:include page=\"html\\head_tag.html\"></jsp:include>");
				out.println("<script type=\"text/javascript\">");
				out.println("swal(\"User should login before Booking\", \"Now login..\", \"info\");");
				out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
			else {
				String name=session.getAttribute("Uname").toString();
				String phone=session.getAttribute("Uphone").toString();
				List<String> l=rDao.findDriver(lat,lng,cartype);
				if(l.isEmpty()==false) {
					rDao.book(name,phone,pickup,destination,cartype,amount/100,l.get(0));
					session.setAttribute("UDname",l.get(0));
					session.setAttribute("UDphone",l.get(1));
					session.setAttribute("UDemail",l.get(2));
					session.setAttribute("UDvpn",l.get(3));
					int booking_id=rDao.bookId(name);
					session.setAttribute("booking_id",booking_id);
					System.out.println(booking_id);
					response.sendRedirect("payment.jsp");
				}
				else
					{
						out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
						out.println("<jsp:include page=\"html\\head_tag.html\"></jsp:include>");
						out.println("<script type=\"text/javascript\">");
						out.println("swal(\"Sorry... Nearest Driver Not Found For Your Searching\", \"Try Again...\", \"info\");");
						out.println("</script>");
						RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
						rd.include(request, response);
						
					}
			}
		}
		catch (NumberFormatException e) {
			out.println("<script>window.alert(\"Please select car type from the dropdown list.\");</script>");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		
	}

}
