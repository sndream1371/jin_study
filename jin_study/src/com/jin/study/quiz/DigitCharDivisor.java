package com.jin.study.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class DigitCharDivisor {

	/*
	 * ���ڿ� ���ڰ����� ���ڿ��� �Է¹����� �����Ͽ�����ض�
	input:"c910m6ia 1ho"
	output:
	str : cma ho
	int : 91061
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println("Input value >>>");
//		Scanner sc = new Scanner(System.in);
//		String msg = sc.nextLine(); //Ű���� �����Է�
//		System.out.println("Input message >"+msg);
		
		String msg ="c910m6ia 1ho";
		System.out.println("input:"+msg);
		
		char[] arrChar = msg.toCharArray();
		String Str="",Int="";
		for(int i=0; i < arrChar.length; i++) {
			if( arrChar[i] >= '0' && arrChar[i] <= '9' ) {
				Int += arrChar[i];
			}else {
				Str += arrChar[i];
			}
		}
		System.out.println("Str : "+Str);
		System.out.println("int : "+Int);
		
	}

}