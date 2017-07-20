package com.sofgen.scm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sofgen.scm.model.User;
import com.sofgen.scm.service.UserService;
import com.sofgen.scm.utils.Messages;

/**
 * @author tpenarubia
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private Messages messages;
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping("/all")
    public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long id){
		LOG.info(messages.get("info.finding") + id );
		User user = userService.findUser(id);
		if(user == null){
			LOG.info(messages.get("error.not.found") + "- id:" + id );
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		LOG.info("User successfully retrieved id: " + id );
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		  LOG.info("saving record ");
		  userService.save(user);
		  LOG.info("record saved");
		  return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Long> deleteUser(@PathVariable("id") Long id){
		LOG.info("deleting record");
		userService.delete(id);
		LOG.info("record deleted");
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
}
