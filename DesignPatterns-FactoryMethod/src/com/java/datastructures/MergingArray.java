package com.java.datastructures;

import java.util.Arrays;

public class MergingArray {

	public static void main(String[] args) {
		int[] nums1= {1,2,4,5,6,0};
		int[] nums2 = {3};
		int m=5;
		int n=1;
		int mergeCounter=0;
		int mergestarter =0;
		
		mergestarter = nums1.length-n;
		

		for(int i=mergestarter;i<nums1.length;i++) {
			if(nums2.length>0 && nums1.length >0) {
				nums1[i] = nums2[mergeCounter];
				mergeCounter++;
			}
		}
		
		Arrays.sort(nums1);

		for(int i:nums1) {
			System.out.println(i);
		}
	}

}
