package com.example.PayMe.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.PayMe.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User getUserByName(String name);
	
	//List<User> findListContactByUser(User user);

}
