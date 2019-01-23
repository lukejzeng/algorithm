package com.coolcode.exercise.algorithm;

public class Factorial {
	public static int calculateItr(int n)
	{
		for(int i = n-1; i>0; i--)
		{
			n *= i;
		}
		
		return n;
	}
	public static int calculate(int accumulate, int n)
	{
		if(n == 1)
			return accumulate;
		
		return calculate(accumulate*n, n-1);
	}
	public static int calculate(int n)
	{
		if(n == 1)
			return n;
		
		return n*calculate(n-1);
	}
	
	public static void main(String [] args)
	{
		System.out.println(calculate(1, 5));
	}
}
