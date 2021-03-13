<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="html\head_tag.html"></jsp:include>
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/paysuccess.css">
		<style type="text/css">
			@media only screen and (min-width: 1000px) {
				.main{
					background-color: none;	
					background-image: url("images/user_final.jpg");
					background-repeat: no-repeat;
					background-size: 102% 112%;	
				}
			}
		</style>
		
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDUDiKPR7wO3UOt09Ve0vUct5nq_h00828&libraries=places&callback=initMap" async defer></script>
		<script type="text/javascript">
			<%
				String pickup = (String) session.getAttribute("pickup");
				String destination = (String) session.getAttribute("destination");
			%>
			var pickup = '<%=pickup%>';  
			localStorage.setItem("pickup", pickup); 
			var destination = '<%=destination%>';  
			localStorage.setItem("destination", destination);  
			
		</script>
		<script src="js/user_direction.js"></script>
	</head>
	<body class="main bg-success">
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache"); 
			response.setHeader("Expires", "0"); 
			String name="",phone="",email="";
			PrintWriter obj=response.getWriter();
			if(session.getAttribute("Uname")==null){
				obj.println("<style type=\"text/css\"> #logout{display: none;} #Uprofile{display: none;} #Dprofile{display: none;}</style>");
				response.sendRedirect("login.jsp");
			}
			else{
				obj.println("<style type=\"text/css\"> .mobile-new-user{height:0px; padding-top:0px;} #Dprofile{display: none;} #slogin{display: none;}</style>");
				obj.print("<style type=\"text/css\">#login{display: none;} #register{display: none;}</style>");
				obj.print("<style type=\"text/css\">#items{ margin: 5px 3px -9px 0;}</style>");
				name =session.getAttribute("Uname").toString().toUpperCase();
				phone=session.getAttribute("Uphone"). toString();
				email=session.getAttribute("Uemail").toString();
			}								
		%>
		
		<jsp:include page="html\navbar.html"></jsp:include>
		<input type="hidden"  id="origin-input" name="pickup" value="" >
		<input type="hidden"  id="destination-input" name="destination" value="">
		<div class="container-fluid vh-100 bg-window">
			<div class="row  ">
				<div class="col-sm-6 mt-4 ">			
					<div class="card  rounded shadow shadow-sm my-2">
						<div class="card-header text-center">
			            	<h3 class="">Driver Details</h3>
			        	</div>
			       		<div class="card-body">
			       			<img src="./Ddp" width="150" height="100" class="d-block " style="margin: auto;" ></p>
			       			<div class="form-group" style="margin-top: 15px;">
								<div class="col-auto ">
									<strong> <i class="fas fa-user" style="color: RGB(255,173,96);"></i> Driver Name :</strong> <%=session.getAttribute("UDname") %>
								</div>
							</div>	
							<div class="form-group" style="margin-top: 15px;">
								<div class="col-auto">
									<strong> <i class="fas fa-phone" style="color: blue;"></i> Driver Contact :</strong> <%=session.getAttribute("UDphone") %>
								</div>
							</div>	
							<div class="form-group" style="margin-top: 15px;">
								<div class="col-auto">
									<strong> <i class="fas fa-car" style="color: rgb(154,205,50);"></i> Vehicle Number :</strong> <%=session.getAttribute("UDvpn") %>
								</div>
							</div>
			   			</div>
			   		</div>
				</div>			
				<div class="col-sm-6 ">
		        	<div class="container shadow shadow-sm mt-2" id="map" style="width:100%;height:400px;margin-bottom: 15px;">
					</div>
		 		</div>
		 	</div>
			<div class="col ">			
				<div class="card  rounded shadow shadow-sm my-2">            	
		       		<div class="card-body">
						<p>We Hope You will get your ride Fast.</p>
						<p>We Welcome all of your Feedbacks which help us to become better..</p>
						<a href="feedback.jsp" type="button" class="btn btn-success float-right"  data-toggle="tooltip" data-placement="bottom" >Give Feedback</a>
						<p>Thank You</p>
		       		</div>
		      	</div>
			</div>
		</div>
	</body>
</html>