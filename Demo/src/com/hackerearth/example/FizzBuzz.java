package com.hackerearth.example;

import java.util.Optional;

public class FizzBuzz <T> {

	public static void main(String[] s) {
		Optional<String> opt = Optional.ofNullable(null);
		//System.out.println(opt.isPresent() + "---" + opt.isEmpty());
		System.out.println(opt.empty().equals(opt));
		
		int cnt3 = 0;
		int cnt5 = 0;
		for(int i=0;i<100;i++) {
			cnt3 =  cnt3 + 1;
			cnt5 = cnt5 + 1;
			String flag = "";
			if(cnt3 == 3 ) {flag = "FIZZ"; cnt3 = 0;}
			if(cnt5 == 5) {flag = flag+"BUZZ"; cnt5 = 0;}
			
			if(flag.isEmpty())
				System.out.println(i+1);
			else
				System.out.println(flag);
		}
	}
}
