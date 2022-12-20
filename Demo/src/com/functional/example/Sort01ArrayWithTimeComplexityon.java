package com.functional.example;

public class Sort01ArrayWithTimeComplexityon {

	public static void main(String[] s) {
		int[] res = sortWithTimeComplexity(new int[] {0,0,1,1,1,1,0,1,0,10,1,0,1,1});
		for(int i: res) {
			System.out.println(i+",");
		}
	}
	
	public static int[] sortWithTimeComplexity(int[] input) {
		int j=0;
		for(int i=0;i<input.length;i++) {
			if(input[i] == 0) {
				int temp = input[j];
				input[j] = input[i];
				input[i] = temp; 
				
				j = j + 1;
			}
		}
		
		return input;
	}
}
