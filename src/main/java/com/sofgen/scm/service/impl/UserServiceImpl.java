package com.sofgen.scm.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sofgen.scm.dao.RoleDAO;
import com.sofgen.scm.dao.UserDAO;
import com.sofgen.scm.enums.Status;
import com.sofgen.scm.model.Role;
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
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Override
	public User save(User user) {
		if(user.getId() > 0){
			User update = userDAO.findOne(user.getId());
			update.setFirstName(user.getFirstName());
			update.setLastName(user.getLastName());
			user = update;
		}else{
			Role userRole = roleDAO.findByRole("ADMIN");
			user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		    user.setStatus(Status.ACTIVE.getIntValue());
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
	public User findUserByEmail(String email) {
		return userDAO.findByEmail(email);
	}
}
