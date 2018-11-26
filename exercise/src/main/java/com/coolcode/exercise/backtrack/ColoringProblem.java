package com.coolcode.exercise.backtrack;

import java.util.Arrays;

public class ColoringProblem {
	
	int numberOfVertexes;
	
	//static String [] colors = {"red", "blue", "yellow", "green", "orange"};
	int colorIndex;
	int numberOfColors;
	int [][] adjacencyMatrix;
	int [] nodeColorMap;
	
	public ColoringProblem(int[][] adjacencyMatrix, int numberOfColors) 
	{
		this.adjacencyMatrix = adjacencyMatrix; 
		numberOfVertexes = adjacencyMatrix.length;
		nodeColorMap  = new int[numberOfVertexes];
		Arrays.fill(nodeColorMap, -1);
		this.numberOfColors = numberOfColors;
	}
	
	private boolean isValidColorAssignment(int position, int colorIndex)
	{
		for(int i = 0; i<numberOfVertexes; i++)
		{
			if(adjacencyMatrix[position][i] == 0)
				continue;
			
			if(colorIndex == nodeColorMap[i])
				return false;
		}
		return true;
	}
	
	public void printColorMap()
	{
		int i = 0;
		for(int s : nodeColorMap)
		{
			System.out.print("{" + i + "," + s + "}");
			i++;
		}
		System.out.println();
	}
	public boolean assignColor(int position)
	{
		if(position == numberOfVertexes)
			return true;

		for(int i = 0; i<numberOfColors; i++)
		{
			if(isValidColorAssignment(position, i))
			{
				nodeColorMap[position] = i;
				if(assignColor(position + 1))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
//		int [][] adjacencyMatrix = {{0,1,1,1,0,0}, 
//									{1,0,1,0,1,1}, 
//									{1,1,0,1,0,1}, 
//									{1,0,1,0,0,1},
//									{0,1,0,0,0,1},
//									{0,1,1,1,1,0}};
		int [][] adjacencyMatrix = {{0,1,0,1,0}, 
									{1,0,1,1,0}, 
									{0,1,0,1,0}, 
									{1,1,1,0,1},
									{0,0,0,1,0}};
		int numberOfColors = 3;
		ColoringProblem cp = new ColoringProblem (adjacencyMatrix, numberOfColors);
		if(cp.assignColor(0))
			cp.printColorMap();
		else
			System.out.println("No solution");

	}

}
