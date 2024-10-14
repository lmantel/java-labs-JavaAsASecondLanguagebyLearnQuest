<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
	String beers[]={"Amber Ale","Stout","Lager"};
    String qty[]={"0","0","0"};
	String myqty[]={"","",""};
	double thecost[]={0.00,0.00,0.00};
	String strCost[]={"","",""};
	int q[]={0,0,0};
	double price[]={7.00,5.00,8.00};
	String strPrice[]={"","",""};
	
	String users[]={"admin","jim","jenny"};
	String pwd[]={"pwd!","welcome$","welcome$"};
	String suser=null;
	int itmCounter=0;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Confirmation Leo</title>
</head>
<body>

<%
    out.println("<div style=\"text-align:center\"><h1>Order Confirmation</h1></div><br>");
	for(int i=0;i<beers.length;i++){
		myqty[i] = request.getParameter("qty[" + i + "]");
	}
	
    suser = session.getAttribute("uname").toString();
    out.println("<left> Great, " + suser + "</left><br>");
   
    if(myqty[0] != null || myqty[1] != null || myqty[2] != null){
    	int theqty;
%>
<h4>You selected options </h4>
<ul>
<%  
      itmCounter = 0;
	  for(int i=0; i<beers.length; i++){   
        
        if(myqty[i]!=""){ %>
        <li>
        	<%= beers[i] %>
        </li>
<%      } //if  
   	
        try{
		    theqty = Integer.parseInt(myqty[i]);
        }catch(Exception ex){
    	    theqty = 0;
        }
        if(myqty[i]!=""){
	        thecost[i] = price[i]*theqty;
	        strPrice[i] = String.format("%.2f", price[i]);
	        strCost[i] = String.format("%.2f", thecost[i]);
	        out.print("The quantity: "+myqty[i]+"<br>");
	        out.print("The price: $"+strPrice[i]+"<br>");
	        out.print("The cost: $"+strCost[i]+"<br>");
	        out.print("<br>");
		    itmCounter++;
	    }//if
      } //for
      out.println("<a href=\"./selectOrder.jsp?username=" + suser + "\">Change the Order</a>");
%>
</ul>
	   <form name="f1" ACTION="./processorder" method="post">
	    <% for(int j=0; j<beers.length; j++){  
	        //out.print("<p><input type=\"text\" name=\"beer[" + j + "]\" id=\"beer[" + j + "]\" value=\"" + myqty[j] + "\"></p>");
	    	out.print("<p><input type=\"hidden\" name=\"beer[" + j + "]\" id=\"beer[" + j + "]\" value=\"" + myqty[j] + "\"></p>");
	       } //for   
	     %>
	    <p><input type="hidden" name="itmCount" id="itmCount" value="<%= itmCounter%>"></p>
	    <p><input type="hidden" name="username" id="username" value="<%= suser %>"></p>
	    <p><input type="submit" value="submit purchase"></p>
	    </form>
<%
    }//if
%>

</body>
</html>