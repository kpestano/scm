package com.sofgen.scm.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
			Role userRole = roleDAO.findOne(user.getId());
			User update = userDAO.findOne(user.getId());
			update.setFirstName(user.getFirstName());
			update.setLastName(user.getLastName());
			update.setModifiedBy(userRole.getRole());
			update.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
			user = update;
		}else{
			Role userRole = roleDAO.findByRole("ADMIN");
			user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		    user.setStatus(Status.ACTIVE.getIntValue());
		    user.setCreatedBy(userRole.getRole());
		    user.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
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
