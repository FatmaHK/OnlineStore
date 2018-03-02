package com.SWE.Entities;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 */
@Entity
public class Store {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String type;
    private String ownerName;
    private String location;
    private boolean isAccepted;
    public Store(String name, String type, String ownerName, String location, boolean isAccepted) {
		super();
		this.name = name;
		this.type = type;
		this.ownerName = ownerName;
		this.location = location;
		this.isAccepted = isAccepted;
	}
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
	public Store() {
    }



}