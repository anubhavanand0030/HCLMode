package com.hcl.model;

import java.sql.Date;

public class Employee {
	private int empno;
	private String empname;
	private double salary;
	private char band;
	private Date dateofjoin;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public char getBand() {
		return band;
	}
	public void setBand(char band) {
		this.band = band;
	}
	public Date getDateofjoin() {
		return dateofjoin;
	}
	public void setDateofjoin(Date dateofjoin) {
		this.dateofjoin = dateofjoin;
	}
	
	
}
