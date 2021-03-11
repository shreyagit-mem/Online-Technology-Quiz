

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ALeaderboard extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Connection con=ConnectionProvider.getConnect();
		try
		{
			PreparedStatement ps=con.prepareStatement("SELECT * FROM leaderboard order by score desc limit 20");
			ResultSet rs=ps.executeQuery();
			out.println("<link rel='stylesheet' type='text/css' href='result.css'>");
			out.println("<body background='admback.jpg'>");
			out.println("<a href='AdminDash.html'><img src=\"logo2.jpg\" class=\"logo\" alt=\"logo\" height=\"80\" width=\"100\" style=\"opacity: 0.9;  filter: grayscale(40%); margin-left:50px\"></a>");
			out.println("<a href='Logout'>Logout</a>");
			out.println("<html>");
			if(!rs.next())
			{
				out.println("<p>No Records Found!</p>");
			}
			else
			{
			out.println("<center><p>Leaderboard</p></center>");
			out.println("<center><table border=1><tr><th>User</th><th>Technology</th><th>Quiz ID</th><th>Score</th><tr>");
			out.println("<tr>");
			out.println("<td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td>");
			out.println("</tr></center>");
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td>");
				out.println("</tr></center>");
			}
			out.println("</table></body></html>");
		}
		}
		catch(Exception e)
		{
			
		}
	}
}
