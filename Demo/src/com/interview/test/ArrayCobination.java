package com.interview.test;

import java.util.*;

public class ArrayCobination {

	public static void main(String[] s) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8};

		List<String> res = combination(arr);
		
		LinkedList<Integer> list2 = arrangement(new int[] {0,1,2,3,0,4,5,6,0,7,8,9});

		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.remove(2);
		System.out.println(list1);

		ArrayList<Integer> list = new ArrayList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);



		ListIterator<Integer> it = list.listIterator();
		while (it.hasNext()) {
			Integer value = it.next();
			System.out.println("List Value:" + value);
			if (value.equals(3))
				list.remove(value);
		}
	}
	
	//need to get the index of 2 array element whose sum becomes 9
	public static List<String> combination(int[] arr){
		List<String> res = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(i != j) {
					if(arr[i] + arr[j] == 9) {
						res.add(arr[i]+ "---" + arr[j]);
					}
				}
			}
		}
		return res;
	}
	
	//return an array by arrangin all the 0 at the end
	public static LinkedList<Integer> arrangement(int[] arr){
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=arr.length-1;i>=0;i--) {
			if(arr[i] == 0)
				list.addLast(arr[i]);
			else
				list.addFirst(arr[i]);
		}
		
		return list;
	}
}
