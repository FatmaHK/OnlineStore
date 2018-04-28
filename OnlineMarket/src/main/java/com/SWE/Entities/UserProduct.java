package com.SWE.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
// */
@Entity
@Table(name = "user_product")
public class UserProduct implements Serializable{
	private Integer id;
	private User user;
	private Product product;
	private int boughtQuantityByUser;
	private float totalPrice;
		
	public UserProduct() {
		boughtQuantityByUser= 0;
		totalPrice= 0; 
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne
    @JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
    @JoinColumn(name = "product_id")
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Column(name = "bought_quantity")
	public int getBoughtQuantityByUser() {
		return boughtQuantityByUser;
	}
	public void setBoughtQuantityByUser(int boughtQuantityByUser) {
		this.boughtQuantityByUser = boughtQuantityByUser;
	}
	@Column(name = "total_price", columnDefinition = "INT(11) UNSIGNED")
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
		
	
}
