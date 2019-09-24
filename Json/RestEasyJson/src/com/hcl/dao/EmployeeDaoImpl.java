package com.hcl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.model.Employee;
import com.hcl.model.GenericResponse;

public class EmployeeDaoImpl implements EmployeeDao {
	
	
	@Override
	public Employee[] getAllEmployees() {
		SessionFactory sf=HibernateUTIL.getConnection();
		Session s=sf.openSession();
		Query q=s.createQuery("from Employee");
		List<Employee> lstEmploy=q.list();
		Employee[] emp=new Employee[lstEmploy.size()];
		int i=0;
		for (Employee employee : lstEmploy) {
			emp[i]=(Employee)employee;
			i++;
		}
		return emp;
	}
	@Override
	public Response addEmployee(Employee e) {
		GenericResponse response = new GenericResponse();
		//SessionFactory sessionFactory=new HibernateUTIL().getConnection();
		//Employee emp = (Employee) sessionFactory.getCurrentSession().get(Employee.class, e.getId());
		SessionFactory sf=HibernateUTIL.getConnection();
		Session s=sf.openSession();
		Query q=s.createQuery("from Employee where id="+e.getId());
		List<Employee> lst=q.list();
	
		
		if (lst.size()>0) {
			response.setStatus(false);
			response.setMessage("Employee Already Exists");
			response.setErrorCode("EC-01");
			return Response.status(422).entity(response).build();
		} else {
			response.setStatus(true);
			response.setMessage("Employee Added Succesfully");
			response.setErrorCode("EC-02");

			SessionFactory sf1=HibernateUTIL.getConnection();
			Session s1=sf1.openSession();
			Transaction t=s1.beginTransaction();
			s1.save(e);
			t.commit();
			return Response.ok(response).build();

		}

}
