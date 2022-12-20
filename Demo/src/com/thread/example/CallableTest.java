package com.thread.example;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/*
 * By implementing the callable interface, the thread can not start directly by using Thread.start(). We have to use the FutureTask which 
 * implements Future and Runnable interface. If we don't want to use the FutureTask then use ExecutorService to start the thread and pass the 
 * callable object inside that get the result in Future object.
 */
public class CallableTest {

	public static void main(String[] s) throws InterruptedException, ExecutionException {
		FutureTask callableResult = new FutureTask(new CallableThread1());
		Thread callableThread1 = new Thread(callableResult);
		callableThread1.start();
		List<Integer> list = new ArrayList<>();
		HashSet set = new HashSet<>();
		System.out.println("CallableThread1 result => "+callableResult.get());
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<Integer> callableResult2 = service.submit(new CallableThread2());
		System.out.println("CallableThread1 result => "+callableResult2.get());
		

		Callable thread3 = () -> {
			Integer result = list.stream().mapToInt(i -> i.intValue()).sum();
			return result;		
		};
		Future<Integer> callableResult3 = service.submit(thread3);
		System.out.println("CallableThread3 result => "+callableResult3.get());

		Demo d = new Demo();
		d.start();
	}
}

class Demo extends Thread{
	public void run(){
		System.out.println("===");
	}
}

class CallableThread1 implements Callable{

	@Override
	public Object call() throws Exception {
		System.out.println("inside the callableThread1 call method");
		return "Hello world from CallableThread1";
	}
	
}

class CallableThread2 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("inside the callableThread2 call method");
		Random generator = new Random();
		Integer randomNumber = generator.nextInt();
		return randomNumber;
	}
	
}
 