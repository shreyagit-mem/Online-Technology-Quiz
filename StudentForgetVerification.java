//package OTPVerification;

		import java.io.IOException;
		import java.io.PrintWriter;
		import java.sql.Connection;
		import java.sql.PreparedStatement;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.sql.Statement;

		import javax.servlet.RequestDispatcher;
		import javax.servlet.ServletException;
		import javax.servlet.http.HttpServlet;
		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;

		//import DBConnection.ConnectionProvider;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

		public class StudentForgetVerification extends HttpServlet {
			
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
			String email=request.getParameter("id");
			String pass=request.getParameter("password");
			Connection con=ConnectionProvider.getConnect();
			System.out.println("Checking Email");
			String mobile_number="";
			try {
				//PreparedStatement st=con.createStatement();
				//boolean b=true;
				//String q="select Email_ID,Mobile_No from student" ;
				//ResultSet rs=st.executeQuery(q);
		             System.out.println("Before while    ");
				//while(rs.next())
				//{
					//if(rs.getString("Email_ID").equals(email))
					//{
						//b=false;
						PreparedStatement ps=con.prepareStatement("select Mobile_No from student where  Email_ID= '"+email+"'");
						ResultSet rs=ps.executeQuery();
						while(rs.next())
						{
						    mobile_number=rs.getString("Mobile_No");
						}
						System.out.println(mobile_number);
						String otp=new SendSms().generatingOTP(mobile_number);
						request.setAttribute("id", email);
						request.setAttribute("pass", pass);
						request.setAttribute("otp", otp);
						 		RequestDispatcher rd = request.getRequestDispatcher("OTP.jsp");
						 System.out.println("Successfully navigated to OTP");
						  
						 
					     rd.include(request, response);
					//}
					
			//	}
					/*if(b)
					{
						RequestDispatcher r = request.getRequestDispatcher("SLogin.html");
						//out.println("<input type='hidden' name='alert' value='1'  id='failedStatus' > "  );
						out.println("<html><head></head><body onload=\"alert('Incorrect ID')\"></body></html>");
						System.out.println("Error ");
						rd.include(request, response);
			
					}*/
				
				}
			catch(SQLException e)
			{
				e.printStackTrace();
				
			}
	 }
		
}

