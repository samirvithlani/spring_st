package com.bean;

import java.util.Date;

public class EmployeeBean {

	private int eId;
	private String eName;
	private Date date;
	private EmployeeDetail employeeDetail;

	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}
	
	
	
	public void clean() {
		
		System.out.println("clean calle...");
	}
	public void check() {
		
		
		System.out.println("init/check method called....");
	}

	public void display() {

		System.out.println("eid = " + eId + " -- ename =" + eName + "---" + date.getDate());
		System.out.println("employeedetail -- >> >>> " + employeeDetail.getEmpCity());
	}

}
