package com.jin.study.string;

public class StringSwitch {

	public static void main(String[] args) {
		
		int comp = 45; //값을 다르게 해서 실행하면 1~5까지 입력하면 5가 출력,  6~9까지 입력하면 9출력 된다.
		
		switch( comp ) {
			case 1 :
			case 2 :
			case 3 :
			case 4 :
			case 45 :
			case 5 :
				System.out.println("this is 5");
				break;
			case 6 :
			case 7 :
			case 8 :
			case 9 :
				System.out.println("this is 9");
				break;
			case 10 :
			default :
				System.out.println("this is default...");
		}
		
		
	}
	
	
	
}
