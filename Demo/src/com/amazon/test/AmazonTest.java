package com.amazon.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonTest {
    public static void main(String[] s){
        /*System.out.println("hiiii");
        List<Integer> list = Arrays.asList(11, 2, 5, 3, 2, 55, 32, 34);
        list.sort(null);
        System.out.println(list.size()%2);
        list = list.stream().filter(x -> x>10 && x<50).collect(Collectors.toList());
        System.out.println(list);*/

       /* LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("rohit");
        linkedList.add("rohit1");
        linkedList.add("rohit2");
        linkedList.add("rohit3");

        System.out.println(linkedList.size());

        Integer[] input = new Integer[]{1,4,6,8,9,11};
        for(int i=0;i<3;i++){
            input = rotateClockWise(input);
            System.out.println("after rortation: "+Arrays.asList(input));
        }
        System.out.println("index of 8 : "+ findIndex(input, 8));*/

        int n1 = 1;
        long n2 = 45l;
        n1 = (int)n2;
        System.out.println(n1);

        String x = "abc".concat("mm").join(":").concat("123");
        System.out.println(x);
        StringBuilder sb = new StringBuilder("abc0000");
        System.out.println(sb.capacity());
    }

    public static Integer[] rotateClockWise(Integer[] input){
        Integer[] output = new Integer[input.length];
        output[0] = input[input.length - 1];
        for(int i=1; i<output.length; i++){
            output[i] = input[i-1];
        }
        return output;
    }

    public static int findIndex(Integer[] input, int value){
        for(int i=0;i<input.length;i++){
            if(input[i] == value)
                return i;
        }
        return -1;
    }
}
