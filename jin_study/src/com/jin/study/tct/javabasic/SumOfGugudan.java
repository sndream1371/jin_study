package com.jin.study.tct.javabasic;

import java.util.Scanner;

/*
 * �������� ��
 * ��, ���� �ܼ��� �������� �����Ѵ�.
 * 
 * [���࿹��]
 * �Է°�:1 / ��� : 44
 * �Է°�:4 / ���: 420
 * �Է°�:7 / ���:1120
 * 
 * 
 */
public class SumOfGugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("�Է°�:");
		String input = sc.nextLine(); //Ű���� �����Է�
		//System.out.println("Input message >"+msg);
		
		System.out.println("/ ���:"+sum(Integer.parseInt(input)) );
	}
	
	public static int sum(int input) {
		
		int sum = 0;
		for(int k=1; k <= input ; k++) {
			for(int i=1; i <= 9; i++) {
				if( k != i) { //1*1, 2*2, 3*3������ �ܼ��� ����
					System.out.println(k +" * "+ i+" = "+ k*i);
					sum += (k * i);
				}
				//System.out.println(k +" * "+ i+" = "+ k*i);
			}
		}
	
		return sum;
	}

}
