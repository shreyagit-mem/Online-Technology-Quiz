//package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.student.db.student;

//import questions_quiz.quiz_db;
//import questions_quiz.quiz_table;

public class QuestionServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	int  technology=(Integer.parseInt(request.getParameter("Tech")));
	String q1=request.getParameter("q1");
	String a1=request.getParameter("a1");
	String opt1a=request.getParameter("opt1a");
	String opt1b=request.getParameter("opt1b");
	String opt1c=request.getParameter("opt1c");
	String opt1d=request.getParameter("opt1d");
	String q2=request.getParameter("q2");
	String a2=request.getParameter("a2");
	String opt2a=request.getParameter("opt2a");
	String opt2b=request.getParameter("opt2b");
	String opt2c=request.getParameter("opt2c");
	String opt2d=request.getParameter("opt2d");
	String q3=request.getParameter("q3");
	String a3=request.getParameter("a3");
	String opt3a=request.getParameter("opt3a");
	String opt3b=request.getParameter("opt3b");
	String opt3c=request.getParameter("opt3c");
	String opt3d=request.getParameter("opt3d");
	
	quiz_table  quizobj=new quiz_table(technology,q1,a1,opt1a,opt1b,opt1c,opt1d,q2,a2,opt2a,opt2b,opt2c,opt2d,q3,a3,opt3a,opt3b,opt3c,opt3d);
		
	boolean b=new quiz_db().InsertQuiz(quizobj);
				if(b)
				{	System.out.println("inserted quiz ");
				
					//out.print("<h2>Inserted successfullllll </h2>"+"<br>");
				out.println("<html><head></head><body onload=\"alert('Quiz Created Successfully')\"></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("AdminDash.html");
				rd.include(request, response);
				}
				else
				{
					out.print("not inserted");
					
					out.println("<html><head></head><body onload=\"alert('Error in creating Quiz')\"></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("AQues.html");
						rd.include(request, response);
					
					System.out.println("Not inserted ........");
					
				}
				 //out.print("<a href='AdminDash.html'  button type='button' >BAck to Admin </button></a>");
				
	
	
	}

}
