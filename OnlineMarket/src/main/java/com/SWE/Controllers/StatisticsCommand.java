package com.SWE.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.Statistic;
import com.SWE.Repositories.StatisticsRepo;

public abstract class StatisticsCommand {
	
	public static StatisticsRepo statRepo;

//	public void setStatRepo(StatisticsRepo statRepo) {
//		this.statRepo = statRepo;
//	}

	public static void enableStatistics(Statistic stat) {
		stat = statRepo.findOne(stat.getId());
		stat.setEnabled(true);
		statRepo.save(stat);
	}
	
	public static void disableStatistics(Statistic stat) {
		stat = statRepo.findOne(stat.getId());
		stat.setEnabled(false);
		statRepo.save(stat);
	}
	
	public abstract int execute(int store_id);
}
