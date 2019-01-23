package com.coolcode.exercise.algorithm;

import java.util.Stack;

public class TowerOfHanoi 
{
	public static void build(int n, char from, char using, char to)
	{
		if(n > 0)
		{
			build(n - 1, from, to, using);
			System.out.println(n + " moving from: " + from + " to: " + to);
			build(n - 1, using, from, to);
		}
	}
	public static void testHanoi()
	{
		build(10, 'A', 'B', 'C');
	}

	public static void main(String[] args) 
	{
		testHanoi();
		
	}

}
