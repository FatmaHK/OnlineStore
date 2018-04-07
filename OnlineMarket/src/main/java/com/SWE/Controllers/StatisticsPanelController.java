package com.SWE.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.Product;
import com.SWE.Entities.Statistic;
import com.SWE.Entities.Store;
import com.SWE.Entities.StoreProduct;
import com.SWE.Entities.User;
import com.SWE.Repositories.StatisticsRepo;
import com.SWE.Repositories.StoreProductRepo;

@RestController
public class StatisticsPanelController {
	
	
	@Autowired
	private StatisticsRepo statRepo;
	
	@Autowired
	private StoreProductRepo storeProductRepo;
	
	@GetMapping("/onlinemarket/addStatistics/{id}")
	public void addStatistics(Model model, @ModelAttribute Statistic newStat) {
		model.addAttribute("newStat", new Statistic());
		StatisticsCommand statCmd = new StatisticsCommand();
		statCmd.setStatRepo(statRepo);
		statCmd.enableStatistics(newStat);
	}
	
	@GetMapping("/onlinemarket/removeStatistics/{id}")
	public void removeStatistics(Model model, @ModelAttribute Statistic stat) {
		model.addAttribute("stat", new Statistic());
		StatisticsCommand statCmd = new StatisticsCommand();
		statCmd.setStatRepo(statRepo);
		statCmd.disableStatistics(stat);
	}
	
	@RequestMapping("/onlinemarket/{store_id}")
	public int getStatistics(@PathVariable int store_id) {
		
		return 0;
	}
	
	
}
