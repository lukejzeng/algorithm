package com.coolcode.exercise.dp;

/*
 *   
 */

public class Knapsack 
{
	int maxWeight;
	Item [] itemArray;
	int [][] solutionTable;
	
	public Knapsack(int[][] items, int maxWeight)
	{
		itemArray = new Item[items.length];
		this.maxWeight = maxWeight;
		solutionTable = new int[items.length][maxWeight];
		for(int i = 0; i < items.length; i++)
		{
			itemArray[i] = new Item(items[i][0], items[i][1]);
		}
	}
	
	static public class Item
	{
		public Item(int weight, int value)
		{
			this.weight = weight;
			this.value = value;
		}

		int weight;
		int value;
	}
	
	public void solve(int itemNumber)
	{
		if(itemNumber == itemArray.length) return;
		for(int i = 1; i<maxWeight; i++)
		{
			solutionTable[itemNumber][i] = findSolution(itemNumber, i);
		}
		solve(itemNumber + 1);
	}
	
	// will not start with item zero
	private int findSolution(int itemNumber, int maxWeight)
	{
		int weightDelta = maxWeight - itemArray[itemNumber-1].weight;
		int valueOfLastItemWithMaxWeight = solutionTable[itemNumber - 1][maxWeight]; 

		return Math.max(valueOfLastItemWithMaxWeight, 
						itemArray[itemNumber].value + 
						weightDelta < 1 ? 0 : solutionTable[itemNumber-1][weightDelta]);
	}

	public static void main(String[] args) 
	{
		int [][] items =  
	}

}
