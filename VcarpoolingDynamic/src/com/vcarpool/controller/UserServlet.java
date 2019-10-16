package com.vcarpool.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.User;
import com.vcarpool.services.UserServiceImpl;

@WebServlet(description = "user's servlet", urlPatterns = { "/UserServlet" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	Logger log=Logger.getLogger(UserServiceImpl.class);
	UserServiceImpl usr=new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		
		try {
			out.println(usr.showUsers());
			out.println(usr.getUser(3));
		} catch (VCarpoolException e) {
			// TODO Auto-generated catch block
			log.error("controller error", e);
			e.printStackTrace();
		}
	}

}
