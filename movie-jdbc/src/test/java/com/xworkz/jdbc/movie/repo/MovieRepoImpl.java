package com.xworkz.jdbc.movie.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.xworkz.jdbc.dto.MovieDTO;

public class MovieRepoImpl implements MovieRepo {

	public boolean ValidateAndSave(MovieDTO dto) {

		String driverclass = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driverclass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		String jdbcURL = "jdbc:mysql://localhost:3306/movie";
		String username = "root";
		String password = "Xworkzodc@123";
		
		String insert = "INSERT INTO movies(id,name,budjet,language,realease_date) values(?,?,?,?,?)";
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			 conn = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Getting connection to database successfully");
			pstmt =conn.prepareStatement(insert);
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getBudjet());
			pstmt.setString(4, dto.getLanguage());
			pstmt.setDate(5, dto.getRealease_date());
			pstmt.execute();
			System.out.println("Inserted");
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(conn!=null) {
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		return false;
		

	}

	public boolean ValidateAndSave(List<MovieDTO> movielist) {
		String driverclass = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driverclass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		String jdbcURL = "jdbc:mysql://localhost:3306/movie";
		String username = "root";
		String password = "Xworkzodc@123";
		
		String insert = "INSERT INTO movies(id,name,budjet,language,realease_date) values(?,?,?,?,?)";
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			 conn = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Getting connection to database successfully");
			pstmt =conn.prepareStatement(insert);
			for (MovieDTO movieDTO : movielist) {
				pstmt.setInt(1, movieDTO.getId());
				pstmt.setString(2, movieDTO.getName());
				pstmt.setInt(3, movieDTO.getBudjet());
				pstmt.setString(4, movieDTO.getLanguage());
				pstmt.setDate(5, movieDTO.getRealease_date());
				pstmt.execute();
			}
			
			System.out.println("Inserted");
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(conn!=null) {
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		return false;
		

	}

}
