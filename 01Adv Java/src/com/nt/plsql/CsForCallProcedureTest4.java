package com.nt.plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsForCallProcedureTest4 {
private static final String AUTHENTICATION_QUERY="{call P_AUTHENTICATION(?,?,?)}";

	public static void main(String[] args) {
		String uname=null,pass=null,result=null;
try(Scanner sc=new Scanner(System.in);
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "user1", "1234");
		CallableStatement cs=con.prepareCall(AUTHENTICATION_QUERY);
		){
	if (sc!=null) {
		System.out.println("Enter username::");
		uname=sc.nextLine();
		System.out.println("Enter password::");
		pass=sc.nextLine();
	}//if
	if (cs!=null) {
		//register out parameter
		cs.registerOutParameter(3, Types.VARCHAR);
		//set in parameter
		cs.setString(1, uname);
		cs.setString(2, pass);
		//call PL/SQL Procedure
		cs.execute();
		//gathering the result 
		result=cs.getString(3);
		System.out.println("Result::"+result);
		}//if
}//try
catch(SQLException se) {
	se.printStackTrace();
  }//catch
catch(Exception e) {
	e.printStackTrace();
      }//catch
	}//main
}//class
