package com.nt.postgerysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectPostgerySQL {
	private static  final String  SELECT_QUERY="SELECT *FROM STUDENT";
	
public static void main(String[] args)   {
	
	try(Connection con=DriverManager.getConnection("jdbc:postgresql:ntaj915db","postgres","1234");
			PreparedStatement ps=con.prepareStatement(SELECT_QUERY	);
			ResultSet rs=ps.executeQuery();
			){ 
		if (rs!=null) {
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}//while
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
