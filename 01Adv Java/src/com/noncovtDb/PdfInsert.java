//PdfInsert.java
package com.noncovtDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PdfInsert {
public static void main(String[] args) {
	try(Connection con=DriverManager.getConnection("jdbc:Pdf:///D:/Adv Java/mydb");
			PreparedStatement ps=con.prepareStatement("INSERT INTO pdf1 VALUES(?,?,?,?)");
			){
		if (ps!=null) {
			//set param values
			ps.setInt(1,50);
			ps.setString(2, "cot");
			ps.setInt(3, 10);
			ps.setInt(4, 6);
		}//if
		//process the result
		int count=ps.executeUpdate();
		if (count==0) 
			System.out.println("record is not update");
		else
			System.out.println("record id update");
		
	}//try
	catch(SQLException se) {
		se.printStackTrace();
	}//catch
	catch(Exception e) {
		e.printStackTrace();
	}//catch
						
}//main
}//class
