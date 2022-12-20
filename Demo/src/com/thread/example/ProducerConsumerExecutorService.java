package com.thread.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import com.custome.example.Singleton;

public class ProducerConsumerExecutorService {

	public static void main(String[] s) {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(4);
		ExecutorService executor = Executors.newFixedThreadPool(4);
		
		Runnable producer = () -> {
			try {
				int value = 0;
				while(true) {
					synchronized(queue) {
						if(queue.size() >= 4)
							queue.wait();
						
						queue.put(value);
						System.out.println("produced => "+value+" ==== queue size = "+queue.size());
						value++;
						queue.notify();
						Thread.sleep(1000);
					}
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Runnable consumer = () -> {
			try {
				while(true) {
					synchronized(queue) {
						if(queue.size() == 0)
							queue.wait();
						
						int value = queue.take();
						System.out.println("consumed => "+value+" ==== queue size = "+queue.size());
						queue.notify();
						Thread.sleep(1000);
					}
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		
		Runnable thread1 = () -> {
			try {
				Singleton s1 = Singleton.getInstance();
				while(true) {
					System.out.println("Current singleton count for thread1 === "+s1.getCount());
					s1.setCount(s1.getCount() + 1);
					Thread.sleep(2000);
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Runnable thread2 = () -> {
			try {
				Singleton s1 = Singleton.getInstance();
				while(true) {
					System.out.println("Current singleton count for thread2 === "+s1.getCount());
					s1.setCount(s1.getCount() + 1);
					Thread.sleep(2000);
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		executor.execute(producer);
		executor.execute(consumer);
		executor.execute(thread1);
		executor.execute(thread2);
		
		executor.shutdown();
	}
}
