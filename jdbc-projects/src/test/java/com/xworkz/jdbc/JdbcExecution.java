package com.xworkz.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcExecution {
	public static void main(String[] args) {

		String jdbcURL = "jdbc:mysql://localhost:3306/Jdbc";
		String username = "root";
		String password = "Xworkzodc@123";

		String driverclass = "com.mysql.jdbc.Driver"; // FQCN or package
//		String Oracledriverclass ="com.oracle.jdbc.OracleDriver";

		try {
			// Class loading/ class loader
			// load and register driver class
			Class.forName(driverclass);// static method,class-class
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("Getting connection to database");
//		String query ="INSERT into Bank(id,name,branch,state) VALUES (1,'SBI','BTM','KARNATAKA')";
//		String UpdateQuery = "Update Bank set branch = 'BTM LAYOUT' where name ='SBI'";
//		String deleteQuery = "delete from Bank where name = 'SBI'";

//		String query1 = "INSERT into Circket(id,name,country,batting_style) VALUES(18,'VIRAT_KOHLI','INDIA','CLASSIC')";
//		String UpdateQuery1 = "Update Circket set batting_style = 'COVER_DRIVE' where name ='VIRAT_KOHLI'";
//		String deleteQuery1 = "delete from Circket where country = 'INDIA'";

//		String query2 = "INSERT into Employee(id,name,phone_number,gender) VALUES(1,'KARAN',76543765,'MALE')";
//		String UpdateQuery2 = "Update Employee set name = 'SHARMA' where gender = 'MALE'";
		String deleteQuery2 = "delete from Employee where gender = 'MALE'";

		try {
			// set connection to Database server
			Connection conn = DriverManager.getConnection(jdbcURL, username, password);// driver man is class
			System.out.println("Getting connection to database sucessfully !!!!");

//			Statement stat = conn.createStatement();// connection & statement is interfaces
//			stat.execute(query);
//			System.out.println("Executed Insert Query");//execute, executeUpdate, executeQuery present in statement
//			stat.execute(UpdateQuery);
//			System.out.println("Executed Upadate Qyery");
//			stat.execute(deleteQuery);
//			System.out.println("Executed Delete Query");

			System.out.println("--------2nd table-----------");
//			Statement circ = conn.createStatement();//creat = non static method stat -interface
//			circ.execute(query1);
//			System.out.println("Executed Insert Query");
//			circ.execute(UpdateQuery1);
//			System.out.println("Executed Update Query");
//			circ.execute(deleteQuery1);
//			System.out.println("Exceuted delete Query");

			System.out.println("-------3rd table---------");
			Statement emp = conn.createStatement();
//			emp.execute(query2);
			System.out.println("Executed Insert Query");		
//			emp.execute(UpdateQuery2);
			System.out.println("Executed Update Query");
			emp.execute(deleteQuery2);
			System.out.println("Executed Delete Query");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
