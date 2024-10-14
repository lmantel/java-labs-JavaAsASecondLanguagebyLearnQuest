package proc;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Base
 */
@WebServlet("/base.md")
public class Base extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String message;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Base() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		message = "Thanks for using the Craft Pub!";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String suser = request.getParameter("username");
		
		PrintWriter out = response.getWriter();
		out.println("<div style=\"text-align:center\"><h1>" + message + " " + suser + "</h1></div><br>");
		out.println("<br><a href=\"../selectOrder.jsp?username=" + suser + "\">Start a New Order</a><br>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}