package com.interview.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BalanceTheSumOfTwoArrayBySwap {

    public static void main(String[] s){
        int[] input1 = new int[]{3,5,7,-2,4,-4,6}; //19
        int[] input2 = new int[]{15,4,7,-2,0,-4,6}; //26

        int[] A = new int[]{1, 3, 6, 4, 1, 2};
        solution(A);
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int max = Arrays.stream(A).max().getAsInt();
        if(max <= 0 || max == 1)
            return 1;

        List<Integer> list = Arrays.stream(A)        // IntStream
                .boxed()          // Stream<Integer>
                .collect(Collectors.toList());
        for (int i = 1; i < max; i++) {
            if(!list.contains(i)){
                return i;
            }
        }
        return max+1;
    }
}
