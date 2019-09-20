package com.journaldev.jaxrs.dao;

import javax.ws.rs.core.Response;

import com.journaldev.jaxrs.model.Employee;

public interface EmployeeDao {
	
	public Response addEmployee(Employee e);
	
	public Response deleteEmployee(int id);
	
	public Employee getEmployee(int id);
	
	public Employee[] getAllEmployees();
}
