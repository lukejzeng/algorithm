package com.coolcode.exercise.backtrack;

import java.util.Arrays;

public class ColoringProblem {
	
	int numberOfVertexes;
	
	static String [] colors = {"red", "blue", "yellow", "green", "orange"};
	int [][] adjacencyMatrix;
	Node [] nodeMap;
	
	public ColoringProblem(int[][] adjacencyMatrix) 
	{
		this.adjacencyMatrix = adjacencyMatrix; 
		numberOfVertexes = adjacencyMatrix.length;
		nodeMap = new Node[numberOfVertexes];
	}

	static class Node {
		String color = "none";
		String name;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
