package com.SWE.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.StatResult;
import com.SWE.Entities.Statistic;
import com.SWE.Repositories.StatisticsRepo;
import com.SWE.Repositories.StoreBrandRepo;
import com.SWE.Repositories.StoreProductRepo;

public abstract class StatisticsCommand {
	
	public static StatisticsRepo statRepo;
	StoreProductRepo spRepo;
	StoreBrandRepo sbRepo;
	String commandName;

//	public void setStatRepo(StatisticsRepo statRepo) {
//		this.statRepo = statRepo;
//	}

	public static void enableStatistics(String statName) {
		for(Statistic s: statRepo.findAll()) {
			if(s.getName().equals(statName)) {
				s.setEnabled(true);
				statRepo.save(s);
			}
		}
	}
	
	public static void disableStatistics(String statName) {
		for(Statistic s: statRepo.findAll()) {
			if(s.getName().equals(statName)) {
				s.setEnabled(false);
				statRepo.save(s);
			}
		}
	}
	
	public abstract StatResult execute(int store_id);

}
