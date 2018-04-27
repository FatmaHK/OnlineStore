package com.SWE.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.SWE.Entities.Product;
import com.SWE.Entities.StoreAction;
import com.SWE.Entities.StoreActions;

public interface StoreActionsRepo extends CrudRepository<StoreActions, Integer>{

}
