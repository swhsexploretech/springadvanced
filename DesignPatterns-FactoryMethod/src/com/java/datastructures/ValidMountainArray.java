package com.java.datastructures;

public class ValidMountainArray {
	public static void main(String[] args) {
		int[] arr= {1,3,2};
		boolean result=validMountainArray(arr);
		System.out.println(result);
	}
	
	public static boolean validMountainArray(int[] arr) {
        int N = arr.length;
        int i=0;
        
        //walk up
        while(i+1<N && arr[i]<arr[i+1]) {
        	i++;
        }
        
        //peak cannot be the first or last position
        if(i==0 || i==N-1) {
        	return false;
        }
        
        //walk down
        while(i+1<N && arr[i]>arr[i+1]) {
        	i++;
        }
        
        return i==N-1;
    }
}
