

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S_Regis extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("name");
		String u=request.getParameter("univ");
		String c=request.getParameter("colg");
		String d=request.getParameter("dob");
		String p=request.getParameter("phnno");
		String e=request.getParameter("email");
		String pwd=request.getParameter("passwd1");
		//String cps=request.getParameter("cpasswd");
		String g=request.getParameter("gender");
		
		try{
			Connection con = null;

		    String url = "jdbc:mysql://localhost:3306/OTQuiz";
		    String username = "root";
		    String password ="Shreya";
			Class.forName("com.mysql.jdbc.Driver");
		      con = DriverManager.getConnection(url, username, password);
		      java.util.Date utilDate = new java.util.Date();
	          java.sql.Date date = new java.sql.Date(utilDate.getTime());
	          java.sql.Time time = new java.sql.Time(utilDate.getTime());
        PreparedStatement ps=con.prepareStatement("insert into Student values(?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1,n);
		ps.setString(2,u);
		ps.setString(3,c);
		ps.setString(4,d);
		ps.setString(5,p);
		ps.setString(6,e);
		ps.setString(7,pwd);
		//ps.setString(8,cps);
		ps.setString(8,g);
		ps.setString(9,"Pending");
		ps.setDate(10,date);
		ps.setTime(11,time);
		
		int i=ps.executeUpdate();
		if(i>0)
		//out.print("You are successfully Registered...");
		{ out.println("<html><head></head><body onload=\"alert('Your request has been registered sucessfully.Thank You for choosing us!')\"></body></html>");
	     RequestDispatcher rd = request.getRequestDispatcher("index.html");
	     rd.include(request, response);
	     con.close();
		}
		/*else
		{
			out.println("<html><head></head><body onload=\"alert('Your request has been registered sucessfully.Thank You for choosing us!')\"></body></html>");
		    RequestDispatcher rd = request.getRequestDispatcher("index.html");
		    rd.include(request, response);
		}*/
		
		
		
		}catch (Exception e2) 
		{  System.out.println(e2);
		   out.println("<html><head></head><body onload=\"alert('You are already registered')\"></body></html>");
	     RequestDispatcher rd = request.getRequestDispatcher("index.html");
	     rd.include(request, response);
		}
		
		out.close();
	}

}
