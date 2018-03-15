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
    
    
    

	public Store() {
    }
public Store(Integer id, String name, String type, String ownerName, String location, boolean isAccepted) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.ownerName = ownerName;
		this.location = location;
		this.isAccepted = isAccepted;
		storeProducts = new HashSet<StoreProduct>();
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

}