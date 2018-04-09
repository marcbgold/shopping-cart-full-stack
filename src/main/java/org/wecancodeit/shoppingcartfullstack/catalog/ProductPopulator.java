package org.wecancodeit.shoppingcartfullstack.catalog;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductPopulator implements CommandLineRunner{

		@Resource
		ProductRepository productRepo; 
		
		@Resource
		CartRepository cartRepo; 
		
		@Resource
		TagRepository tagRepo; 
		
		@Resource
		CartItemRepository cartItemRepo; 
		
		@Override
		public void run(String... args) throws Exception {
			Tag white = new Tag("white");
			Tag black = new Tag("black");
			Tag small = new Tag("small");
			Tag medium = new Tag("medium");
			Tag large = new Tag("large");
			
			white = tagRepo.save(white);
			black = tagRepo.save(black); 
			small = tagRepo.save(small); 
			medium = tagRepo.save(medium); 
			large = tagRepo.save(large); 
			
			Product wshirt1 = new Product("Shirt1",white,large);
			Product bshirt1 = new Product("Shirt2",black,small);
			wshirt1.editInfo("large white shirt"); 
			bshirt1.editInfo("small black shirt"); 
			
			wshirt1 = productRepo.save(wshirt1); 
			bshirt1 = productRepo.save(bshirt1); 
			
			Cart cart = new Cart(); 
			
			cart = cartRepo.save(cart); 
			
			CartItem item = new CartItem(cart, wshirt1, 1); 
			
			item = cartItemRepo.save(item); 
		}
		
}
