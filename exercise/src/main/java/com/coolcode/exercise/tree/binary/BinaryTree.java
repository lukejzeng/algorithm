package com.coolcode.exercise.tree.binary;

import java.util.ArrayList;
import java.util.List;

import com.coolcode.exercise.sorting.SortingUtil;

public class BinaryTree<T extends Comparable<T>>
{
	private Node<T> root;
	public void insert(T t)
	{
		if(root == null)
			root = new Node<T>(t);
		else
			root.insert(t);
	}
	
	public Node<T> get(T t)
	{
		return root.get(t);
	}
	
	public void delete(T t)
	{
		root = delete(t, root);
	}
	
	private Node<T> delete(T t, Node<T> subTreeRoot)
	{
		if(subTreeRoot == null)
			return subTreeRoot;

		Node<T> left = subTreeRoot.getLeft();
		Node<T> right = subTreeRoot.getRight();
		
		if(subTreeRoot.getData().compareTo(t) > 0)
		{
			if(left != null)
				subTreeRoot.setLeft(delete(t, left));
		}
		else if(subTreeRoot.getData().compareTo(t) < 0)
		{
			if(right != null)
				subTreeRoot.setRight(delete(t, right));
		}
		else 
		{
			if(left == null)
				return right;
			else if(right == null)
				return left;
			else
			{
				subTreeRoot.setData(subTreeRoot.getRight().getMin());
				subTreeRoot.setRight(delete(subTreeRoot.getRight().getMin(), right));
			}
		}

		return subTreeRoot;
	}
		
	public void preOrderTraverse(List<T> flatList)
	{
		root.preOrderTraverse(flatList);
	}
	
	public void postOrderTraverse(List<T> flatList)
	{
		root.postOrderTraverse(flatList);
	}
	
	public void inOrderTraverse(List<T> flatList)
	{
		root.inOrderTraverse(flatList);
	}
	
	public static void main(String[] args) 
	{
		BinaryTree<Integer> bTree = new BinaryTree<>();
		int [] intArray = {25, 20, 15, 27, 30, 29, 26, 22, 32, 17};
		System.out.println("Original array:");
		SortingUtil.printArray(intArray);
		
		for(int value : intArray)
		{
			bTree.insert(value);
			//System.out.print(value + " ");
			//System.out.println();
		}
		
		List<Integer> flatList = new ArrayList<>();
		bTree.preOrderTraverse(flatList);
		System.out.println("Pre-order traversal:");
		flatList.forEach(node->System.out.print(node + " "));
		System.out.println();

		flatList.clear();
		bTree.inOrderTraverse(flatList);
		System.out.println("In-order traversal:");
		flatList.forEach(node->System.out.print(node + " "));
		System.out.println();		
		flatList.clear();

		bTree.postOrderTraverse(flatList);
		System.out.println("Post-order traversal:");
		flatList.forEach(node->System.out.print(node + " "));
		System.out.println();
		flatList.clear();
		
		int v = 25;
		System.out.println("Deleting node: " + v);
		bTree.delete(v);
		bTree.inOrderTraverse(flatList);
		System.out.println("In-order traversal:");
		flatList.forEach(node->System.out.print(node + " "));
	
	}
}
