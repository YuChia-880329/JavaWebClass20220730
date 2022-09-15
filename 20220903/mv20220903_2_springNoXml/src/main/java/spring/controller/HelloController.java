package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("hello")
public class HelloController {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("greeting", "Hello World from Spring 5 MVC");
		return "welcome";
	}
	
	
	@RequestMapping(value="again", method=RequestMethod.GET)
	public String helloAgain(Model model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 5 MVC");
		return "welcome";
	}
}
