package com.coolcode.exercise.tree;

import java.util.Arrays;

import com.coolcode.exercise.sorting.SortingUtil;

public class Heap {

	private int [] heap;
	private int size = 0;
	
	public Heap(int capacity)
	{
		heap = new int[capacity];
	}
	
	private void resize()
	{
		int [] tempHeap = new int[2*heap.length];
		System.arraycopy(heap, 0, tempHeap, 0, heap.length);
		heap = tempHeap;
	}
	
	public boolean isFull()
	{
		return size == heap.length;
	}
	
	private boolean isEmpty()
	{
		return size == 0;
	}
	
	public void sort()
	{
		sort(size);
	}
	
	private void sort(int lastHeapIndex)
	{
		if(lastHeapIndex < 1 ) return;
		swap(0, --lastHeapIndex);
		heapifyDown(0, lastHeapIndex);
		sort(lastHeapIndex);
	}

	public int peek()
	{
		if(isEmpty())
		{
			throw new IndexOutOfBoundsException("Heap is empty");
		}
		return heap[0];
	}

	public int search(int value)
	{
		return search(value, 0);
	}
	private int search(int value, int start)
	{
		int foundIndex = -1;
		if(start >= size) return foundIndex;
		
		if(heap[start] == value)
			return start;
		
		foundIndex = search(value, getRightChild(start));
		if(foundIndex == -1)
		{
			foundIndex = search(value, getLeftChild(start));
		}
		return foundIndex;
	}
	public void delete(int value)
	{
		int deletePos = search(value);
		int rightMostChild = size-1;
		if(deletePos == -1) return;
		swap(deletePos, rightMostChild);
		heap[rightMostChild] = 0;
		size--;
		if(rightMostChild == deletePos)
			return;
		
		if(heap[deletePos] > heap[getParent(deletePos)])
			heapifyUp(deletePos);
		else if(isLeaf(deletePos))
			return;
		else
			heapifyDown(deletePos, size);
	}
	
	private boolean isLeaf(int index)
	{
		return getRightChild(index) >= size && getLeftChild(index) >= size;
	}

	private boolean is(int index)
	{
		return getRightChild(index) >= size && getLeftChild(index) >= size;
	}
	
	public void insert(int value)
	{
		if(isFull())
		{
			resize();
		}
		heap[size] = value;
//		heapifyUp(size);
		heapify(size);
		size++;
	}
	
	private void heapify(int index)
	{
		if(index == 0)
			return;
		
		if(heap[index] > heap[getParent(index)])
		{
			swap(index, getParent(index));
			heapify(getParent(index));
		}
	}
	
	private void heapifyDown(int index, int lastHeapIndex)
	{
		if(index >= lastHeapIndex)
			return;
		
		int rightChild = getRightChild(index);
		int leftChild = getLeftChild(index);

		if( rightChild >= lastHeapIndex && leftChild >= lastHeapIndex) 
		{
			return;
		}
		int swapIndex = 0;
		if( rightChild >= lastHeapIndex || leftChild >= lastHeapIndex) 
		{
			swapIndex = rightChild >= lastHeapIndex ? leftChild : rightChild;
		}
		else if( heap[rightChild] <= heap[index] && heap[leftChild] <= heap[index]) 
			return; 
		else
		{
			swapIndex =  heap[rightChild] > heap[leftChild] ? rightChild : leftChild;
		}
		if(heap[swapIndex] == heap[index]) return;
		swap(index, swapIndex);
		heapifyDown(swapIndex, lastHeapIndex);
	}

	private void heapifyUp(int index)
	{
		int newValue = heap[index];
		int i = index;
		while(newValue > heap[getParent(i)] && i >0)
		{
			heap[i] = heap[getParent(i)];
			i = getParent(i);
		}
		heap[i] = newValue;
	}
	
	private void swap(int i, int j)
	{
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public int getLeftChild(int i)
	{
		return (2*i+1);
	}
	
	public int getRightChild(int i)
	{
		return (2*i+2);
	}
	
	public int getParent(int i)
	{
		return (i-1)/2;
	}

	
	@Override
	public String toString() {
		return "Heap [heap=" + Arrays.toString(heap) + ", size=" + size + "]";
	}

	public static void main(String[] args) 
	{
		int [] intArray = {25, 20, 15, 27, 30, 29, 26, 22, 32, 17};
		//int [] intArray = {80, 75, 60, 68, 55, 40, 52, 67};
		System.out.println("Original array:");
		SortingUtil.printArray(intArray);
		
		Heap heap = new Heap(5);
		for(int v : intArray)
		{
			heap.insert(v);
		}
		System.out.println(heap);
		//int value = 80;
		//System.out.println("Deleting: " + value );
		//heap.delete(value);
		heap.sort();
		System.out.println(heap);
	}

}
