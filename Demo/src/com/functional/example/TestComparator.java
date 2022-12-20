package com.functional.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestComparator {

	public static void main(String[] s) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("rohit","kaushik",29,"e 93, sector 15 noida"));
		persons.add(new Person("Yogesh","mishra",30,"e 93, sector 13 noida"));
		persons.add(new Person("Anuj","gangwar",29,"e 93, sector 12 noida"));
		persons.add(new Person("rohit","sharma",29,"e 93, sector 11 noida"));
		List<String> sorted = persons.stream().map(Person::getFirstName).sorted().collect(Collectors.toList());
		System.out.println("Sort by first name: "+sorted);
		
		Comparator<Person> sortByFirstName = Comparator.comparing(p -> p.getFirstName());
		persons.sort(sortByFirstName);
		System.out.println(persons);
		
		System.out.println("=== sort in reverse order ===");
		persons.sort(sortByFirstName.reversed());
		
		System.out.println("=== sort on multiple field ===");
		Comparator<Person> groupByComparator = Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName).thenComparing(Person::getAge);
		persons.sort(groupByComparator);
		System.out.println(persons);
		
		LocalDate date = LocalDate.now();
		date.minusMonths(778);
		date.plusDays(1);

		String input = "ssshhuubbhhaaam";

		Map<Object, Long> stringCountMap = input.chars().boxed()
				.collect(Collectors.groupingBy(e->e, Collectors.counting()));
		stringCountMap.forEach((k, v) -> {
			System.out.println("Character: " + k + " Value: " + v);
		});

		Integer[] arr = new Integer[]{2, 3, 5, 7};
		Integer sum1 = Stream.of(arr).mapToInt(Integer::intValue).sum();
		Integer sum = Stream.of(arr).collect(Collectors.summingInt(Integer :: intValue));
		System.out.println(sum1 + "--" + sum);
	}
}
