//package com.student.db;
//import com.student.db.StudentRegister;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import DBConnection.ConnectionProvider;

public class AdminLoginCheck {
	public boolean checkAdminLogin(admin admobj) {
		boolean b=false;
		Connection con=ConnectionProvider.getConnect();
		try {
			String q="select * from admin  where id=? && password=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, admobj.getEmail());
			ps.setString(2,admobj.getPassword());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				if(((rs.getString("id")).equals(admobj.getEmail()) )  && ((rs.getString("password")).equals(admobj.getPassword()) ))
				{
					b=true;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
}