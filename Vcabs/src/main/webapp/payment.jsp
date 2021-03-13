<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="html\head_tag.html"></jsp:include>
		<link rel="stylesheet" href="css/payment.css">
		<script src="js/json.js"></script>
	</head>
	<body class="img" onload="remove_json()">
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache"); 
			response.setHeader("Expires", "0"); 
			PrintWriter obj=response.getWriter();
			if(session.getAttribute("Uname")==null){
				
				response.sendRedirect("login.jsp");
			}							
		%>
		<div class="container d-flex justify-content-center ">
			
			<div class="content">
			<h5 class=" text-center">It is one step verification for payment...</h5>
			<br>
	    	<p class=" text-center">Razorpay provides all kind's of paymet methods like net banking,<br>card payment,wallet and UPI with QR barcode 
	   		</p>
	   		<h6 class="text-center">Click Pay Button To Continue..</h6><br>
			<form action="Pay" name="myform" id="my_form_id" method="POST" class="text-center">
				<script 
			    src="https://checkout.razorpay.com/v1/checkout.js"
			    data-key="rzp_test_VJOsr36zCNbVYX"
			    data-amount= <%= session.getAttribute("amt") %>
			    data-buttontext="Pay with Razorpay"
			    data-name="Vcab"
			    data-description="Payment Description"
			    data-image="images/car.png"
			    data-prefill.email=<%= session.getAttribute("Uemail") %>
			    data-theme.hide_topbar
			    data-theme.color="green"
				>
				    </script>
			</form>
			</div>
		</div>
	</body>
</html>