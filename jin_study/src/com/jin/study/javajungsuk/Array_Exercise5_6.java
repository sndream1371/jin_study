package com.jin.study.javajungsuk;

/*
 *������ �Ž������� �� ���� �������� ������ �� �ִ����� ����ϴ� �����̴� 
 *���� �� �ݾ��� �������� �ٲپ��� �� ���� �� ���� ������ �ʿ����� ����ؼ� ����� money ��
 * �� ������ �� ���� ���� �������� �Ž��� �־���Ѵ� �� �˸��� �ڵ带 �־ . , . (1) ���α׷��� �ϼ��Ͻÿ�.
  [Hint] ������ �����ڿ� ������ �����ڸ� ����ؾ� �Ѵ�.
 * 
 * 
 * [������]
 * money=2680 ��
 *  500 : 5 ��
 *  100 : 1 ��
 *   50 : 1 ��
 *   10 : 3 ��
*/
class Array_Exercise5_6 {
	
	public static void main(String args[]) {
		
		// ū �ݾ��� ������ �켱������ �Ž��� ����Ѵ�
		int[] coinUnit = { 500, 100, 50, 10 };
		int money = 2680;
		System.out.println("money=" + money);
		for (int i = 0; i < coinUnit.length; i++) {
			/* �˸��� �ڵ带 �־� �ϼ��Ͻÿ� (1) . */
			
			System.out.println(coinUnit[i] +" : "+ money / coinUnit[i]); //�Ž����ִ� ������
			money = money % coinUnit[i]; //�Ž����ִ� �������� ��������
			
		}
	}
	
	
}
