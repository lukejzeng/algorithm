package com.coolcode.exercise.backtrack;

import javax.print.attribute.standard.NumberOfDocuments;

public class KnightsTour 
{
	private int[][] chessBoard;
	private int [] xMoves = {2, 1, -1, -2, -2, -1, 1, 2}; 
	private int [] yMoves = {1, 2, 2, 1, -1, -2, -2, -1}; 
	
	private int currentX;
	private int currentY;
	private int boardSize;
	private int numberOfMoves;
	
	
	
	KnightsTour(int boardSize)
	{
		chessBoard = new int[boardSize][boardSize];
		xMoves = new int[boardSize];
		yMoves = new int[boardSize];
		this.boardSize = boardSize;
	}


	public boolean solve()
	{
	  for(int x = 0; x < boardSize; x++ )	
	  {
		  for(int y = 0; y < boardSize; y++)
		  {
			  for(int i = 0; i< boardSize; i++)
			  {
				  
			  }
		  }
	  }
	}
		
	private boolean move(int startX, int startY)
	{
		int newX;
		int newY;
		
		if(startX >= boardSize && startY >= boardSize)
			return false;
		
		for(int i: xMoves)
		{
			newX = startX + xMoves[i];
			newY = startY + yMoves[i];
			if(newX < 0 || newY < 0)
				continue;
			if(chessBoard[newX][newY] == 1)
				continue;
			
			chessBoard[newX][newY] = 1;
			numberOfMoves++;
			if(numberOfMoves == boardSize*boardSize-1)
				return true;
			if(move(startY == boardSize ? 0 : startX ))
		}
		
		return true;
	}

	public static void main(String[] args) 
	{

	}

}
