

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection con=ConnectionProvider.getConnect();
		String ids=request.getParameter("id");
		System.out.println(ids);
		int id=Integer.parseInt(ids);
		try
		{
			System.out.println("Outside");
			PreparedStatement ps=con.prepareStatement("DELETE FROM quiz_create where quizid='"+id+"'");
			System.out.println("Inside");
			int i=ps.executeUpdate();
			if(i>0)
			   { 
				out.println("<html><head></head><body onload=\"alert('Quiz Deleted Successfully')\"></body></html>"); 
				request.getRequestDispatcher("DeleteQuiz").include(request, response);
			   }
			else
			{
				out.println("<html><head></head><body onload=\"alert('Wrong Quiz ID entered')\"></body></html>");
				request.getRequestDispatcher("DeleteQuiz").include(request, response);
			}
			//con.close();
		}
		catch(Exception e)
		{
			
		}
	}
}
