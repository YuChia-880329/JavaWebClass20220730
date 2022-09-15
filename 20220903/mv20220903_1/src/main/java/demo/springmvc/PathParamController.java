package demo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathParamController {
	
	@RequestMapping("/web/fe/{sitePrefix}/{language}/document/{id}/{naturalText}")
	public String pathParam(Model model,
			@PathVariable(value = "sitePrefix") String sitePrefix,
			@PathVariable(value = "language") String language,
			@PathVariable(value = "id") String idStr,
			@PathVariable(value = "naturalText") String naturalText) {
		
		
		int id = 0;
		String idMsg = "";
		try {
			id = Integer.parseInt(idStr);
		}catch(NumberFormatException ex) {
			System.out.println(ex);
			id = 80;
			idMsg = " (id should be a number not " + idStr + ")";
		}
		
		
		model.addAttribute("sitePrefix", sitePrefix);
		model.addAttribute("language", language);
		model.addAttribute("id", id + idMsg);
		model.addAttribute("naturalText", naturalText);
		
		String documentName = "Java tutorial for Beginners";
		if(id == 8080)
			documentName = "Sping tutorial for Beginners";
		model.addAttribute("documentName", documentName);
		
		return "document";
	}
}
