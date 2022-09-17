package demo.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.bean.model.Coffee;
import demo.dao.CoffeeDAO;

@Controller
public class CoffeeController {
	
	@RequestMapping(value="coffee", method=RequestMethod.GET)
	public String getCoffees(Model model) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		JdbcTemplate template = ctx.getBean(JdbcTemplate.class);
		CoffeeDAO cofDao = ctx.getBean(CoffeeDAO.class);
		cofDao.setTemplate(template);
		List<Coffee> cofList = cofDao.getAllCoffees();
		
		model.addAttribute("coffees", cofList);
		
		return "coffee";
	}
}
