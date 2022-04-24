package com.nt.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

class SelectTest4{

	public static void main(String[] args) 	throws Exception{
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter sal"); 
		int sal =sc.nextInt();


//establish connection
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","root");

//create statement object
	Statement st =con.createStatement();

//prepare query
//SELECT ENO,ENAME,JOB,SAL FROM EMP WHERE JOB='CLERK';
String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL="+sal;
	//	System.out.println(query);

	//r send and execute query to db
	ResultSet rs=st.executeQuery(query);
	boolean isRSEmpty=true;
	while (rs.next()){
		isRSEmpty=false;
	System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4));
	}
	if (isRSEmpty)	{
System.out.println("No Record Found");
	}
	rs.close();
	st.close();
	con.close();
  sc.close();
	}
}
