package com.jin.study.tct.cubesum;


/*
 * ���� �˻� : java 2���� �迭 ȸ��
 * 
 * N*N ���簢 ť�갡 �����Ѵ�. 
 * 
 * �־��� ť�긦 �ð�������� 90�� ȸ���Ͽ� �ΰ��� ���� ���ϴ� ���α׷��� �ۼ��Ѵ�.
 * 
 * cube sum
 * 
 * ���
 * 
 *
 *------------IN PUT---------------

  5  7  8
  4  2  1
  2  5  6
------------IN PUT 90�� �迭 ȸ��---------------

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
		
		int [][] arrSum = new int [cube.length][cube[0].length];  //[��] [��]
		int [][] cubeRotate = new int [cube.length][cube[0].length];
		
		System.out.println("------------IN PUT---------------");
		printOut(cube);
		
		for(int row=0; row < cube.length; row++){
			for(int col=0; col < cube.length; col++){
				arrSum[row][col] = cube[row][col] + cube[2-col][row]; // 2*2�迭 ���� �Է°�  + 90�� ȸ��(������)�� ��
				//arrSum[row][col] = cube[row][col] + cube[col][2-row]; // 2*2�迭 ���� �Է°�  + 90�� ȸ��(����)�� ��
				//arrSum[row][col] = cube[row][col] + cube[2-col][2-row]; // 2*2�迭 ���� �Է°�  + 180�� ȸ��(����)�� ��
				
				cubeRotate[row][col] = cube[2-col][row];
			}
		}
		
		System.out.println("------------IN PUT 90�� �迭 ȸ��---------------");
		printOut(cubeRotate);
		
		System.out.println("------------OUTPUT---------------");
		printOut(arrSum);

		return arrSum;
	}
	
	//N*N �迭 ���
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
