package com.coolcode.exercise.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		itemArray = new Item[items.length+1];
		this.maxWeight = maxWeight;
		solutionTable = new int[items.length+1][maxWeight+1];
		itemArray[0] = new Item(0, 0);
		for(int i = 0; i < items.length; i++)
		{
			itemArray[i+1] = new Item(items[i][0], items[i][1]);
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
	
	public void printSolution()
	{
		for(int i = 0; i < solutionTable.length; i++)
		{
			for(int j = 0; j < maxWeight + 1; j++)
			{
				System.out.print(" " + solutionTable[i][j]);
			}
			
			System.out.println();
		}
	}

	public void solve(int itemNumber)
	{
		if(itemNumber == itemArray.length) return;
		for(int i = 1; i<maxWeight+1; i++)
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
						itemArray[itemNumber].weight <= maxWeight ?  
						(itemArray[itemNumber].value + (weightDelta < 1 ? 0 : solutionTable[itemNumber-1][weightDelta])) : 0
						);
	}
	
	public List<Item> getItems(int maxWeight)
	{
		List<Knapsack.Item> items = new ArrayList<>();
		
		int totalValue = solutionTable[solutionTable.length-1][maxWeight];
		while()
		return items;
	}

	public static void main(String[] args) 
	{
		int [][] items = {{4, 10}, {2,4}, {3,7}};  
		for(int [] item : items)
			System.out.print(Arrays.toString(item));
		System.out.println();
		int maxWeight = 5;
		Knapsack ks = new Knapsack(items, maxWeight);
		ks.solve(1);
		ks.printSolution();
	}

}
