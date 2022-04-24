package com.nt.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test02_PreapredUpdate3 {
private static final String DELETE_CUSTOMER_BY_CID="DELETE FROM  CUSTOMER WHERE CID=?";
	
public static void main(String[] args) {
	Scanner sc=null;
	Connection con=null;
	PreparedStatement ps=null;
	int count=0;
	try {
		//read input from user
		sc=new Scanner(System.in);
		if (sc!=null) 
		System.out.println("Enter customer Count :");
		count=sc.nextInt();
//Establish Connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "user1", "1234");
	if (con!=null) 
		ps=con.prepareStatement(DELETE_CUSTOMER_BY_CID);
//read multiple customer details and set them pre-compiled SQL query
	for(int i=1;i<=count;i++) {
		System.out.println("enter customer Customer ID");
		int cid=sc.nextInt();
	
//set each customer details query param values
		ps.setInt(1, cid);
//execute SQL query
		int result=ps.executeUpdate();
				if (result==0) {
			System.out.println("NO RECORD FOUND");
		}else
		System.out.println("RECORD DELETED");
	
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
