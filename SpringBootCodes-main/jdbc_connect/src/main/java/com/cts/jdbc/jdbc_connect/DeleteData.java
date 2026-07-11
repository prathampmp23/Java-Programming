package com.cts.jdbc.jdbc_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {

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
		String sql = "delete from bus where serviceid=?";
		PreparedStatement pst = con.prepareStatement(sql);

		// 4. read the values for three columns
		System.out.println("Enter bus id");
		int busid = sc.nextInt();

		// 4. execute the query
		pst.setInt(1, busid);

		int k = pst.executeUpdate();

		if (k >= 1)
			System.out.println("Record Deleted..!");
		else
			System.out.println("Not Deleted..!");

		// 6. close the connections
		sc.close();
		pst.close();
		con.close();

	}
}
