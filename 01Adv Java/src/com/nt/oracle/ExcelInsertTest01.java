package com.nt.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcelInsertTest01 {
	private static final String INSERT_STUD_QUERY="INSERT INTO Sheet1 VALUES(?,?,?,?)";
public static void main(String[] args) {
	try(Connection con=DriverManager.getConnection("jdbc:Excel:///D:/Adv Java/NOTES/Student.xlsx");
			PreparedStatement ps=con.prepareStatement(INSERT_STUD_QUERY);
			){
		//set param values
		if (ps!=null) {
			ps.setInt(1, 101);
			ps.setString(2,"yogesh");
			ps.setString(3, "java");
			ps.setInt(4, 1000);
			
			//execute query
			int result=ps.executeUpdate();
			if (result==0) 
				System.out.println("record not insertred");
			else
				System.out.println("record is updated");
			}//if
		}//try
	catch (SQLException se) {
		se.printStackTrace();
	}
	catch (Exception e) {
	e.printStackTrace();
	}
}//main
}//class
