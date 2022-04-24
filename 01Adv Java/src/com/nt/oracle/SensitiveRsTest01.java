//SensitiveRsTest01.java
package com.nt.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SensitiveRsTest01 {
	private static final String GET_STUD_QUERY="SELECT SID,SNAME,MARKS FROM STUDENT";
	
public static void main(String[] args) {
	try(Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","user1","1234");
			PreparedStatement ps=con.prepareStatement(GET_STUD_QUERY,ResultSet.TYPE_SCROLL_SENSITIVE,
					                                                                                                                                                   ResultSet.CONCUR_UPDATABLE);
			
			//scrollable rs 
		ResultSet rs=ps.executeQuery();
			){
		if (rs!=null) {
			System.out.println("recored from top to bottom");
			int count=0;
			while (rs.next()) {
			if (count==0) {
				System.out.println("modify records in this sleep method");
	                   Thread.sleep(10000);
		      }//if
		rs.refreshRow();
			count++;
			System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getFloat(3));
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
