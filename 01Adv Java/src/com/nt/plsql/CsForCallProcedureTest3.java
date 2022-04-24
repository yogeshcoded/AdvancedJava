package com.nt.plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Type;

/*CREATE OR REPLACE PROCEDURE P_STUDENT 
(
  NO IN NUMBER 
, NAME OUT VARCHAR2 
, AVG OUT NUMBER 
) AS 
BEGIN
  SELECT SNAME,MARKS INTO NAME,AVG FROM STUDENT WHERE SID=NO;
END P_STUDENT;*/

public class CsForCallProcedureTest3 {
private static final String QUERY="{call  P_STUDENT(?,?,?)}";

public static void main(String[] args) {
String name=null,add=null;
float marks=0;	
int no=0;
	try(Scanner sc=new Scanner(System.in);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "user1", "1234");
			CallableStatement cs=con.prepareCall(QUERY);
			){
		//read input
	while (true) {
		if (sc!=null) {
			System.out.println();
		System.out.println("Enter Student no::");
		no=sc.nextInt();
			
		}//if
		if (cs!=null) {
		//register out parameter with jdbc datatype
		cs.registerOutParameter(2, Types.VARCHAR);
		cs.registerOutParameter(3,Types.FLOAT);
		//set value IN parameter
		cs.setInt(1, no);
		
	//	cs.setFloat(4, marks);
		//call PL/SQL procedure
		cs.execute();
		//gather result from OUT parameter
		System.out.println("Student Name::"  +cs.getString(2));
		System.out.println("Student AVg::"     +cs.getFloat(3));
		}//if
		}//try
	}//while
	catch(SQLException se) {
		System.out.println("Please Enter corrrect student no");
	//	se.printStackTrace();
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}//main
}//class
