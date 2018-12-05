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
		int weightDelta = maxWeight - itemArray[itemNumber].weight;
		int valueOfLastItemWithMaxWeight = solutionTable[itemNumber - 1][maxWeight]; 

		return Math.max(valueOfLastItemWithMaxWeight, 
						itemArray[itemNumber].weight <= maxWeight ?  
						(itemArray[itemNumber].value + (weightDelta < 1 ? 0 : solutionTable[itemNumber-1][weightDelta])) : 0
						);
	}
	
	public void showResult()
	{
		for(int w = maxWeight, n = itemArray.length -1; n>0; n-- )
		{
			if(solutionTable[n][w] > 0 && solutionTable[n][w] != solutionTable[n-1][w] )
			{
				System.out.println("#" + n);
			}
			w = maxWeight - itemArray[n].weight;
		}
	}

	public List<Integer> getItems(int maxWeight)
	{
		List<Integer> list =  new ArrayList<>();
		getItem(itemArray.length - 1, maxWeight, list);
		return list;
	}
	public void getItem(int n, int maxWeight, List<Integer> list)
	{
		if(n == 0 ) return;
		int totalValue = solutionTable[n][maxWeight];
		if(totalValue == 0 ) return;
		int nextWeight = maxWeight - itemArray[n].weight; // 5 - 3 = 2
		if(totalValue > solutionTable[n-1][maxWeight])
		{
			list.add(n);
			getItem(n-1, nextWeight, list);
		}
		else if(totalValue == solutionTable[n-1][maxWeight])
		{
			getItem(n-1, maxWeight, list);
		}
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
		List<Integer> list =  ks.getItems(5);
		list.stream().forEach(System.out::println);
		ks.showResult();
	}

}
