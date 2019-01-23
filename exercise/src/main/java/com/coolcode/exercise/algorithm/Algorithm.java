package com.coolcode.exercise.algorithm;

public class Algorithm {

	public static int GreatestCommonDivisor(int n1, int n2)
	{
		int n = n1 > n2 ? n2 : n1;
		for(int i = n; i > 0; i--)
		{
			if((n1%i == 0) && (n2%i == 0))
				return i;
		}
		
		return 1;
	}

	public static int GCD(int n1, int n2)
	{
		int temp = 0;
		while(n2 != 0)
		{
			temp = n2;
			n2 = n1%n2;
			n1 = temp;
		}
		
		return n1;
	}
	public static void main(String[] args) 
	{
		//System.out.println(GreatestCommonDivisor(36, 48));
		System.out.println(GCD(36, 48));
	}

}
