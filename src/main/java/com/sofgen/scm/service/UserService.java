package com.sofgen.scm.service;

import java.util.List;

import com.sofgen.scm.model.User;

/**
 * @author tpenarubia
 *
 */
public interface UserService {

	User addUser(User user);
	void delete(User user);
	List<User> getUsers();
	User findUser(long id);
}
