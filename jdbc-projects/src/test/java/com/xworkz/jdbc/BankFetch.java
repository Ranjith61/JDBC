package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class BankFetch {
	public static void main(String[] args) {
		
		fetchAllBank();
			
		fetchSingle();
	}
	
	private static void fetchAllBank() {
		String jdbcURL = "jdbc:mysql://localhost:3306/Jdbc";
		String username = "root";
		String password = "Xworkzodc@123";
		
		
	String driverClass = "com.mysql.jdbc.Driver";	
	try {
		Class.forName(driverClass);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	String fetchByName ="Select * from bank"; 
	String insertQuery = "INSERT into bank(id,name,branch,state) VALUES(2,'HDFC','HSR','KERLA')";
	System.out.println("Establishing connection to database");
	try {
		Connection conn = DriverManager.getConnection(jdbcURL, username, password);
		System.out.println("Getting connection to database sucessfully !!!!");
		Statement stmt = conn.createStatement();	
		int rs1 = stmt.executeUpdate(insertQuery);
		ResultSet rs =  stmt.executeQuery(fetchByName);
//		System.out.println(rs);
		while(rs.next()) {//all record
			System.out.println("Bank Name " + rs.getString(2));
			System.out.println("Branch Name " + rs.getString(3));
			System.out.println("Bank State " + rs.getString("state"));
		}
		System.out.println("Executed select Qyery");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}// driver man is class
	}
	
	
	private static void fetchSingle() {
		System.out.println();
		System.out.println("Fetching single bank");
		String jdbcURL = "jdbc:mysql://localhost:3306/Jdbc";
		String username = "root";
		String password = "Xworkzodc@123";
		
		
	String driverClass = "com.mysql.jdbc.Driver";	
	try {
		Class.forName(driverClass);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	String fetchByName ="Select * from bank "; 
	
	System.out.println("Establishing connection to database");

	try {
		Connection conn = DriverManager.getConnection(jdbcURL, username, password);
		Statement stmt = conn.createStatement();
		ResultSet rs =  stmt.executeQuery(fetchByName);
		System.out.println(rs);
		if(rs.next()) {
			System.out.println("Bank Name " + rs.getString(2));
			System.out.println("Branch Name " + rs.getString(3));
			System.out.println("Bank State " + rs.getString("state"));
		}
		System.out.println("Executed select Qyery");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}// driver man is class
	System.out.println("Getting connection to database sucessfully !!!!");
	}
	
}
