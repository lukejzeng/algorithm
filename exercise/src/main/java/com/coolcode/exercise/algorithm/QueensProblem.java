package com.coolcode.exercise.algorithm;

public class QueensProblem 
{
	private int [][] chessBoard;
	private int numberOfQueens;
	
	public QueensProblem(int numberOfQueens)
	{
		chessBoard = new int[numberOfQueens][numberOfQueens];
		this.numberOfQueens = numberOfQueens;
	}

	public void solve()
	{
		
	}
	
	public void printChessBoard()
	{
		for(int i = 0; i<numberOfQueens; i++)
		{
			for(int j = 0; j<numberOfQueens; j++)
			{
				if(chessBoard[i][j] == 1)
					System.out.print(" * ");
				else
					System.out.print(" - ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) 
	{
		QueensProblem qp = new QueensProblem(4);
		qp.printChessBoard();
	}

}
