package com.helper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//import javax.servlet.http.Part;
//@MultipartConfig(maxFileSize=16177216)
@WebServlet("/register")
public class Registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		Connection con=null;
			
		String f_name = request.getParameter("InputFIRSTName");
		String l_name = request.getParameter("InputLASTName");
		String email = request.getParameter("exampleInputEmail1");
		String pass = request.getParameter("exampleInputPassword1");
		String contact = request.getParameter("contact");
		String gender = request.getParameter("gender");
		String age=request.getParameter("AGE");
		String dob=request.getParameter("birthday");
	//	Part part=request.getPart("photo");
//		vallidation
//		System.out.println(dob);
		RequestDispatcher rd1=null;	

			if(f_name.isEmpty()==true||f_name==null){
				request.setAttribute("status1","invalidFName");
				request.getRequestDispatcher("registeration.jsp").forward(request, resp);
				System.out.println("emppty");
//				rd1.forward(request,resp);
			}
			if(l_name.isEmpty()==true||l_name==null){
				request.setAttribute("status1","invalidLName");
				rd1=request.getRequestDispatcher("registeration.jsp");
				rd1.forward(request ,resp);
			}
			if(age==""||age==null){
				request.setAttribute("status1","invalidAge");            
				rd1=request.getRequestDispatcher("registeration.jsp");
				rd1.forward(request ,resp);
			}
			if(dob.isEmpty()==true||dob==null){
				request.setAttribute("status1","invalidDate");
				rd1=request.getRequestDispatcher("registeration.jsp");
				rd1.forward(request ,resp);
			}
			if(gender==""||gender==null){
				request.setAttribute("status1","invalidgender");                  
				rd1=request.getRequestDispatcher("registeration.jsp");
				rd1.forward(request ,resp);
			}

//			if(email==""||email==null||email.matches("^[A-Z0-9._]+@[A-Z0-9.-]+\\.[A-Z]{2,3}$")!=true){
//				request.setAttribute("status1","invalidEmail");
//				rd1=request.getRequestDispatcher("registeration.jsp");
//				rd1.forward(request, resp);
//			}
			if(pass==""||pass==null){
				request.setAttribute("status1","invalidPass");
				rd1=request.getRequestDispatcher("registeration.jsp");
				rd1.forward(request, resp);
			}
	
//			if(pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@$&-])(?=\\S+$).{8,20}$")!=true){
//				request.setAttribute("status1","inproper");
//				rd1=request.getRequestDispatcher("registeration.jsp");
//				rd1.forward(request, resp);
//			}
			if(contact==""||contact==null){
				request.setAttribute("status1","invalidContact");
				rd1=request.getRequestDispatcher("registeration.jsp");
				rd1.forward(request, resp);
			}
			if(contact.matches("[0-9]{10,12}")!=true){
				request.setAttribute("status1","invalidContactlength");
				rd1=request.getRequestDispatcher("registeration.jsp");
				rd1.forward(request, resp);
			}
//			if(part!=null){
//			request.setAttribute("status","invalidimage");
//			rd1=request.getRequestDispatcher("registeration.jsp");
//			rd1.forward(request, resp);
//		}
		try{
			
//			Class.forName("com.mysql.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Web?characterEncoding=utf8","root", "Techtree@123");
			 con=DBhandler.establishCon();
			String sql="SELECT count(*) FROM fb_user where Email='"+email+"' AND CONTACT='"+contact+"';";
			PreparedStatement st=con.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			rs.next();
			String count=rs.getString(1);
			
			if(count.equals("0")){
				
				String data="INSERT INTO fb_user(FIRST_NAME,LAST_NAME,EMAIL,PASS,CONTACT,AGE,DATE_OF_BIRTH,GENDER,CREATION_TIME,MODIFYED_TIME,LOGIN_TIME) VALUES (?,?,?,?,?,?,?,?,now(),now(),now());";
				java.sql.PreparedStatement ps= con.prepareStatement(data);
				//InputStream is = part.getInputStream();
				ps.setString(1,f_name);
				ps.setString(2,l_name);
				ps.setString(3,email);
				ps.setString(4,pass);
				ps.setString(5,contact);
				ps.setInt(6, Integer.parseInt(age));
				ps.setString(7, dob);
				ps.setString(8,gender);
//				ps.setBlob(9,is);
				
				int i=ps.executeUpdate();
				System.out.println(i); 
				if(i>0){
					

					System.out.println("succesfully  data is enter");
					
					request.setAttribute("status1","success");
					request.getRequestDispatcher("registeration.jsp").forward(request, resp);

				}
			}else{
				System.out.println("exit the email n nmber");
				request.setAttribute("status1","Email is already registered!!");
				request.getRequestDispatcher("registeration.jsp").forward(request, resp);

			}
			rd1.forward(request, resp); //validation
		}catch( Exception e){
			e.printStackTrace();
		}
		
		finally{
			try {
				
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			

	
	}



}
