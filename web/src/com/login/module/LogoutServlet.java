package com.login.module;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
			/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

			public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					HttpSession sess=req.getSession();
					sess.removeAttribute("user");
					sess.invalidate();
					resp.sendRedirect("login.jsp");
			}
}
