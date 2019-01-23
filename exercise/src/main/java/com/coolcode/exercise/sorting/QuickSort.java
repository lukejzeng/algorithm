package com.coolcode.exercise.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort 
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

	public static int partition(int [] input, int start, int end)
	{
		int pivot = input[start];
		int i = start;
		int j = end;
		while(i < j)
		{
			while(input[--j] >= pivot && i < j);
			if(i < j)
			{
				input[i] = input[j];
			}
			while(input[++i] <= pivot && i < j);
			if(i < j)
			{
				input[j] = input[i];
			}
		}
		
		input[j] = pivot;
		return j;
	}
}
