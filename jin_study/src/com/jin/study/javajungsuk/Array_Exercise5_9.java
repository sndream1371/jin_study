package com.jin.study.javajungsuk;

/*
 * �־��� �迭�� �ð�������� 90�� ȸ�����Ѽ� ����ϴ� ���α׷��� �ϼ��Ͻÿ� 
 * 
 * [������]
 * **
 * ** 
 * ** 
 * ***** 
 * *****
 * 
 * [���]
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
		
		//�Է°� ���
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		
		//������
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				
				//result[i][j] = star[j][4-i];  //�������� 90�� ������
				result[i][j] = star[4-j][i];  //���������� 90�� ������				
				
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}
