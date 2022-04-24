package com.nit.Mysql;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test02_Mysql {
	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// read input
			sc = new Scanner(System.in);
			System.out.print("Enter Student Name:");
			String name = sc.next().toUpperCase();
			name = "'" + name + "'";
			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish connection
			con = DriverManager.getConnection("jdbc:mysql:///student", "root", "1234");
			// preapare statement object
			if (con != null)
				st = con.createStatement();
			// prepare query
			String query = "SELECT *FROM STUDENT WHERE SNAME=" + name;
			// send and execute query
			if (st!= null)
				rs = st.executeQuery(query);
			// prepare resultset object
			if(rs!=null) {
			boolean isRSEmpty = true;
			while (rs.next()) {
				isRSEmpty = false;
				System.out.println(rs.getString(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3));
			} // while
			if (isRSEmpty)
				System.out.println("record not found");
			}//if
		} // try
		catch (SQLException se) {
			se.printStackTrace();
		} // catch
		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} // catch
		catch (Exception e) {
			e.printStackTrace();
		} // catch
		finally {
			try {
				if (rs != null)
					rs.close();
			} // try
			catch (SQLException se) {
				se.printStackTrace();
			} // catch
			try {
				if (st != null)
					st.close();
			} // try
			catch (SQLException se) {
				se.printStackTrace();
			} // catch
			try {
				if (con != null)
					con.close();
			} // try
			catch (SQLException se) {
				se.printStackTrace();
			} // catch
			try {
				if (sc != null)
					sc.close();
			} // try
			catch (Exception e) {
				e.printStackTrace();
			} // catch
		} // finally
	}// main
}// class