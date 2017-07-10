package com.sofgen.scm.service;

import java.util.List;

import com.sofgen.scm.model.File;

public interface FileService {

	List<File> getAllFiles();
	
	File getFile(int id);
	
	File downloadFile(int id);
	
	File uploadFile(File file);
}
