package com.coolcode.exercise.select;

import java.util.Arrays;
import java.util.Random;

import com.coolcode.exercise.common.util;

public class QuickSelect 
{
	private int [] nums;
	private boolean isLargest = true;
	private int kth;
	
	public int selectKthLargest(int [] nums, int kth)
	{
		this.nums = nums;
		this.kth = kth-1;
		isLargest = true;
		return nums[select(0, nums.length)];
	}

	public int selectKthSmallest(int [] nums, int kth)
	{
		this.nums = nums;
		this.kth = kth-1;
		isLargest = false;
		return nums[select(0, nums.length)];
	}

	private int select(int start, int end)
	{
		if(start == end)
			return start;

		int pivotIndex = partition(start, end);
		System.out.println(pivotIndex);
    	System.out.println(Arrays.toString(nums));
		if(pivotIndex == kth)
			return pivotIndex;
		if(kth > pivotIndex)
		{
//			pivotIndex = isLargest ? select(pivotIndex+1, end): select(start, pivotIndex); 
			pivotIndex = select(pivotIndex+1, end);
		}
		else
		{
			//pivotIndex = isLargest ? select(start, pivotIndex): select(pivotIndex+1, end);
			pivotIndex = select(start, pivotIndex);
		}
			
		return pivotIndex;
	}
		
	private int partition(int start, int end)
	{
		Random rand = new Random();
		int pivot = start + rand.nextInt(end - start);		
		int pivotVal = nums[pivot];
		util.swap(nums, pivot, start);

		int i,j = 0;
		for(i=start, j=end-1; i<j; )
		{
			while(i < j)
			{
				if (isLargest) 
				{
					if (nums[j] > pivotVal) 
					{
						nums[i++] = nums[j];
						break;
					}
					else
						j--;
				} 
				else 
				{
					if (nums[j] < pivotVal) 
					{
						nums[i++] = nums[i];
						break;
					}
					else 
						j--;
				}
			}
			
			while(i < j)
			{
				if(isLargest)
				{
					if(nums[i] < pivotVal)
					{
						nums[j--] = nums[i];
						break;
					}
					else
						i++;
				}
				else
				{
					if(nums[i] > pivotVal)
					{
						nums[j--] = nums[i];
						break;
					}
					else
						i++;
				}
			}
		}
		nums[i] = pivotVal;
		return i;
	}
}
