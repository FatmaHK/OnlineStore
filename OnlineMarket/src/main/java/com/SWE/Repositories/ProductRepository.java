package com.SWE.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.SWE.Entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
