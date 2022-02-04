package com.java.datastructures;

public class RemoveElement {

	public static void main(String[] args) {
		int[] nums= {0,1,2,2,3,0,4,2};
		int val=2;
		int dc=0;
		
		for(int j=0;j<nums.length;j++) {
			if(nums[j]==val) {
				dc++;
			}
		}

		for(int i=0;i<nums.length;i++) {
			if(nums[i]==val) {
				int counter=i;
				for(int j=i;j<nums.length-1;j++) {
					if(nums[j+1]!=val) {
						nums[counter]=nums[j+1];
						counter++;
					}
				}
			}
		}

		for(int k=0;k<nums.length-dc;k++) {
			System.out.println(nums[k]);
		}
	}

}
