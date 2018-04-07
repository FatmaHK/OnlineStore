package com.SWE.Entities;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Brand {

    public Brand() {
    }

    private String name;
    private Integer id;
    private String category;
    
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;

	}
}
