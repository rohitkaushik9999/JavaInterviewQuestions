package com.interview.test;

import java.util.*;

public class ComparatorExample {

    public static void main(String... s){
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        Collections.sort(list,new StringSort());
        System.out.println(list);



        //Iterator<Integer> iterator = list.iterator();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(11);
        queue.add(5);
        queue.add(4);
        queue.add(13);
        queue.add(1);

        System.out.println("before == "+queue);

        //if we try to remove an element from queue while iterating over it, then ConcurrentModificationException will throw
		/*for (Integer integer : queue) {
			queue.remove();
		}*/

        System.out.println("after == "+queue);



        String s1="abc";
        String s2="abcz";
        System.out.println(s1.compareTo(s2));



        //How many times name reapeated
        //you can use looping only one time
        List<String> data = new ArrayList<String>();
        data.add("Rohit");
        data.add("Kaushik");
        data.add("Sharma");
        data.add("Rohit");

        Map<String,Object> result = new HashMap<>();
        for (String name : data) {
            Integer count = (Integer) result.get(name);
            if(count == null)
                count = 1;
            else
                count = count + 1;
            result.put(name, count);
        }
        System.out.println(result);

    }
}


class StringSort implements Comparator<String>{

    public int compare(String s1, String s2){
        return s1.charAt(1) - s2.charAt(1);
    }
}

