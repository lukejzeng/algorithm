package com.coolcode.exercise.sorting;

import java.util.Arrays;

public class RadixSortForString 
{
	public static void main(String[] args) 
	{
		String[] array = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb" };
		String[] array2 = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb" };
		System.out.println("Unsorted array:");
		SortingUtil.printArray(array);
		System.out.println("Radix sorted array:");
		radixSort(array);
		SortingUtil.printArray(array);
		//Arrays.sort(array2);
		SortingUtil.printArray(array2);
	}
	
	public static void radixSort(String[] input)
	{
		int width = input[0].length();
		for(int i = width-1; i>=0; i--)
		{
			radixSingleSort(input, i);
		}
	}

	public static int [] getCountArray(String [] input, int position)
	{
		int [] countingArray = new int[26];
		for(String value : input)
		{
			int asciiValue = ((int)value.charAt(position)) - ((int)'a');
			countingArray[asciiValue]++;
		}
		for(int i = 1; i<countingArray.length; i++)
		{
			countingArray[i] += countingArray[i-1];
		}
		return countingArray;
	}

	public static void radixSingleSort(String[] input, int position)
	{
		int[] countingArray =  getCountArray(input, position);
		SortingUtil.printArray(countingArray);
		String [] inputClone = new String[input.length];
		int j = 0;
		for(int i = input.length-1; i>=0; i--)
		{
			int asciiValue = (int)input[i].charAt(position) - (int)'a';
			inputClone[--countingArray[asciiValue]] = input[i]; 
		}
		System.arraycopy(inputClone, 0, input, 0, input.length);
		SortingUtil.printArray(input);
	}
}
