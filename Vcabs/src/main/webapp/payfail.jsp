<%@page import="javax.servlet.RequestDispatcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="html\head_tag.html"></jsp:include>
	</head>
	<body>
		<script type="text/javascript">
			swal("Payment Failed..", "Try Again..", "error");
		</script>
		<% 	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		%>
	</body>
</html>