

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StudQues extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();	
		int  tech=Integer.parseInt(request.getParameter("Tech"));
		String uid="";
		out.println("<a href='studhome.html'><img src=\"logo2.jpg\" class=\"logo\" alt=\"logo\" height=\"80\" width=\"100\" style=\"opacity: 0.9;  filter: grayscale(40%); margin-left:50px\"></a>");
		Connection con=ConnectionProvider.getConnect();
		HttpSession session=request.getSession(); 
        String sid=session.getId();
		System.out.println(sid);
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT uid FROM login_detail where sid='"+sid+"'");
			ResultSet r=p.executeQuery();
			while(r.next())
			{
				uid=r.getString(1);
			}
			PreparedStatement ps=con.prepareStatement("SELECT quizid FROM quiz_create where tech_id='"+tech+"'");
			ResultSet rs=ps.executeQuery();
			out.println("<link rel='stylesheet' type='text/css' href='profilestyle.css'>");
			out.println("<center>");
			if(!(rs.next()))
			{
				out.println("<p>No Records Found</p>");
			}
			else
			{
			out.println("<form method=post   action='DisplayQues'>");
			out.println("<b><h2> Quiz </h2></b><br>");
			out.println("<label for='Quiz'> Choose Quiz ID:</label>");
			out.println("<input type='hidden' name='techid' value='"+tech+"'/>");
			out.println("<input type='hidden' name='uid' value='"+uid+"'/>");
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
