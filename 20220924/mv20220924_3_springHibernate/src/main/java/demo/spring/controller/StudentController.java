package demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Student;

@Controller
public class StudentController {

	@RequestMapping(value="/student", method=RequestMethod.GET)
	public ModelAndView studentForm() {
		Student defaultStu = new Student(1201, "Kevin", 23);
		
		
		return new ModelAndView("student_form", "command", defaultStu);
	}
	
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String showResult(Model model, @ModelAttribute("student") Student student) {
//		model.addAttribute("stu", student);
		return "show_result";
	}
}
