import java.util.ArrayList;
/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 6
 *Instructor: Farnaz Eivazi
 *Summary of Description:A data element class for Town
 *Due Date: 05/09/21
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 */
public class Town implements Comparable<Town> {
	String name;
	int minWeight;
	Town prev;
	ArrayList<Town> adjTowns=new ArrayList<>();
	/**
	 * A constructor that sets the town and adjacent towns
	 * @param town the town
	 */
	public Town(Town town) {
		this.name=town.name;
		this.adjTowns=town.adjTowns;
		
	}
	/**
	 * A constructor that required a name 
	 * @param name the name of the town
	 */
	
	public Town(String name) {
		this.name=name;
	}
	/**
	 * A method that sets the minimum weight
	 * @param minWeight the minimim weight
	 */
	public void setMinWeight(int minWeight) {
		this.minWeight=minWeight;
		
	}
	/**
	 * A method that sets back the path
	 * @param vertex the town 
	 */
	public void setBackPath(Town vertex) {
		prev=vertex;
	}
	/**
	 * A method that returns the minimum weight
	 * @return minWeight the minimum weight
	 */
	public int getMinWeight() {
		return minWeight;
	}
	/**
	 * A method that return the name
	 * @return name the name of the town
	 */
	public String getName() {
		return name;
	}
	/**
	 * A method that returns the hashcode of the name of town
	 * return the hash code of the name of town
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
		
	}
	/**
	 * A method to compare two towns
	 * @param o another town
	 * @return return 0 if the towns are equal, 1 otherwise
	 */
	@Override
	public int compareTo(Town o) {
		if(name.equals(o.getName())){
			return 0;
		}
		else {
			return 1;
		}
			
	}
	/**
	 * An equals method to check if two towns are equal
	 * @param town another town
	 * @return true if towns are equals, false otherwise
	 */
	@Override
	public boolean equals(Object town) {
		Town town1=(Town) town;
		return name.equals(town1.name);
	}
	/**
	 * A toString method that prints the name of the town 
	 * return name the name of the town
	 */
	public String toString() {
		return name;
	}
	
	

}
