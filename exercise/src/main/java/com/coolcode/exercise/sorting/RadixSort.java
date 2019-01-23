package com.coolcode.exercise.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort 
{
	public static void main(String[] args) 
	{
		List<Integer> intList = new ArrayList<>();
		intList.add(991);
		intList.add(824);
		intList.add(218);
		intList.add(592);
		intList.add(123);
		intList.add(849);
		intList.add(951);
		intList.add(241);
		intList.add(190);
		intList.add(519);
		int array[] = SortingUtil.toIntArray(intList);
		System.out.println("Unsorted list: " + array.length);
		SortingUtil.printArray(array);

		int iteration = 0;
		iteration = SortingMain.bubleSort(array, array.length);
		System.out.println("Buble sorted list: " + iteration);
		SortingUtil.printArray(array);
		array = SortingUtil.toIntArray(intList);	
		
		System.out.println("Radix sorted list: ");
		radixSort(array);
		SortingUtil.printArray(array);
		array = SortingUtil.toIntArray(intList);
	}
	
	public static void radixSort(int[] input)
	{
		int numberOfDigit = SortingUtil.getNumberOfDigit(input[0]);
		for(int i = 1; i<=numberOfDigit; i++)
		{
			int radix = (int) Math.pow(10, (i-1));
			System.out.println("radix: " + radix);
			countingSortForRadix(input, radix);
		}
		//SortingUtil.printArray(countArray);
	}

	public static int [] getCountArray(int [] input, int place)
	{
		int [] countingArray = new int[10];
		for(int i = 0; i<input.length; i++)
		{
			int countIndex = SortingUtil.getDigit(input[i], place);
			if(countIndex >= 0)
			{
				countingArray[countIndex]++;
			}
		}
		for(int i = 1; i<countingArray.length; i++)
		{
			countingArray[i] += countingArray[i-1];
		}
		return countingArray;
	}

	public static void countingSortForRadix(int[] input, int digit)
	{
		int[] countingArray =  getCountArray(input, digit);
		int [] inputClone = Arrays.copyOf(input, input.length);
		int j = 0;
		for(int i = input.length-1; i>=0; i--)
		{
			int radix = SortingUtil.getDigit(input[i], digit);
			//System.out.println(radix);
			inputClone[--countingArray[radix]] = input[i]; 
		}
		System.arraycopy(inputClone, 0, input, 0, input.length);
	}
}
