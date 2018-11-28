package com.coolcode.exercise.backtrack;

import java.util.List;

public class Sudoku {
	
	private int [][] matrix;
	
	private int emptyCellIndex;
	private int rowIndex;
	private int columnIndex;
	
	private List<Pair<Integer>> emptyCells;

	static public class Pair <T>
	{
		Pair(T first, T second)
		{
			this.first = first;
			this.second = second;
		}
		T first;
		T second;
	}

	Sudoku(int [][] matrix)
	{
		this.matrix = matrix; 
		for(int i = 0; i<matrix.length; i++)
			for(int j = 0; j<matrix[0].length; j++)
			{
				if(matrix[i][j] == 0) 
					emptyCells.add(new Pair(new Integer(i), new Integer(j)));
			}
	}
	
	public boolean solve(int nextCellIndex)
	{
		if(isFinished()) return true;
		Pair<Integer> cell = emptyCells.get(nextCellIndex);
		for(int value = 0; value < matrix.length; value++)
		{
			if(isValidValue(cell.first, cell.second, value))
			{
				
			}
		}
		return false;
	}
		
		
	private boolean isValidValue(int first, int second, int value) 
	{
		if(isNumberExistedInColumn(first, second, value)) return false;
		if(isNumberExistedInRow(first, value)) return false;
		if(isNumberExistedInSquare(first, second, value)) return false;
	}

	private boolean isNumberExistedInColumn(int row, int column, int value)
	{
		for(int i=0; i<row; i++)
		{
			if(matrix[i][column] == value)
				return true;
		}
		return false;
	}

	private boolean isNumberExistedInSquare(int row, int column, int value)
	{
		if(row < 3 && column < 3)
			row = column = 3;
		else if(row >= 3 && row < 6 && column)
		for(int i = row; i< row + 3; i++)
		{
			if (binarySearch(column, column + 2, matrix[i], value))
					return true;
		}
		return false;
	}

	private boolean isNumberExistedInRow(int row, int value)
	{
		return binarySearch(0, matrix.length, matrix[row], value);
	}
	
	public static boolean binarySearch(int start, int end, int [] arr, int value)
	{
		if(arr[start] == value || arr[end] == value) return true;
		if(end - start < 1) return arr[start] == value;
		
		int mid = start + (end - start)/2; 
		if( binarySearch(start, mid, arr, value) == true)
			return true;
		
		return binarySearch(mid+1, end, arr, value);
		
	}

	public boolean isFinished()
	{
		return emptyCellIndex == emptyCells.size()-1;
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
				
		int [][] matrix = {{5,3,0,0,7,0,0,0,0}, 
						   {6,0,0,1,9,5,0,0,0}, 
						   {0,9,8,0,0,0,0,6,0}, 
						   {8,0,0,0,6,0,0,0,3},
						   {4,0,0,8,0,3,0,0,1},
						   {7,0,0,0,2,0,0,0,6},
						   {0,6,0,0,0,0,2,8,0},
						   {0,0,0,4,1,9,0,0,5},
						   {0,0,0,0,8,0,0,7,9}};
		Sudoku sdku = new Sudoku(matrix);
		boolean found = sdku.isNumberExistedInSquare(3, 3, 9);
		System.out.println(found ? "found" : "not found");
			
	}

}
