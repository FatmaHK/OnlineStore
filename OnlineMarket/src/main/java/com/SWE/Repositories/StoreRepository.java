package com.SWE.Repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.SWE.Entities.Store;

import antlr.collections.List;

public interface StoreRepository extends CrudRepository<Store, Integer>{
	
}
