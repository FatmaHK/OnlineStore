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
public class DeleteProduct extends StoreCommand{
	
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

	@GetMapping("/onlinemarket/deleteProductFromStore/{sName}/{pName}")
	public boolean execute(@PathVariable String sName, @PathVariable String pName) {
		Product p = productRepo.findByName(pName);
		Store s = storeRepository.findByName(sName);
		StoreAction a = actionRepository.findByName("Delete product");
		sc= new StoreController(storeProductRepo, saRepository);
		return (sc.deleteProduct(s, p, a));
	}

	
}
