package com.SWE.Entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Panel {
	 private Integer id;
	 private ArrayList<IStatistics> statistics;
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 public Integer getId() {
		 return id;
	 }
	 public void setId(Integer id) {
		 this.id = id;
	 }
	public Panel(Integer id) {
		super();
		this.id = id;
		statistics = new ArrayList<IStatistics>();
	}
	public Panel() {
		super();
		statistics = new ArrayList<IStatistics>();
	}
	 
}
