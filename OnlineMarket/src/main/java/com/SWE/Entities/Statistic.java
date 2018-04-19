package com.SWE.Entities;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Statistic {
	
	
	private int id;
	private String name;
	private String description;
	private boolean enabled;
	private Set<Store> stores;
	
	public Statistic() {
		
	}
	
public Statistic(String name, String description, boolean enabled, Set<Store> stores) {
		super();
		this.name = name;
		this.description = description;
		this.enabled = enabled;
		this.stores = stores;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@ManyToMany(mappedBy = "statistics")
	public Set<Store> getStores() {
		return stores;
	}
	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}
	
}
