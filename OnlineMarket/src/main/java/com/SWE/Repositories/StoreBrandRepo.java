package com.SWE.Repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.SWE.Entities.Product;
import com.SWE.Entities.Store;
import com.SWE.Entities.StoreProduct;

public interface StoreBrandRepo extends JpaRepository<StoreProduct, Integer>{
	@Query("select sb.brand.id from StoreBrand sb where sb.store = ?1 order by sb.numberOfSoldItems desc")
    ArrayList<Integer> findMaxByStore_id(Store s);
	
	@Query("select sb.brand.id from StoreBrand sb where sb.store = ?1 order by sb.numberOfSoldItems asc")
    ArrayList<Integer> findMinByStore_id(Store s);
}
