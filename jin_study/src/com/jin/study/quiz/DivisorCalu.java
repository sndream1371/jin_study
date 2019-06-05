package com.jin.study.quiz;

import java.util.ArrayList;
import java.util.List;

public class DivisorCalu {

	
	/*
	 *  약수를 모두 찾는 수학 문제를 풀다가 지친 X는 컴퓨터의 도움을 받아 문제를 풀어 보기로 하였다.
	 *  하지만 계산기를 이용하자니 계산기로 하고 싶지만 찾기도 어려우며, 
	 *  쉽게 찾아낼 수도 없었다.
	 *  
		풀이에 지친 그는 결국 약수들이 가지고 있는 특징을 찾아 
		결국 몇시간에 걸쳐 복잡한 수라도 약수를 찾아줄 수 있고 개수도 알려주는 프로그램을 짜게 된다.
		
		다음은 약수를 얻기 위한 입력과 출력 예제들이다.
		
		입력 1
		24
		
		출력 1
		{ 1, 2, 3, 4, 6, 8, 12, 24}
		약수의 개수는 8개 입니다.
		
		입력 2
		36
		
		출력 2
		{ 1, 2, 3, 4, 6, 9, 12, 18, 36 }
		약수의 개수는 9개 입니다.
		
		입력 3
		2468013579
		출력 3
		
		{ 1, 3, 9, 61, 183, 549, 4495471, 13486413, 40459239, 274223731, 822671193, 2468013579 }
		약수의 개수는 12개 입니다.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String inputNum = "2468013579"; //입력값
		String inputNum = "24"; //입력값
		System.out.println("입력1:"+inputNum);
		System.out.println("출력1:");
		System.out.println(DivisorCalu.doDivisor(inputNum));
		System.out.println("약수의 개수는 "+DivisorCalu.doDivisor(inputNum).size()+"개 입니다.");
	}
	
	public static List<Long> doDivisor(String str) {
		List<Long> listNum = new ArrayList<Long>();
		long num = Long.parseLong(str); //형변환 String -> long
		for(long i=1; i <= (num/2); i++) {   //속도가 느리다.
			if( num % i == 0) {
				listNum.add(i);
			}
		}
		listNum.add(num); //자기자신의 수
		
		return listNum;
	}

}
