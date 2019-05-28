package com.jin.study.javajungsuk;


/*
 * �־��� ���� �迭�� �����ͺ��� ���ο� ���η� �� �� ū �迭�� �����ؼ� �迭 2 1 �� ��� ���� ������ ��ҿ� �� ���� ���� ������ �����ϰ� ����ϴ� ���α׷��̴�. (1) �� �˸��� �ڵ带 �־ �ϼ��Ͻÿ�
 * 
 * [������]
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
				         }; //5*3 ��� -> 6*4 ���
		
		int[][] result = new int[score.length + 1][score[0].length + 1];
		System.out.println("score.length + 1 > "+(score.length+1) +" score[0].length + 1 >"+ (score[0].length + 1) );
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				/* �˸��� �ڵ带 �־� �ϼ��Ͻÿ� (1) . */
				
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
