package com.coolcode.exercise.tree.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>
{
	private Node<T> left;
	private Node<T> right;
	private T data;
	
	public void setData(T data) {
		this.data = data;
	}

	public Node(T data)
	{
		this.data = data;
	}
	

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	public T getData() { return data; }
	
	public Node<T> getLeft() { return left; };
	public Node<T> getRight() { return right; };
	public void setLeft(Node<T> left) { this.left = left; }
	public void setRight(Node<T> right) { this.right = right; }
	
	public void preOrderTraverse(List<T> flatList)
	{
		flatList.add(getData());
		if(getLeft() != null)
			getLeft().preOrderTraverse(flatList);

		if(getRight() != null)
			getRight().preOrderTraverse(flatList);
		
		return;
	}
	
	public void postOrderTraverse(List<T> flatList)
	{
		if(getLeft() != null)
			getLeft().preOrderTraverse(flatList);

		if(getRight() != null)
			getRight().preOrderTraverse(flatList);
		
		flatList.add(getData());
		return;
	}
	
	public void inOrderTraverse(List<T> flatList)
	{
		if(getLeft() != null)
			getLeft().inOrderTraverse(flatList);

		flatList.add(getData());
		if(getRight() != null)
			getRight().inOrderTraverse(flatList);
		
		return;
	}
	public void insert(T t)
	{
		insert(new Node<T>(t));
	}

	private void insert(Node<T> node)
	{
		if(compareTo(node) > 0)
		{
			if(left == null)
				setLeft(node);
			else
				left.insert(node);
		}
		else
		{
			if(right == null)
				setRight(node);
			else
				right.insert(node);
		}
	}

	public T getMax()
	{
		if(right == null)
			return getData();
		
		return right.getMax();
	}
	
	public T getMin()
	{
		if(left == null)
			return getData();
		
		return left.getMin();
	}
	
	public Node<T> get(T t)
	{
		int comp = t.compareTo(getData());
		
		if(comp == 0) return this;
		
		if(comp < 0)
		{
			if(left == null) return null;
			
			return left.get(t);
		}
		else
		{
			if(right == null) return null;
			return right.get(t);
		}
	}

	@Override
	public int compareTo(Node<T> node) 
	{
		return data.compareTo(node.getData());
	}
	

	public static void main(String [] args)
	{
		List<String> list = new ArrayList<>();
		list.add("l");
		list.add("u");
		list.add("k");
		list.add("e");
		list.add(" ");
		list.add("z");
		list.add("e");
		String key = "l";
		//System.out.println(binarySearch(key, 0, list.size(), list));
	}

}
