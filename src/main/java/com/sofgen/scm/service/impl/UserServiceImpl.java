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
	public User save(User user) {
		if(user.getId() > 0){
			User update = userDAO.findOne(user.getId());
			update.setFirstName(user.getFirstName());
			update.setLastName(user.getLastName());
			update.setGender(user.getGender());
			update.setBirthdate(user.getBirthdate());
			update.setUsername(user.getUsername());
			update.setPassword(user.getPassword());
			user = update;
		}
		return userDAO.save(user);
	}

	@Override
	public void delete(Long id) {
		userDAO.delete(id);
	}

	@Override
	public List<User> getUsers() {
		return userDAO.findAll();
	}

	@Override
	public User findUser(Long id) {
		return userDAO.findOne(id);
	}

	@Override
	public List<User> findByUsername(String username) {
		return userDAO.findByUsername(username);
	}
	
}
