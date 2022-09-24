package demo.spring.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Student;

@Controller
public class StudentController2 {

	@RequestMapping(value="/student2", method=RequestMethod.GET)
	public String showStudents(Model model) {
		List<Student> list = getList();
		System.out.println(list);
		model.addAttribute("stuList", list);
		return "show_students";
	}
	private List<Student> getList(){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		List<Student> list = session.createQuery("FROM Student").list();
		
		return list;
	}
}
