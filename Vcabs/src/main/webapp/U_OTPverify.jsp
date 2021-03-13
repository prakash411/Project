<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="html\head_tag.html"></jsp:include>
		<style type="text/css">
			body{
				background: #FDFC47;
				background: -webkit-linear-gradient(to left, #24FE41, #FDFC47);  
				background: linear-gradient(to left, #24FE41, #FDFC47);				
			}
		</style>
	</head>
	<body>
		<div class="container-fluid " >
		<div class="col-xl-12 d-flex flex-column justify-content-center mt-5">
			<div class="col-xl-4 col-md-8 mx-auto ">
	        	<div class="card rounded shadow shadow-sm">	            	
	       			<div class="card-body">
	                	<form class="form " role="form" autocomplete="off" id="fg" action="U_OTPverify" method="POST">
	                		<div class="form-group" style="margin-top: 5px;">
							    <div class="col-auto">
							      	<label  for="inlineFormInputGroup"><strong>Enter Your OTP</strong></label>
							      	<div class="input-group mb-2">
							        	<div class="input-group-prepend">
							          		<div class="input-group-text"><i class="fas fa-shield-alt"></i></div>
							       		</div>
							        	<input type="tel" class="form-control form-control-md " id="Uotp" name="Uotp"
							        		style="outline:none;"  required >
							      	</div>
							    </div>
							</div>
	                 		<button type="submit"  class="btn btn-success btn-lg float-right " name="submit" id="btnfg">Verify</button>	                 		
	              		</form>
	        		</div>
	      		</div>
	 		</div>
		</div>
</div>
	</body>
</html>