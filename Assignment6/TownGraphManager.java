import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 6
 *Instructor: Farnaz Eivazi
 *Summary of Description A town graph manager class that adds and gets towns and roads using the graph class
 *Due Date: 05/09/21
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 */
public class TownGraphManager implements TownGraphManagerInterface {
	Graph graph=new Graph();
	/**
	 * A method that returns an arrrayList of all towns in alphabetical order
	 * @return an arrrayList of all towns in alphabetical order
	 */
	public ArrayList<String> allTowns() {
		ArrayList<String> rr1=new ArrayList<>();
		Iterator iter=graph.vertexSet().iterator();
		while(iter.hasNext()) {
			Town t=(Town) iter.next();
			rr1.add(t.name);
		}
		
		Collections.sort(rr1);
		return rr1;
	}
	/**
	 * A method that returns an arrrayList of all roads in alphabetical order
	 * @return an arrrayList of all roads in alphabetical order
	 */
	public ArrayList<String> allRoads() {
		ArrayList<String> rr1=new ArrayList<>();
		Iterator iter=graph.edgeSet().iterator();
		while(iter.hasNext()) {
			Road t=(Road) iter.next();
			rr1.add(t.name);
		}
		Collections.sort(rr1);
		return rr1;
	}
	/**
	 * A method that gets town 
	 * @param string the name of town 
	 * @return the town using the name
	 */
	public Town getTown(String string) {
       return graph.getVertex(string);
		
	}
	/**
	 * Adds a town to the graph
	 * @param townName the name of town
	 * @return true if its successful 
	 */
	public boolean addTown(String townName) {
		Town town=new Town(townName);
		 graph.addVertex(town);	
		 return true;
	}
	/**
	 * A method that adds road
	 * @param town1 name of town 1 
	 * @param town2 name of town 2 
	 * @param roadName name of road
	 * @param weight the weight of the road
	 * @return true if successful , false otherwise
	 */
	@Override  
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		try {
			Town one=new Town(town1);
			Town two=new Town(town2);
			graph.addEdge(one, two, weight, roadName);
			return true;
		}
		catch(IllegalArgumentException e){
			return false;
			
		}
		
	}
	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 
	 * @param town2 name of town 2 
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */

	@Override
	public String getRoad(String town1, String town2) {
	    Road r=graph.getEdge(new Town(town1), new Town(town2));
		return r.name;
	}
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */

	@Override
	public boolean containsTown(String v) {
		
		return graph.containsVertex(new Town(v));
	}
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 
	 * @param town2 name of town 2 
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(new Town(town1), new Town(town2));
		
	}
	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 
	 * @param town2 name of town 2 
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		graph.removeEdge(new Town(town1),new Town(town2),0,road );
		return true;
		
	}
	/**
	 * Deletes a town from the graph
	 * @param v name of town 
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v) {
		
		return graph.removeVertex(new Town(v));
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return null;
	}
	public void populateTownGraph(File input)throws FileNotFoundException, IOException{
		
	}
	



}
