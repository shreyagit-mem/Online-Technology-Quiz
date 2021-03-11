

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Parti extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String tech= request.getParameter("tech");
		PrintWriter out=response.getWriter();
		//out.println("Hello");
		//out.println(s1);
		Connection con=ConnectionProvider.getConnect();
		//out.println("<link rel='stylesheet' type='text/css' href='servletStyle.css'>");
		//out.println("<a href='AdminDash.html'><img src=\"logo2.jpg\" class=\"logo\" alt=\"logo\" height=\"80\" width=\"100\" style=\"opacity: 0.9;  filter: grayscale(40%); margin-left:50px\"></a>");
		//out.println("<html><head>");
		//out.println("</head><body background='admback.jpg'");
		//out.println("<center><p>Participants</p></center>");
		//out.println("<center><img src='profile.jpg' width='200' style='margin-left:400px; border-image-outset:100px'></center>");
		try
		{
			PreparedStatement ps=con.prepareStatement("SELECT distinct UID,Score,Remark,Date_Time FROM review_quiz where Technology='"+tech+"'");
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
			out.println("<center><p>Participants</p></center>");
			out.println("<center><table border=1><tr><th>User ID</th><th>Score</th><th>Remark</th><th>Date/Time</th></tr>");
			out.println("<tr>");
			out.println("<td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></td>");
			out.println("</tr></center>");
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></td>");
				out.println("</tr></center>");
			}
			out.println("</table><br>");
		}
		}
		catch(Exception e)
		{
			
		}
	}

}
