package com.SWE.Repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.SWE.Entities.Product;
import com.SWE.Entities.Store;
import com.SWE.Entities.StoreProduct;

public interface StoreProductRepo extends JpaRepository<StoreProduct, Integer>{
	@Query("select s.product.id from StoreProduct s where s.store = ?1 order by s.numberOfSoldItems desc")
    ArrayList<Integer> findByStore_id(Store s);
	
	@Query("select s.product.id from StoreProduct s where s.store = ?1 order by s.numberOfSoldItems asc")
    ArrayList<Integer> findMinByStore_id(Store s);
}
