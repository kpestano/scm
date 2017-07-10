package com.sofgen.scm.dao;

import java.io.Serializable;

public interface BaseDAO<T extends Serializable>{

	void add(T entity);
	void update(T entity);
	void delete(T entity);
	boolean exists(T entity);
}
