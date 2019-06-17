package com.jin.study.javajungsuk;

/*
 * 주어진 배열을 시계방향으로 90도 회전시켜서 출력하는 프로그램을 완성하시오 
 * 
 * [실행결과]
 * **
 * ** 
 * ** 
 * ***** 
 * *****
 * 
 * [결과]
   ***** 
   ***** 
   ** 
   **
   **
 */
class Array_Exercise5_9 {
	public static void main(String[] args)
	{
		char[][] star = { { '*', '*', ' ', ' ', ' ' },
				          { '*', '*', ' ', ' ', ' ' }, 
				          { '*', '*', ' ', ' ', ' ' }, 
				          { '*', '*', '*', '*', '*' },
				          { '*', '*', '*', '*', '*' } 
				        }; //[5][5]
		char[][] result = new char[star.length][star[0].length]; // [5],[5]
		System.out.println("star[0].length >"+star[0].length +" star.length >"+star.length);
		
		//입력값 출력
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		
		//결과출력
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				
				//result[i][j] = star[j][4-i];  //왼쪽으로 90도 돌리기
				result[i][j] = star[4-j][i];  //오른쪽으로 90도 돌리기				
				
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}
