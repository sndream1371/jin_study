package com.jin.study.javajungsuk;

/*
 * 주어진 배열을 시계방향으로 도 회전시켜서 출력하는 프로그램을 완성하시오 
 * 
 * [실행결과]
 * ** 
 * ** 
 * ***** 
 * *****
 * 
   **** 
   **** 
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
				        }; //[4][5]
		char[][] result = new char[star[0].length][star.length]; // [5],[4]
		System.out.println("star[0].length >"+star[0].length +" star.length >"+star.length);
		
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				
				//System.out.println("star[4-j][i] > "+star[4-j][i]);
				result[i][j] = star[4-j][i];
						
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}
