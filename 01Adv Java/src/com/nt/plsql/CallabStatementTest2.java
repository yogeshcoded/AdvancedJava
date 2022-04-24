package com.nt.plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;



public class CallabStatementTest2 {
	//prepare pre-compile query
	private static final String QUERY="{call sec_pro(?,?.?)}";
public static void main(String[] args) {
	try(Scanner sc=new Scanner(System.in);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "user1", "1234");
			CallableStatement cs=con.prepareCall(QUERY);
			){
		int fno=0,sno=0;
		if (sc!=null) {
			//read input
		System.out.println("Enter first no");
	 fno=sc.nextInt();
	 System.out.println("Enter second no");
	 sno=sc.nextInt();
			}	//if
		if (cs!=null) {
		//register out parameter with jdbc data type
		cs.registerOutParameter(3, Types.INTEGER);
		//set value to in parameter
		cs.setInt(1, fno);
		cs.setInt(2, sno);
		//call PL/SQL procedure
		cs.execute();
		//gather result from out parameter
		int result=cs.getInt(3);
		System.out.println("Squre Value::"+result);
		System.out.println("cube Value::"+result);
		}
	}//try
	catch(SQLException se) {
		se.printStackTrace();
	}//catch
	}//main
}//class
