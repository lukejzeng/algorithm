package com.coolcode.exercise.backtrack;

public class NQueens 
{
	int [][] chessBoard;
	int numberOfQueens;
	
	int [] queenSet;
	
	
	
	public NQueens(int numbOfQueens)
	{
		chessBoard = new int[numbOfQueens][numbOfQueens];
		numberOfQueens = numbOfQueens;
		queenSet = new int[numberOfQueens];
	}
	
	public void solve()
	{
		if(setQueens(0))
			printChessBoard();
		else
			System.out.println("No solution");
	}
	
	private boolean setQueens(int column)
	{
		if(column == numberOfQueens)
			return true;
		
		for(int i = 0; i<numberOfQueens; i++ )
		{
			if(!checkQueen(column, i))
				continue;
			chessBoard[column][i] = 1;
			queenSet[column] = i;
			if(setQueens(column + 1) == true)
				return true;
			chessBoard[column][i] = 0;
		}
		return false;
	}
	
	private boolean checkQueen(int column, int row)
	{
		if(column == 0) 
			return true;
		for(int i = column - 1; i >= 0; i--)
		{
			int setRow = queenSet[i];
			if(row == setRow) return false;
			if(Math.abs(column - i) == Math.abs(row - setRow))
				return false;
		}
		return true;
	}
	
	public void printChessBoard()
	{
		for(int i = 0; i<numberOfQueens; i++)
		{
			for(int j = 0; j<numberOfQueens; j++)
			{
				System.out.print((chessBoard[i][j] == 0 ? "-" : "*") + " ");
			}
			System.out.println();
		}
	}
}
