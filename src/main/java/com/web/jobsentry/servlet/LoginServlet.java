package com.web.jobsentry.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.jobsentry.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet(
        name = "LoginServlet",
        urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In LoginServlet .....");
		doGet(request, response);
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    HttpSession session = request.getSession();
	    String name=request.getParameter("name");  
	    String password=request.getParameter("password");  
	    String email=request.getParameter("email");  
	    session.setAttribute("email", email);
	          
	    if(LoginDao.validate(name, password)){  
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.forward(request,response);  
	    }  
	    else{  
	        String sorryMsg = "  Sorry username or password error";  
	        request.setAttribute("sorryMsg", sorryMsg);
			RequestDispatcher rd=request.getRequestDispatcher("/loginErr.jsp");
	         rd.forward(request, response);
	      
	    }  
	    
	    out.close();   
	    
	}

}
