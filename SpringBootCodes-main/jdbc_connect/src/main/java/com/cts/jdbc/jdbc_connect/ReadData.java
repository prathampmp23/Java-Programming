package com.cts.jdbc.jdbc_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		
		// 1. Load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		// 2. establish the connection
		String url ="jdbc:mysql://localhost:3306/ctsdb";
		String username="root";
		String password ="root23";
		Connection con = DriverManager.getConnection(url,username,password);
		
		
		//3. create the statement object
		Statement st = con.createStatement();
		
			
		// 4. write the query and execute the query
		String sql ="select * from bus";
		ResultSet rs = st.executeQuery(sql);
		
		
		//5. fetch the result and process it
		while(rs.next())
			System.out.println(rs.getInt(1)+". "+rs.getString(2)+" "+rs.getString(3));
		
		
		//6. close the connections
		rs.close();
		st.close();
		con.close();
	}
}
