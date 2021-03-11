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

public class admin_reset_password extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
		String password=request.getParameter("password");
		Connection con=ConnectionProvider.getConnect();
		try {
			String q="update admin set password=?  where ID='admin' ";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, password);
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("Password updated  successfully");
				RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
				out.println("<html><head></head><body onload=\"alert('Password Changed')\"></body></html>");
				//out.print("<h1 style='color:yellow;'>"+"PAssword updated succcessfully "+"</h1>");	
				rd.include(request, response);
			}
			else
			{
				System.out.println("Password not updated");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		}
}
