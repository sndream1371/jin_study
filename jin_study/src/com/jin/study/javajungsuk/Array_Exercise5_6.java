package com.jin.study.javajungsuk;

/*
 *다음은 거스름돈을 몇 개의 동전으로 지불할 수 있는지를 계산하는 문제이다 
 *변수 의 금액을 동전으로 바꾸었을 때 각각 몇 개의 동전이 필요한지 계산해서 출력하 money 라
 * 단 가능한 한 적은 수의 동전으로 거슬러 주어야한다 에 알맞은 코드를 넣어서 . , . (1) 프로그램을 완성하시오.
  [Hint] 나눗셈 연산자와 나머지 연산자를 사용해야 한다.
 * 
 * 
 * [실행결과]
 * money=2680 원
 *  500 : 5 원
 *  100 : 1 원
 *   50 : 1 원
 *   10 : 3 원
*/
class Array_Exercise5_6 {
	
	public static void main(String args[]) {
		
		// 큰 금액의 동전을 우선적으로 거슬러 줘야한다
		int[] coinUnit = { 500, 100, 50, 10 };
		int money = 2680;
		System.out.println("money=" + money);
		for (int i = 0; i < coinUnit.length; i++) {
			/* 알맞은 코드를 넣어 완성하시오 (1) . */
			
			System.out.println(coinUnit[i] +" : "+ money / coinUnit[i]); //거슬러주는 동전주
			money = money % coinUnit[i]; //거슬러주는 동전을뺀 나머지돈
			
		}
	}
	
	
}
