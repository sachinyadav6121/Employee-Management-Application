package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {
	
	@Autowired
	private IEmployeeMgmtService empService;

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/emp_report")
	public String showEmployees(Map<String,Object> map) {
		List<Employee> list = empService.findAllEmployees();
		map.put("empsData", list);
		return "show_report";
	}
	
	@GetMapping("/emp_add")
	public String    showAddEmployeeFormPage(@ModelAttribute("emp") Employee emp) {
		//return LVN
		return "employee_register_form";
	}
	
	@PostMapping("/emp_add")
	public   String  procssAddEmployeeFormPageSubmission(Map<String,Object> map,
			                                                                                           @ModelAttribute("emp") Employee emp) {
		//use Service
		String msg=empService.registerEmployee(emp);
		List<Employee> list=empService.findAllEmployees();
		// keep the results in Model attributes
		map.put("resultMsg",msg);
		map.put("empsData", list);
		
		//return  lvn
		return "redirect:emp_report";
	}//method
	
	@GetMapping("/emp_edit")
	public    String    showEditEmployeeFormPage(@RequestParam("no") int no,
			                                                                         @ModelAttribute("emp") Employee emp) {
		  //use  Service
		Employee emp1=empService.findEmployeeByNo(no);
		BeanUtils.copyProperties(emp1, emp);  //given by spring api
		// return   edit form page lvn
		return "employee_edit_form";
		
	}
	
	@PostMapping("/emp_edit")
	public  String   processEditFormPageSubmission(@ModelAttribute("emp") Employee emp,
			                                                                           Map<String,Object> map) {
		//use serivce
		String msg=empService.modifyEmployeeDetailsByNo(emp);
		List<Employee> listEmps=empService.findAllEmployees();
		//keep results in model attributes
		 map.put("resultMsg", msg);
		 map.put("empsData", listEmps);
		 
		 //return  lvn
		 return "show_report";
	}
	
	@GetMapping("/emp_delete")
	public   String   removeEmployee(@RequestParam("no") int no,
			                                                    Map<String,Object> map) {
		//use  Service
		String msg=empService.removeEmployeeByNo(no);
		List<Employee> list=empService.findAllEmployees();
		// add the results in  ModelAttributes
		map.put("resultMsg",msg);
		map.put("empsData", list);
		
		//return  LVN
		return "show_report";
		
		
	}
	
	
}
