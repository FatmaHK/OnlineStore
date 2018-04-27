package com.SWE.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.Brand;
import com.SWE.Entities.Product;
import com.SWE.Entities.Store;
import com.SWE.Entities.StoreAction;
import com.SWE.Repositories.ActionRepo;
import com.SWE.Repositories.BrandRepository;
import com.SWE.Repositories.ProductRepository;
import com.SWE.Repositories.StoreActionsRepo;
import com.SWE.Repositories.StoreBrandRepo;
import com.SWE.Repositories.StoreProductRepo;
import com.SWE.Repositories.StoreRepository;

@CrossOrigin(origins = "*")
@RestController
public class EditBrand extends StoreCommand{
	
	@Autowired
	StoreActionsRepo saRepository;
	@Autowired
	ActionRepo actionRepository;
	@Autowired
	StoreRepository storeRepository;
	@Autowired
	StoreBrandRepo storeBrandRepo;
	@Autowired
	BrandRepository brandRepo;

	@Override
	@GetMapping("/onlinemarket/editBrandToStore/{sName}/{bId}")
	public boolean execute(@PathVariable String sName, @PathVariable int bId, Model model, Brand newbrand) {
		Store s = storeRepository.findByName(sName);
		StoreAction a = actionRepository.findByName("Edit brand");
		sc= new StoreController(storeBrandRepo, saRepository);
		sc.setBrandRepo(brandRepo);
		return (sc.editBrand(newbrand, s, bId, a));
	}

}
