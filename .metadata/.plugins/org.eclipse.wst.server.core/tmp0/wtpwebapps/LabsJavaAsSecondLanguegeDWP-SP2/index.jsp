<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>

      // Form validation code will come here.
      function validate(){
      
         if(document.loginfrm.username.value == "" || document.loginfrm.pwd.value == ""){
            alert( "Both username and password are required fields" );
            document.loginfrm.username.focus() ;
            return false;
         }
       }
</script>
<title>Login Leo</title>
</head>
<body>
<div style="text-align:center"><h1><b>Welcome to the Craft Pub!</b></h1></div>
<br>
<div style="margin:0 auto" align=center>
<FORM class="text-center" name="loginfrm" METHOD=POST onsubmit="return validate()" ACTION="./selectOrder.jsp" style="width: 643px; ">
Enter user name: <INPUT TYPE=TEXT NAME=username id=username SIZE=20><br><br>
Enter password:  <INPUT TYPE=password NAME=pwd SIZE=20><br>
<P><INPUT TYPE=SUBMIT value="Login">
</FORM>
</div>
</body>
</html>