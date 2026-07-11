package com.cts.jdbc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setEmpid(rs.getInt(1));
		emp.setDept(rs.getString(2));
		emp.setDesg(rs.getString(3));
		emp.setName(rs.getString(4));
		emp.setSalary(rs.getInt(5));
		return emp;
	}
}
