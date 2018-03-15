package com.SWE.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "store_product")
public class StoreProduct implements Serializable{
	private Integer id;
    private Store store;
    private Product product;
    private Integer quantity;
    private int numberOfSoldItems;
    private Integer numberOfViewers;
    private float price;
    
    
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
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    @Column(name = "quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Column(name = "price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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
