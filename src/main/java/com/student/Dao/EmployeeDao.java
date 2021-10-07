package com.student.Dao;

import org.springframework.stereotype.Repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("This the all the attribute of employee model")
@Repository
public class EmployeeDao {
 
	@ApiModelProperty(notes = "ID should be on 10 length",name = "employeeid", required = true, value="emp_id")
	private int empid;
	private String name;
	private String mobno;
	private double salary;
	
	public EmployeeDao() {
		
	}

	public EmployeeDao(int empid, String name, String mobno, double salary) {
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
	
}
