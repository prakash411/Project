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
			@media only screen and (min-width: 1000px) {
				.container-fluid {
				  	background-image: url("images/driver_register.jpg");
					background-repeat: no-repeat;
					background-size: 100% 100%;	
				}
			}
		</style>
	</head>
	<body>
		<jsp:include page="html\navbar.html"></jsp:include>
		<jsp:include page="html\driver_register.html"></jsp:include>
	</body>
</html>