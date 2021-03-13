package vcab.driver_registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class DriverRegister
 */
@WebServlet("/DriverRegister")
public class DriverRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverRegister() {
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
		
		String uname = session.getAttribute("uname").toString();
		String phone = session.getAttribute("phone").toString();
		String email = session.getAttribute("email").toString();
		String password = session.getAttribute("pwd1").toString();
		String vpn = session.getAttribute("vpn").toString();
		
		
		DMember member = new DMember(uname, phone, email,vpn, password);
		
		DriverRegisterDao rDao = new DriverRegisterDao();
		int result = rDao.insert(member);
		PrintWriter out = response.getWriter();
		if(result==1)
		{
			out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
			out.println("<jsp:include page=\"html\\head_tag.html\"></jsp:include>");
			out.println("<script type=\"text/javascript\">");
			out.println("swal(\"Registerd succesfully!\", \"We will shortly contact you for verification process..\", \"success\");");
			out.println("</script>");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		else
		{
			out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
			out.println("<jsp:include page=\"html\\head_tag.html\"></jsp:include>");
			out.println("<script type=\"text/javascript\">");
			out.println("swal(\"You are already registered!\", \"try again..\", \"error\");");
			out.println("</script>");
			RequestDispatcher rd=request.getRequestDispatcher("driver_register.jsp");
			rd.include(request, response);
		}
	}

}
