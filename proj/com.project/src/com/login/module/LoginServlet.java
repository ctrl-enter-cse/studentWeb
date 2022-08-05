package com.login.module;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.helper.DBhandler;

public class LoginServlet extends HttpServlet {
		public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				//fetching values from web page- login form
				String web_uname=req.getParameter("uname");
				String web_pass=req.getParameter("pass");
				
				//code to fetch password for user-web_uname from data base
				String db_pass="";
				try {
					db_pass = DBhandler.getPass(web_uname);
				} catch (Exception e) {
					System.out.println("PROBLEMSS");
				}
			
				if(web_pass.equals(db_pass)){
						HttpSession sess=req.getSession();
						sess.setAttribute("user", web_uname);
						if(web_uname.equals("admin")){
							resp.sendRedirect("admin.jsp");
						}
						else{
							resp.sendRedirect("home.jsp");
						}
				}
				else{
						resp.sendRedirect("login.jsp");
				}
		}
}
