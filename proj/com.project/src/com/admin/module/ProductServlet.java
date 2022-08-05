package com.admin.module;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.helper.DBhandler;

@MultipartConfig
public class ProductServlet extends HttpServlet {
		public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
			String p_name=req.getParameter("prod_name");
			String p_price=req.getParameter("prod_price");
			String p_desc=req.getParameter("prod_desc");
			Part p_img=req.getPart("p_img");
			
			DBhandler.addProduct(p_name,p_price,p_desc,p_img.getSubmittedFileName());
			
			String path=req.getRealPath("img/product_img/")+""+p_img.getSubmittedFileName();
			System.out.println(path);
			
			InputStream is=p_img.getInputStream();
			byte[] data=new byte[is.available()];
			is.read(data);
			
			FileOutputStream fos=new FileOutputStream(path);
			fos.write(data);
			fos.close();
			is.close();
		}
}
