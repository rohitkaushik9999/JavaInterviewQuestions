package com.thread.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest implements Runnable{

	public static CyclicBarrier barrier = new CyclicBarrier(3);

	@Override
	public void run() {
		System.out.println("Number of parties required to trip the barrier "+barrier.getParties());
		System.out.println("Sum of the product and sum = "+ (Computation1.sum + Computation2.product));
		
		Computation1 comp1 = new Computation1();
		Computation2 comp2 = new Computation2();
		
		Thread t1 = new Thread(comp1);
		Thread t2 = new Thread(comp2);
		
		t1.start();
		t2.start();
		
		try {
			CyclicBarrierTest.barrier.await();
		}catch(InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		
		System.out.println("Sum of the product and sum = "+ (Computation1.sum + Computation2.product));
		barrier.reset();
		System.out.println("Barrier reset successfully");
	}
	
	public static void main(String[] s) {
		CyclicBarrierTest test = new CyclicBarrierTest();
		Thread t = new Thread(test);
		t.start();
	}
}


class Computation1 implements Runnable{
	
	public static int sum = 0;

	@Override
	public void run() {
		System.out.println("Is the barrier broken ? - "+CyclicBarrierTest.barrier.isBroken());
		sum = 10+20;
		try {
			CyclicBarrierTest.barrier.await(3000, TimeUnit.MILLISECONDS);
			System.out.println("Number of parties waiting in the barrier at this point = "+CyclicBarrierTest.barrier.getNumberWaiting());
		}catch(InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}


class Computation2 implements Runnable{
	
	public static int product = 0;

	@Override
	public void run() {
		System.out.println("Is the barrier broken ? - "+CyclicBarrierTest.barrier.isBroken());
		product = 10*20;
		try {
			CyclicBarrierTest.barrier.await(3000, TimeUnit.MILLISECONDS);
			System.out.println("Number of parties waiting in the barrier at this point = "+CyclicBarrierTest.barrier.getNumberWaiting());
		}catch(InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}