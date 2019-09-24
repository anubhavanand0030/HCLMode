package com.hcl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Employee;
import com.hcl.repository.EmployeeRepository;;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = (List<Employee>) empRepository.findAll();
		if (empList.size() > 0) {
			return empList;
		} else {
			return new ArrayList<Employee>();
		}
	}

	@Override
	public String addEmployee(String empstr) {

		JSONParser jsonParser = new JSONParser();
		String str="";

		try {
			Object obj = jsonParser.parse(empstr);
			JSONArray emparr = new JSONArray();
			emparr = (JSONArray) obj;
			Employee emp = new Employee();
			for (Object object : emparr) {
				JSONObject employee = (JSONObject) object;

				long empno = (Long) employee.get("id");
				emp.setId((int)empno);
				emp.setName((String) employee.get("name"));
				double d=(Double)employee.get("salary");
				emp.setSalary(d);

			}
			Employee tempEmp = empRepository.save(emp);
			if (tempEmp != null) {
				str= "Employee created successfully";
			} else {
				str= "Not Created";
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public String addEmployees(String empstr) {
		JSONParser jsonParser = new JSONParser();
		String str="";
		try {
			Object obj = jsonParser.parse(empstr);
			JSONArray emparr = new JSONArray();
			List<Employee> lst=new ArrayList<Employee>();
			emparr = (JSONArray) obj;
			for (Object object : emparr) {
				JSONObject employee = (JSONObject) object;
				Employee emp = new Employee();
				long empno = (Long) employee.get("id");
				emp.setId((int)empno);
				emp.setName((String) employee.get("name"));
				double d=(Double)employee.get("salary");
				emp.setSalary(d);
				lst.add(emp);

			}
			List<Employee> tempEmp = (List<Employee>) empRepository.saveAll(lst);
			if (tempEmp != null) {
				str= "Employees created successfully";
			} else {
				str= "Not Created";
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public String deleteEmployee(int id) {
		boolean bool=empRepository.existsById(id);
		String str="";
		if(bool==true) {
			empRepository.deleteById(id);
			str="deleted successfully";
		} else {
			str="Employee doesn't exist";
		}
		return str;
	}
	@Override
	public String deleteEmployees(String idstr) {
		JSONParser jsonParser = new JSONParser();
		String str="";
	
			try {
				Object obj = jsonParser.parse(idstr);
				JSONArray emparr = new JSONArray();
				List<Employee> lst=new ArrayList<Employee>();
				emparr = (JSONArray) obj;
				for (Object object : emparr) {
					JSONObject employee = (JSONObject) object;
					Employee emp = new Employee();
					long empno = (Long) employee.get("id");
					emp.setId((int)empno);
					emp.setName((String) employee.get("name"));
					double d=(Double)employee.get("salary");
					emp.setSalary(d);
					lst.add(emp);

				}
				empRepository.deleteAll(lst);
				str="Employees deleted";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return str;

	}

	@Override
	public String updateEmployee(String empstr) {
		JSONParser jsonParser = new JSONParser();
		String str="";

		
			try {
				Object obj = jsonParser.parse(empstr);
				JSONArray emparr = new JSONArray();
				emparr = (JSONArray) obj;
				Employee emp = new Employee();
				for (Object object : emparr) {
					JSONObject employee = (JSONObject) object;

					long empno = (Long) employee.get("id");
					emp.setId((int)empno);
					emp.setName((String) employee.get("name"));
					double d=(Double)employee.get("salary");
					emp.setSalary(d);

				}
				boolean bool=empRepository.existsById(emp.getId());
				if(bool==true) {
					Employee tempEmp = empRepository.save(emp);
					if (tempEmp != null) {
						str= "Employee Updated";
					} else {
						str= "Not Created";
					}
				} else {
					str="Employee with thid id doesn't exist";
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return str;
	}
	@Override
	public String updateEmployees(String empstr) {
		JSONParser jsonParser = new JSONParser();
		String str="";

		
			try {
				Object obj = jsonParser.parse(empstr);
				JSONArray emparr = new JSONArray();
				emparr = (JSONArray) obj;
				List<Employee> lst=new ArrayList<Employee>();
				for (Object object : emparr) {
					JSONObject employee = (JSONObject) object;
					Employee emp = new Employee();
					long empno = (Long) employee.get("id");
					emp.setId((int)empno);
					emp.setName((String) employee.get("name"));
					double d=(Double)employee.get("salary");
					emp.setSalary(d);
					lst.add(emp);
				}
			List<Employee> lsttemp=(List<Employee>) empRepository.saveAll(lst);
			if(lsttemp!=null) {
				str="Employees updated";
			}
			else {
				str="Employees not updated";
			}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return str;
	}

	@Override
	public Optional<Employee> getEmployee(int id) {
		boolean bool=empRepository.existsById(id);
		String str="";
		Optional<Employee> emp=null;
		if(bool==true) {
			emp=empRepository.findById(id);
			return emp;
		} else {
			return emp;
		}
		
	}

}
