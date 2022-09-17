package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.bean.Book;


@Controller
public class MyController {
	private Book book;

	@Autowired
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	@RequestMapping(value="service", method=RequestMethod.GET)
	public String getService(Model model) {
		System.out.println("book : " + book);
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		Book bk1 = ctx.getBean(Book.class);
		model.addAttribute("bk1", bk1);
		
		return "home";
	}
	
}
