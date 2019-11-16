package com.company.jake;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/book_ex?ussSSl=false&serverTimezone=UTC";
	private static final String USER = "jake";
	private static final String PW = "1234";
	
	@Test
	public void testConnection() throws Exception{
	Class.forName(DRIVER);
	try {
		Connection con = DriverManager.getConnection(URL,USER,PW);
		System.out.println(con);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}
	
}
