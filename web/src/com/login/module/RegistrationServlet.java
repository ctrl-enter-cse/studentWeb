package com.login.module;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.helper.DBhandler;

public class RegistrationServlet extends HttpServlet{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public void doPost(HttpServletRequest req,HttpServletResponse resp) {
					String uname=req.getParameter("uname");
					String mail=req.getParameter("mail");
					String password=req.getParameter("password");
					try {
						DBhandler.insert(uname,mail,password);
				//		resp.getWriter().print("registration successful");
						HttpSession sess=req.getSession();
						sess.setAttribute("message", "REGISTRATION SUCCESSFUL for user: "+uname);
						resp.sendRedirect("login.jsp");
					} catch (Exception e) {
						System.out.println("problem occured");
					}
					
		}
}
