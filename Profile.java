

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Profile extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Connection con=ConnectionProvider.getConnect();
		try
		{
			PreparedStatement ps=con.prepareStatement("SELECT id,name,Contact_No,Email_ID FROM admin");
			ResultSet rs=ps.executeQuery();
			String css="<link rel='stylesheet' type='text/css' href='profilestyle.css'>";
			out.println("<a href='AdminDash.html'><img src=\"logo2.jpg\" class=\"logo\" alt=\"logo\" height=\"80\" width=\"100\" style=\"opacity: 0.9;  filter: grayscale(40%); margin-left:50px\"></a>");
			out.println("<a href='Logout'>Logout</a>");
			out.println("<html><head>"+css);
			out.println("</head><body background='admback.jpg'");
			out.println("<center><img src='profile.jpg' width='200' style='margin-left:400px; border-image-outset:100px'></center>");
			out.println("<center><p>Admin Detail</p></center><br>");
			while(rs.next())
			{
				out.println("<form method='get' action='AProUpdate'>");
				out.println("<label>ID</label><br>");
				out.println("<input type=\"text\" name=\"id\" readonly placeholder='"+rs.getString(1)+"'value='"+rs.getString(1)+"'/><br>");
				out.println("<label>Name</label><br>");
				out.println("<input type='text' name='name' placeholder='"+rs.getString(2)+"'value='"+rs.getString(2)+"'required='required'/><br>");
				out.println("<label>Contact No.</label><br>");
				out.println("<input type='text' name='no' placeholder='"+rs.getString(3)+"'value='"+rs.getString(3)+"'required='required' pattern=\"[0-9]{10}\" /><br>");
				out.println("<label>Email ID</label><br>");
				out.println("<input type='email' name='email' placeholder='"+rs.getString(4)+"'value='"+rs.getString(4)+"'required='required' /><br>");
			}
			out.println("<br><center><input type=submit name=sub value=Save /></center>");
		    out.println("</form></body></html>");
		}
		catch(Exception e)
		{
			
		}
		 finally
         {
       	  out.close();
		 }
	}
}
