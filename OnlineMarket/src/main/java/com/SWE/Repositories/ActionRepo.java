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
import com.SWE.Entities.StoreAction;

public interface ActionRepo extends CrudRepository<StoreAction, Integer>{
	
	@Query("select a from StoreAction a where a.name = ?1")
    StoreAction findByName(String name);
	
}
