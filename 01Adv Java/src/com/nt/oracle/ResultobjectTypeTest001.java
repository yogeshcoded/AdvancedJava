package com.nt.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultobjectTypeTest001 {
public static void main(String[] args) {
	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "user1", "1234");
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery("SELECT EMPNO,ENAME,JOB,SAL FROM EMP");
			){
		if (rs!=null) {
			System.out.println("Records top to bottom");
			System.out.println();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+" "+rs.getNString(3)+" "+rs.getFloat(4));
			}//while
		}//if
		System.out.println("======================================================");
		System.out.println();
		rs.afterLast();
		System.out.println("Records from bottom to top");
		System.out.println();
		while (rs.previous()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+" "+rs.getNString(3)+" "+rs.getFloat(4));
		}
		System.out.println("======================================================");
		
		rs.first();
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+" "+rs.getNString(3)+" "+rs.getFloat(4));
		rs.last();
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+" "+rs.getNString(3)+" "+rs.getFloat(4));
		rs.relative(-5);
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+" "+rs.getNString(3)+" "+rs.getFloat(4));
		System.out.println(rs.getRow());
		rs.absolute(14);
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+" "+rs.getNString(3)+" "+rs.getFloat(4));
		rs.relative(-9);
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+" "+rs.getNString(3)+" "+rs.getFloat(4));
		System.out.println(rs.getRow());
		rs.absolute(10);
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+" "+rs.getNString(3)+" "+rs.getFloat(4));
	
	}//try
	catch(SQLException se) {
		se.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
