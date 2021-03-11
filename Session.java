

import java.beans.Statement;
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


public class Session extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String sid=(String) request.getAttribute("id");
		System.out.println(sid+"---2");
	    HttpSession session=request.getSession();
		String uid=(String) session.getAttribute("email");
		PrintWriter out=response.getWriter();
		Connection con=ConnectionProvider.getConnect();
		int n=0;
		try
		{
			//java.sql.Statement s=con.createStatement();
			PreparedStatement ps=con.prepareStatement("Select count(*) from Login_Detail where sid='"+sid+"'");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				n=rs.getInt(1);
				System.out.println(n);
			}
			if(n==0) // checks if session id is already present or not
			{
				java.util.Date utilDate = new java.util.Date();
	            java.sql.Date date = new java.sql.Date(utilDate.getTime());
	            java.sql.Time time = new java.sql.Time(utilDate.getTime());
	            System.out.println(date+" "+time);
	            //java.sql.Timestamp time = new java.sql.Timestamp(utilDate.getTime());
	            String sql="insert into Login_Detail(UID,SID,Login_Date,Login_Time,offline)values(?,?,?,?,?)";
	            PreparedStatement p=con.prepareStatement(sql);
	            p.setString(1, uid);
	            p.setString(2, sid);
	            p.setDate(3, date);
	            p.setTime(4, time);
	            p.setBoolean(5, false);
	            p.executeUpdate();
	            //s.execute("insert into Login_Detail(UID,SID,Login_Date,Login_Time,offline) values('"+uid+"'"+"'"+sid+"'"+"'"+date+"'"+"'"+time+"'"+"'"+false+"'");
			}
			else
			{
				java.util.Date utilDate = new java.util.Date();
	            java.sql.Date date = new java.sql.Date(utilDate.getTime());
	            java.sql.Time time = new java.sql.Time(utilDate.getTime());
	            String sql="update Login_Detail set Logout_Date=?,Logout_Time=?,offline=? where sid=?";
	            PreparedStatement p=con.prepareStatement(sql);
	            p.setDate(1, date);
	            p.setTime(2, time);
	            p.setBoolean(3, true);
	            p.setString(4, sid);
				//PreparedStatement p=con.prepareStatement("update Login_Detail set Logout_Date='"+date+"'"+",Logout_Time='"+time+"'"+",offline='"+true+"'"+"where uid='"+uid+"'");
				p.executeUpdate();
				session.invalidate();
			}
		}
		catch(Exception e)
		{
			
		}
		out.close();
	}
}
