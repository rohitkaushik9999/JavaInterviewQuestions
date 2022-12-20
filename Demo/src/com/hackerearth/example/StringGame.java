package com.hackerearth.example;

import java.util.ArrayList;
import java.util.List;

public class StringGame {
	
	public static void main(String[] s) {
		System.out.println(StringGame.test("xyz","aaa",3));
	}

	public static String test(String S, String P, int K) {
		String result = "NO";
		
		char[] alphabets = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		List<String> list = new ArrayList<>();
		
		for(char c: alphabets)
			list.add(String.valueOf(c));
		
		char[] cs = S.toCharArray();
		char[] cp = P.toCharArray();
		
		for(int i=0;i<cs.length;i++) {
			result = "NO";
			if(cs[i] != cp[i]) {
				int index = list.indexOf(String.valueOf(cs[i]).toLowerCase());
				for(int j=1;j<=K;j++) {
					index = index + 1;
					
					if(index >= list.size() - 1)
						index = 0;
					
					char temp = list.get(index).toCharArray()[0];
					if(temp == cp[i]) {
						result = "YES";
						System.out.println("matched");
						break;
					}
				}
			}else {
				result = "YES";
			}
			
			if(result.equals("NO"))
				return result;
		}
		
		return result;
	}
}
