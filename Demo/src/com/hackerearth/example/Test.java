package com.hackerearth.example;

public class Test <T>
{
    private T t;

    public T get(){return  t;}
    public void set(T t){
        this.t = t;
    }
    public static void main(String[] s){
        Test test = new Test();
        test.set("%");
        System.out.println(test.get());
    }
}
