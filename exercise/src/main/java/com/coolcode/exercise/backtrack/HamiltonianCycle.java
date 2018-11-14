package com.coolcode.exercise.backtrack;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HamiltonianCycle 
{
	int numberOfVertexes;
	int[] hamiltonianPath;
	int [][] adjacencyMatrix;
	int pathIndex = 0;;
	
	public HamiltonianCycle(int[][] adjacencyMatrix) 
	{
		this.numberOfVertexes = adjacencyMatrix.length;
		this.adjacencyMatrix = adjacencyMatrix;
		this.hamiltonianPath = new int[this.numberOfVertexes];
		Arrays.stream(hamiltonianPath).forEach(item->{item = -1;});
		this.hamiltonianPath = IntStream.generate(()->-1).limit(this.numberOfVertexes).toArray();
	}
	
	public boolean solve(int startingNode)
	{
		if(startingNode == numberOfVertexes || startingNode < 0)
			return false;
		int rowIndex = hamiltonianPath[pathIndex] = startingNode;
		for(int i = rowIndex; i<numberOfVertexes; i++)
		{
			if(findPath(i) == true)
				return true;
			else
			{
				pathIndex = 0;
				Arrays.stream(hamiltonianPath).forEach(item->{item = -1;});
			}
		}
		
		return false;
	}
	
	public boolean findPath(int startingNode)
	{
		if(startingNode > numberOfVertexes -1 || startingNode < 0)
			return false;
		int rowIndex = hamiltonianPath[pathIndex] = startingNode;
		for(int i = 0; i<numberOfVertexes; i++)
		{
			if(adjacencyMatrix[rowIndex][i] == 1)
			{
				if(isCompletedPath(i))
					return true;
				if(isValidPath(i))
				{
					hamiltonianPath[++pathIndex] = i;
					System.out.println("Found valid node: " + i);
					printHamiltonPath();
					if(findPath(i) == true)
						return true;
					else
						hamiltonianPath[pathIndex--] = -1;
				}
				else
				{
					System.out.println("Invalid node: " + i);
					printHamiltonPath();
				}
			}
		}
		return false;
	}

	private boolean isCompletedPath(int nextNode) 
	{
		return (pathIndex == numberOfVertexes - 1 && nextNode == hamiltonianPath[0]);
	}
	
	private boolean isValidPath(int nextNode) 
	{
		if (pathIndex == numberOfVertexes - 1 && nextNode != hamiltonianPath[0])
			return false;

		for(int i = 0; i<pathIndex; i++)
		{
			if(hamiltonianPath[i] == nextNode)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public void printHamiltonPath()
	{
		System.out.println(Arrays.toString(hamiltonianPath));
	}

	public void printAdjacencyMatrix()
	{
		System.out.print(" ");
		for(int i= 0; i<numberOfVertexes; i++)
		{
			System.out.print(" " + i);
		}
		System.out.println();
		for(int i= 0; i<adjacencyMatrix.length; i++)
		{
			System.out.print(i);
			for(int j=0; j<adjacencyMatrix.length; j++)
			{
				System.out.print(" " + adjacencyMatrix[i][j]);
			}
			System.out.println();
		}

	}

	public static void main(String[] args) 
	{ 
		int [][] adjacencyMatrix = {{0,1,1,1,0,0}, 
									{1,0,1,0,1,1}, 
									{1,1,0,1,0,1}, 
									{1,0,1,0,0,1},
									{0,1,0,0,0,1},
									{0,1,1,1,1,0}};
		HamiltonianCycle hc = new HamiltonianCycle(adjacencyMatrix);
		hc.printAdjacencyMatrix();
		if(hc.solve(0))
		{
			System.out.println("Hamilton path is found");
			hc.printHamiltonPath();
		}
		else
			System.out.println("Hamilton path is not found");
	}

}
