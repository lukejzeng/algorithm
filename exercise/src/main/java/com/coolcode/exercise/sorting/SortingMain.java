package com.coolcode.exercise.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingMain {
	
	static List<Integer> SORTED_LIST = new ArrayList<>();
	static
	{
		SORTED_LIST.add(1);
		SORTED_LIST.add(2);
		SORTED_LIST.add(3);
		SORTED_LIST.add(4);
		SORTED_LIST.add(5);
		SORTED_LIST.add(6);
		SORTED_LIST.add(7);
	}

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
		intList.add(-8);
		intList.add(-9);
		intList.add(9);
		int array[] = SortingUtil.toIntArray(intList);
		System.out.println("Unsorted list: " + array.length);
		SortingUtil.printArray(array);

		int iteration = 0;
		iteration = bubleSort(array, array.length);
		System.out.println("Buble sorted list: " + iteration);
		SortingUtil.printArray(array);
		array = SortingUtil.toIntArray(intList);

		/*
		iteration = selectionSort(array, array.length);
		System.out.println("Selection sorted list: " + iteration);
		SortingUtil.printArray(array);
		array = SortingUtil.toIntArray(intList);
		*/

		//array = SortingUtil.toIntArray(SORTED_LIST);
		iteration = insertionSort(array, 0);
		System.out.println("Insertion sorted list: " + iteration);
		SortingUtil.printArray(array);
		array = SortingUtil.toIntArray(intList);
/*
		//array = SortingUtil.toIntArray(SORTED_LIST);
		iteration = shellSort(array);
		System.out.println("Shell sorted list: " + iteration);
		SortingUtil.printArray(array);
		array = SortingUtil.toIntArray(intList);

		int[] intArray = mergeSort(array, 0, array.length-1);
		System.out.println("Merge sorted list: " + iteration);
		SortingUtil.printArray(intArray);
		array = SortingUtil.toIntArray(intList);
		*/
	}
	
	public static int shellSort(int[] array)
	{
		int gap = array.length/2;
		int iteration = 0;
		for(int i = gap; i > 0; i /= 2)
		{
			iteration += insertionSort(array, i-1, i);
		}
		return iteration;
	}

	public static int insertionSort(int[] array, int unsortedStartingPos)
	{
		return insertionSort(array, unsortedStartingPos, 1);
	}
	
	public static int insertionSort(int[] array, int unsortedStartingPos, int gap)
	{
		int insertionValue = array[unsortedStartingPos];
		int insertionPos = -1;
		int iteration = 0;
		for(int i = unsortedStartingPos-gap; i >=0; i-=gap)
		{
			if(array[i] > insertionValue )
			{
				array[i+gap] = array[i];
				insertionPos = i;
				iteration++;
			}
		}
		if(insertionPos != -1)
		{
			array[insertionPos] = insertionValue;
		}
		
		SortingUtil.printArray(array);
		if(unsortedStartingPos < array.length-1)
			iteration += insertionSort(array, unsortedStartingPos+1, gap);
		
		return iteration;
	}

	public static int selectionSort(int[] array, int unsortedLength)
	{
		if(unsortedLength < 2) return 0;
		int largestPos = 0;
		int largestValue = array[0];
		int iteration = 0;
		for(int i = 0; i< unsortedLength; i++)
		{
			if(array[i] > largestValue)
			{
				largestValue = array[i];
				largestPos = i;
			}
		}
		SortingUtil.swap(array, largestPos, unsortedLength-1);
		iteration++;
		iteration += selectionSort(array, unsortedLength -1);
		return iteration;
	}

	public static int bubleSort(int[] array, int unsortedLength)
	{
		if(unsortedLength < 2) return 0;
		int iteration = 0;
		for(int i = 0; i< unsortedLength-1; i++)
		{
			if(array[i] > array[i+1])
			{
				SortingUtil.swapWithNext(array, i);
				iteration++;
			}
		}
		
		iteration += bubleSort(array, unsortedLength - 1);
		return iteration;
	}
	
	public static int[] mergeSort(int [] array, int start, int end)
	{
		if(end == start)
		{
			int [] result = {array[start]};
			return result; 
		}
		int mid = start + (end+1 - start)/2;
		int outputLeft [] = mergeSort(array, start, mid-1);
		int outputRight [] = mergeSort(array, mid, end);
		return merge(outputLeft, outputRight);
	}

	public static int [] merge(int [] left, int [] right)
	{
		int [] result = new int[left.length + right.length];
		int leftIndex = 0; 
		int rightIndex = 0;
		int resultIndex = 0;
	
		while(resultIndex < result.length)
		{
			if(leftIndex == left.length)
			{
				result[resultIndex++] = right[rightIndex++];
				continue;
			}
			if(rightIndex == right.length)
			{
				result[resultIndex++] = left[leftIndex++];
				continue;
			}
			if(left[leftIndex] > right[rightIndex])
			{
				result[resultIndex++] = right[rightIndex++];
				continue;
			}
			if(left[leftIndex] < right[rightIndex])
			{
				result[resultIndex++] = left[leftIndex++];
				continue;
			}
			if(left[leftIndex] == right[rightIndex])
			{
				result[resultIndex++] = left[leftIndex++];
				result[resultIndex++] = right[rightIndex++];
				continue;
			}
		}
		return result;
	}
}
