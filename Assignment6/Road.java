/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 6
 *Instructor: Farnaz Eivazi
 *Summary of Description:A data element class for Road
 *Due Date: 05/09/21
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 */
public class Road implements Comparable<Road>{
	String name;
	Town source;
	Town destination;
	int weight;
	/**
	 * A constructor to set the attributes
	 * @param source the source town 
	 * @param destination the destination town
	 * @param weight the distance of the road
	 * @param string the name of the road
	 */

	public Road(Town source, Town destination, int weight, String string) {
		this.source=source;
		this.destination=destination;
		this.weight=weight;
		this.name=string;
		
	}
	/**
	 * A constructor that sets the weight to 1
	 * @param source the source town
	 * @param destination the destination town 
	 * @param name the name of the road 
	 */
	
	public Road(Town source, Town destination, String name) {
		weight=1;
		this.source=source;
		this.destination=destination;
		this.name=name;
		
	}
	/**
	 * A method that returns the name of the road
	 * @return name roads name
	 */

	public String getName() {
		return name;
	}
	/**
	 * A method that gets the source town
	 * @return source the source town 
	 */
	public Town getSource() {
		return source;
	}
	/**
	 * A method that gets the distance if the road
	 * @return weight the weight if the road
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * A contains method to check if the road contain the given town 
	 * @param town the town to be checked
	 * @return true if the edge is connected to the town passed, false otherwise
	 */
	public boolean contains(Town town) {
		return town.equals(source)||town.equals(destination);
	}
	/**
	 * A method to compare if two roads are the same
	 * @param o another road
	 * @return 0 if the roads are equal, 1 otherwise
	 */
	@Override
	public int compareTo(Road o) {
		if (name.equals(o.name)) {
			return 0;
		}
		else {
			return 1;
		}
	}
	/**
	 * A toString method that returns the name
	 * @return name the name of the road
	 */
	public String toString() {
		return name;
	}
	/**
	 * An equals method to compare two roads
	 * @return true if the roads are equals, false otherwise
	 */
	@Override
	public boolean equals(Object road) {
		
		Road obj=(Road) road;
		return ((destination.equals(obj.destination)||destination.equals(obj.source))
				&&(source.equals(obj.destination)||source.equals(obj.source)));
			
	}
}
