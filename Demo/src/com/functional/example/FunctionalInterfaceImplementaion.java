package com.functional.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

//if you implement the functional interface then we need to give the body of abstract method.
public class FunctionalInterfaceImplementaion {

	public static void main(String[] s) {
		FunctionalInterface add = (x,y) -> {return x+y;};
		FunctionalInterface sub = (x,y) -> {return x-y;};
		
		System.out.println(add.calculate(10,5));
		System.out.println(add.calculate(10,5));
		
		String str = " ";
		//System.out.println(str.isEmpty() +"--- "+str.isBlank());
	}
}

class ConsumerBiConsumerTest {
	public static void main(String[] args) {
		Consumer<String> c = (x) -> System.out.println(x.toLowerCase());  // lambda expression
		c.accept("Raja");

		Consumer<Integer> con = (x) -> {  // lambda expression
			System.out.println(x + 10);
			System.out.println(x - 10);
		};
		con.accept(10);

		BiConsumer<String, String> bc = (x, y) -> { System.out.println(x + y);};
		bc.accept("1", "2");

		List<Person1> plist = Arrays.asList(new Person1("RAJA"), new Person1("ADITHYA"));
		acceptAllEmployee(plist, p -> System.out.println(p.name));
		acceptAllEmployee(plist, p -> {p.name = "unknown";});
		acceptAllEmployee(plist, p -> System.out.println(p.name));
	}
	public static void acceptAllEmployee(List<Person1> plist, Consumer<Person1> con) {
		for(Person1 p : plist) {
			con.accept(p);
		}
	}
}

// Person class
class Person1 {
	public String name;
	public Person1(String name) {
		this.name = name;
	}
}

class JavaBiPredicate1 {

	public static void main(String[] args) {

		BiPredicate<String, Integer> filter = (x, y) -> {
			return x.length() == y;
		};

		boolean result = filter.test("mkyong", 6);
		System.out.println(result);  // true

		boolean result2 = filter.test("java", 10);
		System.out.println(result2); // false
	}

}

class Java8BiFunction2a {

	public static void main(String[] args) {

		// Math.pow(a1, a2) returns Double
		BiFunction<Integer, Integer, Double> func1 = (a1, a2) -> Math.pow(a1, a2);

		// takes Double, returns String
		Function<Double, String> func2 = (input) -> "Result : " + String.valueOf(input);

		String result = func1.andThen(func2).apply(2, 4);

		System.out.println(result);

	}

}
