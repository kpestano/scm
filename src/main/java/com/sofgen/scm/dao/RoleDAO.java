package com.sofgen.scm.dao;

import org.springframework.stereotype.Repository;

import com.sofgen.scm.model.Role;

@Repository("roleDAO")
public interface RoleDAO extends BaseRepository<Role, Long>{
	Role findByRole(String role);
}
