<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
	<body>
		<%
			PrintWriter ob= response.getWriter();
			String name="";
			if(session.getAttribute("Uname")==null)
			{
				
			}
			else
			{
				name=session.getAttribute("Uname").toString().toUpperCase();
			}
		%>
		<div class="container-fluid" >
			<div class="row flex-nowrap ">
					<jsp:include page="html\sidnav.html"></jsp:include>
					<main class="col-lg pl-0 pr-0" id="main">
					<div class="container-fluid shadow shadow-sm" id="homecon">
						<h1 class="mes">
							<%=name %><br>
							WE ARE ALWAYS THERE <br>AT YOUR SERVICE
						</h1>
					</div>	
					<jsp:include page="html\booking.html"></jsp:include>			
					<jsp:include page="html\aboutUs.html"></jsp:include>
					<jsp:include page="html\testimonial.html"></jsp:include>	
					<jsp:include page="html\footer.html"></jsp:include>
				</main>
			 </div>
		</div>
	</body>
</html>