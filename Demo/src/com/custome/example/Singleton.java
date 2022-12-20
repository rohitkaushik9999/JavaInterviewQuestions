package com.custome.example;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable{
	
	private static volatile Singleton singleton;
	private volatile int count;
	
	private Singleton() {
		if(singleton != null)
			throw new RuntimeException("use getInstance() method to get the singleton instance of this class");
	}
	
	public static Singleton getInstance() {
		if(singleton == null) {
			synchronized(Singleton.class){
				if(singleton == null)
					singleton = new Singleton();
			}
		}
		
		return singleton;
	}
	
	//male singleton in serialize and deserialze operation
	public Singleton readResolve() {
		return getInstance();
	}
	
	public Object clone() throws CloneNotSupportedException{
		return getInstance();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
