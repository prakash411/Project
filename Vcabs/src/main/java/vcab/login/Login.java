package vcab.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vcab.user_registration.UMember;
import vcab.driver_registration.DMember;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		// TODO Auto-generated method stub
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("pwd1");
		
		LoginMembers member = new LoginMembers(user_id,password);
		
		UserLoginDao UDao= new UserLoginDao();
		DriverLoginDao DDao= new DriverLoginDao();
		List<UMember> users=UDao.validate(member);
		List<DMember> driver=DDao.validate(member);
		PrintWriter out = response.getWriter();
		if(users.isEmpty()==false)
		{
			HttpSession session =request.getSession();
			for(UMember t:users){ 
				session.setAttribute("Uname",t.getUname());
				session.setAttribute("Uphone", t.getPhone());
				session.setAttribute("Uemail", t.getEmail());
			}
			response.sendRedirect("index.jsp");
		}
		else if(driver.isEmpty()==false)
		{
			HttpSession session =request.getSession();
			for(DMember t:driver){ 
				session.setAttribute("Dname",t.getUname());
				session.setAttribute("Dphone", t.getPhone());
				session.setAttribute("Demail", t.getEmail());
				session.setAttribute("Dvpn",t.getVpn());
			}
			response.sendRedirect("Dindex");
		}
		else
		{
			out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
			out.println("<jsp:include page=\"html\\head_tag.html\"></jsp:include>");
			out.println("<script type=\"text/javascript\">");
			out.println("swal(\"Invalid User_ID or Password!\", \"try again..\", \"error\");");
			out.println("</script>");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}

}
