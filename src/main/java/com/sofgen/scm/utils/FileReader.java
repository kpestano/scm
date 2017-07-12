package com.sofgen.scm.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tpenarubia
 *
 */
public class FileReader {
	private String file;
	private List<String> fileLines  = new ArrayList<>();
	
	public FileReader(String file){
		this.file = file;
	}

	public List<String> readFile() {
		return readLines(file);
	}
	
	public boolean compare(String file2) {
		List<String> firstFileLines  = new ArrayList<>();
		List<String> secondFileLines  = new ArrayList<>();
		firstFileLines = readLines(file);
		secondFileLines = readLines(file2);
		
		return firstFileLines.stream().collect(Collectors.toList()).equals(secondFileLines);
	}
	
	public BasicFileAttributes readMetadata() {
		BasicFileAttributes attr = null;
		try{
	    	attr = Files.readAttributes(Paths.get(file), BasicFileAttributes.class);
	    }catch(IOException e){
	    	e.printStackTrace();
	    }
	    return attr;
	}
	
	private List<String> readLines(String file){
		List<String> lines  = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(file))) {
			lines = stream.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lines;
	}

}
