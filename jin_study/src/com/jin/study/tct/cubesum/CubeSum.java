package com.jin.study.tct.cubesum;


/*
 * 구글 검색 : java 2차원 배열 회전
 * 
 * N*N 정사각 큐브가 존재한다. 
 * 
 * 주어진 큐브를 시계방향으로 90도 회전하여 두개의 합을 구하는 프로그램을 작성한다.
 * 
 * cube sum
 * 
 * 결과
 * 
 *
 *------------IN PUT---------------

  5  7  8
  4  2  1
  2  5  6
------------IN PUT 90도 배열 회전---------------

  2  4  5
  5  2  7
  6  1  8
------------OUTPUT---------------

  7 11 13
  9  4  8
  8  6 14
  
 *
 *
 */
public class CubeSum {
	
	int [][] sum(int[][] cube){
		
		//int [][] arrSum = new int [3][3];
		//int [][] cubeRotate = new int [3][3];
		
		int [][] arrSum = new int [cube.length][cube[0].length];  //[행] [열]
		int [][] cubeRotate = new int [cube.length][cube[0].length];
		
		System.out.println("------------IN PUT---------------");
		printOut(cube);
		
		for(int row=0; row < cube.length; row++){
			for(int col=0; col < cube.length; col++){
				arrSum[row][col] = cube[row][col] + cube[2-col][row]; // 2*2배열 최초 입력값  + 90도 회전(오른쪽)한 값
				//arrSum[row][col] = cube[row][col] + cube[col][2-row]; // 2*2배열 최초 입력값  + 90도 회전(외쪽)한 값
				//arrSum[row][col] = cube[row][col] + cube[2-col][2-row]; // 2*2배열 최초 입력값  + 180도 회전(외쪽)한 값
				
				cubeRotate[row][col] = cube[2-col][row];
			}
		}
		
		System.out.println("------------IN PUT 90도 배열 회전---------------");
		printOut(cubeRotate);
		
		System.out.println("------------OUTPUT---------------");
		printOut(arrSum);

		return arrSum;
	}
	
	//N*N 배열 출력
	void printOut(int[][] cube) {
		
		System.out.println();
		for(int row=0; row < cube.length; row++){
			for(int col=0; col < cube.length; col++){
				System.out.printf("%3d", cube[row][col]);
			}
			System.out.println();
		}
	}

}
