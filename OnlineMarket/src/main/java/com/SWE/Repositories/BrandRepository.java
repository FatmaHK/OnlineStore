package com.SWE.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.SWE.Entities.Brand;
import com.SWE.Entities.Product;

public interface BrandRepository extends CrudRepository<Brand, Integer>{
	
	@Query("select b from Brand b where b.name = ?1")
    Brand findByName(String name);
}
