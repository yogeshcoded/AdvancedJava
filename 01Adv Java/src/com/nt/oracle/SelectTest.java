package com.nt.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class  SelectTest
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
	
	//load driver 
	Class.forName("oracle.jdbc.driver.OracleDriver");

	//Establish connection
	try(
Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","user1","1234");

		//create jdbc statement object 
		Statement st=con.createStatement();

		//send and execute SELECT Quary to db
		ResultSet rs=st.executeQuery("SELECT *FROM EMP");
){
		//process the resultset object
		while (rs.next()!=false)	{
	System.out.println(rs.getInt (1)+"\t\t" +rs.getString(2));//+" \t\t"+rs.getString(3)+"\t\t"+rs.getString (4));
		}//while loop close
}
//close objects
//rs.close();
//st.close();
//con.close();

	}//main close
}//class close
