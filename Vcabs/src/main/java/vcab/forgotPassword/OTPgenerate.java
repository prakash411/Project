package vcab.forgotPassword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.SplittableRandom;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class OTPgenerate
 */
@WebServlet("/OTPgenerate")
public class OTPgenerate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String otp="";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OTPgenerate() {
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
		String num=request.getParameter("phone");
		session.setAttribute("phone",num);
		SplittableRandom sp=new SplittableRandom();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<5;i++) {
			sb.append(sp.nextInt(0,10));
		}
		otp=sb.toString();
		System.out.print(otp);
		//OTPgenerate.sendotp(num);		
		session.setAttribute("otp",otp);
		RequestDispatcher rd=request.getRequestDispatcher("OTPverify.jsp");
		rd.include(request, response);
	}
	
//	public static void sendotp(String num) {
//		try {
//			   String apiKey = "apiKey=" + "f85PxvRSC5I-R2rPtNZfWMnoZ7IqNEGbSll2vIOmM9";
//			   
//			   String message = "&message=" + URLEncoder.encode("Your OTP is " + otp,"UTF-8");
//			   
//			   String numbers = "&numbers=" + num;
//			   
//			   String apiURL = "https://api.textlocal.in/send/?" + apiKey + message + numbers;
//			   
//			   URL url = new URL(apiURL);
//			   URLConnection connection = url.openConnection();
//			   connection.setDoOutput(true);
//			   
//			   BufferedReader reader = new BufferedReader(new 
//			     InputStreamReader(connection.getInputStream()));
//			   
//			   String line = "";
//			   StringBuilder sb = new StringBuilder();
//			   
//			   while ( (line = reader.readLine()) != null) {
//			    sb.append(line).append("\n");
//			   }
//			   
//			   System.out.println(sb.toString());
//			   
//		} catch (Exception e) {
//			   e.printStackTrace();
//		}
//	}
}
