package com.jin.study.tct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Number {
	
	public static void main(String [] args) {
		
		String number = "368581382";
		String result = getRemovedStr(number);
		int numCount = 3;
		System.out.println("[���� ū ���ڿ� ���� ���� ���ڸ� ������ ���ڿ�]");
		System.out.println("[�Է�]:"+number);
		System.out.println("[���]:"+result );
		System.out.println("----------------------------------");
		System.out.println("[���� ū ���� ���� ���� ���� ��]");
		System.out.println("[�ڸ���]:"+numCount);
		System.out.println("[�Է�]:"+result );
		//System.out.println("[���]:"+getDifference(result,numCount) );
		System.out.println("[���]:"+getDifference_otherSolve(result,numCount) );
		System.out.println("----------------------------------");
		
	}
	
	/*
	 *  ���� ū ���ڿ� ���� ���� ���ڸ� �����ϴ� ��� . 
	 *  �Ű�����: String inputData - �Էµ�����(���ڿ�) . 
	 *  ����: String - ���� ū ���ڿ� ���� ���� ���ڸ� ������ ���ڿ�
	 */
	 public static String getRemovedStr(String inputData) {
		 
		 //String minNum, maxNum=0;
		 int intNum , minNum=10, maxNum=0;
		 
		 for(int i=0; i < inputData.length(); i++) {
			 intNum = Integer.parseInt(inputData.charAt(i)+"");
			 if(intNum > maxNum) {
				 maxNum = intNum;
			 }
			 
			 if(intNum < minNum) {
				 minNum = intNum;
			 }
		 }
		 System.out.println("min :"+minNum+" max :"+maxNum);
		 
		 inputData = inputData.replaceAll(maxNum+"", "");
		 inputData = inputData.replaceAll(minNum+"", "");
		 
		 return inputData;
	 }
	 
	 /*
	  * ���� ū ���� ���� ���� ���� ���� ����ϴ� ��� . 
	  * �Ű�����: String removedStr  ���� ū ���ڿ� ���� ���� ���ڸ� ������ ���ڿ� . 
	  * �Ű�����: int digit  �Էµ�����(�ڸ���) . 
	  * ����: int  ���� ū ���� ���� ���� ���� ��
	  */
//	 public static int getDifference(String removedStr, int digit) {
//		 
//			char[] arrChar = null;
//			ArrayList<String> arrList = new ArrayList<String>();
//			
//			arrChar = removedStr.toCharArray();
//			
//			for(int i=0; i < arrChar.length; i++) {
//				arrList.add(arrChar[i]+"");
//			}
//			
//			//���� accending (���� ������ �̱�����)
//			Collections.sort(arrList);
//			String removedStrSort="";
//			for(String strArr : arrList) {
//				removedStrSort += strArr;
//			}
//			//System.out.println("removedStrSort :"+removedStrSort);
//			
//			//���� decending (����ū�� �ȱ�����)
//			Collections.reverse(arrList);
//			String removedStrSort2="";
//			for(String strArr : arrList) {
//				removedStrSort2 += strArr;
//			}
//			
//		 return Integer.parseInt(removedStrSort2.substring(0, digit)) - Integer.parseInt(removedStrSort.substring(0, digit));
//	 }
	 
	 
	 /*
	  * getDifference�� �������� �����ϳ��θ� min, max���� �����Ѵ�. 
	  * 
	  * ���� ū ���� ���� ���� ���� ���� ����ϴ� ��� . 
	  * �Ű�����: String removedStr  ���� ū ���ڿ� ���� ���� ���ڸ� ������ ���ڿ� . 
	  * �Ű�����: int digit  �Էµ�����(�ڸ���) . 
	  * ����: int  ���� ū ���� ���� ���� ���� ��
	  * 
	  */
	 public static int getDifference_otherSolve(String removedStr, int digit) {
		 
			char[] arrChar = null;
			
			arrChar = removedStr.toCharArray();
			Arrays.sort(arrChar); //�������� 
			
			String minV="";
			for(int i=0; i < digit; i++) { //�������� ���ĵ� ���� ���ڸ��� ���� �ڸ�����ŭ �ּҰ� �����.
				minV += arrChar[i];
			}
			
			String maxV="";
			for(int i = arrChar.length-1 ; i > (arrChar.length-1) - digit ; i--) { //�������� ���ĵ� ���� ���ڸ����� �ڸ�����ŭ �ִ밪 �����.
				maxV += arrChar[i];
			}
			
		 return Integer.parseInt(maxV) - Integer.parseInt(minV);
	 }

}
