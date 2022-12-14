package demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello(Model model) {
		String msg = "Hello Spring MVC Framework";
		model.addAttribute("message", msg);
		return "hello";
	}
}
