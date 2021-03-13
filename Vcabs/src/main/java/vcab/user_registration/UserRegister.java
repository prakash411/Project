package vcab.user_registration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
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

import vcab.user_profile.*;
/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
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
		
		
		UMember member = new UMember(uname, phone, email, password);
		
		UserRegisterDao rDao = new UserRegisterDao();
		int result = rDao.insert(member);
		PrintWriter out = response.getWriter();
		if(result==1)
		{
			out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
			out.println("<jsp:include page=\"html\\head_tag.html\"></jsp:include>");
			out.println("<script type=\"text/javascript\">");
			out.println("swal(\"Registerd succesfully!\", \"Now you can login..\", \"success\");");
			out.println("</script>");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
			
		}
		else
		{
			out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
			out.println("<jsp:include page=\"html\\head_tag.html\"></jsp:include>");
			out.println("<script type=\"text/javascript\">");
			out.println("swal(\"You are already registered!\", \"\", \"error\");");
			out.println("</script>");
			RequestDispatcher rd=request.getRequestDispatcher("user_register.jsp");
			rd.include(request, response);
			
		}
	}

}
