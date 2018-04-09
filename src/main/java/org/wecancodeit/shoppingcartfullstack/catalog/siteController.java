package org.wecancodeit.shoppingcartfullstack.catalog;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
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
	
	@RequestMapping("/mycart")
	public String myCart(@RequestParam long id, Model model) {
		Cart cart = cartRepo.findById(id); 
		Iterable<CartItem> cartItems = cartItemRepo.findAll(); 
		model.addAttribute("cartItems", cartItems); 
		return "mycart"; 
	}
	
	@RequestMapping("/add-item")
	public String addItem(@RequestParam long id, Integer itemQuantity) {
		Product product = productRepo.findById(id);
		Cart cart = cartRepo.findById(0L); 
		
		CartItem newItem = new CartItem(cart, product, itemQuantity); 
		cartItemRepo.save(newItem); 
		
		return "redirect:/mycart?id=" + 0L; 
	}
	
	@RequestMapping("/remove-item")
	public void removeItem(@RequestParam long id, Integer itemQuanitity) {
		CartItem itemToRemove = cartItemRepo.findOne(id); 
		cartItemRepo.delete(itemToRemove);
	}

}
