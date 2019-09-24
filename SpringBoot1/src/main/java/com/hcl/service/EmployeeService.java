package com.hcl.service;

import java.util.List;
import java.util.Optional;

import com.hcl.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	
	public String addEmployee(String empstr);
	
	public String addEmployees(String empstr);
	
	public String deleteEmployee(int id);
	
	public String deleteEmployees(String idstr);
	
	public String updateEmployee(String empstr);
	
	public String updateEmployees(String empstr);
	
	public  Optional<Employee>  getEmployee(int id);


}
