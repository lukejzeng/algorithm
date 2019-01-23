package com.coolcode.exercise.ternary;

import java.util.ArrayList;
import java.util.List;


public class Ternary 
{
	private Node root = null;
	
	public void put(String key, int value)
	{
		if(root == null)
			root = new Node(key, value);
		else
			root.put(key, value);
	}
	
	public int get(String key)
	{
		if(key == null | key.isEmpty()) return -1;
		return root.get(key);
	}
	
	public void traverse(List<String> wordList)
	{
		root.traverse("", wordList);
	}
	
	public static void main(String[] args) 
	{
		Ternary ternary = new Ternary();
		ternary.put("cat", 1);
		ternary.put("car", 2);
		ternary.put("carrot", 3);
		ternary.put("cow", 4);
		ternary.put("apple", 5);
		ternary.put("air", 6);
		ternary.put("appa", 7);
		ternary.put("approve", 8);
		ternary.put("appb", 9);
		ternary.put("adam", 10);
		ternary.put("adr", 11);
		ternary.put("adda", 12);
		ternary.put("adada", 13);
		ternary.put("adazzz", 14);
		ternary.put("bdazzz", 15);
		ternary.put("cqazzz", 16);
		ternary.put("cdaance", 17);
		ternary.put("xdazzz", 18);
		ternary.put("qdazzz", 19);
		
		List<String> wordList = new ArrayList<>();
		ternary.traverse(wordList);
		System.out.println(wordList.size());
		System.out.println(wordList);
		
		String data = "pp";
		System.out.println("Getting value for key " + data + " : " + ternary.get(data));
		//System.out.println(data + ": " + ternary.search(data));
		//System.out.println("Auto complete: " + ternary.autoComplete(data));
		//System.out.println("Largest common prefix: " + ternary.getCommonLongestPrefix());
	}

}
