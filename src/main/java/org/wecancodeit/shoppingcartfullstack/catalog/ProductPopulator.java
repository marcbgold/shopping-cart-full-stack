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
			
			Product wlshirt = new Product("Shirt1",white,large);
			Product sbshirt = new Product("Shirt2",black,small);
			wlshirt.editInfo("large white shirt"); 
			sbshirt.editInfo("small black shirt"); 
			
			wlshirt = productRepo.save(wlshirt); 
			sbshirt = productRepo.save(sbshirt); 
			
			Cart cart = new Cart(); 
			
			
			
			
			
			
		}
		
}
