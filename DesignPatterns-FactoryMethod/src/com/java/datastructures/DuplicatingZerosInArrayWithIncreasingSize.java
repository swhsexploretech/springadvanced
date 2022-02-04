package com.java.datastructures;

public class DuplicatingZerosInArrayWithIncreasingSize {

	public static void main(String[] args) {
		int[] arr = {1,0,2,3,0,4,5,0};
		int[] output = null;
		int countIncrementor=0;

		for(int i=0;i<arr.length;i++) {
			if(arr[i] ==0) {
				i=i+countIncrementor;
				output=shiftElementsToRight(arr,i,output);
				countIncrementor++;
				System.out.println("count incrementor is"+countIncrementor);
			}
		}

		for(int i=0;i<output.length-3;i++) {
			System.out.println(output[i]);
		}
	}

	private static int[] shiftElementsToRight(int[] num, int i,int[] output) {
		int[] newNum =null;
		if(output!=null && output.length>num.length){
			newNum = new int[output.length+1];
			num=output;
		}else {
			newNum = new int[num.length+1];
		}
		//System.out.println("length of old array is"+num.length);
		//System.out.println("length of new array is"+newNum.length);
		for(int j=0;j<newNum.length;j++) {
			//System.out.println("value of j is"+j);
			if(j!=i && j==num.length) {
				newNum[j]=num[j-1];
				//System.out.println("Value of newNum "+j+" is"+newNum[j]);
				//System.out.println("Value of Num "+j+" is"+num[j-1]);
			}else if(j!=i && j>i) {
				newNum[j]=num[j-1];
				//System.out.println("Value of newNum "+j+" is"+newNum[j]);
				//System.out.println("Value of Num "+j+" is"+num[j-1]);
			}else if(j!=i) {
				newNum[j]=num[j];
				//System.out.println("Value of newNum "+j+" is"+newNum[j]);
				//System.out.println("Value of Num "+j+" is"+num[j]);
			}else if(i==j) {
				newNum[j]=num[j];
				//System.out.println("Value of newNum "+j+" is"+newNum[j]);
				//System.out.println("Value of Num "+j+" is"+num[j]);
				j++;
			}
		}
		return newNum;

	}

}
