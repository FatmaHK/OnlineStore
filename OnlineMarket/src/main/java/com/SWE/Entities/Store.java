package com.SWE.Entities;
import java.util.*;

import javax.persistence.*;

/**
 * 
 */
@Entity
public class Store {
	
    private Integer id;
    private String name;
    private String type;
    private String ownerName;
    private String location;
    private boolean isAccepted;
    private int numberOfVisitors;
    private int numberOfBuyers;
    private Set<StoreProduct> storeProducts;
    private Set<StoreBrand> storeBrands;
    private Set<StoreActions> storeActions;
    private Set<Statistic> statistics;
    private Set<User> users;

	public Store() {
    }
	
public Store(String name, String type, String ownerName, String location, boolean isAccepted, int numberOfVisitors,
		int numberOfBuyers, Set<StoreProduct> storeProducts,Set<StoreBrand> storeBrands, Set<StoreActions> storeActions, Set<Statistic> statistics,
		Set<User> users, Set<StoreAction> actions) {
	super();
	this.name = name;
	this.type = type;
	this.ownerName = ownerName;
	this.location = location;
	this.isAccepted = isAccepted;
	this.numberOfVisitors = numberOfVisitors;
	this.numberOfBuyers = numberOfBuyers;
	this.storeProducts = storeProducts;
	this.storeBrands = storeBrands;
	this.statistics = statistics;
	this.users = users;
	this.storeActions = storeActions;
}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean getIsAccepted() {
		return isAccepted;
	}
	public void setIsAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	public int getNumberOfVisitors() {
		return numberOfVisitors;
	}
	public void setNumberOfVisitors(int numberOfVisitors) {
		this.numberOfVisitors = numberOfVisitors;
	}
	public int getNumberOfBuyers() {
		return numberOfBuyers;
	}
	public void setNumberOfBuyers(int numberOfBuyers) {
		this.numberOfBuyers = numberOfBuyers;
	}
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<StoreProduct> getStoreProducts() {
		return storeProducts;
	}

	public void setStoreProducts(Set<StoreProduct> storeProducts) {
		this.storeProducts = storeProducts;
	}
	
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<StoreBrand> getStoreBrands() {
		return storeBrands;
	}

	public void setStoreBrands(Set<StoreBrand> storeBrands) {
		this.storeBrands = storeBrands;
	}
	
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<StoreActions> getStoreActions() {
		return storeActions;
	}

	public void setStoreActions(Set<StoreActions> storeActions) {
		this.storeActions = storeActions;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "store_statistics", joinColumns = @JoinColumn(name = "stat_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "store_id", referencedColumnName = "id"))
	public Set<Statistic> getStatistics() {
		return statistics;
	}
	public void setStatistics(Set<Statistic> statistics) {
		this.statistics = statistics;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "store_collaboratores", joinColumns = @JoinColumn(name = "store_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "collaborator_id", referencedColumnName = "id"))
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "store_actions", joinColumns = @JoinColumn(name = "action_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "store_id", referencedColumnName = "id"))	
//	public Set<StoreAction> getActions() {
//		return actions;
//	}
//
//	public void setActions(Set<StoreAction> actions) {
//		this.actions = actions;
//	}
}