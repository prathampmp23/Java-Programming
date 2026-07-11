package com.cts.jdbc.jdbc_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class WriteData {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Scanner sc = new Scanner(System.in);

		// 1. Load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2. establish the connection
		String url = "jdbc:mysql://localhost:3306/ctsdb";
		String username = "root";
		String password = "root23";
		Connection con = DriverManager.getConnection(url, username, password);

		// 3. create the prepared statement object
		String sql = "insert into bus values (?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);

		// 4. read the values for three columns
		System.out.println("Enter bus id");
		int busid = sc.nextInt();

		System.out.println("Enter destination");
		String toplace = sc.next();

		System.out.println("Enter source");
		String fromplace = sc.next();

		// 4. execute the query
		pst.setInt(1, busid);
		pst.setString(2, toplace);
		pst.setString(3, fromplace);
		int k = pst.executeUpdate();

		if (k >= 1)
			System.out.println("Record Inserted..!");
		else
			System.out.println("Not inserted..!");

		// 6. close the connections
		sc.close();
		pst.close();
		con.close();

	}
}
