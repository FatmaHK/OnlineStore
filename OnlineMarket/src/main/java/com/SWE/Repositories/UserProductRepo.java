package com.SWE.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.SWE.Entities.Product;
import com.SWE.Entities.UserProduct;

public interface UserProductRepo extends CrudRepository<UserProduct, Integer>{

}
