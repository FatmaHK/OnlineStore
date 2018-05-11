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
import com.SWE.Entities.User;
import com.SWE.Entities.UserProduct;
import com.SWE.Repositories.ProductRepository;
import com.SWE.Repositories.StoreProductRepo;
import com.SWE.Repositories.StoreRepository;
import com.SWE.Repositories.UserProductRepo;
import com.SWE.Repositories.UserRepository;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {
	
	@Autowired
	private UserProductRepo userProductRepo;
	
	@Autowired
	private UserRepository userRepo;
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
	
//	@GetMapping("/onlinemarket/buyproduct/")
//	public boolean buyProduct(@PathParam(value = "sName") String sName, @PathParam(value = "pName") String pName, @PathParam(value = "requiredAmount") int requiredAmount) {
//		Store s = storeRepository.findByName(sName);
//		Product p = productRepository.findByName(pName);
//		StoreProduct storeProduct = new StoreProduct();
//		storeProduct.setStore(s);
//		storeProduct.setProduct(p);
//		for(StoreProduct sp: spRepo.findAll()) {
//			if(sp.getStore().getId()== storeProduct.getStore().getId() && sp.getProduct().getId() == storeProduct.getProduct().getId() &&
//				sp.getQuantity()>= requiredAmount) {
//				sp.setQuantity(sp.getQuantity() - requiredAmount);
//				sp.setNumberOfSoldItems(sp.getNumberOfSoldItems() + requiredAmount);
//				spRepo.save(sp);
//				System.out.println("Success! ");
//				return true;
//			}
//		}
//		return false;
//	}
	
	@GetMapping("/onlinemarket/buyproduct/{username}/{sname}/{pname}/{requiredAmount}")
	public double buyProduct(@PathVariable String username, @PathVariable String sname, @PathVariable String pname, @PathVariable int requiredAmount) {
		User user= new User();
		user.setUsername(username);
		Store s = new Store();
		Product p = new Product();
		s.setName(sname);
		p.setName(pname);
		for(Store s1: storeRepository.findAll()) {
			if(s1.getName().equals(s.getName())) {
				s.setId(s1.getId());
				break;
			}
		}
		for(Product p1: productRepository.findAll()) {
			if(p1.getName().equals(p.getName())) {
				p.setId(p1.getId());
				break;
			}
		}
		StoreProduct storeProduct = new StoreProduct();
		storeProduct.setStore(s);
		storeProduct.setProduct(p);
		boolean validRequest= false;
		for(StoreProduct sp: spRepo.findAll()) {
			if(sp.getStore().getId()== storeProduct.getStore().getId() && sp.getProduct().getId() == storeProduct.getProduct().getId() &&
				sp.getQuantity()>= requiredAmount) {
				sp.setQuantity(sp.getQuantity() - requiredAmount);
				sp.setNumberOfSoldItems(sp.getNumberOfSoldItems() + 1);
				validRequest= true;
				spRepo.save(sp);
				break;
			}
		}
		if(validRequest == true) {
			double decreaseAmount= 0;
			UserProduct buyProcess= new UserProduct();
			buyProcess.setUser(user);
			buyProcess.setProduct(p);
			for(StoreProduct spr: spRepo.findAll()) {
				if(spr.getProduct().getId()== p.getId() && spr.getStore().getId()== s.getId()) {
					p.setPrice(spr.getPrice());
					break;
				}
			}
			buyProcess.setTotalPrice(requiredAmount* p.getPrice());
			for(User us: userRepo.findAll()) {
				if(us.getUsername().equals(buyProcess.getUser().getUsername())) {
					//user = us;
					user.setId(us.getId());
					if(us.getType().equals("store owner")) {
						decreaseAmount+= 0.15;
						System.out.println("store owner! ");
						break;
					}
				}
			}
			if(requiredAmount == 2) {
				decreaseAmount+= 0.10;
				System.out.println("amount= 2 ! ");
			}
			boolean firstBuy= true;
			for(UserProduct usp: userProductRepo.findAll()) {
				if(usp.getUser().getId()== user.getId() && usp.getProduct().getId()== p.getId()) {
					firstBuy= false;
					break;
				}
			}
			if(firstBuy) {
				decreaseAmount+= 0.05;
				System.out.println("first buy ! ");
			}
			buyProcess.setBoughtQuantityByUser(requiredAmount);
			double totalPrice= buyProcess.getTotalPrice();
			buyProcess.setTotalPrice((float)(totalPrice- decreaseAmount* totalPrice));
			userProductRepo.save(buyProcess);
			return buyProcess.getTotalPrice();
		}
		return -1;
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
