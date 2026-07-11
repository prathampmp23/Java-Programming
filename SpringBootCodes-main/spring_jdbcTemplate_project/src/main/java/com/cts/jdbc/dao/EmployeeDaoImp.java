package com.cts.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.jdbc.model.Employee;
import com.cts.jdbc.model.EmployeeMapper;

@Repository
public class EmployeeDaoImp implements EmployeeDao {

	@Autowired
	JdbcTemplate template;

	@Override
	public List<Employee> displayEmployees() {
		return template.query("select * from employee", new EmployeeMapper());
	}

	@Override
	public boolean addEmployee(Employee employee) {
		String sql = "insert into employee values (?,?,?,?,?)";
		int k = template.update(sql, employee.getEmpid(), employee.getDept(), employee.getDesg(), employee.getName(),
				employee.getSalary());
		if (k >= 1)
			return true;
		else
			return false;
	}

	@Override 
	public boolean deleteEmployee(int empid) {
		String sql = "delete from employee where empid=?";
		int k = template.update(sql, empid);
		if (k >= 1)
			return true;
		else
			return false;
	}

}
