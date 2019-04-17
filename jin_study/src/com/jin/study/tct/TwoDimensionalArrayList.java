package com.jin.study.tct;

import java.util.ArrayList;

public class TwoDimensionalArrayList {

	public static void main(String[] argv) {
		
		//First, let¡¯s create a new 2-D ArrayList:

		int vertexCount = 3;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertexCount);
		
		//Next, we¡¯ll initialize each element of ArrayList with another ArrayList:
		for(int i=0; i < vertexCount; i++) {
		    graph.add(new ArrayList());
		}
		
		//Finally, we can add all the edges (0, 1), (1, 2), and (2, 0), to our 2-D ArrayList:
//		graph.get(0).add(1);
//		graph.get(1).add(2);
//		graph.get(2).add(0);
		
		//Let us also assume that our graph is not a directed graph. So, we also need to add the edges (1, 0), (2, 1), and (0, 2), to our 2-D ArrayList:
		graph.get(1).add(0);
		graph.get(2).add(1);
		graph.get(0).add(2);
		
		//Then, to loop through the entire graph, we can use a double for loop:

		vertexCount = graph.size();
		for (int i = 0; i < vertexCount; i++) {
		    int edgeCount = graph.get(i).size();
		    for (int j = 0; j < edgeCount; j++) {
		        Integer startVertex = i;
		        Integer endVertex = graph.get(i).get(j);
		        System.out.printf("Vertex %d is connected to vertex %d%n", startVertex, endVertex);
		    }
		}
		
	}

}