package com.SWE.Repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.SWE.Entities.Product;
import com.SWE.Entities.Store;

import antlr.collections.List;

public interface StoreRepository extends CrudRepository<Store, Integer>{
	
	@Query("select s from Store s where s.name = ?1")
    Store findByName(String name);
	
}
