package vcab.driver_profile;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;



/**
 * Servlet implementation class DriverProfile
 */

@WebServlet("/DriverProfile")
@MultipartConfig(maxFileSize = 16177215) 
public class DriverProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverProfile() {
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
		String name = request.getParameter("uname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("pwd1");
		String vpn = request.getParameter("vpn");
		
		Part filePart = request.getPart("dp");
		InputStream inputStream = null; 
		if (filePart.getSize() != 0) {
        	inputStream = filePart.getInputStream();
        }
		DpMember member = new DpMember(name, phone, email,password,vpn);
		
		DriverProfileDao rDao = new DriverProfileDao();
		int result = rDao.update(member,inputStream);
		
		if(result==1)
		{
			HttpSession session =request.getSession();
			session.setAttribute("Dname",name);
			session.setAttribute("Dphone",phone);
			session.setAttribute("Demail",email );
			session.setAttribute("Dvpn",vpn );
			out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
			out.println("<jsp:include page=\"html\\head_tag.html\"></jsp:include>");
			out.println("<script type=\"text/javascript\">");
			out.println("swal(\"Profile succesfully Updated!\", \"\", \"success\");");
			out.println("</script>");
			
			RequestDispatcher rd=request.getRequestDispatcher("DriverProfile.jsp");
			rd.include(request, response);
			
		}
		else
		{
			out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
			out.println("<jsp:include page=\"html\\head_tag.html\"></jsp:include>");
			out.println("<script type=\"text/javascript\">");
			out.println("swal(\"Profie Updation Fail\", \"\", \"error\");");
			out.println("</script>");
			RequestDispatcher rd=request.getRequestDispatcher("DriverProfile.jsp");
			rd.include(request, response);
			
		}
	}

}
