package com.manan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String password="hbstudent";
		
		try
		{
			System.out.println("Attempting to connect to the database");
			Connection connection=DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("Successfully established connection to the database");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
