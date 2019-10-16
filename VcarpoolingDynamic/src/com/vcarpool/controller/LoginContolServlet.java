package com.vcarpool.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.User;
import com.vcarpool.services.UserServiceImpl;
/**
 * Servlet implementation class LoginContolServlet
 */
@WebServlet("/LoginContolServlet")
public class LoginContolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log=Logger.getLogger(LoginContolServlet.class);
	static UserServiceImpl usr=new UserServiceImpl();
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginContolServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	int uName=Integer.parseInt( request.getParameter("userid"));
	PrintWriter out=response.getWriter();
	String password=request.getParameter("password");
	RequestDispatcher dispatcher=request.getRequestDispatcher("WebContent/html/Error.html");
	
	try {
		if(usr.login(uName, password)==1) {
			
			User user=usr.getUser(uName);
			HttpSession session=request.getSession();
			session.setAttribute("userid",user.getUserName());
			
		}
	} catch (VCarpoolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
