package com.web.jobsentry.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

	
	public static boolean validate(String name, String pass) {
		boolean status = false;
		try {
			if(name.equals("user1") && pass.equals("password")) {
				status = true;
			} else if(name.equals("user2") && pass.equals("password")) {
				status = true;
			}
			else if(name.equals("user3") && pass.equals("password")) {
				status = true;
			}
			/*
			 * Class.forName("oracle.jdbc.driver.OracleDriver"); Connection
			 * con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
			 * "system","oracle"); PreparedStatement
			 * ps=con.prepareStatement("select * from userreg where name=? and pass=?");
			 * ps.setString(1,name); ps.setString(2,pass); ResultSet rs=ps.executeQuery();
			 * status=rs.next();
			 */

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	} 
		
}
