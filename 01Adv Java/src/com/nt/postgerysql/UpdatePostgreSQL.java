package com.nt.postgerysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import org.postgresql.util.PSQLException;

public class UpdatePostgreSQL {
	private static final String UPDATE_QUERY="UPDATE  STUDENT SET SNAME=? WHERE SID=?";
public static void main(String[] args) { 
	int sid=0;
	String sname=null;
	
	try(Scanner sc=new Scanner(System.in);
	Connection con=DriverManager.getConnection("jdbc:postgresql:ntaj915db","postgres","1234");
	PreparedStatement ps=con.prepareStatement(UPDATE_QUERY);
		){
		//read input from end user
		if (sc!=null) {
		System.out.println("Enter student name::");
		sname=sc.next();
		System.out.println("Enter sid::");
		sid=sc.nextInt();
				}//if
		//set the values for query
		if (ps!=null) {
			ps.setString(1, sname);	
			ps.setInt(2, sid);
				}
		//execute the query
			int count=0;
			count=ps.executeUpdate();
			//reteuving
			if (count==0) 
				System.out.println("Recors is not update");
			else
				System.out.println("Recors is  update");
			}//try
	catch(PSQLException pe) {
		pe.printStackTrace();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}//main
}//class
