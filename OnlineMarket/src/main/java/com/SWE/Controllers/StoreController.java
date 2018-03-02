package com.SWE.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.Store;
import com.SWE.Repositories.StoreRepository;

@RestController
public class StoreController {
	@Autowired
	private StoreRepository storeRepository;
	
	@GetMapping("/onlinemarket/addstore/request")
	public boolean requestToAddStore(Model model, @ModelAttribute Store newStore) {
		model.addAttribute("newStore", new Store());
		newStore.setIsAccepted(false);	
		storeRepository.save(newStore);
		return true;
	}
	
	
	@GetMapping("/onlinemarket/addstore/accept-request")
	public boolean acceptStore(Model model, @ModelAttribute Store newStore) {
		model.addAttribute("newStore", new Store());
		newStore.setIsAccepted(true);	
		storeRepository.save(newStore);
		return true;
	}
	
}
