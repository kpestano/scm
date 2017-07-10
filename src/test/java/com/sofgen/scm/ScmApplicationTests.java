package com.sofgen.scm;

import static org.junit.Assert.*;

import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sofgen.scm.utils.FileReader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScmApplicationTests {
	
	String file1 = "D://PROJECTS//SCM//fileFolder//file.txt";
	String file2 = "D://PROJECTS//SCM//fileFolder//file2.txt";
	String file3 = "D://PROJECTS//SCM//fileFolder//file3.txt";
	String file4 = "D://PROJECTS//SCM//fileFolder//file4.txt";
	String file5 = "D://PROJECTS//SCM//fileFolder//file5.txt";
	FileReader file = new FileReader(file1);

	//@Test
	public void contextLoads() {
	}
	
	@Test
	public void readFileTest() {
		List<String> lines = file.readFile();
		assertNotNull(lines);
	}
	
	@Test
	public void testMetadataReader(){
		BasicFileAttributes metadata = file.readMetadata();
		assertNotNull(metadata.creationTime());
	}
	
	@Test
	public void testCompareFile1ToFile2(){
        assertFalse(file.compare(file2));
	}
	@Test
	public void testCompareFile1ToFile3(){
        assertFalse(file.compare(file3));
	}

	@Test
	public void testCompareFile1toFile4(){
        assertFalse(file.compare(file4));
	}
	
	@Test
	public void testCompareFile1toFile5(){
        assertTrue(file.compare(file5));
	}

}
