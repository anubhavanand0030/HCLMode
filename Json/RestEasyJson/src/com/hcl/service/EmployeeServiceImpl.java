package com.hcl.service;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hcl.dao.EmployeeDaoImpl;
import com.hcl.model.Employee;
import com.hcl.model.GenericResponse;

@Path("/employee")

@Produces(MediaType.APPLICATION_JSON)
public class EmployeeServiceImpl implements EmployeeService {
	@GET
	@Path("/getAll")
	public Employee[] getAllEmployees() {
		return new EmployeeDaoImpl().getAllEmployees();
	}
	
}
