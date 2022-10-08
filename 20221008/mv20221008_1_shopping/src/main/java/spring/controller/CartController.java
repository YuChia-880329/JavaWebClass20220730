package spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Item;
import model.dao.ProductDAO;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@RequestMapping(value="index", method=RequestMethod.GET)
	public String index() {
		return "cartindex";
	}
	
	@RequestMapping(value="/buy/{id}", method=RequestMethod.GET)
	public String buy(@PathVariable("id") String id, HttpSession session) {
		List<Item> cart = null;
		ProductDAO productDao = new ProductDAO();
		
		if((cart = (List<Item>)session.getAttribute("cart")) == null) {
			cart = new ArrayList<>();
			cart.add(new Item(productDao.find(id), 1));
			session.setAttribute("cart", cart);
		}else {
			int index = this.exist(cart, id);
			
			if(index == -1) {
				cart.add(new Item(productDao.find(id), 1));
			}else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
		}
		return "redirect:/cart/index";
	}
	
	private int exist(List<Item> cart, String id) {
		for(int i=0; i<cart.size(); i++) {
			if(cart.get(i).getProduct().getId().equalsIgnoreCase(id))
				return i;
		}
		return -1;
	}
	
	@RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
	public String remove(@PathVariable("id") String id, HttpSession session) {
		ProductDAO productDao = new ProductDAO();
		List<Item> cart = (List<Item>)session.getAttribute("cart");
		int index = this.exist(cart, id);
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "redirect:/cart/index";
	}
}
