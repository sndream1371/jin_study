package com.jin.study.tct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/*
 * ��� ���ϱ�
 * 
 * �Է��� ���� ����� ����Ͽ� ArrayList�� ��ȯ�Ѵ�.
 */
public class Exam_02_divisor {

	public static void main(String[] argv) {
		
		// 2-1 , int X�� ��� ���ϱ�
	    // �� > 7 �� ������ [1,7]
		Scanner scan = new Scanner(System.in);
        System.out.println("����� ���� ���ڸ� �Է��ϼ���.");
        
        // num=�Է¹޴°�, a=�����°�
        int num = scan.nextInt();
        int a;
 
		for (a = 1; a <= num; a++) {
			if ((num % a) == 0) {
				System.out.println(a);
			}
		}
		scan.close();
		
		/// 2- 2. int x[]�� ����� ���ϰ� ���� �ߺ� ���� ������ LIST
	    /// �� > {7, 3, 6, 12 }   > ����� [1, 2, 3, 4, 6, 7 , 12]
		
		int[] arrNum= {7,3,6,12};
		
		divisor(arrNum);
		
	}
	
	public static ArrayList<Integer> divisor(int[] num) {
		
		ArrayList<Integer> arrInt = new ArrayList<Integer>();
		ArrayList<Integer> arrIntResult = new ArrayList<Integer>();
		
		for(int i=0; i < num.length; i++) {
			for(int j=1; j<= num[i]; j++) {
				if(num[i]%j == 0) { //�μ�
					arrInt.add(j);
				}
			}
		}
		
		for(int k=0; k < arrInt.size(); k++) {
			if(!arrIntResult.contains(arrInt.get(k))) {
				arrIntResult.add(arrInt.get(k));
			}
		}
		
		System.out.println("Before sort arr Reuslt >"+arrIntResult );
		Collections.sort(arrIntResult); //������������
		System.out.println("After sort arr Reuslt >"+arrIntResult );
		
		return arrIntResult;
	}
}