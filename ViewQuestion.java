//package com.admin;

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

public class ViewQuestion extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();	
		int  technology=Integer.parseInt(request.getParameter("Tech"));
		out.println("<link rel='stylesheet' type='text/css' href='result.css'>");
		out.println("<body background='admback.jpg'>");
		out.println("<a href='AdminDash.html'><img src=\"logo2.jpg\" class=\"logo\" alt=\"logo\" height=\"80\" width=\"100\" style=\"opacity: 0.9;  filter: grayscale(40%); margin-left:50px\"></a>");
		//out.print("<body bgcolor='yellow'>");
		out.println("<a href='Logout'>Logout</a>");
		//out.println("<center><p>Quiz Detail</p>");
		new ViewQuestion().viewQuiz(technology,out);

	}
		public  void  viewQuiz(int technology,PrintWriter out)
		{
		Connection con=ConnectionProvider.getConnect();
		try {
		String q="select quiz_date,quizid,q1,a1,q2,a2,q3,a3  from  quiz_create  where tech_id = ?";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setInt(1, technology);
	    ResultSet rs=ps.executeQuery();
	    if(!rs.next())
	    {
	    	out.println("<p>No Records Found!</p>");
	    }
	    else
	    {
	    	out.println("<center><p>Quiz Detail</p>");
	    	out.print("<h3>"+ rs.getTimestamp("quiz_date")+"</h3>"+"<h3>Quiz ID: "+ rs.getInt("quizid")+"</h3>"+"<hr> "+rs.getString("q1")+"<br> "+rs.getString("a1")  +"<br><hr>" +rs.getString("q2")+"<br> "+rs.getString("a2")+" <hr> "+rs.getString("q3")+"<br> "+rs.getString("a3")+" <hr>");	
	    	while(rs.next())
				{	
				out.print("<h3>"+ rs.getTimestamp("quiz_date")+"</h3>"+"<h3>Quiz ID: "+ rs.getInt("quizid")+"</h3>"+"<hr> "+rs.getString("q1")+"<br> "+rs.getString("a1")  +"<br><hr>" +rs.getString("q2")+"<br> "+rs.getString("a2")+" <hr> "+rs.getString("q3")+"<br> "+rs.getString("a3")+" <hr>");
					//	out.print("document.getElementById('Quesone').innerHTML= "+rs.getString("q1")+ " ;   " );
					System.out.println("success");
				}
				out.println("</center>");
				 //out.print("<a href='AdminDash.html'  button type='button' >BAck to Admin </button></a>");
		}
		}
			 catch (SQLException e) {
					e.printStackTrace();
				}
		
	}
}