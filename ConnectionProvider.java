//package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
			public static Connection getConnect() 
		{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OTQuiz", "root","Shreya");
			if(con!=null)
				System.out.println("connected");
			else
				System.out.println("not connected ");
		} 
		
		catch (Exception e) {
				e.printStackTrace();
		}
			return con;
	}
}
