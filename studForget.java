

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class studForget extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String id=request.getParameter("email");
	boolean b=new studForget().checkLogin(id);
	if(b)
	{
		System.out.println("Student  validation successfully");
		//out.print("Admin validation ");
		//out.println("<html><head></head><body onload=\"alert('Invalid username/password')\"></body></html>");
		request.setAttribute("id", id);
		RequestDispatcher rd=request.getRequestDispatcher("StudForgetPass.jsp");
				rd.include(request, response);
	}
	else
	{
		System.out.println("Student validation unsuccessfully");
		//out.print("Admin not        validation ");
		out.println("<html><head></head><body onload=\"alert('Incorrect ID')\"></body></html>");
		RequestDispatcher rd=request.getRequestDispatcher("StudForgot.jsp");
		rd.include(request, response);

	}
	}

	public   boolean checkLogin(String id) {
		boolean b=false;
		Connection con=ConnectionProvider.getConnect();
		try {
			String q="select * from student where Email_ID=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				if((rs.getString("Email_ID")).equals(id) )
						{
					b=true;
						}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

}
