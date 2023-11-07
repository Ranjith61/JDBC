package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchAllRecord {
	public static void main(String[] args) {

		String driverClass = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String jdbcURL = "jdbc:mysql://localhost:3306/Jdbc";
		String username = "root";
		String password = "Xworkzodc@123";

		String query = "select * from bank";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("connection is successfull");
			pstmt = conn.prepareCall(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("Id : " + rs.getInt(1));
				System.out.println("BankName : " + rs.getString("name"));
				System.out.println("BranchName : " + rs.getString("branch"));
				System.out.println("State : " + rs.getString("state"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
