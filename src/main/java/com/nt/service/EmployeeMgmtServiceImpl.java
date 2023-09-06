package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{

	@Autowired
	private IEmployeeDAO empDAO;
	
	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> list = empDAO.getAllEmployees();
		return list;
	}
	
	@Override
	public String registerEmployee(Employee emp) {
		//use DAO
		int count=empDAO.registerEmployee(emp);
		return count==0?"Employee not registered":"Employee is registered";
	}
	
	@Override
	public Employee findEmployeeByNo(int no) {
		//use  DAO
		Employee  emp=empDAO.getEmployeeByNo(no);
		return emp;
	}
	
	@Override
	public String modifyEmployeeDetailsByNo(Employee emp) {
		// use  DAO
		int count=empDAO.updateEmployeeByNo(emp);
		return count==0?" Employee  not found for updation":"Employee found and updated";
	}
	
	@Override
	public String removeEmployeeByNo(int no) {
		//use DAO
		int count=empDAO.deleteEmployeeByNo(no);
		
		return count==0?" Employee not found for deletion":"Employee found and Deleted";
	}

}
