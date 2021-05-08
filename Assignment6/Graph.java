import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 6
 *Instructor: Farnaz Eivazi
 *Summary of Description A graph class that adds and gets towns and roads 
 *Due Date: 05/09/21
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 */
public class Graph implements GraphInterface<Town, Road> {
	Set<Road> road=new HashSet<>();
	Set<Town> town=new HashSet<>();
	/**
	 * A method that returns an edge connecting source vertex to target vertex 
	 * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @return an edge connecting source vertex to target vertex.
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Iterator<Road> iter= road.iterator();
		while(iter.hasNext()) {
			Road r1=iter.next();
			if (r1.contains(sourceVertex)&&r1.contains(destinationVertex)) {
				return r1;
			}
		}
		return null;
	}
	/**
	 * A method that gets the vertex
	 * @param name name of the town 
	 * @return the targeted town
	 */
	public Town getVertex(String name) {
		Iterator<Town> to=town.iterator();
		while (to.hasNext()) {
			Town t1=to.next();
			if(t1.name.equals(name)) {
				return t1;
			}
		}
		return null;
	}
	/**
	 * Adds a road to the graph between two towns
	 * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     * @throws IllegalArgumentException if source or target isnt found
     * 
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws IllegalArgumentException {
		int count=0;
		Iterator<Town> iter1=town.iterator();
		while(iter1.hasNext()) {
			Town town1=iter1.next();
			if(town1.equals(sourceVertex)||town1.equals(destinationVertex)) {
				count++;
			}
		}
		if (count==2) {
			Road road1= new Road(sourceVertex, destinationVertex, weight, description);
			road.add(road1);
			return road1;
		}
		else {
			throw new IllegalArgumentException();
		}
		
	}
	/**
	 * Adds vertex to the graph
	 * @param v vertex to be added to this graph.
     * @return true if this graph did not already contain the specified
     * vertex.
     * @throws NullPointerException if the specified vertex is null.
	 */

	@Override
	public boolean addVertex(Town v) {
		Iterator<Town> iter=town.iterator();
		while(iter.hasNext()) {
			Town town1=iter.next();
			if(town1.equals(v)) {
				return false;
			}
			
		}
		town.add(v);
		return true;
	}
	/**
	 * A method that checks if the the graph contain a road between the passed towns 
	 * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @return true if this graph contains the specified edge.
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		int count=0;
		Iterator<Town> iter1=town.iterator();
		while(iter1.hasNext()) {
			Town town1=iter1.next();
			if(town1.equals(sourceVertex)||town1.equals(destinationVertex)) {
				count++;
			}
		}
		if (count==2) {
			Iterator<Road> iter=road.iterator();
			while(iter.hasNext()) {
				Road road1=iter.next();
				if (road1.contains(sourceVertex)&&road1.contains(destinationVertex)) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * checks if the town is contained in the graph
	 * @param v vertex whose presence in this graph is to be tested.
     * @return true if this graph contains the specified vertex.
	 */

	@Override
	public boolean containsVertex(Town v) {
		Iterator<Town> iter=town.iterator();
		while(iter.hasNext()) {
			Town town1=iter.next();
			if(town1.equals(v)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Returns a set of the edges contained in this graph
	 * @return a set of the edges contained in this graph.
	 */
	@Override
	public Set<Road> edgeSet() {		
		return road;
	}
	/**
	 *Returns a set of the vertices contained in this graph.
	 *@return a set view of the vertices contained in this graph.
	 */
	@Override
	public Set<Town> vertexSet() {
		return town;
	}
	/**
	 * Array list that contains all towns 	 * 
	 * @return rr1 list of all towns
	 */
	public ArrayList<Town> allTowns() {
		ArrayList<Town> rr1=new ArrayList<>();
		Iterator<Town> iter=vertexSet().iterator();
		while(iter.hasNext()) {
			Town t=iter.next();
			rr1.add(t);
		}		
		return rr1;
	}
	/**
	 *Returns a set of all edges touching the specified vertex
	 *@param vertex the vertex for which a set of touching edges is to be
     * returned.
     *@return a set of all edges touching the specified vertex
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) {

		Set<Road> setOfEdges=new HashSet<>();
		Iterator<Road> iter= road.iterator();
		while(iter.hasNext()) {
			Road r1=iter.next();
			if (r1.contains(vertex)) {
				setOfEdges.add(r1);
			}
		}
		return setOfEdges;

	}
	/**
	 * Removes the road frome the source and the destination vertex
	 * @param sourceVertex source vertex of the edge.
	 * @param destinationVertex target vertex of the edge.
	 * @param weight weight of the edge
	 * @param description description of the edge
	 * @return The removed edge, or null if no edge removed.
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road rr=new Road(sourceVertex,destinationVertex,weight,description);
		if(weight>-1) {
			Iterator<Road> iter=road.iterator();
			while(iter.hasNext()) {
				Road road1=iter.next();
				if(road1.equals(rr)) {
					road.remove(road1);
					return road1;
				}
			}
		}

		return null;
	}
	/**
	 * Removes the specified town from graph
	 * @param v vertex to be removed from this graph, if present.
	 * @return true if the graph contained the specified vertex;
     * false otherwise.
	 */
	@Override
	public boolean removeVertex(Town v) {

		if(!containsVertex(v)) {
			return false;
		}

		Iterator<Road> iter1=road.iterator();
		while(iter1.hasNext()) {
			Road road1=iter1.next();
			if (road1.contains(v)) {
				iter1.remove();
			}

		}

		town.remove(v);
		return true;

	}
	/**
	 * A method that finds the 
	 */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {		
		return  new ArrayList<>();
	}
	/**
	 * Returns the adjacent vertices in array list
	 * @param vertex the vertex
	 * @param open passed array lists 
	 * @return a list of adjacent vertices
	 */

	public ArrayList<Town> getAdjVerticesInSet(Town vertex, ArrayList<Town> open) {
		ArrayList<Town> adj=new ArrayList<>();
		for (Town T: open) {
			if(vertex.adjTowns.contains(T)) {
				adj.add(T);
			}
		}
		
		
		return adj;
		
	}
	/**
	 * gets weight to source
	 * @param adjVertex the adjacent vertex
	 * @param vertex the vertex
	 * @param sourceVertex the source vertex
	 * @return the weight if the vertices
	 */
	public int getWtToSource(Town adjVertex,Town vertex, Town sourceVertex) {
		Road r;
		r=getEdge(adjVertex,vertex);
		
		return r.weight+vertex.getMinWeight();
		
		
	}
	/**
	 * A method that implements dijiksra's algorithm
	 * @param sourceVertex the vertex to find shortest path from
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		ArrayList<Town> unvisited=allTowns();
		ArrayList<Town> visited=new ArrayList<>();
		visited.add(sourceVertex);
		while(!unvisited.isEmpty()) {
			int min=Integer.MAX_VALUE;
			Town minAdjTown=null;
			for( Town vertex:visited) {
				for(Town V:getAdjVerticesInSet(vertex,unvisited)) {
					int wt=getWtToSource(V,vertex,sourceVertex);
					if(wt<min) {
						min=wt;
						 minAdjTown=V;
						 V.setBackPath(vertex);
					}
				}
			}
			if(minAdjTown!=null) {
				minAdjTown.setMinWeight(min);
				unvisited.remove(minAdjTown);
				visited.add(minAdjTown);
			}
		}
		
	
		

	}
	

}
