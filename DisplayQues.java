

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DisplayQues extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    int  qid=(Integer.parseInt(request.getParameter("Quiz")));
	    int  tid=(Integer.parseInt(request.getParameter("techid")));
	    String  uid=request.getParameter("uid");
	    Connection con=ConnectionProvider.getConnect();
	    PreparedStatement ps;
	   // String sid=(String) request.getAttribute("id");
	   // Object id=(Object)qid;
	    //request.setAttribute("id", id);
		try {
			ps = con.prepareStatement("SELECT q1,q2,q3,q1_opA,q1_opB,q1_opC,q1_opD,q2_opA,q2_opB,q2_opC,q2_opD,q3_opA,q3_opB,q3_opC,q3_opD FROM quiz_create where quizid='"+qid+"'");
			ResultSet rs=ps.executeQuery();
			out.println("<a href='studhome.html'><img src=\"logo2.jpg\" class=\"logo\" alt=\"logo\" height=\"80\" width=\"100\" style=\"opacity: 0.9;  filter: grayscale(40%); margin-left:50px\"></a>");
			out.println("<link rel='stylesheet' type='text/css' href='disstyle.css'>");
			out.println("<center>");
			out.println("<form method='post' action='Score'>");
			while(rs.next())
			{
				out.println("<input type='hidden' name='id' value='"+qid+"'/>");
				out.println("<input type='hidden' name='techid' value='"+tid+"'/>");
				out.println("<input type='hidden' name='uid' value='"+uid+"'/>");
				out.println("<input type='text' name='q1' readonly value='"+rs.getString(1)+"'/><br>");
				out.println("<input type='radio' name='a1' value='"+rs.getString(4)+"'/><label>"+rs.getString(4)+"</label>");
				out.println("<input type='radio' name='a1' value='"+rs.getString(5)+"'/><label>"+rs.getString(5)+"</label>");
				out.println("<input type='radio' name='a1' value='"+rs.getString(6)+"'/><label>"+rs.getString(6)+"</label>");
				out.println("<input type='radio' name='a1' value='"+rs.getString(7)+"'/><label>"+rs.getString(7)+"</label><br>");
				out.println("<input type='text' name='q2' readonly value='"+rs.getString(2)+"'/><br>");
				out.println("<input type='radio' name='a2' value='"+rs.getString(8)+"'/><label>"+rs.getString(8)+"</label>");
				out.println("<input type='radio' name='a2' value='"+rs.getString(9)+"'/><label>"+rs.getString(9)+"</label>");
				out.println("<input type='radio' name='a2' value='"+rs.getString(10)+"'/><label>"+rs.getString(10)+"</label>");
				out.println("<input type='radio' name='a2' value='"+rs.getString(11)+"'/><label>"+rs.getString(11)+"</label><br>");
				out.println("<input type='text' name='q3' readonly value='"+rs.getString(3)+"'/><br>");
				out.println("<input type='radio' name='a3' value='"+rs.getString(12)+"'/><label>"+rs.getString(12)+"</label>");
				out.println("<input type='radio' name='a3' value='"+rs.getString(13)+"'/><label>"+rs.getString(13)+"</label>");
				out.println("<input type='radio' name='a3' value='"+rs.getString(14)+"'/><label>"+rs.getString(14)+"</label>");
				out.println("<input type='radio' name='a3' value='"+rs.getString(15)+"'/><label>"+rs.getString(15)+"</label><br>");
			}
			out.println("<br><input type=submit name=submit  value=Submit  /><br>");
			out.println("</form></center>");
			//request.getRequestDispatcher("Score").include(request, response);
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
