package com.coolcode.exercise.backtrack;

public class Sudoku {
	
	private int [][] matrix;
	
	private int numberOfBlanks;
	
	Sudoku(int [][] matrix)
	{
		this.matrix = matrix; 
	}
	
	public boolean solve(int startX, int startY)
	{
		return false;
	}
	
	private boolean isNumberExisted(int [] row, int value)
	{
		return binarySearch(0, row.length, row, value);
	}
	
	public static boolean binarySearch(int start, int end, int [] arr, int value)
	{
		if(arr[start] == value) return true;
		if(arr[end] == value) return true;
		if(end - start < 1)
			return arr[start] == value;
		
		int mid = start + (end - start)/2; 
		if( binarySearch(start, mid, arr, value) == true)
			return true;
		
		return binarySearch(mid+1, end, arr, value);
		
	}

	public boolean isFinished()
	{
		return numberOfBlanks == 0;
	}
	
	public void printMatrix()
	{
		for(int i = 0; i< matrix.length; i++)
		{
			for(int j = 0; j<matrix[0].length; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void testBinarySearch()
	{
		int [] arr = { 1, 2, 4, 5, 43, 232, 32, 9 ,32 ,323 , 23};
		for(int i : arr)
		{
		if(Sudoku.binarySearch(0, arr.length-1, arr, i ))
			System.out.println("Found");
		else
			System.out.println("Not Found");
		}
	}

	public static void main(String[] args) 
	{
		testBinarySearch();
	}

}
