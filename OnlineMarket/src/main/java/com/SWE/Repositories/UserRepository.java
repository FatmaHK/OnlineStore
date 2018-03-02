package com.SWE.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.SWE.Entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
}
