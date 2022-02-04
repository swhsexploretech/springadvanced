package com.design.pattern.factory.method;

public class MainClass {
	
	public static void main(String[] args) {
		Factory factory = new Factory();
		System.out.println(factory.getPerson("Urban"));
	}
}
