package com.java.datastructures;

public class OrganizeEvenAndOdd {
	
	public static void main(String[] args) {
		int[] nums= {3,1,2,4};
		int[] newA = new int[nums.length];
		int oc=0;
		int ec=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]%2==0) {
				newA[ec]=nums[i];
				ec++;
			}else {
				newA[nums.length-1-oc]=nums[i];
				oc++;
			}
		}
		for(int k:newA) {
			System.out.println(k);
		}
	}

}
