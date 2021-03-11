

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class St_Login extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("user");
		String password=request.getParameter("pass");
		student studobj=new student(email,password);
		boolean b=	new StudentLoginCheck().checkStudentLogin(studobj);
		if(b)
		{
			try {
			Connection c= null;
			Statement st=null;
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/OTQuiz", "root", "Shreya");
			st=c.createStatement();
			ResultSet rs=st.executeQuery("select status from student where email_id='"+email+"'"+"&& password='"+password+"'");
			while(rs.next())
		    {
			    if((rs.getString(1)).equals("Reject"))
			     {  //System.out.println("Login successful");
			    	out.println("<html><head></head><body onload=\"alert('We're sorry! Your request has been rejected')\"></body></html>");
				    RequestDispatcher rd = request.getRequestDispatcher("SLogin.html");
				    rd.include(request, response);
			     }
			     else if ((rs.getString(1)).equals("Pending"))
			     {
			    	 out.println("<html><head></head><body onload=\"alert('Your request is in process')\"></body></html>");
				     RequestDispatcher rd = request.getRequestDispatcher("SLogin.html");
				     rd.include(request, response);
			     }
			     else
			    {	
			    	HttpSession session=request.getSession();
			 		String sid=request.getSession().getId();
			 		session.setAttribute("email",email);
					request.setAttribute("id", sid);
			    	request.getRequestDispatcher("studhome.html").include(request, response);
			    	request.getRequestDispatcher("Session").include(request, response);
			    }
		      }
			}
			catch(Exception e)
			{
			}
		}		
		else
		{
			out.println("Login failed");
			out.println("<html><head></head><body onload=\"alert('Invalid username/password')\"></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("SLogin.html");
			//out.println("<input type='hidden' name='alert' value='1'  id='failedStatus' > "  );
			//response.setStatus(2);
			rd.include(request, response);
		}
	}
}
