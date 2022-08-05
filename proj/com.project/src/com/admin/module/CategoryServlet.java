package com.admin.module;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.DBhandler;

public class CategoryServlet extends HttpServlet{
		public void doPost(HttpServletRequest req,HttpServletResponse resp){
			try {
				String c_name=req.getParameter("cat_name");
				String c_desc=req.getParameter("cat_desc");
				DBhandler.addCategory(c_name,c_desc);
				resp.sendRedirect("admin.jsp");
			} catch (Exception e) {
				System.out.println("Problem occured in Category Servlet");
			}
		}
}
