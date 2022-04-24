package com.nt.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test01_PreapredStat {
public static void main(String[] args) {
	Scanner sc=null;
	Connection con=null;
	PreparedStatement ps=null;
	int count=0;
	try {
		//read input from user
		sc=new Scanner(System.in);
		if (sc!=null) 
		System.out.println("Enter Student Count :");
		count=sc.nextInt();
//Establish Connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "user1", "1234");
	if (con!=null) 
		ps=con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?)");
//read multiple student details and set them pre compiled SQL query
	for(int i=1;i<=count;i++) {
		System.out.println("enter student sno");
		int sno=sc.nextInt();
		System.out.println("enter student name");
		String name=sc.next().toUpperCase();
		System.out.println("enter student Marks");
		double mark=sc.nextDouble();
		System.out.println("enter student Add");
		String sadd=sc.next().toUpperCase();
//set each student details query param values
		ps.setInt(1,sno);
		ps.setString(2, name);
		ps.setDouble(3,mark);
		ps.setString(4, sadd);
//execute SQL query
		int result=ps.executeUpdate();
		if (result==0) {
			System.out.println("no record insert");
		}
		System.out.println("record inserted");
	
	}//for
	}//try 
	catch (SQLException se) {
		se.printStackTrace();
	}
	finally {
		try {
			if (ps!=null) 
				ps.close();
		} //try
		catch (SQLException se) {
		se.printStackTrace();
		}//catch
		try {
			if (con!=null) 
				con.close();
		} //try
		catch (SQLException se) {
			se.printStackTrace();
		}//catch
		try {
			if (sc!=null) 
				sc.close();
		} //try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
	   }//finally
	}//main
}//class
