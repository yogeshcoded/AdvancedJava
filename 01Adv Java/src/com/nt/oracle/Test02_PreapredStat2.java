package com.nt.oracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test02_PreapredStat2 {
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
		ps=con.prepareStatement("INSERT INTO CUSTOMER VALUES(?,?,?,?)");
//read multiple customer details and set them pre compiled SQL query
	for(int i=1;i<=count;i++) {
		System.out.println("enter customer CID");
		int cid=sc.nextInt();
		System.out.println("enter customer name");
		String name=sc.next();
		System.out.println("enter customer Add");
		String add=sc.next();
		System.out.println("enter customer MNo:");
		long mno=sc.nextLong();
//set each customer details query param values
		ps.setInt(1,cid);
		ps.setString(2, name);
		ps.setString(3,add);
		ps.setLong(4, mno);
//execute SQL query
		int result=ps.executeUpdate();
		System.out.println(ps);
		if (result==0) {
			System.out.println("no record update");
		}
		System.out.println("record update");
	
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
