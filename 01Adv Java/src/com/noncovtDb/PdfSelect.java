//PdfSelect.java
package com.noncovtDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PdfSelect {
public static void main(String[] args) {
	try(Connection con=DriverManager.getConnection("jdbc:Pdf:///D:/Adv Java/mydb");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM Pdf1");
			){
		if (rs!=null) {
			while (rs.next()) {
				System.out.println(rs.getShort(1)+""+rs.getString(2)+""+rs.getString(3)+""+rs.getShort(4));
			}//while
		}//if
	}//try
	catch(SQLException se) {
		se.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
