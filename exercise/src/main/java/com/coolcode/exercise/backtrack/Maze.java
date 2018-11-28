package com.coolcode.exercise.backtrack;

public class Maze 
{
	private int [][] maze;
	
	private int [] xMoves = {1, 0, -1, 	0};
	private int [] yMoves = {0, 1,  0, -1};

	Maze(int [][] maze)
	{
		this.maze = maze;
		maze[0][0] = 2;
	}
	
	public boolean move(int startX, int startY)
	{
		for(int i = 0; i<xMoves.length; i++)
		{
			int newX = startX + xMoves[i];
			int newY = startY + yMoves[i];
			printMaze();
			if(isValidMove(newX, newY))
			{
				if(maze[newX][newY] == 8) 
					return true;
				maze[newX][newY] = 2;
				if(move(newX, newY) == true)
					return true;
				maze[newX][newY] = 0;
			}
		}
		return false;
	}
	
	public void printMaze()
	{
		for(int i = 0; i<maze.length; i++)
		{
			for(int j=0; j<maze[0].length; j++)
			{
				String value = (maze[i][j]==0 ? "0" :(maze[i][j] == 1 ? "-" : "*" )) + " ";
				System.out.print(value);
			}
			System.out.println();
		}
		System.out.println();
	}

	public boolean isValidMove(int nextX, int nextY)
	{
		if(nextX < 0 || nextY  < 0 || nextX >= maze.length || nextY >= maze[0].length )
			return false;
		if(maze[nextX][nextY] != 0 && maze[nextX][nextY] != 8 ) 
			return false;
		
		return true;
	}

	public static void main(String[] args) 
	{
		int [][] maze = {{0,0,0,0,0}, 
						 {1,1,1,0,1}, 
						 {0,0,1,0,0}, 
						 {0,0,1,1,0},
						 {0,0,0,0,0},
						 {1,8,0,0,1}};
		
		Maze m = new Maze(maze);
		m.printMaze();
		System.out.println("Solving...");
		if(m.move(0, 0) == true)
			m.printMaze();
		else
			System.out.println("No solution");
		
	}
}
