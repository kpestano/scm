package com.sofgen.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofgen.scm.dao.FileDAO;
import com.sofgen.scm.model.File;
import com.sofgen.scm.service.FileService;

@Service
public class FileServiceImpl implements FileService{
	
	@Autowired
	private FileDAO fileDao;

	@Override
	public List<File> getAllFiles() {
		return fileDao.getAllFiles();
	}

	@Override
	public File getFile(int id) {
		// TODO Auto-generated method stub
		return null;
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
