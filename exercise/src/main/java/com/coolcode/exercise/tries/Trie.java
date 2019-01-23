package com.coolcode.exercise.tries;

import java.util.List;

public class Trie 
{
	private Node root = new Node("");
	
	public void insert(String key, int value)
	{
		root.insert(key, value);
	}
	
	public int search(String key)
	{
		return root.search(key);
	}

	public String getCommonLongestPrefix()
	{
		if(root.getChildrentCount() == 1)
		{
			for(Node node : root.getChildren())
			{
				if(node != null)
				{
					return node.getLongestCommonPrefix("");
				}
			}
		}
		return "";
	}
	public void traverse()
	{
		root.traverse();
	}
	
	public List<String> autoComplete(String prefix)
	{
		return root.getWordsWithPrefix(prefix);
	}
	
	public static void main(String[] args) 
	{
		Trie trie = new Trie();
		trie.insert("apple", 2);
		//trie.insert("air", 5);
		trie.insert("appa", 8);
		trie.insert("approve", 9);
		trie.insert("appb", 10);
		//trie.insert("adam", 10);
		//trie.insert("adr", 10);
		//trie.insert("adda", 10);
		//trie.insert("adada", 10);
		//trie.insert("adazzz", 10);
		//trie.insert("bdazzz", 10);
		//trie.insert("cqazzz", 10);
		//trie.insert("cdaance", 10);
		//trie.insert("xdazzz", 10);
		//trie.insert("qdazzz", 10);
		//trie.traverse();
		System.out.println();
		
		String data = "c";
		//System.out.println(data + ": " + trie.search(data));
		//System.out.println("Auto complete: " + trie.autoComplete(data));
		System.out.println("Largest common prefix: " + trie.getCommonLongestPrefix());
	}

}
