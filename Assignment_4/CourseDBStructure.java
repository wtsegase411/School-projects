import java.io.IOException;
import java.util.LinkedList;
/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 4
 *Instructor: Farnaz Eivazi
 *Summary of Description: A course DB Structure class that implements a hashtable with buckets
 *or to enter the data by hand, and uses an Alert to print out the database elements
 *Due Date: 04/11/21
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 */
public class CourseDBStructure implements CourseDBStructureInterface {
	private int i;
	protected LinkedList<CourseDBElement>[] hashTable;
	/**
	 * A constructor for initializing the size and create a linkedlist;
	 * @param i the size
	 */ 
	public CourseDBStructure(int i) {
		this.i=i;
		hashTable=new LinkedList[i];
	}
	/**
	 * A constructor for initializing the size
	 * @param str the string passed for testing 
	 * @param i the size
	 */
	public CourseDBStructure(String str, int i) {
		this.i=i;
		hashTable=new LinkedList[i];
	}
	/**
	 * A method to get the table size
	 * @return i the table size
	 */
	public int getTableSize() {
		return i;
	}
	/**
	 * A method to add the elements in a bucket list
	 * @param cde the element  
	 */
	public void add(CourseDBElement cde) {
		int index=cde.hashCode()%getTableSize();
		if (hashTable[index]==null) {
			hashTable[index]=new LinkedList<>();
			hashTable[index].add(cde);
		}
		else {
			hashTable[index].add(cde);
		}
	} 
	/**
	 * A method that that searches for the passed crn and gets the element 
	 * @param crn the crn of the course
	 * @throws IOException the exception to be thrown if the element doesnt exist
	 * @return element the targeted element 
	 */
	public CourseDBElement get(int crn) throws IOException {
		String str=Integer.toString(crn);
		int index=str.hashCode()%getTableSize();
		if(hashTable[index]==null) {
			throw new IOException("No item here");
		}
		for(int count = 0; count < getTableSize(); count++) {
			CourseDBElement element = hashTable[index].get(count);
			if(element.getCRN() == crn) {
				return element;
			}
		
		}
		throw new IOException("No matching item here");
		
	}

}
