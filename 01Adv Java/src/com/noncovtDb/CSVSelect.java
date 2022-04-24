package com.noncovtDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//CSVSelect.java
public class CSVSelect {
public static void main(String[] args) {
	try(Connection con=DriverManager.getConnection("jdbc:Text:///D:/Adv Java/mydb");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT *FROM Text.csv");
			){
		if (rs!=null) {
			while (rs.next()) {
				System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getInt(3)+""+rs.getInt(4));
			}//while
		}//if
	}//try
	catch(SQLException se) {
		se.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}//main
}//class
