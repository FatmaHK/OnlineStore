package com.SWE.Controllers;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.Statistics;
import com.SWE.Entities.Store;
import com.SWE.Entities.StoreProduct;
import com.SWE.Entities.User;
import com.SWE.Repositories.ProductRepository;
import com.SWE.Repositories.StoreProductRepo;
import com.SWE.Repositories.StoreRepository;

@CrossOrigin(origins = "*")
@RestController
public class StoreController {
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private StoreProductRepo storeProductRepo;
	
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
	
	public Store getStore(String sName) {
		for(Store s : storeRepository.findAll()) {
			System.out.println(s.getName());
			if(s.getName().equals(sName)) {
				return s;
			}
		}
		return null;
	}
	
	@GetMapping("/onlinemarket/store-statistics/{sName}")
	public ArrayList<Statistics> getStatistics(@PathVariable String sName) {
		Store store = getStore(sName);
		ArrayList<Statistics> statistics = new ArrayList();
		for(StoreProduct sp : storeProductRepo.findAll()) {
			if(sp.getStore().getId() == store.getId()) {
				Statistics s = new Statistics();
				s.productName = sp.getProduct().getName();
				s.numberOfViewers =sp.getNumberOfViewers();
				s.numOfSoldItems = sp.getNumberOfSoldItems();
				statistics.add(s);
			}
		}
		return statistics;
	}
	
}
