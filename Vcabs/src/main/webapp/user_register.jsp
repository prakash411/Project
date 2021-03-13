<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="html\head_tag.html"></jsp:include>
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/user_registration.css">
		<script src="js/form_valid.js"></script>
		<style type="text/css">
			#logout{
				display: none;
			}
			#ride{display: none;}
			#Uprofile{display: none;}
			#Dprofile{display: none;}
		</style>
	</head>
	<body>
		<jsp:include page="html\navbar.html"></jsp:include>
		<jsp:include page="html\user_register.html"></jsp:include>		
	</body>
</html>