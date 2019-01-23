package com.coolcode.exercise.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BogoSort {

	public static void main(String[] args) {
		int [] input = {1, 2,3,4};
		List<int[]> output = new ArrayList<>();
		permutate(input, 0, output);
		
		output.forEach(arr -> System.out.println(Arrays.toString(arr)));
	}

	public static boolean isSorted(int [] nums)
	{
		for(int i = 0; i< nums.length -1 ; i++)
		{
			if(nums[i] > nums[i+1])
				return false;
		}
		
		return true;
	}
	
	public static void permutate(int [] nums, int start, List<int []> output)
	{
		if(start >= nums.length)
		{
			output.add(nums.clone());
			return;
		}
		
		for(int i = start; i< nums.length; i++)
		{
			swap(nums, start, i);
			permutate(nums, start + 1, output);
			swap(nums, i, start);
		}
	}
	
	public static void swap (int[] nums, int pos1, int pos2)
	{
		int temp = nums[pos1];
		nums[pos1] = nums[pos2];
		nums[pos2] = temp;
	}
	
	
	public static void sort(int [] nums)
	{
		for(int i = 0; i< nums.length; i++)
		{
			
		}
	}
}
