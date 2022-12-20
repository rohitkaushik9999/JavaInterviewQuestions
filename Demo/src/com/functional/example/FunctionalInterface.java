package com.functional.example;
/*
 * The interface with single abstract method. If we are using @FunctionlInterface annotation and try to add more abstract method then compile
 * will throw error. Runnable is also an example of Functional Interface. There are 4 types of predefine functional interfaces, 
 * Consumer, Supplier, Function and Predicate
 */

//@FunctionalInterface
public interface FunctionalInterface {

	public Integer calculate(int x, int y);
	
	default String show(String s) {
		return "Functional Interface => "+s;
	}
	
	default String showAgain(String s) {
		return "Functional Interface => "+s;
	}
	
	public static void main(String[] s) {
		System.out.println("Main function of FunctionalInterface : "+s.length);
	}
}