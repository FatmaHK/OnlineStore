package com.SWE.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.Brand;
import com.SWE.Entities.Product;
import com.SWE.Repositories.BrandRepository;

@CrossOrigin(origins = "*")
@RestController
public class BrandController {

	@Autowired
	private BrandRepository brandRepository;

	@GetMapping("/onlinemarket/addbrand")
	public boolean addBrand(Model model, @ModelAttribute Brand newBrand) {
		model.addAttribute("newBrand", new Brand());
		Brand b = brandRepository.findByName(newBrand.getName());
		if(b != null) {
			return false;
		}
		brandRepository.save(newBrand);
		return true;
	}
	
//	public Brand getBrandByID(int id) {
//		for(Brand b : brandRepository.findAll())
//        {
//            if(b.getId() == id)
//            	return b;
//        }
//        return null;
//	}
}
