package com.SWE.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "store_brand")
public class StoreBrand implements Serializable{
	private Integer id;
    private Store store;
    private Brand brand;
    private int numberOfSoldItems;
    private Integer numberOfViewers;
    
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
    @ManyToOne
    @JoinColumn(name = "store_id")
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    
    @ManyToOne
    @JoinColumn(name = "brand_id")
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
	public int getNumberOfSoldItems() {
		return numberOfSoldItems;
	}

	public void setNumberOfSoldItems(int numberOfSoldItems) {
		this.numberOfSoldItems = numberOfSoldItems;
	}

	public Integer getNumberOfViewers() {
		return numberOfViewers;
	}

	public void setNumberOfViewers(Integer numberOfViewers) {
		this.numberOfViewers = numberOfViewers;
	}
	
	
    
}
