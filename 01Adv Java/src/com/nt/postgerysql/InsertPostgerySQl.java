package com.nt.postgerysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import org.postgresql.util.PSQLException;

public class InsertPostgerySQl {
	private static  final String  INSERT_QUERY="INSERT INTO STUDENT VALUES (nextval('SID_SEQ'),?,?, ?)";
	
public static void main(String[] args)   {
		String sname = null, course =null; 
		int fee=0;
		try(Scanner sc=new Scanner(System.in);
			Connection con=DriverManager.getConnection("jdbc:postgresql:ntaj915db","postgres","1234");
			PreparedStatement ps=con.prepareStatement(INSERT_QUERY);
			){ 
		//read inputs
		if (sc!=null) {
		System.out.println("Enter student Name");
		sname=sc.next();
		System.out.println("Enter course"); 
		course=sc.next();
		System.out.println("Enter Fee");
		fee=sc.nextInt();  
			}//if
		//set the values
		if (ps!=null) {
			ps.setString(1,sname);
			ps.setString(2, course);
			ps.setInt(3, fee);
				}//if
		//execute the query
	int count=0;
		count=ps.executeUpdate();
		
		//process the result
		  if (count==0) { 
		System.out.println("record insertion problem");
		}
		  else {
		  System.out.println("Record is inserted"); 
		  }
		 
	}//try
	catch(PSQLException se) {
           se.printStackTrace();
}//catch
	catch(Exception e) {
		e.printStackTrace();
	}//catch
}//main
}//class
