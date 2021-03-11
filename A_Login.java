

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class A_Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String email=request.getParameter("user");
	String password=request.getParameter("pass");
	admin admobj=new admin(email,password);
	boolean b=	new AdminLoginCheck().checkAdminLogin(admobj);
	if(b)
	{
		System.out.println("Login successful");
		HttpSession session=request.getSession();
		String sid=request.getSession().getId();
		System.out.println(sid+"----1");
		session.setAttribute("email",email);
		request.setAttribute("id", sid);
		RequestDispatcher rd=request.getRequestDispatcher("AdminDash.html");
				rd.include(request, response);
		request.getRequestDispatcher("Session").include(request, response);
	}
	else
	{
		System.out.println("Login failed");
		out.println("<html><head></head><body onload=\"alert('Invalid username/password')\"></body></html>");
		// out.println("<body style='color:red;font-size:20px'>Username/Password is incorrect");
		//out.println("<input type='hidden' name='alert' value='1'  id='failedStatus' > "  );
		RequestDispatcher rd = request.getRequestDispatcher("Admin.html");
		//out.println("<script>document.getElementById('message').innerHTML='Sorry UserName or Password'; </script>");
		rd.include(request, response);
	}
}


		
	}

