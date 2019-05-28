package com.jin.study.javajungsuk;

/*
 * 다음은 배열 에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 answer ‘*’ 을 찍어서 그래프를 그리는 프로그램이다 에 
 * 알맞은 코드를 넣어서 완성하시오 . (1)~(2) .
 * 
 * [실행결과]
 * 3*** 
 * 2** 
 * 2** 
 * 4****
 */
class Array_Exercise5_8 {
	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];
		for (int i = 0; i < answer.length; i++) { 
			/* 알맞은 코드를 넣어 완성하시오 /* (1) . */
			System.out.print(answer[i]);
			for (int j = 0; j < answer[i]; j++) {
				/* 알맞은 코드를 넣어 완성하시오 (2) . */
				System.out.print("*");
			}
			System.out.println();			
		}
	
	}
}
