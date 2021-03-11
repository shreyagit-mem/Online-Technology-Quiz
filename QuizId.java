

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class QuizId
 */
public class QuizId extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();	
			int  tech=Integer.parseInt(request.getParameter("Tech"));
			out.println("<a href='AdminDash.html'><img src=\"logo2.jpg\" class=\"logo\" alt=\"logo\" height=\"80\" width=\"100\" style=\"opacity: 0.9;  filter: grayscale(40%); margin-left:50px\"></a>");
			//out.println("<a href='Logout'>Logout</a>");
			Connection con=ConnectionProvider.getConnect();
			try
			{
				PreparedStatement ps=con.prepareStatement("SELECT quizid FROM quiz_create where tech_id='"+tech+"'");
				ResultSet rs=ps.executeQuery();
				out.println("<link rel='stylesheet' type='text/css' href='servletStyle.css'>");
				out.println("<a href='Logout'>Logout</a>");
				out.println("<center>");
				if(!rs.next())
				{
					out.println("<h2>No Records Found!</h2>");
				}
				else
				{
				out.println("<form method='post'   action='ModifyServlet'>");
				out.println("<b><h2> Quiz </h2></b><br>");
				out.println("<label for='Quiz'> Choose Quiz ID:</label>");
				//out.println("<input type='hidden' name='techid' value='"+tech+"'/>");
				out.println("<select name='Quiz' id='Quiz'>");
				out.println("<option value='"+rs.getInt(1)+"'>"+rs.getInt(1)+"</option>");
				/*HashMap<Integer,Integer> quizID=new HashMap<Integer,Integer>();*/
				while(rs.next())
				{
					out.println("<option value='"+rs.getInt(1)+"'>"+rs.getInt(1)+"</option>");
					/*quizID.put(i,rs.getInt(1));*/
				}
				out.println("<br></option>");
				out.println("<br><input type=submit name=submit  value=Start  /><br>");
				out.println("</select></form></center><br>");
				//request.setAttribute("techID", quizID);
				//request.getRequestDispatcher("StartQuiz.jsp").include(request,response);
			}
			}
			catch(Exception e)
			{
				
			}

	}

}
