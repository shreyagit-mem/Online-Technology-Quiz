

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

public class studProfile extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        Connection con=ConnectionProvider.getConnect();
        String uid="";
        HttpSession session=request.getSession(); 
        String sid=session.getId();
        System.out.println(sid+"---1");
        try
        {
        	PreparedStatement ps=con.prepareStatement("SELECT UID FROM login_detail where SID='"+sid+"'");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				uid=rs.getString(1);
				System.out.println(uid);
			}
			PreparedStatement p=con.prepareStatement("SELECT Name,University,College,Date_Of_Birth,Mobile_No,Email_ID,Gender FROM student where Email_ID='"+uid+"'");
			ResultSet r=p.executeQuery();
			out.println("<link rel='stylesheet' type='text/css' href='profilestyle.css'>");
			out.println("<a href='studhome.html'><img src=\"logo2.jpg\" class=\"logo\" alt=\"logo\" height=\"80\" width=\"100\" style=\"opacity: 0.9;  filter: grayscale(40%); margin-left:50px\"></a>");
			out.println("<html><head>");
			out.println("</head><body background='admback.jpg'");
			out.println("<center><img src='profile.jpg' width='200' style='margin-left:400px; border-image-outset:100px'></center>");
			out.println("<center>Student Detail</center><br>");
			while(r.next())
			{
				//System.out.println(uid);
				out.println("<form method='get' action='studProUpdate'>");
				out.println("<label>Name</label><br>");
				out.println("<input type=\"text\" name=\"name\" placeholder='"+r.getString(1)+"'value='"+r.getString(1)+"'required='required' /><br>");
				out.println("<label>University</label><br>");
				out.println("<input type='text' name='uni' placeholder='"+r.getString(2)+"'value='"+r.getString(2)+"'required='required' /><br>");
				out.println("<label>College</label><br>");
				out.println("<input type='text' name='colg' placeholder='"+r.getString(3)+"'value='"+r.getString(3)+"'required='required' /><br>");
				out.println("<label>Date of Birth</label><br>");
				out.println("<input type='date' name='dob' placeholder='"+r.getString(4)+"'value='"+r.getString(4)+"' required='required' /><br>");
				out.println("<label>Contact No.</label><br>");
				out.println("<input type='text' name='no' placeholder='"+r.getString(5)+"'value='"+r.getString(5)+"' required='required' pattern=\"[0-9]{10}\" /><br>");
				out.println("<label>Email ID</label><br>");
				out.println("<input type='email' name='email' readonly placeholder='"+r.getString(6)+"'value='"+r.getString(6)+"' required='required' /><br>");
				out.println("<label>Gender</label><br>");
				out.println("<input type='text' name='gender' placeholder='"+r.getString(7)+"'value='"+r.getString(7)+"' required='required' /><br>");
			}
			out.println("<br><center><input type=submit name=sub value=Save /></center>");
		    out.println("</form></body></html>");
        }
        catch(Exception e)
        {
        	
        }
	}
}
