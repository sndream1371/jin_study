package com.jin.study.string;

public class StringSwitch {

	public static void main(String[] args) {
		
		int comp = 45; //���� �ٸ��� �ؼ� �����ϸ� 1~5���� �Է��ϸ� 5�� ���,  6~9���� �Է��ϸ� 9��� �ȴ�.
		
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
