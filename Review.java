

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

public class Review extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Connection con=ConnectionProvider.getConnect();
		HttpSession session=request.getSession();
 		String sid=session.getId();
 		String uid="",a1="",a2="",a3="";
 		out.println("<link rel='stylesheet' type='text/css' href='review.css'>");
		out.println("<body background='admback.jpg'>");
		out.println("<a href='studhome.html'><img src=\"logo2.jpg\" class=\"logo\" alt=\"logo\" height=\"80\" width=\"100\" style=\"opacity: 0.9;  filter: grayscale(40%); margin-left:50px\"></a>");
		out.println("<a href='Logout'>Logout</a>");
 		try
 		{
 			PreparedStatement ps=con.prepareStatement("SELECT UID FROM login_detail where SID='"+sid+"'");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				uid=rs.getString(1);
				System.out.println("user id: "+uid);
			}
			PreparedStatement p=con.prepareStatement("SELECT * FROM review_quiz where UID='"+uid+"'");
			ResultSet r=p.executeQuery();
			if(!(r.next()))
			{
				out.println("<p>No Records Found</p>");
			}
			else
			{ 
				if(r.getString(5)==null)
				{
					a1="Unanswered";
				}
				else
				{
					a1=r.getString(5);
				}
				if(r.getString(8)==null)
				{
					a2="Unanswered";
				}
				else
				{
					a2=r.getString(8);
				}
				if(r.getString(11)==null)
				{
					a3="Unanswered";
				}
				else
				{
					a3=r.getString(11);
				}
				out.println("<p><i>Technology: </i>"+r.getString(2)+"<br> <i>Quiz ID: </i>"+r.getString(3)+"<br><i> Question 1:</i> "+r.getString(4));
				out.println("<br><i> Your Answer:</i> "+a1+"<br><i> Correct Answer:</i> "+r.getString(6)+"<br>");
				out.println("<i> Question 2: </i>"+r.getString(7)+"<br><i> Your Answer: </i>"+a2+"<br> <i>Correct Answer:</i> "+r.getString(9)+"<br>");
				out.println("<i> Question 3:</i> "+r.getString(10)+"<br><i> Your Answer:</i> "+a3+"<br><i> Correct Answer:</i> "+r.getString(12)+"<br>");
				out.println("<i> Score: </i>"+r.getString(13)+"<br> <i>Remark:</i> "+r.getString(15)+"<br><hr></p></body>");
			while(r.next())
			{
				System.out.println("Done1");
				out.println("<p><i>Technology: </i>"+r.getString(2)+"<br> <i>Quiz ID: </i>"+r.getString(3)+"<br><i> Question 1:</i> "+r.getString(4));
				out.println("<br><i> Your Answer:</i> "+a1+"<br><i> Correct Answer:</i> "+r.getString(6)+"<br>");
				out.println("<i> Question 2: </i>"+r.getString(7)+"<br><i> Your Answer: </i>"+a2+"<br> <i>Correct Answer:</i> "+r.getString(9)+"<br>");
				out.println("<i> Question 3:</i> "+r.getString(10)+"<br><i> Your Answer:</i> "+a3+"<br><i> Correct Answer:</i> "+r.getString(12)+"<br>");
				out.println("<i> Score: </i>"+r.getString(13)+"<br> <i>Remark:</i> "+r.getString(15)+"<br><hr></p></body>");
				System.out.println("Done2");
			}
 		}
 		}
 		catch(Exception e)
 		{
 			
 		}
	}
}
