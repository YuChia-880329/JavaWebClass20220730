package spring.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Product;
import model.dao.ProductDAO;

@Controller
public class ProductCartController {
	
	@RequestMapping(value="/productcart", method=RequestMethod.GET)
	public String index(Model model) {
		List<Product> proList = new ProductDAO().findAll();
		model.addAttribute("products", proList);
		return "index";
	}
	
	
}
