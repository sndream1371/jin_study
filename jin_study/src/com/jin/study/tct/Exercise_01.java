package com.jin.study.tct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * �̹� ���� ���������� 1~1000���� 369 ���� �� �ڼ��� �� �� ġ�� �Ǵ��� ����ϴ� ���α׷��� �ۼ��Ѵ�.
�� 369 �����̶�? 
1) ���ڸ� 1���� ���ʴ�� ���鼭 3, 6, 9�� ������ �� ������ŭ �ڼ��� ġ�� �����̴�.
2) 10�� �ڸ����� 369 ���ڰ� �ߺ����� ��ĥ �ÿ��� (ex. 33, 36, 39) �ڼ��� �� �� ġ�� �ȴ�.
3) 100�� �ڸ����� 369 ���ڰ� �ߺ����� �� �� ��ĥ �ÿ��� (ex. 133, 169, 193) �ڼ��� �� �� ġ�� �ȴ�.
4) 100�� �ڸ����� 369 ���ڰ� �ߺ����� �� �� ��ĥ �ÿ��� (ex. 333, 666, 699) �ڼ��� �� �� ġ�� �ȴ�.
<�䱸����> 1 ~ 1000 ���� 369 ������ ���� ��, �ڼ�ġ�� Ƚ���� ��� ����Ѵ�.
<�ۼ��� ����> com.lgcns.exercise.triplegame.TripleGame�� countTriple() �޼ҵ� �ۼ�

<���� ����> 
==================================== 
Count number of clap from 1 to 1000 
====================================
 */
public class Exercise_01 {

	public static void main(String[] argv) {
		
		System.out.println("====================================");
		System.out.println("Count number of clap from 1 to 1000");
		System.out.println("====================================");
		
		System.out.println( countTriple() );
		
	}
	
	public static int countTriple() {
		int totCnt=0;
		String strNum="";
		
		for(int i=1; i <= 1000; i++) {
			strNum=i+"";
			for(int j=0; j < strNum.length(); j ++) {
				if(strNum.charAt(j) == '3') totCnt++;
				if(strNum.charAt(j) == '6') totCnt++;
				if(strNum.charAt(j) == '9') totCnt++;
			}
			
		}
		
		
		return totCnt;
	}
}
