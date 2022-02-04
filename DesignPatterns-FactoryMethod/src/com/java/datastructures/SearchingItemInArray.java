package com.java.datastructures;

public class SearchingItemInArray {
	
	public static void main(String[] args) {
		int [] arr = {-2,0,10,-19,4,6,-8};
		boolean flag=false;
		for(int i:arr) {
			for(int j:arr) {
				if(i==(j*2)) {
					System.out.println("flag value is set to true");
					flag=true;
				}
			}
		}
		System.out.println(flag);
	}
}
