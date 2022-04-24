//TestingCLOB.java
package com.nt.oracle;




import java.io.FileReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestingCLOB {
	private static final String INSERT_CANDIDATE_QUERY="INSERT INTO  JDBC_CANDIDATE_TAB VALUES(CANDIDATE_SEQ.NEXTVAL,?,?,?)";

public static void main(String[] args) {
	String candidateName=null, candidateAddrs=null, fileLocation=null;
	try(Scanner sc=new Scanner(System.in);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","user1","1234");
           PreparedStatement ps=con.prepareStatement(INSERT_CANDIDATE_QUERY);
			){
		//read input
		if (sc!=null) {
		System.out.println("Enter CandidateName::");
		candidateName=sc.nextLine();
		System.out.println("Enter CandidateAddrs::");
		candidateAddrs=sc.nextLine();
		System.out.println("Enter FIleLocation::");
		 fileLocation=sc.nextLine();
	}

	//create stream to take photo location
	FileReader file =new FileReader(fileLocation);
	//set query  param value
	if (ps!=null) {
		ps.setString(1, candidateName);
		ps.setString(2, candidateAddrs);
		ps.setCharacterStream(3, file);
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
	catch(IOException io) {
		io.printStackTrace();
	}//catch
	catch(Exception e) {
		e.printStackTrace();
	}//catch

}//main
}//class
