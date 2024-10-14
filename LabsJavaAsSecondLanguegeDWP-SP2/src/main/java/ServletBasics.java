import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletBasics
 */
@WebServlet("/processorder")
public class ServletBasics extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private double grandTotal=0;
	private String strGrandTotal="";
	double subtotal[]={0,0,0};
	String strSubTot[]={"","",""};

	String beers[]={"Amber Ale","Stout","Lager"};
	double price[]={7.00,5.00,8.00};
	String strPrice[]={"","",""};
	int quant[]={0,0,0};
	String strQuant[]={"","",""};
	private String message;
	int intItmCount = 0;

	@Override
	public void init() throws ServletException {
	      // Do required initialization lager
	      message = "Greetings, Welcome to the Craft Pub222";
	}

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBasics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Set response content type
	      response.setContentType("text/html");

	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();
	      out.println("<h1>" + message + "</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Set response content type
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      out.println("<div style=\"text-align:center\"><h1> Thank You for your Purchase! </h1></div><br>");
	      grandTotal=0;

	      String suser = request.getParameter("username");
	      out.println("<div style=\"text-align:center\"> Great, " + suser + ". It is a pleasure to serve you.</div><br>");

	      String itmCount = request.getParameter("itmCount");
	      try{
	    	  intItmCount = Integer.parseInt(itmCount);
	      }catch (Exception ex){
	    	  System.out.println(ex.toString());
	      }
	      if(intItmCount > 1){
	    	  out.println("<div style=\"text-align:center\"><h2>You have selected " + intItmCount + " different types of beer. We know you will enjoy them</h2></div>");
	      } //if
	      else {
	    	  out.println("<div style=\"text-align:center\"><h2>You have selected " + intItmCount + " type of beer. We know you will enjoy it.</h2></div>");
	      } //else
	      for(int z=0;z<strQuant.length;z++){
	    	  strQuant[z] = request.getParameter("beer[" + z + "]");
		      if(strQuant[z]==""){
		    	  strQuant[z]="0";
			  } //if
	      } //for

		  try{
		      for(int k=0;k<beers.length;k++){
			      quant[k] = Integer.parseInt(strQuant[k]);
			  } //for
		  }catch(Exception ex){
		      System.out.println(ex.toString());
			  out.println("<html><h1> Make sure a valid quantity is entered for the item</h1></htnl>");
		  }

	      response.setContentType("text/html");
	      response.setCharacterEncoding("UTF-8");
	      for(int i = 0;i<price.length;i++){
	          strPrice[i] = String.format("%.2f", price[i]);
	      } //for

	      for(int j=0;j<3;j++){

		      if(quant[j]>0){
		          subtotal[j] = quant[j] * price[j];
		          strSubTot[j] = String.format("%.2f", subtotal[j]);
		          grandTotal += subtotal[j];
		          out.println("<div style=\"text-align:center\"><h2> The quantity ordered of "+ beers[j] + " is: " + quant[j] + ", at price: $" + strPrice[j] + ". The subtotal is: $" + strSubTot[j] + "</h2></div>");
		      } //if
		  } //for

	      strGrandTotal = String.format("%.2f", grandTotal);
	      out.println("<br><div style=\"text-align:left\"><h1>The Grand Total is: $" + strGrandTotal + "</h1></div>");
	      out.println("<br><a href=\"./selectOrder.jsp?username=" + suser + "\">Start a New Order</a>");
	      out.println("<br><a href=\"./proc/base.md?username=" + suser + "\">Wrap Up</a><br>");
	  } //doPost
} //class

