package com.hcl.dao;

import javax.ws.rs.core.Response;

import com.hcl.model.Employee;

public interface EmployeeDao {
	
	
	public Employee[] getAllEmployees();
	public Response addEmployee(Employee e);
}
