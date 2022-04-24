//UpdateableResultSetTest020.java
package com.nt.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateableResultSetTest20 {
private static final String UPDATE_QUERY="SELECT SID,SNAME,MARKS FROM STUDENT";

public static void main(String[] args) {
	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "user1","1234");
			PreparedStatement ps=con.prepareStatement(UPDATE_QUERY,ResultSet.TYPE_SCROLL_SENSITIVE,
					                                                                                                                                                        ResultSet.CONCUR_UPDATABLE);
			//scrollable resultset 
			ResultSet rs=ps.executeQuery();
			){
		//for read operation 
		if (rs!=null) {
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+""+rs.getFloat(3));
			}//while
		}//if
		
//		//for insert operaion
//		System.out.println("INSERT OPERATION");
//		rs.moveToInsertRow();
//		rs.updateInt(1, 10);
//		rs.updateString(2, "prajkta");
//		rs.updateFloat(3, 78.03f);
//		rs.insertRow();
//		System.out.println();
//		System.out.println("record from top to bottom");
//			rs.beforeFirst();
//		while(rs.next()) {
//			System.out.println(rs.getInt(1)+" "+rs.getString(2)+""+rs.getFloat(3));
//		}
		
	//	updating record 
		System.out.println("updates");
		rs.absolute(2);
		rs.updateString(2, "mouse");
		rs.updateRow();
	while (rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+""+rs.getFloat(3));
	}
		
//		
//		
//		//delete record
//		rs.absolute(1);
//		rs.deleteRow();
		
	}//try
	catch(SQLException se) {
		se.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}//main
}//class
