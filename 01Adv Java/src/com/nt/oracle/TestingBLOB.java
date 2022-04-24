//TestingBLOB.java
package com.nt.oracle;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestingBLOB {
	private static final String INSERT_ACTOR_QUERY="INSERT INTO  JDBC_ACTOR_TAB VALUES(ACTOR_SEQ.NEXTVAL,?,?,?)";

public static void main(String[] args) {
	String actorName=null, actorAddrs=null, photoLocation=null;
	try(Scanner sc=new Scanner(System.in);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","user1","1234");
           PreparedStatement ps=con.prepareStatement(INSERT_ACTOR_QUERY);
			){
		//read input
		if (sc!=null) {
		System.out.println("Enter ActressName::");
		actorName=sc.nextLine();
		System.out.println("Enter Addrs::");
		actorAddrs=sc.nextLine();
		System.out.println("Enter PhotoLocation::");
		 photoLocation=sc.nextLine().replace('?',' ').trim();
	}

	//create stream to take photo location
	InputStream is=new FileInputStream(photoLocation);
	//set query  param value
	if (ps!=null) {
		ps.setString(1, actorName);
		ps.setString(2, actorAddrs);
		ps.setBinaryStream(3, is);
	}
	//execute query
	int count=0;
	if (ps!=null) {
		 count=ps.executeUpdate();
		 //process to execute
		 if (count==0) {
			System.out.println("Record insertion problem");
		}else
			System.out.println("Record inserted");
	}
	}//try
	catch(SQLException se) {
		se.printStackTrace();
	}//catch
	catch(Exception e) {
		e.printStackTrace();
	}//catch

}//main
}//class
