<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="html\head_tag.html"></jsp:include>
		<link rel="stylesheet" href="css/Dindex.css">
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDUDiKPR7wO3UOt09Ve0vUct5nq_h00828&libraries=places&callback=initMap2" async defer></script>
		<script type="text/javascript">
		
			var pickup = '<%= session.getAttribute("pickup").toString() %>';  
			localStorage.setItem("pickup", pickup); 
			
			var destination = '<%= session.getAttribute("destination").toString() %>';  
			localStorage.setItem("destination", destination); 
			
			var lat = '<%= session.getAttribute("lat") %>';  
			localStorage.setItem("lat", lat); 
			
			var lng = '<%= session.getAttribute("lng") %>';  
			localStorage.setItem("lng", lng); 
			
		</script>
		<script src="js/user_direction.js"></script>
	</head>
	<body>
			
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");  
			response.setHeader("Pragma", "no-cache"); 
			response.setHeader("Expires", "0");
			PrintWriter ob= response.getWriter();
			String name="";
			if(session.getAttribute("Dname")==null)
			{
				ob.print("<style type=\"text/css\">#logout{display: none;} #Uprofile{display: none;} #ride{display: none;} </style>");
			}
			else
			{
				ob.print("<style type=\"text/css\">#slogin{height: 0px;padding-top: 0px; display:none; } #Uprofile{display: none;} #ride{display: none;} #login{display: none;} #register{display: none;}</style>");
				ob.print("<style type=\"text/css\">#items{ margin: 5px 3px -9px 0;}</style>");
				name=session.getAttribute("Dname").toString();
			}
		%>
		<jsp:include page="html\navbar.html"></jsp:include>
		<div id="driv" class="vh-100">
			
				<h1 class="mes">
					<%=name %><br>
					Let's Get Start	
				</h1>
			
			<div class="container-fluid vh-100 bg-window"  >
				<div class="row  ">
					<div class="col-sm-6" id="Dcard">			
						<div class="card  rounded   ">
							<div class="card-header text-center">
				            	<h3 class="">Your current customer</h3>
				        	</div>
				       		<div class="card-body">
				       			<div class="form-group" style="margin-top: 15px;">
									<div class="col-auto ">
										<strong> <i class="fas fa-user" style="color: RGB(255,173,96);"></i> Customer Name : <%=session.getAttribute("DUname") %></strong>
									</div>
								</div>	
								<div class="form-group" style="margin-top: 15px;">
									<div class="col-auto">
										<strong> <i class="fas fa-phone" style="color: blue;"></i> Contact : <%=session.getAttribute("DUphone") %></strong>
									</div>
								</div>	
								<div class="form-group" style="margin-top: 15px;">
									<div class="col-auto">
										<strong> <i class="fas fa-map-marker-alt" style="color: green;"></i> Pickup Location: <%=session.getAttribute("pickup") %></strong>
									</div>
								</div>
								<div class="form-group" style="margin-top: 15px;">
									<div class="col-auto">
										<strong> <i class="fas fa-map-marker-alt" style="color: red;"></i> Drop Location: <%=session.getAttribute("destination") %></strong>
									</div>
								</div>
								<div class="form-group" style="margin-top: 15px;">
									<div class="col-auto">
										<strong> <i class="fas fa-comment-dots" style="color: brown;"></i> User OTP: <%=session.getAttribute("otp") %></strong>
									</div>
								</div>
								<form action="ServiceCompletion"  method="post">
									<input type="hidden" name="Dlat" id="Dlat" value="" />
									<input type="hidden" name="Dlng" id="Dlng" value="" />
									<button type="submit" class="btn btn-success btn-lg float-right mr-3" name="submit" id="Completed">Completed</button>
								</form>								
				   			</div>				   			
				   		</div>				   		
					</div>
					<div class="col col-sm-6 ">
						<button  class="btn pdi" id="demo">Drop</button>
						<div class="container shadow shadow-sm mt-2 " id="map" style="width:100%;height:400px;margin-bottom: 15px;"></div>
					 </div>
				</div>
				
			</div>
			<div class="foot">
					<jsp:include page="html\footer.html"></jsp:include>
				</div>
		</div>
		
		<script type="text/javascript">
		var temp = false;
		  
		  $(".pdi").on("click", function(){
		    if(!temp){
		      temp = true;
		       initMap();
		      $('.pdi').text('Pickup')
		    } 
		    else{
		      temp = false;
		      $('.pdi').text('Drop')
		      initMap2();
		    } 
		    return false;
		  });
		</script>
	</body>
	
</html>