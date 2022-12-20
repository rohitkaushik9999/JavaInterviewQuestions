package com.custome.example;
/*
 * If exception is checked then it's mendatory to use the handler. If exception is unchecked then it's not force us.
 * But if unchecked exception occurs and you have not handled it then program is terminated because it behaves like a error, 
 * but in this case if you have a finally block then firstly your finally block run then your program is terminated with that
 * unhandled unchecked exception.
 */
class CustomeException {
	public static String message = null;
	public static String subMessage = null;
	
	static {
		try {
			subMessage = message.substring(3);
		}catch(NullPointerException | ExceptionInInitializerError e) {
			System.out.println("++++++++++++++++++++++++++");
			e.printStackTrace();
		}finally {
			System.out.println("=======================");
		}
	}
	
	public static void method(Exception e) {
		System.out.println("Exception Method");
	}
	
	public static void method(ArithmeticException e) {
		System.out.println("ArithmeticException Method");
	}
	
	public static void main(String[] s) {
		CustomeException exc = new CustomeException();
		try {
			CustomeArrayList list = new CustomeArrayList();
			System.out.println("size = "+list.getSize());
			list.add("0");
			int x = 2/0;
		}catch(ArithmeticException e) {
			e.printStackTrace();
			callUncheckedException();
			method(e);
			try {
				throw new CustomeUnCheckedException("Unchecked Exception");
			}catch(CustomeUnCheckedException e1) {
				e1.printStackTrace();
				System.out.println("====================1 "+e1.getMessage());
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("====================2 "+e.getMessage());
		}finally {
			System.out.println("=== inside the finally block ===");
			exc.callCheckedException();
		}
		
		
		System.out.println("*****************************");
		
		try {
			throw new CustomeCheckedException("Checked Exception");
		}catch(CustomeCheckedException e) {
			e.printStackTrace();
		}
		
		System.out.println("=== end of the program ===");
	}
	
	private static void callUncheckedException() {
		System.out.println("=== inside the callUncheckedException method ===");
		try {
			throw new CustomeUnCheckedException("UnChecked Exception");
		}catch(CustomeUnCheckedException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void callCheckedException() {
		System.out.println("=== inside the callcheckedException method ===");
		try {
			throw new CustomeCheckedException("Checked Exception");
		}catch(CustomeCheckedException e) {
			e.printStackTrace();
		}
	}
}


class CustomeCheckedException extends Exception{
	CustomeCheckedException(String msg){
		super(msg);
	}
	
	CustomeCheckedException(Throwable cause){
		super(cause);
	}
	
	CustomeCheckedException(String msg, Throwable cause){
		super(msg, cause);
	}
}


class CustomeUnCheckedException extends RuntimeException{
	CustomeUnCheckedException(String msg){
		super(msg);
	}
	
	CustomeUnCheckedException(Throwable cause){
		super(cause);
	}
	
	CustomeUnCheckedException(String msg, Throwable cause){
		super(msg, cause);
	}
}
