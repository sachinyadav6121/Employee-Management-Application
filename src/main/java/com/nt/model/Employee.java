package com.nt.model;

import lombok.Data;

@Data
public class Employee {

	private Integer empNo;
	private String ename;
	private String job;
	private Float sal;
	private Integer deptno;
	
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Float getSal() {
		return sal;
	}
	public void setSal(Float sal) {
		this.sal = sal;
	}
	
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", sal=" + sal + " ,deptno="+ deptno +", getClass()="+ getClass() +
				"hashCode()="+ hashCode() +" ,toString()="+ super.toString() + "]";
	}
	
	
	
}
