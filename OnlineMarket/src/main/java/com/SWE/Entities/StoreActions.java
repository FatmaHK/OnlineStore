package com.SWE.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "store_actions")
public class StoreActions implements Serializable{
	private Integer id;
    private Store store;
    private StoreAction action;
    private Date date;
    
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
    @JoinColumn(name = "action_id")
    public StoreAction getAction() {
        return action;
    }

    public void setAction(StoreAction action) {
        this.action = action;
    }
    
    @Column(name = "quantity")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
		
	
    
}
