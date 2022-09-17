package demo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.spring.bean.model.Employee;
import demo.spring.dao.EmployeeDAO;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping(value="/employees/{pageId}", method=RequestMethod.GET)
	public String getEmployees(Model model, @PathVariable(value="pageId")String pageId) {
		int rowId = 0;
		int total = 10;
		if(!pageId.equals("1")) {
			try {
				int page = Integer.parseInt(pageId);
				rowId = (page-1)*10 + 1;
			}catch(NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		
		List<Employee> empList = employeeDAO.getEmployees(rowId, total);
		model.addAttribute("employees", empList);
		return "show_employee";
	}
}
