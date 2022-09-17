package demo.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.bean.dao.EmployeeDAO;
import demo.bean.model.Employee;

@Controller
public class EmployeeController {

	@RequestMapping(value="employee", method=RequestMethod.GET)
	@ResponseBody
	public String insertEmployee() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		EmployeeDAO dao = (EmployeeDAO)ctx.getBean("template");
		
		Employee e = new Employee();
		e.setEmployeeNumber(1900);
		e.setLastName("Dean");
		e.setFirstName("Lee");
		e.setExtension("0x1357");
		e.setEmail("dean@demo.com");
		e.setOfficeCode("1");
		e.setReportsTo(1056);
		e.setJobTitle("Sales");
		int status = dao.saveEmployee(e);
		
		return "" + status;
	}
}
