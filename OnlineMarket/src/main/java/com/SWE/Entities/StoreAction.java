package com.SWE.Entities;

import java.util.Set;

import javax.persistence.*;


@Entity
public class StoreAction {
	private int id;
	private String name;
	private String description;
	private Set<Store> stores;
    private Set<StoreActions> storeActions;
	
//	public StoreAction(int id, String name, String description, Set<Store> stores) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.description = description;
//		this.stores= stores;
//	}
	
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
	
	@OneToMany(mappedBy = "action")
	public Set<StoreActions> getStoreActions() {
		return storeActions;
	}
	public void setStoreActions(Set<StoreActions> storeActions) {
		this.storeActions = storeActions;
	}
	
//	@ManyToMany(mappedBy = "storeActionsPage")
//	public Set<Store> getStores() {
//		return stores;
//	}
//	public void setStores(Set<Store> stores) {
//		this.stores = stores;
//	}
	
	
}
