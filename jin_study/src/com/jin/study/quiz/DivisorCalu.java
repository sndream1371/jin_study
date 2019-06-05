package com.jin.study.quiz;

import java.util.ArrayList;
import java.util.List;

public class DivisorCalu {

	
	/*
	 *  ����� ��� ã�� ���� ������ Ǯ�ٰ� ��ģ X�� ��ǻ���� ������ �޾� ������ Ǯ�� ����� �Ͽ���.
	 *  ������ ���⸦ �̿����ڴ� ����� �ϰ� ������ ã�⵵ ������, 
	 *  ���� ã�Ƴ� ���� ������.
	 *  
		Ǯ�̿� ��ģ �״� �ᱹ ������� ������ �ִ� Ư¡�� ã�� 
		�ᱹ ��ð��� ���� ������ ���� ����� ã���� �� �ְ� ������ �˷��ִ� ���α׷��� ¥�� �ȴ�.
		
		������ ����� ��� ���� �Է°� ��� �������̴�.
		
		�Է� 1
		24
		
		��� 1
		{ 1, 2, 3, 4, 6, 8, 12, 24}
		����� ������ 8�� �Դϴ�.
		
		�Է� 2
		36
		
		��� 2
		{ 1, 2, 3, 4, 6, 9, 12, 18, 36 }
		����� ������ 9�� �Դϴ�.
		
		�Է� 3
		2468013579
		��� 3
		
		{ 1, 3, 9, 61, 183, 549, 4495471, 13486413, 40459239, 274223731, 822671193, 2468013579 }
		����� ������ 12�� �Դϴ�.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String inputNum = "2468013579"; //�Է°�
		String inputNum = "24"; //�Է°�
		System.out.println("�Է�1:"+inputNum);
		System.out.println("���1:");
		System.out.println(DivisorCalu.doDivisor(inputNum));
		System.out.println("����� ������ "+DivisorCalu.doDivisor(inputNum).size()+"�� �Դϴ�.");
	}
	
	public static List<Long> doDivisor(String str) {
		List<Long> listNum = new ArrayList<Long>();
		long num = Long.parseLong(str); //����ȯ String -> long
		for(long i=1; i <= (num/2); i++) {   //�ӵ��� ������.
			if( num % i == 0) {
				listNum.add(i);
			}
		}
		listNum.add(num); //�ڱ��ڽ��� ��
		
		return listNum;
	}

}
