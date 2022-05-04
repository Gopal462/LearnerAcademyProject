package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		  response.setContentType("text/html");  
		  PrintWriter out = response.getWriter();          
		    String user=request.getParameter("username");  
		    String pass=request.getParameter("password");  
		    if(user.equalsIgnoreCase("admin")&&pass.equalsIgnoreCase("admin")){  
		        RequestDispatcher rd=request.getRequestDispatcher("index.html"); 	       
		        rd.forward(request,response);  
		    }  
		    else{  
		    	
		         		        
		        RequestDispatcher rd=request.getRequestDispatcher("adminlogin.html");  
		        rd.include(request,response);  
		        out.print("<html><body><center>");
		        out.print("<b><p style=\"color:red;\">Sorry!!!! Invalid User and Password</p></b>");
		        out.print("</center></body></html>");
		    }  
		          
		    out.close();  
	}

}
