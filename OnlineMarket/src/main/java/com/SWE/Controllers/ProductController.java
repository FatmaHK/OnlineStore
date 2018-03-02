package com.SWE.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.Product;
import com.SWE.Repositories.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/onlinemarket/addproduct")
	public boolean addProduct(Model model, @ModelAttribute Product newProduct) {
		model.addAttribute("newProduct", new Product());
		if(getProduct(newProduct.getName(), newProduct.getBrand()) == null) {
			productRepository.save(newProduct);
			return true;
		}
		return false;
	}
	
	public Product getProduct(String pName, String brand) {
		for(Product p : productRepository.findAll())
        {
            if(p.getName().equals(pName) && p.getBrand().equals(brand))
            	return p;
        }
        return null;
	}
}
