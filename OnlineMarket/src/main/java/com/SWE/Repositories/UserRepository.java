package com.SWE.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.SWE.Entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query("select u from User u where u.email = ?1")
    User findByEmail(String email);
	
}
