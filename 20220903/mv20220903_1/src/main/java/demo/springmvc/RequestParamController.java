package demo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamController {

	@RequestMapping(value="/user", method = RequestMethod.POST)
	public String user(Model model, 
			@RequestParam(name = "name", defaultValue = "Guest") String user) {
		model.addAttribute("name", user);
		
		if("Admin".equals(user)) 
			model.addAttribute("email", "admin@demo.com");
		else
			model.addAttribute("email", "Not set");
		
		return "user_info";
	}
	
	
	@RequestMapping("/userui")
	public String userUI(Model model) {
		model.addAttribute("defaultName", "Admin");
		return "user_ui";
	}
}
