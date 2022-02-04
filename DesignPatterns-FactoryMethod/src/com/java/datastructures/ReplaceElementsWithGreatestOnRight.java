package com.java.datastructures;

public class ReplaceElementsWithGreatestOnRight {
	
	public static void main(String[] args) {
		
		int[] b = {17,18,5,4,6,1};
		int[] a = {400};
		
		for(int i=0;i<a.length-1;i++) {
			int temp=a[i+1];
			for(int j=i+1;j<a.length;j++) {
				if(a[j]>temp) {
					temp=a[j];
				}
			}
			a[i]=temp;
		}
		a[a.length-1]=-1;
		
		for(int k:a) {
			System.out.println(k);
		}
	}

}
