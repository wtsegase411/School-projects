import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GraphStudentTest {
	private Graph graph;
	private Town[] town;
	
	@Before
	public void setUp() throws Exception {
		graph=new Graph();
		town= new Town[12];
		for (int i=1;i<12;i++) {
			town[i]=new Town("Town "+i);
			graph.addVertex(town[i]);
		}
		graph.addEdge(town[1], town[2], 2, "Road_1");
		graph.addEdge(town[1], town[3], 4, "Road_2");
		graph.addEdge(town[1], town[5], 6, "Road_3");
		graph.addEdge(town[3], town[7], 1, "Road_4");
		graph.addEdge(town[3], town[8], 2, "Road_5");
		graph.addEdge(town[4], town[8], 3, "Road_6");
		graph.addEdge(town[6], town[9], 3, "Road_7");
		graph.addEdge(town[9], town[10], 4, "Road_8");
		graph.addEdge(town[8], town[10], 2, "Road_9");
		graph.addEdge(town[5], town[10], 5, "Road_10");
		graph.addEdge(town[10],town[11], 3, "Road_11");
		graph.addEdge(town[2], town[11], 6, "Road_12");


	}

	@After
	public void tearDown() throws Exception {
		graph=null;
	}

	@Test
	public void testGetEdge() {
		assertEquals(new Road(town[1], town[2],2, "Road_1"), graph.getEdge(town[1], town[2]));
	}

	@Test
	public void testGetVertex() {
		Town newTown = new Town("Town_2");
		graph.addVertex(newTown);
		assertEquals(newTown, graph.getVertex("Town_2"));
		
	}

	@Test
	public void testAddEdge() {
		graph.addEdge(town[1], town[4],4,"Main_Road");
		assertEquals(true,graph.containsEdge(town[1],town[4]));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("Town");
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
	}
	

	@Test
	public void testContainsEdge() {
		assertEquals(false, graph.containsEdge(town[2], town[4]));
		assertEquals(true, graph.containsEdge(town[1], town[2]));
	}

	@Test
	public void testContainsVertex() {
		Town newTown = new Town("Town");
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
		
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
		assertEquals("Road_10", roadArrayList.get(1));
		assertEquals("Road_11", roadArrayList.get(2));
			
	
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = graph.vertexSet();
		assertEquals(true,roads.contains(town[1]));
		assertEquals(true, roads.contains(town[10]));
	}

	@Test
	public void testEdgesOf() {
		Set<Road> roads = graph.edgesOf(town[1]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
		assertEquals("Road_2", roadArrayList.get(1));
		assertEquals("Road_3", roadArrayList.get(2));
		
	}

	@Test
	public void testRemoveEdge() {
		graph.addEdge(town[1], town[4],4,"Main_Road");
		assertEquals(true,graph.containsEdge(town[1],town[4]));
		graph.removeEdge(town[1], town[4],4,"Main_Road");
		assertEquals(false,graph.containsEdge(town[1],town[4]));
	}

	@Test
	public void testRemoveVertex() {
		Town newTown = new Town("Town");
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
		graph.removeVertex(newTown);
		assertEquals(false, graph.containsVertex(newTown));
		
		
	}

}
