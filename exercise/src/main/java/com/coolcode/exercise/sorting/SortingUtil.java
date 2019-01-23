package com.coolcode.exercise.sorting;

import java.util.List;

public class SortingUtil {

	public static int[] toIntArray(List<Integer> list)
	{
		int [] intArr = new int[list.size()];
		for(int i = 0; i < list.size(); i++)
		{
			intArr[i] = list.get(i);
		}
		return intArr;
	}
	
	public static void swap(int[] array, int i, int j)
	{
		if(i == j) return;
		int temp =  array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void swapWithNext(int[] array, int index)
	{
		int temp =  array[index];
		array[index] = array[index + 1];
		array[index + 1] = temp;
	}
	
	public static<T> void printArray(T [] array)
	{
		for(T i : array)
		{
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}
	
	public static void printArray(int [] array)
	{
		for(int i : array)
		{
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}
	
	public static int getDigit(int value, int places)
	{
		return value < places ? -1 : value/places%10;
	}

	public static int getNumberOfDigit(int value)
	{
		return (int)(Math.log10(value)+1);
	}
}
