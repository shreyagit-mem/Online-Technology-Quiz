

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayScore extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//System.out.println("Display");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int qid=(int) request.getAttribute("qid");
		int tid=(int) request.getAttribute("tid");
		String uid=(String) request.getAttribute("uid");
		String remark=(String) request.getAttribute("remark");
		int score=(int) request.getAttribute("score");
		String tech="";
		out.println("<a href='studhome.html'><img src=\"logo2.jpg\" class=\"logo\" alt=\"logo\" height=\"80\" width=\"100\" style=\"opacity: 0.9;  filter: grayscale(40%); margin-left:50px\"></a>");
		out.println("<html><head>");
		out.println("</head><body background='admback.jpg'>");
		out.println("<a href='Logout'>Logout</a>");
		if(tid==1)
		{
			tech="Java";
		}
		else if(tid==2)
		{
			tech="Python";
		}
		else if(tid==3)
		{
			tech="SQL";
		}
		else
		{
			tech="Data Science";
		}
		out.println("<h2>Thank You!!</h2>");
		out.println("<link rel='stylesheet' type='text/css' href='result.css'>");
		out.println("<p><i>Quiz ID: </i>"+qid+"<br>");
		out.println("<i>Technology: </i>"+tech+"<br>");
		out.println("<i>Score: </i>"+score+"<br>");
		out.println("<i>Remark: </i>"+remark+"<br></p>");
		out.println("</body></html>");
	}
}
