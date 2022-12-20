package com.amazon.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DemoTest {
    public static void main(String[] s){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(30,"rohit",20000,"developement"));
        employeeList.add(new Employee(30,"kaushik",20000,"developement"));
        employeeList.add(new Employee(30,"rohit1",20000,"testing"));
        employeeList.add(new Employee(30,"kaushik1",20000,"testing"));
       /* Map<Object, Long> departmentWiseSalary = employeeList.stream().collect(Collectors.groupingBy(
                Employee::getDepartment, Collectors.reducing(0, (ans,i) -> ans+i)
        ));*/

        //System.out.println(departmentWiseSalary);
        List<String> names = new ArrayList<>();
        names.add("rohit");
        names.add("rohit1");
        names.add("rohit2");
        String result = "";
        result = names.stream().collect(Collectors.joining(","));
        System.out.println("==="+result);
        Set<String> uniqueName = employeeList.stream().map(x -> x.getName()).collect(Collectors.toSet());
        System.out.println("=================="+uniqueName);
    }
}

class Employee{
    int age;
    String name;
    int salary;
    String department;
    Employee(int age, String name, int salary, String department){
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getAge(){return age;}
    public String getName(){return name;}
    public int getSalary(){return salary;}
    public String getDepartment(){return department;}
}
//Employee-> name, age, salary, department
