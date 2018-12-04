package com.coolcode.exercise.dp;

public class Fibonacci 
{
	int [] answers = null;

	public int calculate(int number)
	{
		if(number == 0 || number == 1) return number;
		if(answers == null)
			answers = new int[number + 1];
			
		if(answers[number] != 0 )
			return answers[number];
		System.out.println("Calculating: " + number);
		answers[number - 2] = calculate(number - 2);
		answers[number - 1] = calculate(number - 1);
		return answers[number - 2] + answers[number - 1]; 
	}
	public static void main(String[] args) 
	{
		int n = 1000;
		Fibonacci fb = new Fibonacci();
		System.out.println(fb.calculate(n));
	}

}
