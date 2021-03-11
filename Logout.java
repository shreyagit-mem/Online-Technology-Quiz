

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logout extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
            out.println("<html><head></head><body onload=\"alert('You are successfully logged out!')\"></body></html>");  
            request.getRequestDispatcher("index.html").include(request, response);  
              
           // String sid=(String) request.getAttribute("id");
           // System.out.println(sid+"-----3");
           // request.setAttribute("sid", sid);
            HttpSession session=request.getSession(); 
            String id=session.getId();
            System.out.println(id+"---4");
            request.setAttribute("id", id);
            //session.invalidate();  
            request.getRequestDispatcher("Session").include(request, response);
            //out.print("You are successfully logged out!");  
              
            out.close();  
	    }
}
