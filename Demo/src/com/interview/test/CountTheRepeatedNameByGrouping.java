package com.interview.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountTheRepeatedNameByGrouping {
    public static void main(String[] s){

        List<String> g
                = Arrays.asList("geeks", "for", "geeks");

        // Collect the list as map
        // by groupingBy() method
        Map<String, Long> result
                = g.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

        // Print the result
        System.out.println(result);


        List<Person> personList = new ArrayList<>();
        personList.add(new Person(10,"rohit"));
        personList.add(new Person(12,"ROHIT2"));
        personList.add(new Person(10,"ROHIT3"));
        personList.add(new Person(13,"rohit"));

        List<Person> checkedList = personList.stream().filter(p -> p.getName().toLowerCase().equalsIgnoreCase("rohit2") ||
                p.getName().equalsIgnoreCase("rohit3")).collect(Collectors.toList());
        checkedList.forEach(p -> System.out.println("==="+p.name));

        Map<Object, Long> personResult
                = personList.stream().collect(
                Collectors.groupingBy(
                        Person::getName,
                        Collectors.counting()));
        System.out.println(personResult);
        personResult.forEach((k,v) -> {System.out.println(k + " repeated " + v + " times");});
    }
}

class Person{
    int age;
    String name;
    Person(int age, String name){
        this.age = age;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
