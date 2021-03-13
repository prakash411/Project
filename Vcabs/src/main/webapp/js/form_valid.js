$(document).ready(function(){

        $("#icon-click").click(function(){

          $("#icon").toggleClass('fa-eye-slash');
          var input1=$("#pwd1");
          var input2=$("#pwd2");
          if(input1.attr("type")==="password"){
            input1.attr("type","text");
            input2.attr("type","text");
          }
          else{
            input1.attr("type","password");
            input2.attr("type","password");
          }

        });
        
        $('#uname').focusout(function(){
          
          var pattern = /^([a-zA-Z]{3,})$/;
          var fname = $("#uname").val();
          if(fname.length>=4){

            if (pattern.test(fname) && fname !== '') {
                $('#umessage').html('').css('color','green');
            }
            else {
              $('#umessage').html('Should contain only Characters').css('color','red');
            }
          }
          else{
            $('#umessage').html('maximum 4 character is required').css('color','red');
          }

        });

        $('#phone').focusout(function(){
          
          var pattern = /^([0-9]{10})$/;
          var phone = $("#phone").val();
          if(phone.length==10){

            if (pattern.test(phone) && phone !== '') {
                $('#phmessage').html('').css('color','green');
            }
            else {
              $('#phmessage').html('Should contain only Digits').css('color','red');
            }
          }
          else{
            $('#phmessage').html('Phone Number should contains 10 Digits').css('color','red');
          }
        });

        $('#email').focusout(function(){
          
          var pattern = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
            var email = $("#email").val();
          if (pattern.test(email) && email !== '') {
                $('#email_message').html('').css('color','green');
          }
          else {
              $('#email_message').html('Invalid email').css('color','red');
            }
        });
        
        $('#pwd2').on('keyup',function(){

          if($('#pwd1').val()===$('#pwd2').val()){
            $('#message').html('succes').css('color','green').css('border-color:','green');
          }
          else{
            $('#message').html('password not match').css('color','red','border-color','green');
          }

        });
        
    });