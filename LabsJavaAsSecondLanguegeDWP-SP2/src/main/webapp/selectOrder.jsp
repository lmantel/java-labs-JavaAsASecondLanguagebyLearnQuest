<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
	String beers[]={"Amber Ale","Stout","Lager"};
    String qty[]={"0","0","0"};
	String myqty[]={"","",""};
	double thecost[]={0.00,0.00,0.00};
	int q[]={0,0,0};
	double price[]={7.00,5.00,8.00};
	
	String users[]={"admin","jim","jenny"};
	String pwd[]={"pwd!","welcome$","welcome$"};
	String user;
	String suser=null;
	int itmCounter=0;
%>
<%
    user = request.getParameter("username");
	session.setAttribute("uname", user);
	suser = session.getAttribute("uname").toString();
	out.println("<br>Welcome member: " + suser);
%>
<html>
<head>
<meta http-eqUIv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function validate(){
    
    if(document.f.qty0.value == "" && document.f.qty1.value == "" && document.f.qty2.value == ""){
       alert( "You need an entry in at least 1 field" );
       return false;
    }
  }
</script>
<title>Make Your Order Leo</title>
</head>
<body>
<form name="f" ACTION="./confirmOrder.jsp" method="post" onsubmit="return validate()">
<h3>Please Select your Choices</h3>
<p><input type="text" name="qty[0]" id="qty0" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" /><label for="qty[0]"> Amber Ale: $7.00</label></p>
<p><input type="text" name="qty[1]" id="qty1" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" /><label for="qty[1]"> Stout: $5.00</label></p>
<p><input type="text" name="qty[2]" id="qty2" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" /><label for="qty[2]"> Lager: $8.00</label></p>
<p><input type="hidden" name="username" id="username" value="<%= suser %>"></p>
<p><input type="submit" value="submit"></p>
</form>

</body>
</html>