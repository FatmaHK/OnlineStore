package com.SWE.Entities;
import java.util.*;

import javax.persistence.*;

/**
 * 
 */
@Entity
public class Product {

    private Integer id;
    private String name;
    private float price;
    private String type;
    private String brand;
    private int quantity;
    private Set<StoreProduct> storeProducts;
    
    public Product() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@OneToMany(mappedBy = "product")
	public Set<StoreProduct> getStoreProducts() {
		return storeProducts;
	}
	public void setStoreProducts(Set<StoreProduct> storeProducts) {
		this.storeProducts = storeProducts;
	}
	

}