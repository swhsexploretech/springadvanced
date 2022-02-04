package com.java.datastructures;

import java.util.Arrays;

public class SquareAndSortIntegerArray {
	
	public static void main(String[] args) {
		int[] arr = {-4,-1,0,3,10};
		squareAndSortIntegerArray(arr);
	}

	private static int[] squareAndSortIntegerArray(int[] nums) {
		int[] temp = new int[nums.length];
		for(int i=0;i<nums.length;i++) {
			int squareValue = nums[i]*nums[i];
			temp[i]=squareValue;
		}
		//Below is for sorting using the inbuilt sorting methods
		//Arrays.sort(temp);
		
		//Below is for the custom written sorting logic
		for(int i=0;i<temp.length;i++) {
			for(int j=i+1;j<temp.length;j++) {
				int temp1=0;
				if(temp[i]>temp[j]) {
					temp1=temp[i];
					temp[i]=temp[j];
					temp[j]=temp1;
				}
			}
		}
		for(int i : temp) {
			System.out.println(i);
		}
		return temp;
	}

	

}
