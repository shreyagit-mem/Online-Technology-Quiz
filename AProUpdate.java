

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AProUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String s1= request.getParameter("name");
		String s2= request.getParameter("no");
		String s3= request.getParameter("id");
		String s4= request.getParameter("email");
		System.out.println(s2);
		System.out.println(s1);
		System.out.println(s3);
		PrintWriter out=response.getWriter();
		Connection con=ConnectionProvider.getConnect();
		try
		{
			System.out.println("1");
			PreparedStatement ps=con.prepareStatement("update admin set Name='"+s1+"',Contact_No='"+s2+"',Email_ID='"+s4+"'where id='"+s3+"'");
			ps.executeUpdate();
			System.out.println("2");
			out.println("<html><head></head><body onload=\"alert('Update Sucessfull')\"></body></html>");
			request.getRequestDispatcher("Profile").include(request, response);
		}
		catch(Exception e)
		{
			
		}
	}
}
