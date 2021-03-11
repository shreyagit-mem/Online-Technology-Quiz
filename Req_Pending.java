

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Req_Pending extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Connection con=ConnectionProvider.getConnect();
		try
		{
			PreparedStatement ps=con.prepareStatement("SELECT name,university,college,date_of_birth,mobile_no,email_id,gender FROM student where status='Pending'");
			ResultSet rs=ps.executeQuery();
			String css="<link rel='stylesheet' type='text/css' href='servletStyle.css'>";
			out.println("<body background='admback.jpg'>");
			out.println("<a href='AdminDash.html'><img src=\"logo2.jpg\" class=\"logo\" alt=\"logo\" height=\"80\" width=\"100\" style=\"opacity: 0.9;  filter: grayscale(40%); margin-left:50px\"></a>");
			out.println("<a href='Logout'>Logout</a>");
			out.println("<html><head>");
			if(!rs.next())
			{
				out.println("<h2>No Records Found!</h2>");
			}
			else
			{
			out.println("<center><h2>Pending Requests</h2></center>"+css);
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
			out.println("</table><br>");
			out.println("<form method='get' action='A_Update'>");
			out.println("<input type='email' name='id' required placeholder='Enter Email ID' required='required' /><br>");
			out.println("<input type='radio' name='action' value='Accept'/><label>Accept</label>");
			out.println("<input type='radio' name='action' value='Reject'/><label>Reject</label><br>");
			out.println("<br><input type=submit name=sub value=Submit />");
			out.println("</style></form></body></head></html>");
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
