package vcab.forgotPassword;

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

import com.mysql.cj.Session;

import vcab.dbconnection.DbConnection;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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
		String password = request.getParameter("pwd1").toString();
		String phone = session.getAttribute("phone").toString();
		int UChange=ChangePassword.UChange(password,phone);
		if(UChange==1) {
			
			out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
			out.println("<jsp:include page=\"html\\head_tag.html\"></jsp:include>");
			out.println("<script type=\"text/javascript\">");
			out.println("swal(\"Password Reset Succesfully..\", \"Now Login\", \"success\");");
			out.println("</script>");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		else {
			
			int DChange=ChangePassword.DChange(password,phone);
			if(DChange==1){
				out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
				out.println("<jsp:include page=\"html\\head_tag.html\"></jsp:include>");
				out.println("<script type=\"text/javascript\">");
				out.println("swal(\"Password Reset Succesfully..\", \"Now Login\", \"success\");");
				out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
			else {
				out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
				out.println("<jsp:include page=\"html\\head_tag.html\"></jsp:include>");
				out.println("<script type=\"text/javascript\">");
				out.println("swal(\"This User Not Registered Yet..\", \"\", \"error\");");
				out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
		}
		doGet(request, response);
	}

	public static int UChange(String password, String phone) {
		
		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
		String sql = "UPDATE users SET password =? WHERE phone=? ;";
		PreparedStatement ps;
		int rs=0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,password);
			ps.setString(2, phone);
			rs = ps.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;		
	}
	public static int DChange(String password, String phone) {
		
		DbConnection db_obj=new DbConnection();
		db_obj.loadDriver();
		Connection con = db_obj.getConnection();
		String sql = "UPDATE drivers SET password =? WHERE phone=? ;";
		PreparedStatement ps;
		int rs=0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,password);
			ps.setString(2, phone);
			rs = ps.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;		
	}
}
