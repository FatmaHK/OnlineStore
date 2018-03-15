package com.SWE.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.SWE.Entities.StoreProduct;

public interface StoreProductRepo extends CrudRepository<StoreProduct, Integer>{

}
