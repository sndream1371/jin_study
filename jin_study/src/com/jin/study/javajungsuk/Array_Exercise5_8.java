package com.jin.study.javajungsuk;

/*
 * ������ �迭 �� ��� �����͸� �а� �� ������ ������ ��� ������ŭ answer ��*�� �� �� �׷����� �׸��� ���α׷��̴� �� 
 * �˸��� �ڵ带 �־ �ϼ��Ͻÿ� . (1)~(2) .
 * 
 * [������]
 * 3*** 
 * 2** 
 * 2** 
 * 4****
 */
class Array_Exercise5_8 {
	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 8, 10, 9 };
		
		for (int i = 0; i < answer.length; i++) {
			/* �˸��� �ڵ带 �־� �ϼ��Ͻÿ� /* (1) . */
			System.out.print(answer[i] + display(answer[i]));
		}
	
	}

	//�Ķ���ͷ� ���� ���� ��ŭ "*"�� ǥ���Ѵ�. 
	public static String display(int count) {
		
		String result="";
		
		for (int j = 0; j < count ; j++) {
			/* �˸��� �ڵ带 �־� �ϼ��Ͻÿ� (2) . */
			result += "*";
		}
		result += "\n";
		
		return result;
	}
	
}
