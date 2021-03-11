

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class A_Update extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String s1= request.getParameter("id");
		String s2= request.getParameter("action");
		System.out.println(s2);
		PrintWriter out=response.getWriter();
		Connection con=ConnectionProvider.getConnect();
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT status FROM student where email_id='"+s1+"'");
			ResultSet r=p.executeQuery();
			while(r.next())
			{
				if(!(r.getString(1).equals("Pending")))
				{
					out.println("<html><head></head><body onload=\"alert('Action on entered ID already taken')\"></body></html>");
					request.getRequestDispatcher("Req_Pending").include(request, response);
				}	
			}
			
			if(s2.equalsIgnoreCase("Accept"))
			{
				PreparedStatement ps=con.prepareStatement("update student set status='Approve' where email_id='"+s1+"'");
				int i=ps.executeUpdate();
				if(i>0)
				{  out.println("<html><head></head><body onload=\"alert('Request Approved Successfully')\"></body></html>");
				   request.getRequestDispatcher("Req_Pending").include(request, response);
				}
				else
				{
					out.println("<html><head></head><body onload=\"alert('Wrong ID Entered')\"></body></html>");
					request.getRequestDispatcher("Req_Pending").include(request, response);
				}
			}
			else
			{
				PreparedStatement ps=con.prepareStatement("update student set status='Reject' where email_id='"+s1+"'");
				int a=ps.executeUpdate();
				if(a>0)
				{ out.println("<html><head></head><body onload=\"alert('Request Rejected')\"></body></html>");
				  request.getRequestDispatcher("Req_Pending").include(request, response);
				}
				else
				{
					out.println("<html><head></head><body onload=\"alert('Wrong ID Entered')\"></body></html>");
					request.getRequestDispatcher("Req_Pending").include(request, response);
				}
			}
			
	//	} // else close
		//	} // while close
		} // try close	
		catch(Exception e)
		{
			
		}
	}
}
