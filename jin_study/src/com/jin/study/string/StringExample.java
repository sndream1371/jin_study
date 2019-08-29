package com.jin.study.string;

public class StringExample {

	public static void main(String[] args) {
		String date = "2019-08-29";
		
		String yyyy = date.substring(0, 4);
		String mm = date.substring(5,7);
		
		System.out.println("yyyy :"+ yyyy +" mm:"+mm);
	}
	
	
	
}
