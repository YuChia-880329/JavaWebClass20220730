package demo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectController {
	
	@RequestMapping(value="/redirect", method=RequestMethod.GET)
	public String redirect(Model model) {
		return "redirect:/hello";
	}
	
	@RequestMapping(value="/redirect/2", method=RequestMethod.GET)
	public String redirect2(Model model) {
		return "redirect:/hello2";
	}
	
	@RequestMapping("/hello2")
	public String hello(Model model) {
		model.addAttribute("hello", "Redirect Controller hello");
		return "greeting";
	}
}
