package com.helper;

import java.sql.*;
import java.util.ArrayList;
public class DBhandler {
		static Connection con;
		//establishing connection
		public static Connection establishCon(){
				String url="jdbc:mysql://localhost:3306/mar?characterEncoding=utf8";
				String user="root";
				String pass="root";
				try {
					Class.forName("com.mysql.jdbc.Driver");		//load driver
					 con=DriverManager.getConnection(url,user,pass);
				} catch (Exception e) {
					System.out.println("some problem occured");
				}
				return con;
		}
		//inserting data into data base
		public static void insert(String uname,String mail,String password) throws SQLException{
				establishCon();
				String sql="INSERT INTO user_info VALUES(?,?,?)";
				PreparedStatement st=con.prepareStatement(sql);
				st.setString(1, uname);
				st.setString(2, mail);
				st.setString(3, password);
				st.executeUpdate();
				con.commit();
		}
		public static String getPass(String user) throws SQLException{
			establishCon();
			String sql="SELECT password FROM user_info WHERE username=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, user);
			ResultSet rs=st.executeQuery();
			rs.next();
			System.out.println(rs.getString(1));
			return rs.getString(1);
		}
		public static void addCategory(String c_name,String c_desc) throws SQLException{
			establishCon();
			String sql="INSERT INTO category VALUES(?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, c_name);
			st.setString(2, c_desc);
			st.executeUpdate();
			con.commit();
	}
	public static int getUserCount(){
		establishCon();
		String sql="SELECT COUNT(*) FROM user_info";
		try{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			rs.next();
	        return rs.getInt(1);
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("issue with DBhandler user count");
		}
		return 0;
	}
	public static int getCategoryCount(){
		establishCon();
		String sql="SELECT COUNT(*) FROM category";
		try{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			rs.next();
	        return rs.getInt(1);
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("issue with DBhandler category count");
		}
		return 0;
	}
	public static ArrayList getCategory(){
		establishCon();
		ArrayList<String> al=new ArrayList<String>();
		String sql="SELECT * FROM category";
		try{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()==true){
				al.add(rs.getString(1)+" : "+rs.getString(2));
			}
	        return al;
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("issue with DBhandler category count");
		}
		return al;
	}
	public static void addProduct(String p_name, String p_price, String p_desc, String fileName) {
		establishCon();
		String sql="INSERT INTO product_info VALUES(?,?,?,?)";
		PreparedStatement st;
		try {
			st = con.prepareStatement(sql);
			st.setString(1, p_name);
			st.setString(2, p_price);
			st.setString(3, p_desc);
			st.setString(4, fileName);
			st.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static ArrayList getProduct(){
		establishCon();
		ArrayList<String> al=new ArrayList<String>();
		String sql="SELECT * FROM product_info";
		try{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()==true){
				al.add(rs.getString(4));
			}
	        return al;
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("issue with DBhandler product count");
		}
		return al;
	}
}
