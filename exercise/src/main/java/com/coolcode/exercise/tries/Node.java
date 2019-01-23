package com.coolcode.exercise.tries;

import java.util.ArrayList;
import java.util.List;

public class Node 
{
	private String data;
	private Node [] children;
	private int value;
	
	private int childrentCount = 0;
	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	public int getChildrentCount() {
		return childrentCount;
	}

	public void setChildrentCount(int childrentCount) {
		this.childrentCount = childrentCount;
	}

	boolean isLeaf = true;
	
	public Node(String data)
	{
		this(26);
		this.data = data;
		this.value = -1;
	}
	
	public Node(String data, int value)
	{
		this(26);
		this.data = data;
		this.value = value;
	}


	public Node(int size)
	{
		children = new Node[size];
	}
	
	public String getLongestCommonPrefix(String prefix)
	{
		prefix += data;
		
		for(Node node : children)
		{
			if(node != null)
			{
				if(childrentCount == 1 && isLeaf == false)
					prefix = node.getLongestCommonPrefix(prefix);
				break;
			}
		}
		
		return prefix;

	}
	
	public void insert(String key, int value)
	{
		if(key.length() == 0) 
			return;
		char c = key.charAt(0);
		int index = getAlphaPos(c);
		if( children[index] == null )
		{
			children[index] = new Node(String.valueOf(c), value);
			childrentCount++;
			isLeaf = false;
		}
		children[index].insert(key.substring(1), value);
	}
	
	@Override
	public String toString() {
		return data;
	}

	public void traverse()
	{
		System.out.print(this + " ");
		for(Node n : children)
		{
			if(n != null)
			{
				n.traverse();
			}
		}
	}
	
	public List<String> getWordsWithPrefixOld(String prefix)
	{
		Node prefixNode = getNode(prefix);
		List<String> wordList = new ArrayList<>();
		if(prefixNode != null) 
			prefixNode.traverse(prefix.substring(0, prefix.length()-1), wordList, new StringBuilder());
		return wordList;
	}

	public List<String> getWordsWithPrefix(String prefix)
	{
		Node prefixNode = getNode(prefix);
		List<String> wordList = new ArrayList<>();
		if(prefixNode == null) return wordList; 
		prefix = prefix.equals("") ? prefix : prefix.substring(0, prefix.length()-1);
		prefixNode.collectWords(prefix, wordList);
		return wordList;
	}

	public void collectWords(String prefix, List<String> wordList)
	{
		String nextPrefix = prefix + data;
		for(Node node : children)
		{
			if(node != null)
				node.collectWords(nextPrefix, wordList);
		}
		
		if(isLeaf == true)
		{
			wordList.add(nextPrefix);
		}
	}

	public void traverse(String prefix, List<String> wordList, StringBuilder word)
	{
		String aggregate = "";
		if(data != null && !data.isEmpty())
		{
			aggregate = word.append(data).toString();
		}
		if(isLeaf) 
		{
			wordList.add(prefix + word.toString());
			return;
		}
		
		for(Node node : children)
		{
			if(node != null)
			{
				node.traverse(prefix, wordList, word);
				word = new StringBuilder(aggregate);
			}
		}
	}
	
	public Node getNode(String prefix)
	{
		if(prefix.length() == 0)
			return this;
		
		Node node = children[getAlphaPos(prefix.charAt(0))];
		if(node == null) return null;
		return node.getNode(prefix.substring(1));
	}
	
	public int search(String key)
	{
		if(key.length() == 0)
			return isLeaf == true ? this.value:-1;
		
		int index = getAlphaPos(key.charAt(0));
		Node node = children[index]; 
		if(node == null)
			return -1;
		else
			return node.search(key.substring(1)); 
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
