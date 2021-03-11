//package questions_quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

//import com.student.db.student;

//import DBConnection.ConnectionProvider;

public class quiz_db {

	public boolean InsertQuiz(quiz_table  quizobj) {
		boolean b=false;
		Connection con=ConnectionProvider.getConnect();
		try {
			String q="insert into quiz_create(quiz_date,tech_id,q1,a1,q2,a2,q3,a3,q1_opA,q1_opB,q1_opC,q1_opD,q2_opA,q2_opB,q2_opC,q2_opD,q3_opA,q3_opB,q3_opC,q3_opD) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  ";
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			PreparedStatement ps=con.prepareStatement(q);
			ps.setTimestamp(1, date);
			ps.setInt(2,quizobj. getTech_id() );
			ps.setString(3, quizobj.getQ1() );		
			ps.setString(4, quizobj.getA1() );		
			ps.setString(5, quizobj.getQ2() );		
			ps.setString(6, quizobj.getA2() );		
			ps.setString(7, quizobj.getQ3() );		
			ps.setString(8, quizobj.getA3() );	
			ps.setString(9, quizobj.getOpt1a());
			ps.setString(10, quizobj.getOpt1b());
			ps.setString(11, quizobj.getOpt1c());
			ps.setString(12, quizobj.getOpt1d());
			ps.setString(13, quizobj.getOpt2a());
			ps.setString(14, quizobj.getOpt2b());
			ps.setString(15, quizobj.getOpt2c());
			ps.setString(16, quizobj.getOpt2d());
			ps.setString(17, quizobj.getOpt3a());
			ps.setString(18, quizobj.getOpt3b());
			ps.setString(19, quizobj.getOpt3c());
			ps.setString(20, quizobj.getOpt3d());
			int i=ps.executeUpdate();
			if(i>0)
						{
								b=true;
						}
				
			}
						 catch (SQLException e) {
							e.printStackTrace();
						 			}
		return b;
				}
	/*
	@Override
	public boolean DeleteQuiz(int sno) {
		boolean b=false;
		Connection con=ConnectionProvider.getConnect();
		String deleteQuery="delete from quiz_create  where sno=?";
					try {
						PreparedStatement ps=con.prepareStatement(deleteQuery);
						ps.setInt(1, sno);
						int i=ps.executeUpdate();
						if(i>0)
						{
							System.out.println("Question Deleted Sucessfully !");
							b=true;
						}
						else
						{
							System.out.println("Deletion failed !");
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
										}
		
		return b;
	}
*/
}
