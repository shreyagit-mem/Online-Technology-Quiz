

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Score extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String a1=request.getParameter("a1");
		String a2=request.getParameter("a2");
		String a3=request.getParameter("a3");
		int qid= (Integer.parseInt(request.getParameter("id")));
		int tid= (Integer.parseInt(request.getParameter("techid")));
		String uid= request.getParameter("uid");
		String tech="";
		String remark="";
		String q1="",q2="",q3="",an1="",an2="",an3="";
		System.out.println("qid: "+qid);
		Connection con=ConnectionProvider.getConnect();
	    PreparedStatement ps,p,pre;
	    int score=0;
	    try
	    {
	    	if(a1==null || a1.isEmpty())
	    	{
	    		a1="Unanswered";
	    	}
	    	if(a2==null || a2.isEmpty())
	    	{
	    		a2="Unanswered";
	    	}
	    	if(a3==null || a3.isEmpty())
	    	{
	    		a3="Unanswered";
	    	}
	    	System.out.println("1-- "+a1+"2-- "+a2+"3-- "+a3);
	    	ps = con.prepareStatement("SELECT a1,a2,a3,q1,q2,q3 FROM quiz_create where quizid='"+qid+"'");
			ResultSet rs=ps.executeQuery();
			//out.println("<link rel='stylesheet' type='text/css' href='servletStyle.css'>");
			//System.out.println("----2");
			while(rs.next())
			{   //System.out.println("----3");
				q1=rs.getString(4);
				an1=rs.getString(1);
				q2=rs.getString(5);
				an2=rs.getString(2);
				q3=rs.getString(6);
				an3=rs.getString(3);
			}	
				if(a1.equalsIgnoreCase(an1) && a2.equalsIgnoreCase(an2) && a3.equalsIgnoreCase(an3))
				{
					score=3;
				}
				else if((a1.equalsIgnoreCase(an1) && a2.equalsIgnoreCase(an2)) || (a1.equalsIgnoreCase(an1) && a3.equalsIgnoreCase(an3)) || (a2.equalsIgnoreCase(an2) && a3.equalsIgnoreCase(an3)))
				{
					score=2;
				}
				else if(a1.equalsIgnoreCase(an1) || a2.equalsIgnoreCase(an2) || a3.equalsIgnoreCase(an3))
				{
	                 score=1;
				}
				else
				{
					score=0;
				}
			System.out.println("score "+ score);
			p = con.prepareStatement("insert into leaderboard values(?,?,?,?,?)");
			p.setString(1,uid);
			if(tid==1)
			{
				tech="Java";
			}
			else if(tid==2)
			{
				tech="Python";
			}
			else if(tid==3)
			{
				tech="SQL";
			}
			else
			{
				tech="Data Science";
			}
			p.setString(2,tech);
			p.setInt(3,qid);
			p.setInt(4,score);
			if(score==0)
			{
				remark="Fail";
			}
			else if(score==1 || score==2)
			{
				remark="Extraordinary";
			}
			else 
			{
				remark="Outstanding";
			}
			p.setString(5,remark);
			p.executeUpdate();
			/*pp = con.prepareStatement("SELECT q1,a1,,q2,a2,q3,a3 FROM quiz_create where quizid='"+qid+"'");
			ResultSet rr=pp.executeQuery();
			while(rr.next())
			{
				q1=rr.getString(1);
				an1=rr.getString(2);
				q2=rr.getString(3);
				an2=rr.getString(4);
				q3=rr.getString(5);
				an3=rr.getString(6);
				System.out.println("q1 "+q1+" ans1 "+an1);
			}*/
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			System.out.println("date "+date);
			pre = con.prepareStatement("insert into review_quiz values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pre.setString(1,uid);
			pre.setString(2,tech);
			pre.setInt(3,qid);
			pre.setString(4,q1);
			pre.setString(5,a1);
			pre.setString(6,an1);
			pre.setString(7,q2);
			pre.setString(8,a2);
			pre.setString(9,an2);
			pre.setString(10,q3);
			pre.setString(11,a3);
			pre.setString(12,an3);
			pre.setInt(13,score);
			pre.setTimestamp(14,date);
			pre.setString(15,remark);
			pre.executeUpdate();
			System.out.println("score "+score+"remark "+remark);
			request.setAttribute("qid", qid);
			System.out.println("Set");
			request.setAttribute("tid", tid);
			request.setAttribute("uid", uid);
			request.setAttribute("score", score);
			request.setAttribute("remark", remark);
			request.getRequestDispatcher("DisplayScore").include(request,response);
			//con.close();
	    }
	    catch(Exception e)
	    {
	    	
	    }
	}

}
