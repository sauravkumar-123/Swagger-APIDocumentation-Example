package com.student.Model;


public class Employee {

	private int empid;
	private String name;
	private String mobno;
	private double salary;
	
	public Employee() {
		
	}

	public Employee(int empid, String name, String mobno, double salary) {
		super();
		this.empid = empid;
		this.name = name;
		this.mobno = mobno;
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", mobno=" + mobno + ", salary=" + salary + "]";
	}
	
	
}
