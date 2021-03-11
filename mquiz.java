

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mquiz extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String quizid = request.getParameter("quiz");
		String s1= request.getParameter("q1");
		String s2= request.getParameter("a1");
		String s3= request.getParameter("q2");
		String s4= request.getParameter("a2");
		String s5= request.getParameter("q3");
		String s6= request.getParameter("a3");
		/*System.out.println(s2);
		System.out.println(s1);
		System.out.println(s3);*/
		PrintWriter out=response.getWriter();
		Connection con=ConnectionProvider.getConnect();
		try
		{
			//System.out.println("1");
			PreparedStatement ps=con.prepareStatement("update quiz_create set q1='"+s1+"',a1='"+s2+"',q2='"+s3+"',a2='"+s4+"',q3='"+s5+"',a3='"+s6+"'where quizid='"+quizid+"'");
			ps.executeUpdate();
			//System.out.println("2");
			out.println("<html><head></head><body onload=\"alert('Update Sucessfull')\"></body></html>");
			//setParameter("Quiz",quizid);
			request.getRequestDispatcher("AdminDash.html").include(request, response);
		}
		catch(Exception e)
		{
			
		}

	}

	private void setParameter(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

}
