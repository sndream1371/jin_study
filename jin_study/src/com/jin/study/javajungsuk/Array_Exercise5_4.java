package com.jin.study.javajungsuk;

/*
 *  차원 배열 에 담긴 모든 값의 총합과 평균을 구하는 프로그램을 완성하시오
 */
class Array_Exercise5_4 {
	public static void main(String[] args) {
		int[][] arr = { {  5,  5,  5,  5,  5 }, 
				        { 10, 10, 10, 10, 10 }, 
				        { 20, 20, 20, 20, 20 }, 
				        { 30, 30, 30, 30, 30 } 
				      };
		int total = 0;
		float average = 0;
		
		/*
		 * 알맞은 코드를 넣어 완성하시오 (1) .
		 */
		int cnt=0;
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr[i].length; j++) {
				total += arr[i][j];
				cnt++;
			}
		}
			
		average = (float)total / cnt; //int형을 float로 형변환해서 계산

		//-----------------------------------------------------------
		
		System.out.println("cnt=" + cnt);
		System.out.println("total=" + total);
		System.out.println("average=" + average);
		
	} // end of main
} // end of class
