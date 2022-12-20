package com.interview.test;

import java.util.*;
import java.util.stream.Collectors;

public class StringCombination {

	public static void main(String[] s) {
		String str = "rohit";
		char[] c = str.toCharArray();
		Set<String> set = new HashSet<>();
		set.add(str);
		for(int i=0;i<str.length();i++) {
			for(int j=0;j<str.length();j++) {
				char temp = c[i];
				if(c[i] != c[j]) {
					c[i] = c[j];
					c[j] = temp;
				}
				String changed = String.valueOf(c);
				c = str.toCharArray();
				set.add(changed);
			}
		}
		
		System.out.println(set);
		System.out.println("size = "+set.size());
		/*String inputs = "kaabbcccddddkmnn";
		while(checkAdjacent(inputs)){
			System.out.println(getRemainingValues(inputs));
		}*/

	}

	public static String getRemainingValues(String inputs){
		String result = "";
		char[] inputArr = inputs.toCharArray();

		for(int i=0;i<inputArr.length;i++){
			if(i+1 == inputArr.length){
				if(inputArr[i] == '#')
					inputArr[i+1] = '#';
				break;
			}

			if(inputArr[i] == inputArr[i+1] || inputArr[i-1] == '#'){
				inputArr[i] = '#';
			}
		}
		result = String.valueOf(inputArr);
		return result.replaceAll("#","");
	}

	public static boolean checkAdjacent(String inputs){
		char[] inputArr = inputs.toCharArray();
		boolean res = false;
		for(int i=0;i<inputArr.length;i++){
			if(i+1 >= inputArr.length) {
				res = false;
				break;
			}
			if(inputArr[i] == inputArr[i+1]) {
				res = true;
				break;
			}
		}
		return res;
	}

	//aannbbaaaccffggbbbfff
	public static String[] collaseSameCharacter(String[] inputs){
		String[] response = new String[inputs.length];
		List<String> processedList = new ArrayList<>();
		List<String> processingList = new ArrayList<>();
		List<String> actual = Arrays.stream(inputs).map(String::valueOf).collect(Collectors.toList());
		for(String input:actual){

			processingList.add(input);
			processedList.add(input);
		}
		return response;
	}
}
