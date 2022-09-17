package demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import demo.spring.bean.SignUpForm;

@Controller
public class SignUpFormController {

	@ModelAttribute("signUpForm")
	public SignUpForm getSignUpForm() {
		return new SignUpForm();
	}
	
	@GetMapping("/showSignUpForm")
	public String showFrom() {
		return "sign_up_form";
	}
	
	@PostMapping("/saveSignUpForm")
	public String saveUser(Model model, @ModelAttribute("signUpForm") SignUpForm signUpForm) {
		System.out.println("FirstName : " + signUpForm.getFirstName());
        System.out.println("LastName : " + signUpForm.getLastName());
        System.out.println("Username : " + signUpForm.getUserName());
        System.out.println("Password : " + signUpForm.getPassword());
        System.out.println("Email : " + signUpForm.getEmail());
        
        model.addAttribute("message", "User SignUp Successfully");
        model.addAttribute("user", signUpForm);
		
		return "sign_up_success";
	}
}
