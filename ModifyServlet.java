import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import DBConnection.ConnectionProvider;
//import questions_quiz.quiz_table;

public class ModifyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();	
		int  quizid=Integer.parseInt(request.getParameter("Quiz"));
		//System.out.println("quizid "+quizid);
		//out.print("<body bgcolor='pink'>");
		//out.println("<link rel='stylesheet' type='text/css' href='profilestyle.css'>");
		//out.println("<body background='admback.jpg'>");
		out.println("<a href='AdminDash.html'><img src=\"logo2.jpg\" class=\"logo\" alt=\"logo\" height=\"80\" width=\"100\" style=\"opacity: 0.9;  filter: grayscale(40%); margin-left:50px\"></a>");
		out.println("<a href='Logout'>Logout</a>");
		out.println("<link rel='stylesheet' type='text/css' href='profilestyle.css'>");
		out.println("<center><p><b>Modify Quiz</b></center></p>");
		Connection con=ConnectionProvider.getConnect();
		try {
		String q="select quiz_date,q1,a1,q2,a2,q3,a3  from  quiz_create  where quizid = ?";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setInt(1, quizid);
	ResultSet rs=ps.executeQuery();
				while(rs.next())
				{	
					out.println("<form method='post' action='mquiz'>");
					out.println("<input type='hidden' name='quiz' value='"+quizid+"'/>");
					out.println("<label>Question 1</label><br>");
					out.println("<input type=\"text\" name=\"q1\" placeholder='"+rs.getString("q1")+"'value='"+rs.getString("q1")+"' required='required' /><br>");
					out.println("<label>Answer 1</label><br>");
					out.println("<input type='text' name='a1' placeholder='"+rs.getString("a1")+"'value='"+rs.getString("a1")+"'required='required' /><br>");
					out.println("<label>Question 2</label><br>");
					out.println("<input type=\"text\" name=\"q2\" placeholder='"+rs.getString("q2")+"'value='"+rs.getString("q2")+"'required='required' /><br>");
					out.println("<label>Answer 2</label><br>");
					out.println("<input type='text' name='a2' placeholder='"+rs.getString("a2")+"'value='"+rs.getString("a2")+"'required='required' /><br>");
					out.println("<label>Question 3</label><br>");
					out.println("<input type=\"text\" name=\"q3\" placeholder='"+rs.getString("q3")+"'value='"+rs.getString("q3")+"'required='required' /><br>");
					out.println("<label>Answer 3</label><br>");
					out.println("<input type='text' name='a3' placeholder='"+rs.getString("a3")+"'value='"+rs.getString("a3")+"'required='required' /><br>");
				}
				out.println("<br><center><input type=submit name=sub value=Save /></center>");
			    out.println("</form></body></html>");
					System.out.println("success");
			
		
		}
			 catch (SQLException e) {
					e.printStackTrace();
				}
		
	}
}