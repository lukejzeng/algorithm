package com.coolcode.exercise.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort2 
{
	public static void main(String[] args) 
	{
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(634);
		intList.add(-123);
		intList.add(123);
		intList.add(12);
		intList.add(-1);
		intList.add(0);

		intList.add(-8);
		intList.add(-9);
		intList.add(9);
		int array[] = SortingUtil.toIntArray(intList);
		System.out.println("Unsorted list: " + array.length);
		SortingUtil.printArray(array);

		int iteration = 0;
		iteration = SortingMain.bubleSort(array, array.length);
		System.out.println("Buble sorted list: " + iteration);
		SortingUtil.printArray(array);
		array = SortingUtil.toIntArray(intList);	
		
		quickSort(array, 0, array.length);
		System.out.println("Quick sorted list: " + iteration);
		SortingUtil.printArray(array);
		array = SortingUtil.toIntArray(intList);
	}

	// 1 634 123 123 12  -1   0  
	// 0,  1,  2,  3, 4,  5,  6  7
	// s           m             e
	public static void quickSort(int[] input, int start, int end)
	{
		if(end - start < 2)
			return;
		
		int pivotPos = partition(input, start, end);
		quickSort(input, start, pivotPos);
		quickSort(input, pivotPos+1, end);
	}

	// 20 35 -15 7 55 1 -22
	// s= 0, e = 7
	// 
	public static int partition(int [] input, int start, int end)
	{
		int i = start;
		int j = end;
		int pivotPos = i;
		int pivot = input[pivotPos];
		
		while(i < j)
		{
			while(input[--j] > pivot && i < j);
			if(i<j) 
			{
				input[pivotPos] = input[j];
				pivotPos = j;
			}
			else
			{
				input[pivotPos] = pivot;
				break;
			}
				
			while(input[++i] < pivot && i < j);
			if(i<j) 
			{
				input[pivotPos] = input[i];
				pivotPos = i;
			}
			else
			{
				input[pivotPos] = pivot;
				break;
			}

		}
		return pivotPos;
	}
}
