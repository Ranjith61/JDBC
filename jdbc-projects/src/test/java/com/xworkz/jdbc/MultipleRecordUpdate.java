package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MultipleRecordUpdate {
	public static void main(String[] args) {

		String driverClass = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String jdbcURL = "jdbc:mysql://localhost:3306/Jdbc";
		String username = "root";
		String password = "Xworkzodc@123";

		String UpadteQuery = "upadte bank set branch=? where name =?";

		try {
			Connection conn = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("connection is successfull");
			PreparedStatement pstmt = conn.prepareStatement(UpadteQuery);
			pstmt.setString(1, "BTM");
			pstmt.setString(2, "SBI");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//prepare stmt ->precompile once and execute anytime
// prepare stmt -> uses place holder to exute query dynamically by priovidibd values
