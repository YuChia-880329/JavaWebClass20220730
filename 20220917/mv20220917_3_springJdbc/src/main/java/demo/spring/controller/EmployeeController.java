package demo.spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.spring.bean.model.Employee;
import demo.spring.dao.EmployeeDAO;

@Controller
public class EmployeeController {
	
	@RequestMapping(value="/insertEmp", method=RequestMethod.GET)
	@ResponseBody
	public String insert() {
		Employee e = new Employee();
		e.setEmployeeNumber(1900);
		e.setLastName("Dean");
		e.setFirstName("Lee");
		e.setExtension("0x1357");
		e.setEmail("dean@demo.com");
		e.setOfficeCode("1");
		e.setReportsTo(1056);
		e.setJobTitle("Sales");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		EmployeeDAO employeeDao = (EmployeeDAO)ctx.getBean("empDao");
		
		int status = employeeDao.saveEmployee(e);
		return Integer.toString(status);

	}
	
	@RequestMapping(value="/updateEmp", method=RequestMethod.GET)
	@ResponseBody
	public String update() {
		Employee e = new Employee();
		e.setEmployeeNumber(1900);
		e.setLastName("Kevin");
		e.setFirstName("Chen");
		e.setExtension("0x1235");
		e.setEmail("kevin@demo.com");
		e.setOfficeCode("2");
		e.setReportsTo(1056);
		e.setJobTitle("Sales");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		EmployeeDAO employeeDao = (EmployeeDAO)ctx.getBean("empDao");
		int status = employeeDao.updateEmployee(e);
		return Integer.toString(status);
	}
	
	
	@RequestMapping(value="/deleteEmp", method=RequestMethod.GET)
	@ResponseBody
	public String delete() {
		Employee e = new Employee();
		e.setEmployeeNumber(1900);
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		EmployeeDAO employeeDao = (EmployeeDAO)ctx.getBean("empDao");
		int status = employeeDao.deleteEmployee(e);
		
		return String.valueOf(status);
	}
}
