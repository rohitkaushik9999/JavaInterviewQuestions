package com.thread.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.functional.example.Person;

public class ProducerConsumerWithBlockingQueue {

	public static void main(String[] s) throws InterruptedException {
		BlockingQueue<Person> blockingQueue = new LinkedBlockingQueue<>(5);
		int size = 5;
		
		Runnable producerThread = () -> {
			try {
				int value = 0;
				while(true) {
					Person person = new Person();
					person.setPerson("rohit"+value, "kaushik"+value, value, "SSE"+value);
					blockingQueue.put(person);
					
					value++;
					Thread.sleep(1000);
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		
		Runnable consumerThread = () -> {
			try {
				
				while(true) {
					Person person = blockingQueue.take();
					
					Thread.sleep(1000);
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		
		Thread producer = new Thread(producerThread);
		producer.start();
		
		Thread consumer = new Thread(consumerThread);
		consumer.start();
		
		producer.join();
		consumer.join();
	}
}
