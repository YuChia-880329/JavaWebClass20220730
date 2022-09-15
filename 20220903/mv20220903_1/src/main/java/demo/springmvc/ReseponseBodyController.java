package demo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReseponseBodyController {
	
	@RequestMapping("/respBody")
	@ResponseBody
	public String responseBody(Model model) {
		return "response body";
	}
}
