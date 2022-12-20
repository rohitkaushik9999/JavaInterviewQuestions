package com.interview.test;

import java.util.*;
class A{
    public int x;
    private static int y = 10;

    private A(){
        System.out.println(y);
    }

}
public class JavaTricks {

    private static void check(String str){
        System.out.println("enter into string");
    }

    private static void check(StringBuffer str){
        System.out.println("enter into StringBuffer");
    }

    public static void main(String... s){

       "hackerearth".chars().distinct().peek(System.out::print);
        //JavaTricks.check(null); Amibigous compile time error

        System.out.println("******************************************************0");
        int[] ar = {6,9,8};
        List<Integer> list = new ArrayList<>();
        list.add(ar[0]);
        list.add(ar[2]);
        list.set(1,ar[1]);
        list.remove(0);
        System.out.println(list);

        Integer a = new Integer(2);
        Integer b = new Integer(2);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a == b); //false

        System.out.println("******************************************************1");

        Integer a1 = 2;
        Integer b1 = new Integer(2);
        System.out.println(a1==b1); //false

        System.out.println("******************************************************2");

        String str1 = "rohit";
        String str = new String("rohit");

        System.out.println(str1==str); //false

        System.out.println("******************************************************3");

        Integer a2 = 127;
        Integer b2 = 127;
        System.out.println(a2==b2); // true

        System.out.println("******************************************************4");

        Integer a3 = 200;
        Integer b3 = 200;
        System.out.println(a3==b3); // false (only less than equal to 127 literal Integers are equal)

        System.out.println("******************************************************5");

        boolean x = true;
        if(x=false){
            System.out.println("Inside if");
        }else if(!x){
            System.out.println("Inside else if");  //
        }

        System.out.println("******************************************************6");

        String s1="hello";
        String s2="hemlo";
        System.out.println(s1.compareTo(s2));  //-1

        System.out.println("******************************************************7");

        byte bb = (byte) 264;
        int xx = 0;
        xx = xx << bb;

        System.out.println("bb = "+bb);
        System.out.println("xx = "+xx);

        System.out.println("******************************************************8");

        Map m = new HashMap();
        m.put("1", "Hello");
        m.put("1", "Hi");
        System.out.println( m );


        Set set = m.keySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

        System.out.println("******************************************************9");


        Hashtable h = new Hashtable();
        //h.put(null, "Hello");
        System.out.println(h); // Hashtable not allowed null value and key

        System.out.println("******************************************************10");


        String ss1 = "hello";
        //System.out.println(ss1.compareTo(new Temp1()));
        // compilation error

        System.out.println("******************************************************10");


        MyThread mythread = new MyThread();
        mythread.start();
        new MyThread(new YourThread()).start();

        System.out.println("******************************************************11");

        Integer[] arr =  new Integer[]{1,2,3,4,5,6,7,8,9};
        int count = 0;
        //Arrays.stream(arr).forEach(n -> count = count + n);
        List<Integer> inputs = Arrays.asList(arr); //asList() returns a fixed size list

        for(Integer input : inputs) {
            System.out.println(input + "---" + inputs.indexOf(input));
            inputs.remove(0); //throw java.lang.UnsupportedOperationException
            inputs.remove(input); //throw java.lang.UnsupportedOperationException
        }

        List<Integer> newList = new ArrayList<>(inputs);
        inputs.remove(0); // it will work

    }
}

interface Temp{
    public static final int a = 10; // No compilation error
}


class Temp1{

}


class MyThread extends Thread{
    public void run(){
        System.out.println("inside MyThread");
    }

    MyThread(){
        super();
    }

    MyThread(Runnable r){
        super(r);
    }
}


class YourThread implements Runnable{
    public void run(){
        System.out.println("inside YourThread");
    }
}
