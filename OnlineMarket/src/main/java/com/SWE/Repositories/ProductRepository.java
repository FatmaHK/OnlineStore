package com.SWE.Repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.SWE.Entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	
//	@PersistenceContext
//	EntityManager entityManager;
//	StoredProcedureQuery query = entityManager.createStoredProcedureQuery("login");
}
