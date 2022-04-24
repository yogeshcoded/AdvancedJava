package com.nt.plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;



public class CallableStatementTest {
	//prepare pre-compile query
	private static final String QUERY="{call first_pro(?,?)}";
public static void main(String[] args) {
	try(Scanner sc=new Scanner(System.in);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "user1", "1234");
			CallableStatement cs=con.prepareCall(QUERY);
			){
		int no=0;
		if (sc!=null) {
			//read input
		System.out.println("Enter no");
	 no=sc.nextInt();
			}	//if
		if (cs!=null) {
		//register out parameter with jdbc data type
		cs.registerOutParameter(2, Types.INTEGER);
		//set value to in param
		cs.setInt(1, no);
		//call PL/SQL procedure
		cs.execute();
		//gather result from out param
		int result=cs.getInt(2);
		System.out.println("Squre Value::"+result);
		}
	}//try
	catch(SQLException se) {
		se.printStackTrace();
	}//catch
	}//main
}//class
