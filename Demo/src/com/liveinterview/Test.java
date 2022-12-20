package com.liveinterview;

class TestA {
    static {
        System.out.println("Test A");
    }
}

class TestB extends TestA{
    static {
        System.out.println("Test B");
    }
}

public class Test extends TestB{
    static {
        System.out.println("Test C");
    }

    public static void main(String[] s){
        TestB obj = new Test();
    }
}
