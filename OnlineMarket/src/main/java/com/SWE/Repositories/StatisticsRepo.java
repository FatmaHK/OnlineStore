package com.SWE.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.SWE.Entities.Statistic;

public interface StatisticsRepo extends JpaRepository<Statistic, Integer> {
	
}
