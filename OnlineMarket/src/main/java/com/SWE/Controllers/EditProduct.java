package com.SWE.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.Product;
import com.SWE.Entities.Store;
import com.SWE.Entities.StoreAction;
import com.SWE.Repositories.ActionRepo;
import com.SWE.Repositories.ProductRepository;
import com.SWE.Repositories.StoreActionsRepo;
import com.SWE.Repositories.StoreProductRepo;
import com.SWE.Repositories.StoreRepository;

@CrossOrigin(origins = "*")
@RestController
public class EditProduct extends StoreCommand{
	
	@Autowired
	StoreActionsRepo saRepository;
	@Autowired
	ActionRepo actionRepository;
	@Autowired
	StoreRepository storeRepository;
	@Autowired
	StoreProductRepo storeProductRepo;
	@Autowired
	ProductRepository productRepo;

	@Override
	@GetMapping("/onlinemarket/editProductToStore/{sName}/{pId}")
	public boolean execute(@PathVariable String sName, @PathVariable int pId, Model model, Product newproduct) {
		Store s = storeRepository.findByName(sName);
		if(s == null) {
			return false;
		}
		StoreAction a = actionRepository.findByName("Edit product");
		sc= new StoreController(storeProductRepo, saRepository);
		sc.setProductRepo(productRepo);
		return (sc.editProduct(newproduct, s, pId, a));
	}

}