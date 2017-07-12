package com.sofgen.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofgen.scm.dao.UserDAO;
import com.sofgen.scm.model.User;
import com.sofgen.scm.service.UserService;

/**
 * @author tpenarubia
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User addUser(User user) {
		return userDAO.save(user);
	}

	@Override
	public void delete(User user) {
		userDAO.delete(user);
	}

	@Override
	public List<User> getUsers() {
		return userDAO.findAll();
	}

	@Override
	public User findUser(long id) {
		return userDAO.findOne(id);
	}
	
}
