<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="html\head_tag.html"></jsp:include>
		<link rel="stylesheet" href="css/login_style.css">
		<script src="js/form_valid.js"></script>
		<%
			PrintWriter ob= response.getWriter();
			if(session.getAttribute("Uname")==null)
			{
				ob.print("<link rel=\"stylesheet\" href=\"css/style.css\">");
				ob.print("<style type=\"text/css\">#logout{display: none;} #Uprofile{display: none;} #ride{display: none;} #Dprofile{display: none;}</style>");
			}
			else
			{
				ob.print("<link rel=\"stylesheet\" href=\"css/style.css\">");
				ob.print("<style type=\"text/css\">#slogin{height: 0px;padding-top: 0px; display:none; }  #login{display: none;} #register{display: none;}</style>");
				String name=session.getAttribute("Uname").toString();
			}
		%>
	</head>
	<body>
		<jsp:include page="html\navbar.html"></jsp:include>
		<jsp:include page="html\login.html"></jsp:include>
		
	</body>
</html>