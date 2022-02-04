package com.java.datastructures;

import java.util.Arrays;

public class DeletingArrayInDifferentWays {

	public static void main(String[] args) {
		//deletingTheFirstElement();
		//deletingTheLastElement();
		//deletingTheMiddleElement();
		//deletingAllTheOccurenceOfElement();
		//deletingRepeatingElement();
		deletingRepeatingElementsSecondApproach();
		//deletingREWithInplaceApp();
	}

	private static void deletingREWithInplaceApp() {
		int[] a = {0,1,1,2,2,3,3,4,4,5};
		//finding the number of unique elements
		int writePointer=1;
		
		for(int readPointer=1;readPointer<a.length;readPointer++) {
			if(a[readPointer] != a[readPointer-1]) {
				a[writePointer] = a[readPointer];
				writePointer++;
			}
		}
		
		for(int j:a) {
			System.out.println(j);
		}
	}

	private static void deletingRepeatingElementsSecondApproach() {
		int[] a = {0,1,1,2,2,3,3,4,4,5};
		int length = a.length;
		for(int i=length-2;i>=0;i--) {
			if(a[i]==a[i+1]) {
				for(int j=i+1;j<length;j++) {
					a[j-1]=a[j];
				}
				length--;
			}
		}
		
		int[] b = new int[length];
		for(int k=0;k<b.length;k++) {
			b[k]=a[k];
		}
		
		for(int k:b) {
			System.out.println(k);
		}
		
	}

	private static void deletingRepeatingElement() {
		int[] a = {0,0,1,1,1,2,2,3,3,4};
		int dc=0;
		
		for(int k=1;k<a.length-1;k++) {
			if(a[k]==a[k-1]) {
				dc++;
			}
		}
		
		for(int i=1;i<a.length-1;i++) {
			if(a[i]==a[i-1] && a[i]==a[i+1]) {
				
				for(int j=i;j<a.length-2;j++) {
					a[j]=a[j+2];
				}
			}else if(a[i]==a[i-1]) {
				
				for(int j=i;j<a.length-1;j++) {
					a[j]=a[j+1];
				}
			}
		}
		for(int k:a) {
			System.out.println(k);
		}
		int result =a.length-dc;
		System.out.println("value of results is"+result);
		
	}

	private static void deletingAllTheOccurenceOfElement() {
		int[] var1 = {0,1,2,2,3,0,4,2};
		int[] var2 = {0,1,2,3,0,4,5};
		int[] nums = {2,2,2,3,0,4,5};

		int i=0;
		for(int j=0;j<nums.length;j++) {
			if(nums[j]!=2) {
				nums[i]=nums[j];
				i++;
			}
		}
		
		//return i;
	}

	private static void deletingTheMiddleElement() {
		int[] var= {1,2,3,4,5,6};	
		int n=4;
		int counter=0;
		int[] arr1= new int[var.length-1];

		for(int i=0;i<var.length-1;i++) {
			if(var[i]==n) {
				counter++;
			}
			arr1[i]=var[i+counter];			
		}

		System.out.println("After deleting the middle one");

		for(int i:arr1) {
			System.out.println(i);
		}

	}

	private static void deletingTheLastElement() {
		int[] var= {1,2,3,4,5,6};		
		int[] arr1 = new int[var.length-1];
		for(int i=0;i<var.length-1;i++) {
			arr1[i]=var[i];			
		}
		System.out.println("After deleting the last element");
		for(int i:arr1) {			
			System.out.println(i);
		}

	}

	private static void deletingTheFirstElement() {
		int[] arr= {1,2,3,4,5,6};
		int length = arr.length-1;
		int counter=0;
		int[] arr1 = new int[arr.length-1];
		for(int i=arr.length-1;i>0;i--) {
			arr1[counter]=arr[i];
			counter++;
		}
		Arrays.sort(arr1);
		System.out.println("After deleting the first element");
		for(int i:arr1) {			
			System.out.println(i);
		}
	}

}
