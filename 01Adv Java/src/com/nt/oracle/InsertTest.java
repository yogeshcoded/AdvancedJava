package com.nt.oracle;

//InsertTest.java
/*Application insert the  records into table
  * Author::Team-is
 * Version:1.0
 */
      
//Explicitly import
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
public static void main(String[] args) {
	Scanner sc=null;
	Connection con=null;
	Statement st=null;
		try {
		//read input
		sc=new Scanner(System.in);
		System.out.println("Enter SName Name:");
		String SName=sc.next().toUpperCase();
		System.out.println("Enter SAdds Name:");
		String SAdds=sc.next().toUpperCase();
		System.out.println("Enter SID Name:");
	      int no=sc.nextInt();
	System.out.println("Enter AVG Name:");
	  double avg=sc.nextDouble();
		//INSERT INTO STUDENT VALUES(106,'BHAVESH',48.56,'KOKAN');
		//Establish connection
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","user1","1234");
		//prepare statement
		if (con!=null) 
			st=con.createStatement();
		//prepare query
		String query="INSERT INTO STUDENT VALUES("+no+",'"+SName+"',"+avg+",'"+SAdds+"')";
		System.out.println(query);
		//send and execute query
		int count=0;
		if (st!=null) 
		count=st.executeUpdate(query); 
			if(count==0) 
			System.out.println("No record found ");
			else 
				System.out.println("Student values inserted");
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
