package com.nit.Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlToOracleTransper {
	
private static final String ORACLE_STUDENT_INSERT_QUERY ="INSERT INTO STUDENT VALUES(SEQ2.NEXTVAL,?,?,?)";
private static final String GET_QUERY_TO_MYSQL="SELECT SNAME,SADD,MARKS FROM STUDENT";

	public static void main(String[] args) {
		
		try {
			//register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");   //for oracle
			Class.forName("com.mysql.cj.jdbc.Driver");           //for mysql
			
		}//try
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try(//Establish connections
				Connection oraCon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","root");
				Connection mysqlCon=DriverManager.getConnection("jdbc:mysql:///student","root","1234");
				//Create Statement obj
				Statement mysqlSt=mysqlCon.createStatement();
				PreparedStatement oraPs=oraCon.prepareStatement(ORACLE_STUDENT_INSERT_QUERY);
				//execute the query
				ResultSet rs=mysqlSt.executeQuery(GET_QUERY_TO_MYSQL); 
					){ 
			//process the resultset (mysql) and insert into oracle 
			if (rs!=null) {
				while (rs.next()) {
					//get the record from mysql db
				String name=rs.getString(1);
				String add =rs.getString(2);
				float mark=rs.getFloat(3);
				//set each received into record values to insert sql query of sql
				oraPs.setString(1, name);
				oraPs.setString(2, add);
				oraPs.setFloat(3, mark);
				//execute the query
				oraPs.executeUpdate();
				}	//while
				System.out.println("Record are transper from mysql to  oracle db");
			}//if
		}//try (close all connection automatically)
		catch ( SQLException se) {
			se.printStackTrace();
			System.out.println("record inserted problem");
		   }//catch
		catch ( Exception e) {
			e.printStackTrace();
			System.out.println("record inserted problem");
		   }//catch
		}//main
}//class
