package com.java.datastructures;

public class MovingZerosToLast {

	public static void main(String[] args) {
		int[] nums= {0,1,2,0,3,4,0};
		int zc=0;
		int ec=nums.length-1;

		for(int n=0;n<nums.length;n++) {
			if(nums[n]==0) {
				zc++;
			}
		}
		for(int i=0;i<nums.length;i++) {			
			if(nums[i]==0) {
				int counter=i;
				for(int j=i+1;j<nums.length;j++) {
					if(nums[j]==0) {
						
					} else {
						nums[counter]=nums[j];
						counter++;
					}
				}
			}			
		}

		for(int k=nums.length-zc;k<nums.length;k++) {
			nums[k]=0; 
		} 


		for(int l:nums) {
			System.out.println(l);
		}
	}

}
