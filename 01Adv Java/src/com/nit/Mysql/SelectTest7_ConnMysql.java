package com.nit.Mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest7_ConnMysql {
public static void main(String[] args) {
	Connection con =null;
		
	try {
		//load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Establish connection
		con=DriverManager.getConnection("jdbc:mysql://192.168.37.22:3306/emp", "root","root");
				if (con==null)
	          System.out.println("connection is Fail");
	else 
	          System.out.println("connected");
		
	} //try
	catch (SQLException  se) {
		se.printStackTrace();
	}//catch
	catch (ClassNotFoundException cnf) {
		cnf.printStackTrace();
	}//catch
	finally {
		try {
			if (con!=null) 
				con.close();
		}	//try
		catch (SQLException se) {
						se.printStackTrace();
			}//catch
		}//finally
	}//main
}//Class

