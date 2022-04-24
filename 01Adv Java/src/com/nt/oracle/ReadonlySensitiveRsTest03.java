//SensitiveRsTest01.java
package com.nt.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadonlySensitiveRsTest03 {
	private static final String GET_STUD_QUERY="SELECT * FROM STUDENT";
	
public static void main(String[] args) {
	try(Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","user1","1234");
			PreparedStatement ps=con.prepareStatement(GET_STUD_QUERY,ResultSet.TYPE_SCROLL_SENSITIVE,
					                                                                                                                                                   ResultSet.CONCUR_READ_ONLY);
						//scrollable rs 
		ResultSet rs=ps.executeQuery();
			){
		if (rs!=null) {
			System.out.println("recored from top to bottom");	
			while (rs.next()) {
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3));
			}//while
		}//if
	}//try
	catch(SQLException se) {
		se.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}//main
}//class
