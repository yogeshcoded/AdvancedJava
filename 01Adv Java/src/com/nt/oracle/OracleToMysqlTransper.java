//OracleToMysqlTransper.java
package com.nt.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleToMysqlTransper {
private static final String MYSQL_INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?)";
private static final String GET_QUERY_TO_ORACLE="SELECT * FROM STUDENT";
	public static void main(String[] args) {
		try {
			//loading driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");    //for oracle
			Class.forName("com.mysql.cj.jdbc.Driver");    //for mysql
			
		}//try
		catch (ClassNotFoundException  cnf) {
			cnf.printStackTrace();
		}//catch
try(//Establish connection
		Connection oraCon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","root");
	    Connection mysqlCon=DriverManager.getConnection("jdbc:mysql:///student","root","1234");
		
		//create statement object
		Statement oraSt=oraCon.createStatement();
		PreparedStatement mysqlPs=mysqlCon.prepareStatement(MYSQL_INSERT_QUERY);
		//execute query from oracle
		ResultSet rs=oraSt.executeQuery(GET_QUERY_TO_ORACLE);
		){
	if (rs!=null) {
		while (rs.next()) {
			//get each record form oralce db through rs
			int sid=rs.getInt(1);
			String name=rs.getString(2);
		//	String sadd=rs.getString(3);
			float marks=rs.getFloat(3);
			//set received  value to mysql db
			mysqlPs.setInt(1, sid);
			mysqlPs.setString(2,name);
//			mysqlPs.setString(3, sadd);
			mysqlPs.setFloat(3, marks);
			//execute query
			mysqlPs.executeUpdate();
		}//while
		System.out.println("Record is Transferd from mysql  to oracle db");
	}//if
	
}//try close all objects 
catch (SQLException se) {
	se.printStackTrace();
	System.out.println("record insertion problem");
}//catch
catch (Exception e) {
	e.printStackTrace();
	System.out.println("record insertion problem");
}//catch
	}//main

}
