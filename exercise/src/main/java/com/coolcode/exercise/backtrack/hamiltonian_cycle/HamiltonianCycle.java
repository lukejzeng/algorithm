package com.coolcode.exercise.backtrack.hamiltonian_cycle;

import java.util.Arrays;

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
		this.hamiltonianPath[0] = 0;
	}
	
	public boolean findPath(int startingNode)
	{
		if(startingNode == numberOfVertexes || startingNode < 0)
			return false;
		int rowIndex = hamiltonianPath[pathIndex] = startingNode;
		for(int i = rowIndex; i<numberOfVertexes; i++)
		{
			for(int j = 0; j<numberOfVertexes; j++)
			{
				if(adjacencyMatrix[rowIndex][j] == 1)
				{
					if(isCompletedPath(j))
						return true;
					if(isValidPath(j))
					{
						hamiltonianPath[++pathIndex] = rowIndex = j;
						printHamiltonPath();
						break;
					}
					else
					{
						rowIndex = hamiltonianPath[--pathIndex];
					}
				}
			}
			return findPath(i-1);
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
				System.out.println("Cycle found - node: " + nextNode + " visited already");
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
									{0,0,1,1,1,1}, 
									{1,1,0,1,0,1}, 
									{1,0,1,0,0,1},
									{0,1,0,0,0,1},
									{0,1,1,1,1,0}};
		HamiltonianCycle hc = new HamiltonianCycle(adjacencyMatrix);
		hc.printAdjacencyMatrix();
		if(hc.findPath(0))
			hc.printHamiltonPath();
		else
			System.out.println("Hamilton path is not found");
	}

}
