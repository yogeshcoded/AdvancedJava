//DeleteTest.java
/*Application delete records based on student name
 * Author::Team-js
 * Version:1.0
 */
package com.nit.Mysql;      
//Explicitly import
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {
@SuppressWarnings("resource")
public static void main(String[] args) {
	Scanner sc=null;
	Connection con=null;
	Statement st=null;
	
	try {
		//read input
		sc=new Scanner(System.in);
		System.out.println("Enter Student1 Name:");
		String Fname=sc.next().toUpperCase();
		System.out.println("Enter Student2 Name:");
		String Sname=sc.next().toUpperCase();
	
		//DELETE FROM STUDENT WHERE SNAME IN('RAJA','RANI');
		//Establish connection
				con=DriverManager.getConnection("jdbc:mysql:///student","root","1234");
		//prepare statement
		if (con!=null) 
			st=con.createStatement();
		//prepare query
		String query="DELETE FROM STUDENT WHERE SNAME IN('"+Fname+"','"+Sname+"')";
		//send and execute query
		int count=0;
		if (st!=null) 
		count=st.executeUpdate(query); 
			if(count==0) 
			System.out.println("No record found for delete");
			else 
				System.out.println("Recoed found and deleted");
			}//try 
	catch (SQLException se) {
		se.printStackTrace();
	}//catch
	catch (Exception e) {
		e.printStackTrace();
	}//catch
	
	finally {
		try {
			if (st!=null) 
				st.close();
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
