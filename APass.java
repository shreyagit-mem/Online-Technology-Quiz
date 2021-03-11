

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class APass extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String s1= request.getParameter("old");
		String s2= request.getParameter("new");
		String s3= request.getParameter("cpass");
		PrintWriter out=response.getWriter();
		Connection con=ConnectionProvider.getConnect();
		String pass = null;
		try
		{
			PreparedStatement p=con.prepareStatement("select Password from admin where ID='admin'");
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
				pass=rs.getString(1);
			}
			if(pass.equals(s1))
			{
			   PreparedStatement ps=con.prepareStatement("update admin set Password='"+s2+"'where ID='admin'");
			   ps.executeUpdate();
			   out.println("<html><head></head><body onload=\"alert('Password Updated Successfully')\"></body></html>");
			   request.getRequestDispatcher("AdminDash.html").include(request, response);
			}
			else
			{
				out.println("<html><head></head><body onload=\"alert('Enter current password correctly!')\"></body></html>");
				request.getRequestDispatcher("Pass.html").include(request, response);
			}
		}
		catch(Exception e)
		{
			
		}
	}
}
