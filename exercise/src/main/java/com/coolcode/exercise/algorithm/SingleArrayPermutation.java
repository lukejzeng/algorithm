package com.coolcode.exercise.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.coolcode.exercise.common.util;

public class SingleArrayPermutation {

	public static void main(String[] args) 
	{
		int [] input = {1,2,3,4};
		List<int[]> result = new ArrayList<>();
		permutate(input, 0, result);
		System.out.println(result.size());
		result.forEach(a->System.out.println(Arrays.toString(a)));
	}

	
	public static void permutate(int [] input, int start, List<int[]> output)
	{
		if(start >= input.length)
		{
			output.add(input.clone());
			return;
		}
		for(int i = start; i<input.length; i++)
		{
			util.swap(input, start, i);
			permutate(input, start+1, output);
			util.swap(input, i, start);
		}
		

	}
}
