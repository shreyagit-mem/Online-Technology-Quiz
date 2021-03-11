

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

public class StPass extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        Connection con=ConnectionProvider.getConnect();
        String uid="";
        String pass = null;
        HttpSession session=request.getSession(); 
        String sid=session.getId();
        String s1= request.getParameter("old");
		String s2= request.getParameter("new");
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT UID FROM login_detail where SID='"+sid+"'");
			ResultSet r=p.executeQuery();
			while(r.next())
			{
				uid=r.getString(1);
				//System.out.println(uid);
			}
			PreparedStatement pp=con.prepareStatement("select Password from student where Email_ID='"+uid+"'");
			ResultSet rr=pp.executeQuery();
			while(rr.next())
			{
				pass=rr.getString(1);
				//System.out.println(pass);
			}
			if(pass.equals(s1))
			{
			   //System.out.println("Outside");
			   PreparedStatement ps=con.prepareStatement("update student set Password='"+s2+"'where Email_ID='"+uid+"'");
			   ps.executeUpdate();
			   //System.out.println("Inside");
			   out.println("<html><head></head><body onload=\"alert('Password Updated Successfully')\"></body></html>");
			   request.getRequestDispatcher("studhome.html").include(request, response);
			}
			else
			{
				out.println("<html><head></head><body onload=\"alert('Enter current password correctly!')\"></body></html>");
				request.getRequestDispatcher("studPass.jsp").include(request, response);
			}
		}
		catch(Exception e)
		{
			
		}
	}
}
