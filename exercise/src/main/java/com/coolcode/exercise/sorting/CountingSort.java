package com.coolcode.exercise.sorting;

import java.util.ArrayList;
import java.util.List;

public class CountingSort 
{
	public static void main(String[] args) 
	{
		List<Integer> intList = new ArrayList<>();
		intList.add(11);
		intList.add(14);
		intList.add(18);
		intList.add(12);
		intList.add(13);
		intList.add(19);
		intList.add(11);
		intList.add(11);
		intList.add(10);
		intList.add(19);
		int array[] = SortingUtil.toIntArray(intList);
		System.out.println("Unsorted list: " + array.length);
		SortingUtil.printArray(array);

		int iteration = 0;
		iteration = SortingMain.bubleSort(array, array.length);
		System.out.println("Buble sorted list: " + iteration);
		SortingUtil.printArray(array);
		array = SortingUtil.toIntArray(intList);	
		
		System.out.println("Counting sorted list: ");
		countingSort(array, 10, 20);
		SortingUtil.printArray(array);
		array = SortingUtil.toIntArray(intList);
	}

	public static void countingSort(int[] input, int min, int max)
	{
		int [] temp = new int[max-min+1];
		for(int i = 0; i<input.length; i++)
		{
			int countIndex = toOffset(input[i], min);
			temp[countIndex]++;
		}
		
		SortingUtil.printArray(temp);
		
		int sortIndex = 0;
		for(int i = 0; i < temp.length; i++)
		{
			for(int j = 0; j<temp[i]; j++)
			{
				input[sortIndex++]=fromOffset(i, min);
			}
		}
	}

	public static int toOffset(int value, int min)
	{
		return (value - min);
	}
	public static int fromOffset(int value, int offset)
	{
		return (value + offset);
	}
}
