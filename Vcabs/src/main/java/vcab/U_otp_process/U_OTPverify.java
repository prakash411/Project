package vcab.U_otp_process;

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
 * Servlet implementation class OTPverify
 */
@WebServlet("/U_OTPverify")
public class U_OTPverify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public U_OTPverify() {
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
		
		PrintWriter out = response.getWriter();
		HttpSession session =request.getSession();
		
		int Gotp=Integer.parseInt(session.getAttribute("otp").toString());
		int Uotp=Integer.parseInt(request.getParameter("Uotp").toString());
		if(Gotp==Uotp){
			RequestDispatcher rd=request.getRequestDispatcher("UserRegister");  
	        // rd.forward(request, response);
//			RequestDispatcher rd=request.getRequestDispatcher("changePassword.jsp");
			rd.include(request, response);
		}
		else {
			out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
			out.println("<jsp:include page=\"html\\head_tag.html\"></jsp:include>");
			out.println("<script type=\"text/javascript\">");
			out.println("swal(\"Entered OTP is Invalid\", \"try again..\", \"error\");");
			out.println("</script>");
			RequestDispatcher rd=request.getRequestDispatcher("U_OTPverify.jsp");
			rd.include(request, response);
		}
	}

}
