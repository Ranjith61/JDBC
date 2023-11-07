package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MultipleRecords {
	public static void main(String[] args) {

		String jdbcURL = "jdbc:mysql://localhost:3306/Jdbc";
		String username = "root";
		String password = "Xworkzodc@123";

		String driverClass = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String insert = "INSERT into bank(id,name,branch,state) VALUES(?,?,?,?)";// ?-place holder
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
				conn = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connection is successfull..");
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, 3);
			pstmt.setString(2, "canara");
			pstmt.setString(3, "srinivaspur");
			pstmt.setString(4, "Karnataka");
			pstmt.execute();
			pstmt.setInt(1, 4);
			pstmt.setString(2, "axis");
			pstmt.setString(3, "J P Nagar");
			pstmt.setString(4, "Kerala");
			pstmt.execute();
			System.out.println("Multiple records inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					System.out.println("Connection is closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
					System.out.println("statement is closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
