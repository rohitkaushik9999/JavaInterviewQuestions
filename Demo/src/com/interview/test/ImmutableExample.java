package com.interview.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class ImmutableExample {
    private final String name;
    private final LocalDate date;

    ImmutableExample(String name, LocalDate date){
        this.name = name;
        this.date = date;
    }

    public String getName(){return this.name;}
    public LocalDate getDate(){return (LocalDate)this.date;}

    public static void main(String[] s){
        List<String> list = new ArrayList<>();
        list.add("name");
        System.out.println(list.contains("rohit"));
        ImmutableExample obj1 = new ImmutableExample("rohit", LocalDate.now());
        System.out.println("name = "+obj1.getName()+"   date="+obj1.getDate());

        obj1.getDate().plusDays(10);
        System.out.println("name = "+obj1.getName()+"   date="+obj1.getDate());
    }
}


