//package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import DBConnection.ConnectionProvider;

public class admin_forgot extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	String admin_name=request.getParameter("admin");
	boolean b=new admin_forgot().checkAdminLogin(admin_name);
	if(b)
	{
		System.out.println("Admin  validation successfully");
		//out.print("Admin validation ");
		//out.println("<html><head></head><body onload=\"alert('Invalid username/password')\"></body></html>");
		RequestDispatcher rd=request.getRequestDispatcher("AdminResetPAssword.jsp");
				rd.include(request, response);
	}
	else
	{
		System.out.println("Admin  validation un successfully");
		//out.print("Admin not        validation ");
		out.println("<html><head></head><body onload=\"alert('Incorrect ID')\"></body></html>");
		RequestDispatcher rd=request.getRequestDispatcher("AdmForgot.jsp");
		rd.include(request, response);

	}
	}

	public   boolean checkAdminLogin(String admin_name) {
		boolean b=false;
		Connection con=ConnectionProvider.getConnect();
		try {
			String q="select * from admin where ID=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, admin_name);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				if((rs.getString("ID")).equals(admin_name) )
						{
					b=true;
						}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	}
	