package com.coolcode.exercise.ternary;


import java.util.ArrayList;
import java.util.List;

public class Node 
{
	private String data;
	private int value = 0;
	private boolean containValue = false;
	private boolean isLeaf = false;
	private Node left;
	private Node right;
	private Node next;
	
	public Node(String key, int value)
	{
		data = String.valueOf(key.charAt(0));
		if(key.length() == 1) 
		{
			this.value = value;
			containValue = true;
			return;
		}
		
		String restOfTheKey = key.substring(1, key.length()); 
		next = new Node(restOfTheKey, value);

	}
	
	public int get(String key)
	{
		if(key == null)
			return -1;
		String cstr = String.valueOf(key.charAt(0));
		String newKey = key.length() == 1 ? null : key.substring(1);
		if(newKey == null)
		{
			if(key.equals(data) && containValue)
				return value;
		}
		if(data.equals(cstr))
		{
			if(next == null)
				return -1;
			return next.get(newKey);
		}
		else if(data.compareTo(cstr) < 0)
		{
			if(left == null)
				return -1;
			
			return left.get(key);
		}
		else if(right == null)
		{
			return -1;
		}
		else
			return right.get(key);
	}
	
	boolean isLeaf()
	{
		return next==null&&left==null&&right==null;
	}
	
	public void traverse(String word, List<String> wordList)
	{
		if(containValue)
			wordList.add(word+data + "=" + value);
		if(left != null)
			left.traverse(word, wordList);
		
		if(right != null)
			right.traverse(word, wordList);

		if(next != null)
			next.traverse(word+data, wordList);
		
	}
	
	public void put(String key, int value)
	{
		String cstr = String.valueOf(key.charAt(0));
		String newKey = key.length() == 1 ? null : key.substring(1);
		if(data.compareTo(cstr) == 0)
		{
			if(newKey == null)
			{
				this.value = value;
				return;
			}
			if(next == null)
				next = new Node(newKey, value);
			else
				next.put(newKey, value);
		}
		else if(data.compareTo(cstr) < 0)
		{
			if(left == null)
				left = new Node(key, value);
			else
				left.put(key, value);
		}
		else
		{
			if(right == null)
				right = new Node(key, value);
			else
				right.put(key, value);
		}
	}

	public static int getAlphaPos(char c)
	{
		return c - 'a';
	}
	
	public static void main(String [] args)
	{
		System.out.println(getAlphaPos('a'));
		System.out.println(getAlphaPos('z'));
	}
}
