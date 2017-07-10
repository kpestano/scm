package com.sofgen.scm.dao;

import java.util.List;

import com.sofgen.scm.model.File;

public interface FileDAO{
	
	List<File> getAllFiles();
	
	File getFile(int id);

	File downloadFile(int id);
	
	File uploadFile(File file);
}
