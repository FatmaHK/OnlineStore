package com.SWE.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.Product;
import com.SWE.Entities.StatResult;
import com.SWE.Entities.Store;
import com.SWE.Repositories.StoreProductRepo;

@CrossOrigin(origins = "*")
@RestController
public class maxSoldProduct extends StatisticsCommand{
	
	private StoreProductRepo spRepo;
	
	public maxSoldProduct(StoreProductRepo spRepo) {
		super();
		this.spRepo = spRepo;
		commandName = "Maximum sold product";
	}

	@Override
	public StatResult execute(int store_id) {
		Store s= new Store();
		s.setId(store_id);
		ArrayList<String> products= spRepo.findByStore_id(s);
		try {
			ProductController pc = new ProductController();
			StatResult res = new StatResult();
			res.statName = commandName;
			res.statEntity = products.get(0);
//			Product p = pc.getProductByID(res.entityID);
//			res.statEntity = p.getName();
			return res;
		}catch(Exception e) {
			return null;
		}
	}

	
}

