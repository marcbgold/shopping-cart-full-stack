package org.wecancodeit.shoppingcartfullstack.catalog;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class siteController {
	@Resource
	ProductRepository productRepo;
	
	@Resource
	CartRepository cartRepo; 
	
	@Resource
	CartItemRepository cartItemRepo; 
	
	@RequestMapping("products")
	public String getAllProducts(Model model) {
		model.addAttribute("products", productRepo.findAll());
		return "products"; 
	}
	
	@RequestMapping("product")
	public String getAProduct(@RequestParam long id, Model model) {
		Collection<Tag> selectedTags = productRepo.findOne(id).getTags(); 
		model.addAttribute("selectedTags", selectedTags); 
		model.addAttribute("product",productRepo.findOne(id)); 
		return "product"; 	
	}
	
	@RequestMapping("/my-cart")
	public String myCart(@RequestParam long id, Model model) {
		Cart cart = cartRepo.findById(id); 
		Iterable<CartItem> cartItems = cartItemRepo.findAll(); 
		model.addAttribute("carts", cartRepo); 
		model.addAttribute("cartItems", cartItems); 
		return "mycart"; 
	}
	
	@RequestMapping("/add-item")
	public String addItem(@RequestParam long id, String productName) {
		Product product = productRepo.findOne(id);
		Cart cart = cartRepo.findById(id); 
		
		CartItem newItem = new CartItem(cart, product, 1); 
		cartItemRepo.save(newItem); 
		
		return "/products"; 
	}
	

}
