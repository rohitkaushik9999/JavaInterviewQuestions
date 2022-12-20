package com.interview.test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public class RemoveRepeatedCharacter {
    public static void main(String[] s){
        //Remove repeated character - time complexity o(n)
        String str = "aabbccdefatafaz";
        StringBuilder sb = new StringBuilder();
        str.chars().distinct().forEach(x -> sb.append((char)x));
        System.out.println(sb);


        //Remove repeated character - time complexity o(n*n)
        StringBuilder sb1 = new StringBuilder();
        int idx;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            idx = str.indexOf(c, i + 1);
            if (idx == -1) {
                sb1.append(c);
            }
        }
        System.out.println(sb1);

        //Remove repeated character - using set
        char[] chars = str.toCharArray();
        Set<Character> charSet = new LinkedHashSet<>();
        for (char c : chars) {
            charSet.add(c);
        }
        System.out.println("==="+charSet.toString());
        StringBuilder sb2 = new StringBuilder();
        for (Character character : charSet) {
            sb2.append(character);
        }
        System.out.println(sb2);

        Integer[] num = new Integer[]{1,2,3,4,5};

    }
}
