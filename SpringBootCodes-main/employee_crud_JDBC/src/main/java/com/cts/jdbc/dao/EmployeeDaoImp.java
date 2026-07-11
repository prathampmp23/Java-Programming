package com.cts.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cts.jdbc.model.Employee;

@Repository
public class EmployeeDaoImp implements EmployeeDao {
 
	@Override
	public List<Employee> displayEmployees() {
		List<Employee> employees = new ArrayList<>();
		try {
			// 1. Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			// 2. establish the connection
			String url ="jdbc:mysql://localhost:3306/ctsdb";
			String username="root";
			String password ="root23";
			Connection con = DriverManager.getConnection(url,username,password);
			
			
			//3. create the statement object
			Statement st = con.createStatement();
			
				
			// 4. write the query and execute the query
			String sql ="select * from employee";
			ResultSet rs = st.executeQuery(sql);
			
			
			//5. fetch the result and process it
			
			while(rs.next()) {
				Employee emp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
				employees.add(emp);
			}
			
			
			//6. close the connections
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e) {
			
		}
		return employees;
	}
 
	@Override
	public boolean addEmployee(Employee employee) {
		boolean flag=false;
		try {
			// 1. Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. establish the connection
			String url ="jdbc:mysql://localhost:3306/ctsdb";
			String username="root";
			String password ="root23";
			Connection con = DriverManager.getConnection(url,username,password);
			
			
			//3. create the prepared statement object
			String sql = "insert into employee values (?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			
			
				
			// 4. execute the query
				pst.setInt(1,employee.getEmpid());
				pst.setString(2, employee.getDept());
				pst.setString(3, employee.getDesg());
				pst.setString(4, employee.getName());
				pst.setInt(5, employee.getSalary());
				int k = pst.executeUpdate();
				
				if(k>=1)
					flag=true;
			
			//6. close the connections
			
			pst.close();
			con.close();
			
		}
		catch(Exception e) {
			
		}
		return flag;
	}
 
	@Override
	public boolean deleteEmployee(int empid) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			// 2. establish the connection
			String url ="jdbc:mysql://localhost:3306/ctsdb";
			String username="root";
			String password ="root23";
			Connection con = DriverManager.getConnection(url,username,password);
			
			
			//3. create the prepared statement object
			String sql = "delete from employee where empid=?";
			PreparedStatement pst = con.prepareStatement(sql);
			
			
			// 4. execute the query
				pst.setInt(1,empid);
				
				int k = pst.executeUpdate();
				
				if(k>=1)
					flag=true;
		
			
			//6. close the connections
			
			pst.close();
			con.close();
 
		}
		catch(Exception e) {
			
		}
		
		return flag;
	}

}
