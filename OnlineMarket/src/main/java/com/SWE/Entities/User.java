package com.SWE.Entities;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class User {

    public User() {
    }
    private Integer id;
    private String name;
	private String username;
    private String email;
    private String password;
    private String type;
    private Set<Store> stores;
    
    public User(String name, String username, String email, String passowrd, String type, Set<Store> stores) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = passowrd;
		this.type = type;
		this.stores = stores;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@ManyToMany(mappedBy = "users")
	public Set<Store> getStores() {
		return stores;
	}
	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}

}