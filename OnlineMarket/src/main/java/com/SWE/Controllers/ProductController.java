package com.SWE.Controllers;


import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.Product;
import com.SWE.Entities.Store;
import com.SWE.Entities.StoreProduct;
import com.SWE.Repositories.ProductRepository;
import com.SWE.Repositories.StoreProductRepo;
import com.SWE.Repositories.StoreRepository;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private StoreProductRepo spRepo;
	
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
	
	public Product getProductByID(int id) {
		for(Product p : productRepository.findAll())
        {
            if(p.getId() == id)
            	return p;
        }
        return null;
	}
	
	@GetMapping("/onlinemarket/buyproduct/")
	public boolean buyProduct(@PathParam(value = "sName") String sName, @PathParam(value = "pName") String pName, @PathParam(value = "requiredAmount") int requiredAmount) {
		Store s = storeRepository.findByName(sName);
		Product p = productRepository.findByName(pName);
		StoreProduct storeProduct = new StoreProduct();
		storeProduct.setStore(s);
		storeProduct.setProduct(p);
		for(StoreProduct sp: spRepo.findAll()) {
			if(sp.getStore().getId()== storeProduct.getStore().getId() && sp.getProduct().getId() == storeProduct.getProduct().getId() &&
				sp.getQuantity()>= requiredAmount) {
				sp.setQuantity(sp.getQuantity() - requiredAmount);
				sp.setNumberOfSoldItems(sp.getNumberOfSoldItems() + requiredAmount);
				spRepo.save(sp);
				System.out.println("Success! ");
				return true;
			}
		}
		return false;
	}
	
	 @GetMapping("/get-products")
	    public ArrayList<Product> getAllProducts() {
	        ArrayList<Product> products = new ArrayList<>();
	        for(Product p: productRepository.findAll()) {
	        	p.setStoreProducts(null);
	        	products.add(p);
	        }
	        return products;
	 }
}
