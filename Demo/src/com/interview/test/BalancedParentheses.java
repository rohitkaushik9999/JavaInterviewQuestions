package com.interview.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalancedParentheses {

    public static void main(String[] s){
        String input = "[{()}]";
        System.out.print(check(input));
        List list  = new ArrayList<>();
        list.add(5);
        list.add("5");
        System.out.println(list.size());
    }


    public static boolean check(String input){
        char[] inputArr = input.toCharArray();
        Stack stack = new Stack();
        boolean res = true;

        for(int i=0;i<inputArr.length;i++){
            char current = inputArr[i];
            if(current == '[' || current == '{' || current == '('){
                stack.push(current);
            }

            if(stack.isEmpty())
                return false;

            char c;

            switch (current){
                case ']' :
                    c = (char)stack.pop();
                    if(c != '[')
                        return false;
                    break;

                case '}' :
                    c = (char)stack.pop();
                    if(c != '{')
                        return false;
                    break;

                case ')' :
                    c = (char)stack.pop();
                    if(c != '(')
                        return false;
                    break;

            }
        }

        return stack.isEmpty();
    }
}

