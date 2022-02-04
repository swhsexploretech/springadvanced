package com.java.datastructures;

public class NoOfEvenDigitsInInteger {
	
	
	public static int findMaxIntegerWithEvenDigits(int[] nums) {
		int numsWithEvenDigits=0;
		boolean evenDigitsPresent=false;
		for(int i:nums) {
			System.out.println("value of i is"+i);
			evenDigitsPresent=false;
			while(i>0) {
				int reminder = i%10;
				if(reminder%2==0) {
					evenDigitsPresent=true;
				}
				i=i/10;
			}
			if(evenDigitsPresent) {
				numsWithEvenDigits++;
				System.out.println("numsWithEvenDigits is "+numsWithEvenDigits);
			}
		}
		return numsWithEvenDigits;
	}
	
	
	public static void main(String[] args) {
		int[] arr= {102,123,111,105,151,165};
		int[] arr1= {12,345,2,6,7896};
		//findMaxIntegerWithEvenDigits(arr1);
		findNoofDigitsInInteger(arr);
	}


	private static int findNoofDigitsInInteger(int[] arr1) {
		int evenNumberofDigits=0;
		int oddNumberofDigits=0;
		int digitCounter=0;
		
		for(int i:arr1) {
			digitCounter=0;
			System.out.println("value of i is"+i);
			while(i>0) {
				int reminder = i%10;
				System.out.println("reminder is "+reminder);
				digitCounter++;
				System.out.println("digitCounter is "+digitCounter);
				i=i/10;
				System.out.println("i is "+i);
			}
			if(digitCounter %2==0) {
				evenNumberofDigits++;
			}else {
				oddNumberofDigits++;
			}
		}
		System.out.println("Even number of digits is"+evenNumberofDigits);
		return evenNumberofDigits;
		
	}

}
