

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Detail extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Connection con=ConnectionProvider.getConnect();
		try
		{
			PreparedStatement ps=con.prepareStatement("SELECT name,university,college,date_of_birth,mobile_no,email_id,gender FROM student where status='Approve'");
			ResultSet rs=ps.executeQuery();
			String css="<link rel='stylesheet' type='text/css' href='servletStyle.css'>";
			out.println("<a href='AdminDash.html'><img src=\"logo2.jpg\" class=\"logo\" alt=\"logo\" height=\"80\" width=\"100\" style=\"opacity: 0.9;  filter: grayscale(40%); margin-left:50px\"></a>");
			out.println("<a href='Logout'>Logout</a>");
			out.println("<html><head>");
			//out.println("<body background='admback.jpg'>");
			if(!rs.next())
			{
				out.println("<h2>No Records Found!</h2>");
			}
			else
			{
			out.println("<center><h2>Details Of Registered Students</h2></center>"+css);
			out.println("<center><table border=1><tr><th>Name</th><th>University</th><th>College</th><th>Date Of Birth</th><th>Mobile No.</th><th>Email ID</th><th>Gender</th></tr>");
			out.println("<tr>");
			out.println("<td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td>");
			out.println("</tr></center>");
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td>");
				out.println("</tr></center>");
			}
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		 finally
         {
       	  out.close();
		 }
	}
}
