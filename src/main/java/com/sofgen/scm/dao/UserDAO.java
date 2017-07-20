package com.sofgen.scm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sofgen.scm.model.User;

/**
 * @author tpenarubia
 *
 */

public interface UserDAO extends BaseRepository<User, Long>{

	List<User> findByUsername(String firstname);
}
