package com.SWE.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.Brand;
import com.SWE.Entities.StatResult;
import com.SWE.Entities.Store;
import com.SWE.Repositories.StoreBrandRepo;
import com.SWE.Repositories.StoreProductRepo;

@CrossOrigin(origins = "*")
@RestController
public class minSoldBrand extends StatisticsCommand{
	
	@Autowired
	StoreBrandRepo sbRepo;

	public minSoldBrand(StoreBrandRepo sbRepo2) {
		super();
		this.sbRepo = sbRepo2;
		commandName = "Minimum sold brand";
	}

	@Override
	public StatResult execute(int store_id) {
		Store s= new Store();
		s.setId(store_id);
		ArrayList<String> brands= sbRepo.findMinByStore_id(s);
		try {
			BrandController bc = new BrandController();
			StatResult res = new StatResult();
			res.statName = commandName;
			res.statEntity = brands.get(0);
//			Brand b = bc.getBrandByID(res.entityID);
//			res.statEntity = b.getName();
			return res;
		}catch(Exception e) {
			return null;
		}
		
	}
}

