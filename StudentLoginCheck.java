//package com.student.db;
//import com.student.db.StudentRegister;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import DBConnection.ConnectionProvider;

public class StudentLoginCheck {
	public boolean checkStudentLogin(student studobj) {
		boolean b=false;
		Connection con=ConnectionProvider.getConnect();
		try {
			String q="select * from student  where email_id=? && password=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, studobj.getEmail());
			ps.setString(2,studobj.getPassword());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				if(((rs.getString("email_id")).equals(studobj.getEmail()) )  && ((rs.getString("password")).equals(studobj.getPassword())));
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