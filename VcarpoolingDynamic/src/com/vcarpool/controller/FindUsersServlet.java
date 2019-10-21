package com.vcarpool.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.vcarpool.model.User;
import com.vcarpool.services.UserServiceImpl;
import org.apache.log4j.Logger;

import com.vcarpool.services.UserServiceImpl;

/**
 * Servlet implementation class FindUsersServlet
 */
@WebServlet("/FindUsersServlet")
public class FindUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger(FindUsersServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserServiceImpl userserv=new UserServiceImpl();
		 int userId=Integer.parseInt(request.getParameter("userid"));
		 String UserName=request.getParameter("userName");
		 String Type=request.getParameter("type");
		 HttpSession session= request.getSession();
		 session.setAttribute("userid",userId );
		 session.setAttribute("userName",UserName);
		 RequestDispatcher dispatcher = null;
	
		 
	
	}

}
