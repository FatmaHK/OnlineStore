package com.SWE.Controllers;

import java.util.ArrayList;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.Product;
import com.SWE.Entities.StatResult;
import com.SWE.Entities.Statistic;
import com.SWE.Entities.Store;
import com.SWE.Entities.StoreProduct;
import com.SWE.Entities.User;
import com.SWE.Repositories.BrandRepository;
import com.SWE.Repositories.ProductRepository;
import com.SWE.Repositories.StatisticsRepo;
import com.SWE.Repositories.StoreBrandRepo;
import com.SWE.Repositories.StoreProductRepo;
import com.SWE.Repositories.StoreRepository;

@CrossOrigin(origins = "*")
@RestController
public class StatisticsPanelController {
	
	
	@Autowired
	private StatisticsRepo statRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private BrandRepository brandRepo;
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Autowired
	private StoreProductRepo storeProductRepo;
	
	@Autowired
	private StoreBrandRepo sbRepo;
	
	private ArrayList<StatisticsCommand> commands;
	
	public StatisticsPanelController() {
		
	}
	
	@GetMapping("/onlinemarket/addStatistics/{statname}")
	public boolean addStatistics(@PathVariable String statname) {
		try {
			StatisticsCommand.statRepo = statRepo;
			StatisticsCommand.enableStatistics(statname);
			return true;
		}catch(Exception e) {
			return false;
		}
		
//		newStat.setStores(null);
//		return newStat;
	}
	
	@GetMapping("/onlinemarket/removeStatistics/{statname}")
	public boolean removeStatistics(@PathVariable String statname) {
		try {
			StatisticsCommand.statRepo = statRepo;
			StatisticsCommand.disableStatistics(statname);
			return true;
		}catch(Exception e) {
			return false;
		}
		
//		stat.setStores(null);
//		return stat;
	}
	
	@GetMapping("/onlinemarket/getAvailableStatistics/")
	public ArrayList<Statistic> getAvailableStatistics() {
		ArrayList<Statistic> statistics = new ArrayList<>();
		for(Statistic s: statRepo.findAll()) {
			if(s.isEnabled() == true) {
				s.setStores(null);
				statistics.add(s);
			}
		}
		return statistics;
	}
	
	@GetMapping("/onlinemarket/get-Statistics/{storename}")
	public ArrayList<StatResult> getStatistics(@PathVariable String storename) {
		commands = new ArrayList<>();
		Store store = new Store();
		for(Store s : storeRepo.findAll())
	    {
	        if(s.getName().equals(storename))
	            store = s;
	    }
		int storeId = store.getId();
		Set<Statistic> storeStatistics = store.getStatistics();
		for(Statistic s: storeStatistics) {
			if(s.getId() == 1) {
				StatisticsCommand c1 = new maxSoldProduct(storeProductRepo);
				commands.add(c1);
			}
			else if(s.getId() == 2) {
				StatisticsCommand c2 = new minSoldProduct(storeProductRepo);
				commands.add(c2);
			}
			else if(s.getId() == 3) {
				StatisticsCommand c3 = new maxSoldBrand(sbRepo);
				commands.add(c3);
			}
			else if(s.getId() == 4) {
				StatisticsCommand c4 = new minSoldBrand(sbRepo);
				commands.add(c4);
			}
		}
		ArrayList<StatResult> result = new ArrayList<>();
		System.out.println(commands.size());
		for(StatisticsCommand c: commands) {
			StatResult res = new StatResult();
			res = c.execute(storeId);
			result.add(res);
		}
		return result;
	}
	
}
