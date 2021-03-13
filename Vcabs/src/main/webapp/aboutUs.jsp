<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="html\head_tag.html"></jsp:include>
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/login_style.css">
		<link rel="stylesheet" href="css/aboutUs.css">
	</head>
	<body>
		<%
			PrintWriter ob= response.getWriter();
			if(session.getAttribute("Uname")==null || session.getAttribute("Dname")!=null)
			{
				ob.print("<style type=\"text/css\">#logout{display: none;} #Uprofile{display: none;} #ride{display: none;} #Dprofile{display: none;}</style>");
			}
			else
			{
				ob.print("<style type=\"text/css\">#slogin{height: 0px;padding-top: 0px; display:none; } #Dprofile{display: none;}  #login{display: none;} #register{display: none;}</style>");
				ob.print("<style type=\"text/css\">#items{ margin: 5px 3px -9px 0;} </style>");
				String name=session.getAttribute("Uname").toString();
			}
		%>
		<jsp:include page="html\navbar.html"></jsp:include>
		<jsp:include page="html\aboutUs.html"></jsp:include>
	</body>
</html>