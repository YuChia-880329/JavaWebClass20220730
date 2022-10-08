package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Employee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private List<Employee> employees;
	
	public EmployeeController() {
		employees = new ArrayList<>();
		employees.add(new Employee("Arpit", "IT"));
		employees.add(new Employee("Sanjeev", "IT"));
		employees.add(new Employee("Ben", "IT"));
	}
	
	@GetMapping("/employee")
	public List<Employee> getEmployees(){
		return employees;
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		Employee emp = null;
		
		try {
			emp = employees.get(id);
		}catch(IndexOutOfBoundsException ex) {
			System.out.println("employee exception : " + ex);
		}
		
		return emp;
	}
	
	@PostMapping(value="/employee", produces=MediaType.TEXT_HTML_VALUE)
	public String addEmployee(@RequestBody Employee employee) {
		employees.add(employee);
		return "employee add to List";
	}
	
	
	@PutMapping(value="/employee/{id}", produces=MediaType.TEXT_HTML_VALUE)
	public String updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
		if(id<0 || id>=employees.size()) {
			employees.add(employee);
			return "index not in list so add " + employee;
		}
		employees.set(id, employee);
		return "update index " + id + " to " + employee;
	}
	
	
	@DeleteMapping(value="/employee/{id}", produces=MediaType.TEXT_HTML_VALUE)
	public String deleteEmployee(@PathVariable("id") int id) {
		if(id>=0 && id<employees.size()) {
			Employee tmp = employees.remove(id);
			return "remove " + tmp;
		}
		return "index not in list";
	}
}
