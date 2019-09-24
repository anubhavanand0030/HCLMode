package com.hcl.JsonEmployee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hcl.model.Employee;

public class JsonFileRead {
	public static void main(String[] args) {
//		try {
//			BufferedReader bf=new BufferedReader(new FileReader("C:/hcl/java/mode30/Employees.json"));
//			String st,str="";
//			while((st=bf.readLine())!=null){
//				str=str+st;
//			}
//			Object obj=JSONValue.parse(str);  
//		    JSONObject jsonObject = (JSONObject) obj;  
//		    
//		    
//		    
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
		 JSONParser jsonParser = new JSONParser();
		 try {
			FileReader reader = new FileReader("C:/hcl/java/mode30/Employees.json");
			 Object obj = jsonParser.parse(reader);
			 
	            JSONObject employeeList = (JSONObject) obj;
	            JSONArray emparr=new JSONArray();
	            Object obj1=employeeList.get("Employees");
	            //System.out.println(obj1);
	            JSONObject empobj=(JSONObject)obj1;
	            obj1=empobj.get("Employee");
	            emparr=(JSONArray)obj1;
	            List<Employee> emplist=new ArrayList<Employee>();
	           // System.out.println(employeeList);
	             for (Object object : emparr) {
	            	 JSONObject employee=(JSONObject)object;
	            	 Employee emp=new Employee();
	            	 long empno1=(long)employee.get("empno");
	            	 int empno=(int)empno1;
	            	 emp.setEmpno(empno);
	            	 emp.setEmpname((String)employee.get("empname"));
	            	 
	            	 emp.setSalary((long)employee.get("salary"));
	            	 String str=(String) employee.get("band");
	            	 emp.setBand(str.charAt(0));
	            	 str=(String) employee.get("dateofjoin");
	            	 Date date1=Date.valueOf(str);
	            	 emp.setDateofjoin(date1);
	            	 emplist.add(emp);
				}
	             
	             emplist.forEach((Employee emp) -> System.out.println(emp.getEmpno()+" "+emp.getEmpname()+" "+emp.getSalary()+" "+emp.getBand()+" "+emp.getDateofjoin()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
