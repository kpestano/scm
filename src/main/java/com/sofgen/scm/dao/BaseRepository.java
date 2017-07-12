package com.sofgen.scm.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * @author tpenarubia
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, Long>{

	void delete(T deleted);
	List<T> findAll();
	T findOne(ID id);
	T save(T persisted);
}
