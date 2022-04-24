package com.nt.ds;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class ConnectionPoolTest {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
			if (ds != null) {
				// add jdbc properties to ds object to create conn pool obj
				ds.setDriverType("thin");
				ds.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
				ds.setUser("user1");
				ds.setPassword("1234");
				ds.setMaxStatements(10);
				// get pool object
				con = ds.getConnection();
			} // if

			if (con != null)
				st = con.createStatement();
			if (st != null)
				rs = st.executeQuery("SELECT * FROM STUDENT");
			if (rs != null) {
				while (rs.next()) {
					System.out.println(rs.getInt(1) + "" + rs.getString(2) + "" + rs.getFloat(3));
				} // while
			} // if

		} // try
		catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (rs != null)
					rs.close();
			} 
			catch (SQLException se) {
				se.printStackTrace();
			} // catch
			try {
				if (st != null)
					st.close();
			} 
			catch (SQLException se) {
				se.printStackTrace();
			} // catch
			try {
				if (con != null)
					con.close();
			} // try
			catch (SQLException e) {
				e.printStackTrace();
			}
		} // finally
	}// main
}// class
