import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 4
 *Instructor: Farnaz Eivazi
 *Summary of Description: A course DB Manager test class 
 *Due Date: 04/11/21
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 */
public class CourseDBManagerStudentTest {
	private CourseDBManager manager = new CourseDBManager();
	@BeforeEach
	void setUp() throws Exception {
		manager=new CourseDBManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		manager=null;
	}
	

	@Test
	void testAdd() {
		try {
			manager.add("CMSC204",32461,4,"RemoteLearning","Farnaz Eivazi");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
		
	}

	@Test
	void testReadFile() {
		File inputFile = new File("Test1.txt");
		
		try {
			PrintWriter inFile=new PrintWriter(inputFile);
			inFile.println("CMSC204 32461 4 RemoteLearning Farnaz Eivazi");
			inFile.print("MATH182 35235 4 RemoteLearning Yan Zhao");
			manager.readFile(inputFile);
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		} 
			
	}

	@Test
	void testShowAll() {
		manager.add("CMSC204",32461,4,"RemoteLearning","Farnaz Eivazi");
		manager.add("MATH182",35235,4,"RemoteLearning","Yan Zhao");
		manager.add("MATH117",34543,3,"RemoteLearning","Yan Zhao");
		manager.add("BIOL150",45634,4,"RemoteLearning","Charles Diamond");
		ArrayList<String> list = manager.showAll();
		
		assertEquals(list.get(0),"\nCourse:BIOL150 CRN:45634 Credits:4 Instructor:Charles Diamond Room:RemoteLearning");
		assertEquals(list.get(1),"\nCourse:MATH182 CRN:35235 Credits:4 Instructor:Yan Zhao Room:RemoteLearning");
		assertEquals(list.get(2),"\nCourse:MATH117 CRN:34543 Credits:3 Instructor:Yan Zhao Room:RemoteLearning");
		assertEquals(list.get(3),"\nCourse:CMSC204 CRN:32461 Credits:4 Instructor:Farnaz Eivazi Room:RemoteLearning");
		
		
		

	}

}
