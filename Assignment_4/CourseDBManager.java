import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 4
 *Instructor: Farnaz Eivazi
 *Summary of Description: A course DB Manager class that  allows the user to read the courses from a file 
 *or to enter the data by hand, and uses an Alert to print out the database elements
 *Due Date: 04/11/21
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 */
public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure cds=new CourseDBStructure(500);
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement cdb=new CourseDBElement(id,crn,credits,roomNum,instructor);
		cds.add(cdb);
	}
 /**
  * A method used to get the crn number of the course
  * @param crn the crn of the course
  */
	@Override
	public CourseDBElement get(int crn) {
		try {
			cds.get(crn);
			
		}
		catch(IOException e) {
			System.out.println("Doesn't Exist");
		}
		return null;
	}
	/**
	 * A method used to read from a file and add it into the course data structure
	 * @param input the file input
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		try {
			Scanner newFile=new Scanner(input);
			while (newFile.hasNext()) {
				String read=newFile.nextLine();
				String[] arr=read.split(" ",5);
				int crn=Integer.parseInt(arr[1]);
				int credits=Integer.parseInt(arr[2]);
				CourseDBElement cdb=new CourseDBElement(arr[0],crn,credits,arr[3],arr[4]);
				cds.add(cdb);
			}
			newFile.close();
		}
		catch(FileNotFoundException e) { 
			System.out.println("File Not Found");
		}
	}
	/**
	 * A method to store into an array
	 * @return arr the DB element in an array
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> arr=new ArrayList<>();
		for (int i = 0; i < cds.hashTable.length; i++) { 
			LinkedList<CourseDBElement> linklist = cds.hashTable[i];
			if(linklist != null) {
				for(int j = 0; j < linklist.size(); j++) { 
					CourseDBElement element = linklist.get(j);
					arr.add(element+"");
				}
			}
		}
		return arr;
	}


}

	


