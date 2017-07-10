package com.sofgen.scm.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sofgen.scm.dao.FileDAO;
import com.sofgen.scm.model.File;

@Transactional
@Repository
public class FileDaoImpl implements FileDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<File> getAllFiles() {
		String hql = "FROM File";
		return (List<File>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public File getFile(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(File.class, id);
	}

	@Override
	public File downloadFile(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File uploadFile(File file) {
		// TODO Auto-generated method stub
		return null;
	}

}
