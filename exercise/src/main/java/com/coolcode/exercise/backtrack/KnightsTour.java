package com.coolcode.exercise.backtrack;

import javax.print.attribute.standard.NumberOfDocuments;

public class KnightsTour 
{
	private int[][] chessBoard;
	private int [] xMoves = {2, 1, -1, -2, -2, -1,  1,  2}; 
	private int [] yMoves = {1, 2,  2,  1, -1, -2, -2, -1}; 
	
	private int currentX;
	private int currentY;
	private int boardSize;
	private int numberOfMoves = 1;
	
	
	
	KnightsTour(int boardSize)
	{
		chessBoard = new int[boardSize][boardSize];
		this.boardSize = boardSize;
	}

	public boolean solve(int startX, int startY)
	{
		chessBoard[startX][startY] = numberOfMoves;
		return move(startX, startY);
	}

	public boolean solve()
	{
	  for(int x = 0; x < boardSize-2; x++ )	
	  {
		  for(int y = 0; y < boardSize-2; y++)
		  {
			  chessBoard[x][y] = numberOfMoves;
			  if(move(x, y) == true)
				  return true;
			  else
			  {
				  numberOfMoves = 1;
				  chessBoard[x][y] = 0;
			  }
				  
		  }
	  }
	  return false;
	}
		
	public void printBoard()
	{
	  for(int x = 0; x < boardSize; x++ )	
	  {
		  for(int y = 0; y < boardSize; y++)
		  {
			  System.out.print(String.format("%02d ", chessBoard[x][y]));
		  }
		  System.out.println();
	  }
	}

	public boolean move(int startX, int startY)
	{
		int newX;
		int newY;
		
		if(startX >= boardSize && startY >= boardSize)
			return false;
		
		System.out.println("startX=" + startX + ", startY=" + startY);
		for(int i = 0;  i<xMoves.length; i++)
		{
			newX = startX + xMoves[i];
			newY = startY + yMoves[i];
			if(newX < 0 || newY < 0 || newX >= boardSize || newY >= boardSize)
				continue;
			if(chessBoard[newX][newY] != 0)
				continue;
			
			System.out.println("newX=" + newX + ", newY=" + newY);
			numberOfMoves++;
			System.out.println("Number of moves: " + numberOfMoves);
			chessBoard[newX][newY] = numberOfMoves;
			if(numberOfMoves == boardSize*boardSize)
				return true;
			
			printBoard();
			if(move(newX, newY) == true)
				return true;
			else
			{
				chessBoard[newX][newY] = 0;
				numberOfMoves--;
			}
				
		}
		
		return false;
	}

	public static void main(String[] args) 
	{
		KnightsTour kt = new KnightsTour(5);
		if(kt.solve(1, 1))
		{
			System.out.println("Solution: ");
			kt.printBoard();
		}
		else
			System.out.println("No solution");
	}

}
