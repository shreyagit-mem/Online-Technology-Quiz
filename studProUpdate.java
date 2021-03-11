

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class studProUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String name= request.getParameter("name");
		String uni= request.getParameter("uni");
		String colg= request.getParameter("colg");
		String dob= request.getParameter("dob");
		String no= request.getParameter("no");
		String id= request.getParameter("email");
		String gender= request.getParameter("gender");
		PrintWriter out=response.getWriter();
		Connection con=ConnectionProvider.getConnect();
		try
		{
			PreparedStatement ps=con.prepareStatement("update student set Name='"+name+"',University='"+uni+"',College='"+colg+"',Date_Of_Birth='"+dob+"',Mobile_No='"+no+"',Gender='"+gender+"'where Email_ID='"+id+"'");
			ps.executeUpdate();
			out.println("<html><head></head><body onload=\"alert('Update Sucessfull')\"></body></html>");
			request.getRequestDispatcher("studProfile").include(request, response);
		}
		catch(Exception e)
		{
			
		}
	}
}
