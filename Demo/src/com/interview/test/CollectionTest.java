package com.interview.test;

import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionTest {

    static void CollectionTest(int a, int b){
        int c = a+b ;
        System.out.println(c);
    }

    public final static void main(String[] s){

        short in = 6;
        CollectionTest.CollectionTest(in, 8);
         String buy = "bitcoin";
         System.out.println(buy.substring(1,2));
         double p = 2;
         int j = (int)p;
         System.out.println(j);

         double d = 10.0/-0;
         if (d == Double.POSITIVE_INFINITY)
             System.out.println("uuuuu");
         else
             System.out.println("MMMm");
    }


}



interface Foo{
    int x=10;
}
