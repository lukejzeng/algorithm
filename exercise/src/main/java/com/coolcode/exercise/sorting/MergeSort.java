package com.coolcode.exercise.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort 
{
	public static void main(String[] args) 
	{
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(634);
		intList.add(123);
		intList.add(123);
		intList.add(12);
		intList.add(-1);
		intList.add(0);

		//intList.add(-8);
		//intList.add(-9);
		//intList.add(9);
		int array[] = SortingUtil.toIntArray(intList);
		System.out.println("Unsorted list: " + array.length);
		SortingUtil.printArray(array);

		int iteration = 0;
		iteration = SortingMain.bubleSort(array, array.length);
		System.out.println("Buble sorted list: " + iteration);
		SortingUtil.printArray(array);
		array = SortingUtil.toIntArray(intList);	
		
		mergeSort(array, 0, array.length);
		System.out.println("Merge sorted list: " + iteration);
		SortingUtil.printArray(array);
		array = SortingUtil.toIntArray(intList);
	}

	// 1 634 123 123 12  -1   0  
	// 0,  1,  2,  3, 4,  5,  6  7
	// s           m             e
	public static void mergeSort(int[] input, int start, int end)
	{
		// element of one
		if((end - start) < 2)
		{
			return;
		}
		
		//left partition
		int mid = (start + end)/2;
		mergeSort(input, start, mid);
		//right partition
		mergeSort(input, mid, end);
		merge(input, start, mid, end);
	}
	
	// 1 634 123 123 12  -1   0  
	// 0,  1,  2, 3, 4,  5,  6,  7
	// s             m            e
	public static void merge(int [] input, int start, int mid, int end)
	{
		if(input[mid-1] <= input[mid])
			return;
		
		int i = start;
		int j = mid;
		int t = 0;
		int [] tempArray = new int[end - start];
		while(i < mid && j < end )
		{
			tempArray[t++] = (input[i] <= input[j]) ? input[i++] : input[j++];
		}
		System.arraycopy(input, i, input, start+t, mid-i);
		System.arraycopy(tempArray, 0, input, start, t);
	}
}
