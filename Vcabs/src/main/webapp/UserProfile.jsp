<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="html\head_tag.html"></jsp:include>
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/login_style.css">
		<link rel="stylesheet" href="css/profile.css">
		<style type="text/css">
			.btn-file {
			    position: relative;
			    overflow: hidden;
			}
			.btn-file input[type=file] {
			    position: absolute;
			    top: 0;
			    right: 0;
			    min-width: 100%;
			    min-height: 100%;
			    font-size: 100px;
			    text-align: right;
			    filter: alpha(opacity=0);
			    opacity: 0;
			    outline: none;   
			    cursor: inherit;
			    display: block;
			}
		</style>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache"); 
			response.setHeader("Expires", "0"); 
			String name="",phone="",email="";
			PrintWriter obj=response.getWriter();
			if(session.getAttribute("Uname")==null){
				obj.println("<style type=\"text/css\"> #logout{display: none;} #Dprofile{display: none;} #Uprofile{display: none;}</style>");
				response.sendRedirect("login.jsp");
			}
			else{
				obj.println("<style type=\"text/css\"> .mobile-new-user{height:0px; padding-top:0px;} #slogin{display: none;}</style>");
				obj.print("<style type=\"text/css\">#login{display: none;} #register{display: none;} #Dprofile{display: none;}</style>");
				obj.print("<style type=\"text/css\">#items{ margin: 5px 3px -9px 0;}</style>");
				name =session.getAttribute("Uname").toString().toUpperCase();
				phone=session.getAttribute("Uphone"). toString();
				email=session.getAttribute("Uemail").toString();
			}								
		%>
	</head>
	<body >
		<jsp:include page="html\navbar.html"></jsp:include>
		<div class="col-12 col-sm-6 mx-auto my-2 ">
	        <div class="card" style="margin-top:70px;margin-bottom: 60px;">
				<div class="card card-profile shadow ">
		            <div class="row justify-content-center">
		              	<div class="col-lg-3 order-lg-2">
			                <div class="card-profile-image ">
			                	<div id="profile-container">
			                    	<image id="profileImage" src="./Udp" class="rounded-circle" style="width: 170px;height: 160px;">
			                	</div>
			                </div>
		              	</div>
		            </div>
            		<div class="card-header ">
		            	<div class="d-flex justify-content-end">
		            		
							<span class="btn btn-success " id="btn-edit" data-bs-toggle="tooltip" data-bs-placement="top" title="Edit Profile">
								<i class="fa fa-lg fa-pencil"></i>
								<span>Edit Profile</span>
							</span>	
		              	</div>
            		</div>
            		<div class="card-body text-center" id="text-body-1">
            			<pre style="font-size:30px;margin-top:50px;"><span class="font-weight-bold">Name: </span><%=name %><br><br><span class="font-weight-bold">Mail Id: </span><%=email %>
            			</pre>
            		</div>
            		
		            <div class="card-body " id="text-body-2" style="display:none;">
		            	<form class="form" action="UserProfile" method="post" enctype="multipart/form-data">
			            	<div class="text-center" style="margin-top:15px">
			            		<span class="btn btn-success btn-file " data-bs-toggle="tooltip" data-bs-placement="left" title="Change Photo">
									<i class="fa fa-camera fa-lg" ></i>
									<span>Change Photo</span> 
									<input type="file" name="dp" id="dp"  accept="image/*">
								</span>
			            	</div>
							
							
		            		<div class="tab-content pt-3">
		                		<div class="tab-pane active">

						            <div class="row">

						            	<div class="col-12 col-sm-auto mb-3" style="display: none;">
						                  	<div class="mx-auto" style="width: 140px;">
						                    	<div id="profile-container">
										       		<image id="profileImage" src="./Udp" style="width: 150px;height: 150px;" />
										    	</div>
						                  	</div>
						                </div>
						            </div>
						            
									<div class="row">
				                      <div class="col-12 col-sm-6 mb-3">
				                        <div class="row">
				                          <div class="col">
				                            <div class="form-group">
				                            	<label>Name</label>
										        <div class="input-group mb-2">
										            <input type="text" class="form-control  " name="uname" required="required" id="uname" minlength="4" value="<%=name %>" readonly />
										            <div class="input-group-prepend">
										            	<div class="input-group-text pencil-icon">
										                  	<i class="fa fa-pencil fa-lg" aria-hidden="true"></i>
										                </div>
										            </div>
										        </div>
				                            </div>
				                          </div>
				                        </div>
				                      </div>
				                    </div>

				                    <div class="row">
				                      <div class="col-12 col-sm-6 mb-3">
				                        <div class="row">
				                          <div class="col">
				                            <div class="form-group">
				                            	<label>Email</label>
										        <div class="input-group mb-2">
										            <input type="email" class="form-control " name="email" required="required" id="email" value="<%=email %>" readonly />
										            <div class="input-group-prepend">
										            	<div class="input-group-text pencil-icon">
										                  	<i class="fa fa-pencil fa-lg" aria-hidden="true"></i>
										                </div>
										            </div>
										        </div>
				                            </div>
				                          </div>
				                        </div>
				                      </div>
				                    </div>

				                    <div class="row">
				                      <div class="col-12 col-sm-6 mb-3">
				                        <div class="row">
				                          <div class="col">
				                            <div class="form-group">
				                            	<label>Password</label>
										        <div class="input-group mb-2">
										            <input type="password" class="form-control  " id="pwd1" name="pwd1" autocomplete="new-password" required="required" 
												pattern="[A-Za-z][A-Za-z0-9]*[0-9][A-Za-z0-9]*" placeholder="Enter your password"  />							           
										        </div>
				                            </div>
				                          </div>
				                        </div>
				                      </div>
				                    </div>                    
		                                     
				                    <div class="row">
				                      <div class="col d-flex justify-content-end">
				                        <button class="btn btn-success" type="submit">Save Changes</button>
				                      </div>
				                    </div>
			                	</div>
		              		</div>	   
		              	</form>           	
	            	</div>
        		</div>
			</div>
	    </div>
	     <script src="js/dp_update.js"></script>

	    
		<script type="text/javascript">
		    
			$('#btn-edit').on('click',function(){
			    if($('#text-body-1').css('display')!='none'){
			    	$('#text-body-2').show().siblings('#text-body-1').hide();
			    }else if($('#text-body-2').css('display')!='none'){
			        $('#text-body-1').show().siblings('#text-body-2').hide();
			    }
			});
		
		
			$(document).ready(function () {
			    $('.pencil-icon').click( function() {
			        if($(this).parents().siblings('input').is('[readonly]')){
			           $(this).parents().siblings('input').prop('readonly', false);
			        }
			        else{
			           $(this).parents().siblings('input').prop('readonly', true);
			        }
		    	});

			});
		</script>
	</body>
</html>