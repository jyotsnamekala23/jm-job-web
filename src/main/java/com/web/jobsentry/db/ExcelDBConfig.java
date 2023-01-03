package com.web.jobsentry.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ExcelDBConfig {

	public static Connection getConnection() throws Exception {
	    String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	    String url = "jdbc:odbc:excelDB.xls";
	    String username = "yourName";
	    String password = "yourPass";
	    Class.forName(driver);
	    return DriverManager.getConnection(url, username, password);
	  }
	
		public static void executeQuery() {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = getConnection();
				stmt = conn.createStatement();
				String excelQuery = "select * from [excelDB$]";
				/*
				rs = stmt.executeQuery(excelQuery);
				while (rs.next()) {
					System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
				} */
				ResultSetMetaData rsmd = rs.getMetaData();
			    int numberOfColumns = rsmd.getColumnCount();

			    System.out.println("No of cols " + numberOfColumns);
			    while (rs.next()) {
			      for (int i = 1; i <= numberOfColumns; i++) {
			        String columnValue = rs.getString(i);
			        System.out.println(columnValue);
			      }
			    }
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {

				e.printStackTrace();
			} finally {

			}

		}
		
	
	
}
