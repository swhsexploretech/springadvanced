package com.java.datastructures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HeightChecker  implements Test{
	
	public static void main(String[] args) {
		Set s = new HashSet<>();
		s.add(null);
		s.add(5);
		
		Iterator itr = s.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}		
	}

	@Override
	public void display() {
		System.out.println(Test.a);
		
	}
}
