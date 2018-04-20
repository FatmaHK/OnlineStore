package com.SWE.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.Store;
import com.SWE.Repositories.StoreProductRepo;

@RestController
public class minSoldProduct extends StatisticsCommand{

	@Autowired
	StoreProductRepo spRepo;
	@Override
	@GetMapping("/onlinemarket/getMinSoldProduct/{store_id}")
	public int execute(@PathVariable int store_id) {
		Store s= new Store();
		s.setId(store_id);
		ArrayList<Integer> products= spRepo.findMinByStore_id(s);
		return products.get(0);
	}
}
