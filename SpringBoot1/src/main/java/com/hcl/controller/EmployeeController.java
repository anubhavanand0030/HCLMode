package com.hcl.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Employee;
import com.hcl.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	@RequestMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> list=empService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	@RequestMapping("/add")
	public ResponseEntity<String> addEmployee(@RequestBody String empstr){
		String str=empService.addEmployee(empstr);
		return new ResponseEntity<String>(str,new HttpHeaders(),HttpStatus.OK);
	}
	@RequestMapping("/addAll")
	public ResponseEntity<String> addEmployees(@RequestBody String empstr){
		String str=empService.addEmployees(empstr);
		return new ResponseEntity<String>(str,new HttpHeaders(),HttpStatus.OK);
	}
	
	@RequestMapping("{id}/delete")
	public ResponseEntity<String> deleteEmployee(@PathVariable(value="id") int id){
		String str=empService.deleteEmployee(id);
		return new ResponseEntity<String>(str,new HttpHeaders(),HttpStatus.OK);
	}
	@RequestMapping("/deleteMany")
	public ResponseEntity<String> deleteEmployees(@RequestBody String empstr){
		String str=empService.deleteEmployees(empstr);
		return new ResponseEntity<String>(str,new HttpHeaders(),HttpStatus.OK);
	}
	@RequestMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody String empstr){
		String str=empService.updateEmployee(empstr);
		return new ResponseEntity<String>(str,new HttpHeaders(),HttpStatus.OK);
	}
	@RequestMapping("/updateMany")
	public ResponseEntity<String> updateEmployees(@RequestBody String empstr){
		String str=empService.updateEmployees(empstr);
		return new ResponseEntity<String>(str,new HttpHeaders(),HttpStatus.OK);
	}
	@RequestMapping("{id}/getEmployee")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable(value="id") int id){
		Optional<Employee> str=empService.getEmployee(id);
		return new ResponseEntity<Optional<Employee>>(str,new HttpHeaders(),HttpStatus.OK);
	}
	
}

