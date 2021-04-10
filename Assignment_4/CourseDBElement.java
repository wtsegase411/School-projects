/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 4
 *Instructor: Farnaz Eivazi
 *Summary of Description: A course DBElement class used to get the courseID, crn, number of credits, room number, an instructor and a hashcode for the object
 *Due Date: 04/11/21
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 */
public class CourseDBElement implements Comparable {
	private String courseId;
	private int crn;
	private int numOfCredits;
	private String roomNum;
	private String instructor;
	public CourseDBElement() {
	}

    /**
     * A constructor used to initialize the attributes
     * @param courseId the course ID of the course
     * @param crn the crn number of the course
     * @param numOfCredits the number of credits for the course
     * @param roomNum the room number of the course
     * @param instructor the name of instructor for the course
     */
	public CourseDBElement(String courseId, int crn, int numOfCredits, String roomNum, String instructor) {
		this.setCourseId(courseId);
		this.setCRN(crn);
		this.setNumOfCredits(numOfCredits);
		this.setRoomNum(roomNum);
		this.setInstructor(instructor);
	}
	/**
	 * A method to get the course ID
	 * @return courseId the course Id 
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * A method to set the course ID
	 * @param courseId the course ID
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * A method to get the number of credits 
	 * @return numOfCredits the number of the credits
	 */

	public int getNumOfCredits() {
		return numOfCredits;
	}
	/**
	 * A method to set the number of credits
	 * @param numOfCredits the number of credits
	 */

	public void setNumOfCredits(int numOfCredits) {
		this.numOfCredits = numOfCredits;
	}


	/**
	 * A method to get the room number
	 * @return roomNum the room number
	 */
	public String getRoomNum() {
		return roomNum;
	}

	
	/**
	 * A method to set the Room number
	 * @param roomNum the room number
	 */
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}


	/**
	 * A method to get the Instructor
	 * @return instructor the name of the instructor 
	 */
	public String getInstructor() {
		return instructor;
	}


	/**
	 * A method to set the Instructor name 
	 * @param instructor the name of the instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}


	/**
	 * A method to get the Crn number
	 * @return crn the crn number
	 */
	public int getCRN() {
		return crn;
	}

	
	/**
	 * A method to set the crn number
	 * @param cRN the crn number
	 */
	public void setCRN(int cRN) {
		crn = cRN;
	}
	/**
	 * A toString method to print all the information 
	 * @return the course information
	 */
	public String toString() {
		return "\nCourse:"+courseId + " CRN:" + crn + " Credits:" + numOfCredits+" Instructor:" + instructor
				+ " Room:" + roomNum;
	}

	/**
	 * An overrided compareTo method to compare another object with the current 
	 * @return 0 if the objects are equal, 1 if the calling object is greater and 
	 * negative 1 if the calling object is smaller
	 */
	@Override
	public int compareTo(Object o) {
		CourseDBElement obj=(CourseDBElement)o;
		if (crn==obj.getCRN()) {
			return 0;
		}
		else if(crn>obj.getCRN()) {
			return 1;
		}
		else {
			return -1;
		}

	}
	/**
	 * An overrided method to check if this object is equal with another
	 * @return return true of the objects are equal or false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		CourseDBElement obj=(CourseDBElement)o;
		if (obj==null) {
			return false;
		}
		return this.getCRN()==obj.crn;
		
	}
	/**
	 * An overrided method to get the hashcode of the crn
	 * @return the hashcode of the crn
	 */
	@Override
	public int hashCode() {
		String newInt=Integer.toString(crn);
		return newInt.hashCode();
	}



}
