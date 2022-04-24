package com.nt.oracle;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnTest {
public static void main(String[] args)throws Exception {
	 Class.forName("oracle.jdbc.OracleDriver" );

	//3) Establish connection 

	Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","root");

		//checking connection
		if (con==null)
		          System.out.println("connection is Fail");
		else 
		          System.out.println("connected");

}
}
