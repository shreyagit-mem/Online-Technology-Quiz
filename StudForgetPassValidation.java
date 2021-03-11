

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudForgetPassValidation extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    String password=request.getParameter("pass");
	    String id=request.getParameter("id");
	    int otp=(Integer.parseInt(request.getParameter("otp")));
	    String one=request.getParameter("one");
	    String two=request.getParameter("two");
	    String three=request.getParameter("three");
	    String four=request.getParameter("four");
	    String five=request.getParameter("five");
	    int otpc=Integer.parseInt((one+two+three+four+five));
	    System.out.println("one-- "+one+"two-- "+two+"three-- "+three+"four-- "+four+"five-- "+five+"otp-- "+otpc);
	Connection con=ConnectionProvider.getConnect();
	if(otp==otpc)
	{
	   try {
		   String q="update student set password=?  where Email_ID=? ";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setString(1, password);
		ps.setString(2, id);
		int i=ps.executeUpdate();
		if(i>0)
		{
			System.out.println("Password updated  successfully");
			RequestDispatcher rd=request.getRequestDispatcher("SLogin.html");
			out.println("<html><head></head><body onload=\"alert('Password Changed')\"></body></html>");
			//out.print("<h1 style='color:yellow;'>"+"PAssword updated succcessfully "+"</h1>");	
			rd.include(request, response);
		}
		else
		{
			System.out.println("Password not updated");
			
		}	
	}
	   catch (SQLException e) {
		e.printStackTrace();
	  }
	}
	else
	{
		request.getRequestDispatcher("SLogin.html").include(request, response);
		out.println("<html><head></head><body onload=\"alert('Enter Correct OTP')\"></body></html>");
	}
}
}
