package com.jin.study.javajungsuk;

/*
 * 
 *  ���� �迭 �� ��� ��� ���� ���հ� ����� ���ϴ� ���α׷��� �ϼ��Ͻÿ�
 */
class Array_Exercise5_4 {
	public static void main(String[] args) {
		int[][] arr = { { 5, 5, 5, 5, 5 }, { 10, 10, 10, 10, 10 }, { 20, 20, 20, 20, 20 }, { 30, 30, 30, 30, 30 } };
		int total = 0;
		float average = 0;
		
		/*
		 * �˸��� �ڵ带 �־� �ϼ��Ͻÿ� (1) .
		 */
		int cnt=0;
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr[i].length; j++) {
				total += arr[i][j];
				cnt++;
			}
		}
			
		average = (float)total / cnt; //int���� float�� ����ȯ�ؼ� ���

		//-----------------------------------------------------------
		
		System.out.println("total=" + total);
		System.out.println("average=" + average);
	} // end of main
} // end of class