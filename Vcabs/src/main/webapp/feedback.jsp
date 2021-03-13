<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="html\head_tag.html"></jsp:include>
		<link rel="stylesheet" href="css/paysuccess.css">
	</head>
	<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache"); 
			response.setHeader("Expires", "0"); 
			String name="",phone="",email="";
			PrintWriter obj=response.getWriter();
			if(session.getAttribute("Uname")==null){
				obj.println("<style type=\"text/css\"> #logout{display: none;} #Dprofile{display: none;} #Uprofile{display: none;}</style>");
				response.sendRedirect("login.jsp");
			}
			else{
				obj.println("<style type=\"text/css\"> .mobile-new-user{height:0px; padding-top:0px;} #slogin{display: none;}</style>");
				obj.print("<style type=\"text/css\">#login{display: none;} #Dprofile{display: none;} #register{display: none;}</style>");
				obj.print("<style type=\"text/css\">#items{ margin: 5px 3px -9px 0;}</style>");
				name =session.getAttribute("Uname").toString().toUpperCase();
				phone=session.getAttribute("Uphone"). toString();
				email=session.getAttribute("Uemail").toString();
			}								
		%>
		<jsp:include page="html\navbar.html"></jsp:include>
		<jsp:include page="html\feedback.html"></jsp:include>
	</body>
</html>