

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteQuiz extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Connection con=ConnectionProvider.getConnect();
		try
		{
			String t_name="";
			PreparedStatement ps=con.prepareStatement("SELECT tech_id,quizid,quiz_date FROM quiz_create");
			ResultSet rs=ps.executeQuery();
			out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.0.0/css/font-awesome.min.css'>");
		    //out.println("<script src='https://kit.fontawesome.com/a076d05399.js'></script>");
			out.println("<link rel='stylesheet' type='text/css' href='servletStyle.css'>");
			//out.println("<body background='admback.jpg'>");
			out.println("<a href='AdminDash.html'><img src=\"logo2.jpg\" class=\"logo\" alt=\"logo\" height=\"80\" width=\"100\" style=\"opacity: 0.9;  filter: grayscale(40%); margin-left:50px\"></a>");
			out.println("<a href='Logout'>Logout</a>");
			out.println("<html><head>");
			out.println("<center><h2>Delete Quiz</h2></center>");
			out.println("<center><table border=1><tr><th>Quiz ID</th><th>Technology ID</th><th>Technology Name</th><th>Creation Date/Time</th></tr>");
			while(rs.next())
			{
				if(rs.getInt(1)==1)
				{
					t_name="Java";
				}
				else if(rs.getInt(1)==2)
				{
					t_name="Python";
				}
				else if(rs.getInt(1)==3)
				{
					t_name="SQL";
				}
				else if(rs.getInt(1)==4)
				{
					t_name="Data Science";
				}
				out.println("<tr>");
				out.println("<td>"+rs.getInt(2)+"</td><td>"+rs.getInt(1)+"</td><td>"+t_name+"</td><td>"+rs.getString(3)+"</td>");
				out.println("</tr></center>");
			}
			out.println("</table><br>");
			out.println("<form method='get' action='DeleteServlet'>");
			out.println("<input type='text' name='id' required placeholder='Enter Quiz ID' required='required' /><br>");
			out.println("<br><input type=submit name=sub value=Delete />");
			out.println("</style></form></body></head></html>");
			con.close();
		}
		catch(Exception e)
		{
			
		}
	}

}
