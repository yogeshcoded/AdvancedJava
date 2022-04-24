package com.nt.oracle;

//UpdateTest.java
/*Application update the  records based on given condition
  * Author::Team-is
 * Version:1.0
 */
      
//Explicitly import
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {
public static void main(String[] args) {
	Scanner sc=null;
	Connection con=null;
	Statement st=null;
		try {
		//read input
		sc=new Scanner(System.in);
		System.out.println("Enter SName Name:");
		String SName=sc.next().toUpperCase();
	//	System.out.println("Enter SAdds Name:");
	//String SAdds=sc.next().toUpperCase();
		System.out.println("Enter SID Name:");
	      int no=sc.nextInt();
	System.out.println("Enter MARKS Name:");
	  double mark=sc.nextDouble();
		//UPDATE STUDENT SET SID=106,MARKS=87.00 WHERE SNAME='KOMAL';
		//Establish connection
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","user1","1234");
		//prepare statement
		if (con!=null) 
			st=con.createStatement();
		//prepare query
		String query="UPDATE STUDENT SET SID="+no+",MARKS="+mark+" WHERE SNAME='"+SName+"'";
	//	System.out.println(query);
		//send and execute query
		int count=0;
		if (st!=null) {
		count=st.executeUpdate(query); 
		}
		//process the result
			if (count==0) {
				System.out.println("record not update");
			} else {
				System.out.println(count+ "  record is update");
			}
				
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
