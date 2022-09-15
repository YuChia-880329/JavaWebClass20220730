package demo.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.models.User;

@Controller
public class UserController {
	
	@RequestMapping(value="user_form", method=RequestMethod.GET)
	public ModelAndView userForm() {
		String[] frameWorks = new String[] {WebFrameWork.SPRING_MVC.displayName,
				WebFrameWork.STRUCT_2.displayName};
		User user = new User("Mary", "1234", "Taipei", false, frameWorks);
		return new ModelAndView("userForm", "command", user);
	}
	
	@RequestMapping(value="addUser", method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, ModelMap model) {
		model.addAttribute("user", user);
		return "show_user";
	}
	
	@ModelAttribute("webFrameWorkList")
	public List<String> getWebFrameWorks(){
		
		return WebFrameWork.getDisplayNames();
	}
	
	
	private enum WebFrameWork{
		SPRING_MVC("Spring MVC"),
		SPRING_BOOT("Spring Boot"),
		STRUCT_2("Struts 2"),
		APACHE_HADOOP("Apache Hadoop");
		
		private String displayName;
		private WebFrameWork(String displayName) {
			this.displayName = displayName;
		}
		
		private static List<String> getDisplayNames(){
			List<String> list = new ArrayList<>();
			
			WebFrameWork[] works = values();
			for(WebFrameWork work : works) {
				list.add(work.displayName);
			}
			return list;
		}
	}
}
