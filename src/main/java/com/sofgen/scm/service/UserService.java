package com.sofgen.scm.service;

import java.util.List;

import com.sofgen.scm.model.User;

/**
 * @author tpenarubia
 *
 */
public interface UserService {

	User save(User user);
	
	void delete(Long id);
	
	List<User> getUsers();
	
	User findUser(Long id);
	
	User findUserByEmail(String email);
}
