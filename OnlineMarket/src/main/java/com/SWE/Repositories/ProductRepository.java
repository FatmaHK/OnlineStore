package com.SWE.Repositories;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.SWE.Entities.Product;
import com.SWE.Entities.Store;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	@Query("select p from Product p where p.name = ?1")
    Product findByName(String name);
	
}
