package com.coolcode.exercise.select;

import java.util.Arrays;

/**
 * Quick Select 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int [] nums = {2,9,54,6,8,54,43,35,3,2};
    	System.out.println(Arrays.toString(nums));
    	QuickSelect qs = new QuickSelect();
//    	quickSelectTest(nums, true, 1, qs);
//    	quickSelectTest(nums, true, 2, qs);
//    	quickSelectTest(nums, true, 3, qs);
    	quickSelectTest(nums, false, 1, qs);
//    	quickSelectTest(nums, false, 2, qs);
//    	quickSelectTest(nums, false, 3, qs);
    }
    
    public static void quickSelectTest(int [] nums, boolean isLargest, int kth, QuickSelect qs)
    {
    	int kthVal = isLargest ? qs.selectKthLargest(nums, kth) : qs.selectKthSmallest(nums, kth);
    	System.out.println(kth + (isLargest ? " largest ":" smallest ") + " is " + kthVal);
    }
}
