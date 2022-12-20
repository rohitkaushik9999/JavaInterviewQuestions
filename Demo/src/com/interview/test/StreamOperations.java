package com.interview.test;

import java.util.Arrays;

public class StreamOperations {
    public static void main(String[] s){
        //sum on array
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        int sum = Arrays.stream(arr).reduce(0,(ans,i)->ans+i);
        System.out.println("sum of the array: "+sum);


    }
}
