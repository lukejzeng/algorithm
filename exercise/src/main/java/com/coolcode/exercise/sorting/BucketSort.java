package com.coolcode.exercise.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BucketSort 
{
	public static void main(String[] args) 
	{
		List<Integer> intList = new ArrayList<>();
		intList.add(91);
		intList.add(24);
		intList.add(18);
		intList.add(92);
		intList.add(23);
		intList.add(49);
		intList.add(51);
		intList.add(41);
		intList.add(90);
		intList.add(19);
		int array[] = SortingUtil.toIntArray(intList);
		System.out.println("Unsorted list: " + array.length);
		SortingUtil.printArray(array);

		int iteration = 0;
		iteration = SortingMain.bubleSort(array, array.length);
		System.out.println("Buble sorted list: " + iteration);
		SortingUtil.printArray(array);
		array = SortingUtil.toIntArray(intList);	
		
		System.out.println("Bucket sorted list: ");
		bucketSort(array);
		SortingUtil.printArray(array);
		array = SortingUtil.toIntArray(intList);
	}
	
	public static void bucketSort(int[] input)
	{
		List<Integer> bucketList[] = new ArrayList[input.length];
		for(int value : input)
		{
			List<Integer> bucket = bucketList[hashCode(value)];
			if(bucket == null)
			{
				bucket = new ArrayList<>();
				bucketList[hashCode(value)] = bucket;
			}
			bucket.add(value); 
		}
		
		int i = 0;
		for(List<Integer> bucket : bucketList)
		{
			if(bucket != null)
			{
				Collections.sort(bucket); 
				for(int j = 0; j<bucket.size(); j++)
				{
					input[i++] = bucket.get(j);
				}
			}
		}
	}
	
	public static int hashCode(int key)
	{
		return key/10;
	}

}
