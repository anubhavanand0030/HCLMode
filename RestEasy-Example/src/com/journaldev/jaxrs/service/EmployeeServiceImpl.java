package com.journaldev.jaxrs.service;


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

import com.journaldev.jaxrs.dao.EmployeeDaoImpl;
import com.journaldev.jaxrs.model.Employee;
import com.journaldev.jaxrs.model.GenericResponse;

@Path("/employee")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class EmployeeServiceImpl implements EmployeeService {

	//private static Map<Integer,Employee> emps = new HashMap<Integer,Employee>();
	Employee emp=new Employee();
	
	@Override
	@POST
    @Path("/add")
	public Response addEmployee(Employee emp) {
		return new EmployeeDaoImpl().addEmployee(emp);
	}

	@Override
	@DELETE
    @Path("/{id}/delete")
	public Response deleteEmployee(@PathParam("id") int id) {
		return new EmployeeDaoImpl().deleteEmployee(id);
	}

	@Override
	@GET
	@Path("/{id}/get")
	public Employee getEmployee(@PathParam("id") int id) {
		return new EmployeeDaoImpl().getEmployee(id);
	}
	
	@GET
	@Path("/{id}/getDummy")
	public Employee getDummyEmployee(@PathParam("id") int id) {
		Employee e = new Employee();
		e.setSalary(8976.55);
		e.setName("Dummy");
		e.setId(id);
		return e;
	}

	@Override
	@GET
	@Path("/getAll")
	public Employee[] getAllEmployees() {
		return new EmployeeDaoImpl().getAllEmployees();
	}

}
