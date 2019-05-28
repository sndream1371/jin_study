package com.jin.study.javajungsuk;


/*
 * 주어진 차원 배열의 데이터보다 가로와 세로로 이 더 큰 배열을 생성해서 배열 2 1 의 행과 열의 마지막 요소에 각 열과 행의 총합을 저장하고 출력하는 프로그램이다. (1) 에 알맞은 코드를 넣어서 완성하시오
 * 
 * [실행결과]
 * 100 100 100 300 
 * 20   20  20  60 
 * 30   30  30  90  
 * 40   40  40 120
 * 50   50  50 150 
 * 240 240 240 720
 * 
 */
class Array_Exercise5_11 {
	public static void main(String[] args) {
		int[][] score = { { 100, 100, 100 }, 
				           { 20,  20,  20 }, 
				           { 30,  30,  30 }, 
				           { 40,  40,  40 }, 
				           { 50,  50,  50 } 
				         }; //5*3 행렬 -> 6*4 행렬
		
		int[][] result = new int[score.length + 1][score[0].length + 1];
		System.out.println("score.length + 1 > "+(score.length+1) +" score[0].length + 1 >"+ (score[0].length + 1) );
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				/* 알맞은 코드를 넣어 완성하시오 (1) . */
				
				result[i][j] = score[i][j];
				result[i][3] += score[i][j];
				result[5][j] += score[i][j];
				result[5][3] += score[i][j];
			}
			
		}
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.printf("%4d", result[i][j]);
			}
			System.out.println();
		}
	} // main
}
