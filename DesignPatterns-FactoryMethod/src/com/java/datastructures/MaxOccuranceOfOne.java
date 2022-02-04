package com.java.datastructures;

public class MaxOccuranceOfOne {
	
	public static void main(String[] args) {
		int[] nums= {1,1,1,1,1,1,1};
		findMaxConsecutiveOnes(nums);
	}
	
	public static int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
        int current = 0;
        System.out.println(nums.length / 2);
        System.out.println("current is "+current);
        for (int i : nums) { 
        	System.out.println("current element of array is "+i);
            if (i == 1) {
                current++;
                System.out.println(current);
            } else {
                if (current > max) {
                    max = current;
                    System.out.println("max is"+max);
                }
                
                if (max >= nums.length / 2) {
                	System.out.println("maz is"+max);
                    return max;
                }
                current = 0;
            }
        }
        System.out.println(Math.max(max, current));
        return Math.max(max, current);
        
    }

}
