package com.sofgen.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sofgen.scm.model.File;
import com.sofgen.scm.service.FileService;

@Controller
@RequestMapping("file")
public class FileController {

	@Autowired
	private FileService fileService;
	
	@GetMapping("all")
	public ResponseEntity<List<File>> getAllArticles() {
		List<File> list = fileService.getAllFiles();
		return new ResponseEntity<List<File>>(list, HttpStatus.OK);
	}
}
