package com.jin.study.tct.javabasic;

import java.util.Scanner;

/*
 * 구구단의 합
 * 단, 동일 단수는 덧샘에서 제외한다.
 * 
 * [실행예시]
 * 입력값:1 / 결과 : 44
 * 입력값:4 / 결과: 420
 * 입력값:7 / 결과:1120
 * 
 * 
 */
public class SumOfGugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("입력값:");
		String input = sc.nextLine(); //키보드 문자입력
		//System.out.println("Input message >"+msg);
		
		System.out.println("/ 결과:"+sum(Integer.parseInt(input)) );
	}
	
	public static int sum(int input) {
		
		int sum = 0;
		for(int k=1; k <= input ; k++) {
			for(int i=1; i <= 9; i++) {
				if( k != i) { //1*1, 2*2, 3*3동일한 단수는 제외
					System.out.println(k +" * "+ i+" = "+ k*i);
					sum += (k * i);
				}
				//System.out.println(k +" * "+ i+" = "+ k*i);
			}
		}
	
		return sum;
	}

}
