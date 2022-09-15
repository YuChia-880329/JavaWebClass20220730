package demo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.models.Student;

@Controller
public class StudentController {
	
	@RequestMapping(value="student", method=RequestMethod.GET)
	public ModelAndView studentFrom() {
		
		Student s = new Student("Mary", 20, 1);
		return new ModelAndView("student", "command", s);
	}
	
	@RequestMapping(value="addStudent", method=RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student, ModelMap model) {
		model.addAttribute("student", student);
		
		return "result";
	}
}
