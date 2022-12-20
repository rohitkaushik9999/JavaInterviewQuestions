package com.custome.example;

public class CustomeArrayList {

	private static final int SIZE_FACTOR = 5;
	private Object[] data;
	private int size;
	private int index;
	
	public CustomeArrayList() {
		this.data = new Object[SIZE_FACTOR];
		this.size = SIZE_FACTOR;
	}
	
	public int getSize() {
		return SIZE_FACTOR;
	}
	
	public void add(Object obj) {
		if(this.index == this.size - 1)
			increaseSizeAndRellocate();
		
		this.data[this.index] = obj;
		this.index++;
	}
	
	private void increaseSizeAndRellocate() {
		this.size = this.size + SIZE_FACTOR;
		Object[] newData = new Object[this.size];
		for(int i=0;i<this.data.length;i++) {
			newData[i] = this.data[i];
		}
		this.data = newData;
	}

	public Object get(int index) throws Exception{
		if(index > this.size - 1)
			throw new Exception("ÄrrayIndexOutOfBoundException");
		if(index < 0)
			throw new Exception("Negative Value");

		return this.data[index];

	}
	
	public void remove(int index)throws Exception{
		if(index > this.size - 1)
			throw new Exception("ÄrrayIndexOutOfBoundException");
		if(index < 0)
			throw new Exception("Negative Value");
		
		for(int x=index;x<this.data.length;x++) {
			this.data[x] = this.data[x + 1];
		}
		
		this.size--;
	}
	
	public static void main(String[] s) {
		CustomeArrayList list = new CustomeArrayList();
		System.out.println("size = "+list.size);
		list.add("0");
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		list.add("5");
		System.out.println("size = "+list.size);
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Singleton obj1 = Singleton.getInstance();
				System.out.println("instance 1 hash : "+obj1.hashCode());
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Singleton obj2 = Singleton.getInstance();
				System.out.println("instance 2 hash : "+obj2.hashCode());
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			list.get(-1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
