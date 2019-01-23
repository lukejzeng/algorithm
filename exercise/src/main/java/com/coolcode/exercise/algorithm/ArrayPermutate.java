package com.coolcode.exercise.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.coolcode.exercise.common.util;

public class ArrayPermutate {
	public static void permutate(int[] input, int start, List<int[]> output) 
	{
		if(start >= input.length)
		{
			output.add(input.clone());
			return;
		}
		
		for(int i = start; i < input.length; i++)
		{
			util.swap(input, start, i);
			permutate(input, start+1, output);
			util.swap(input, i, start);
		}
	}
	
	public static void shuffle(int [] input)
	{
		for(int i = input.length-1; i>= 0; i--)
		{
			util.swap(input, i, (int)(Math.random()*i));
			System.out.println(Arrays.toString(input));
		}
	}

	public static void main(String[] args) 
	{
		testPermutate();
	}

	public static void testPermutate()
	{
		int[] arr = { 1, 2, 3, 4, 5 };
		List<int[]> output = new ArrayList<int[]>();
		permutate(arr, 0, output);
		output.forEach(array -> System.out.println(Arrays.toString(array)));
		System.out.println(output.size());
	}
}
