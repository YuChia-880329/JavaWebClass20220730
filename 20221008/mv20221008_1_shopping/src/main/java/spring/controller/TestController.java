package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("greeting", "Test Hello World");
		return "test";
		
	}
}
