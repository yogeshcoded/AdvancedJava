package com.nt.oracle;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner ;


class SelectTest5 {
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);

     System.out.println("Enter start avg");
	 int startAvg=sc.nextInt();

	System.out.println("Enter end avg");
		int endAvg=sc.nextInt();

		//prepare query 
		//Query
	//	"SELECT ENAME FROM EMP WHERE SAL>=800 AND SAL<=5000;"
		String query="SELECT ENAME ,JOB,SAL FROM EMP WHERE SAL>="+ startAvg+"AND SAL<="+endAvg;

	//Load driver
	Class.forName("oracle.jdbc.driver.OracleDriver");

	//establish connection 
	Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","user1","1234");

	//prepare statement object 
	Statement st =con.createStatement();

//send and execute query
	ResultSet rs= st.executeQuery(query);
	boolean isRSEmpty=true;
	while (rs.next()){
	 isRSEmpty=false;
	         System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
	}//while close
         if (isRSEmpty)
                              System.out.println("Record not found");
//closing objects
         rs.close();
         st.close();
         con.close();
         sc.close();;
	}//main close
}//class close
