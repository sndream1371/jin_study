package com.jin.study.tct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Number {
	
	public static void main(String [] args) {
		
		String number = "368581382";
		String result = getRemovedStr(number);
		int numCount = 3;
		System.out.println("[가장 큰 숫자와 가장 작은 숫자를 제거한 숫자열]");
		System.out.println("[입력]:"+number);
		System.out.println("[출력]:"+result );
		System.out.println("----------------------------------");
		System.out.println("[가장 큰 수와 가장 작은 수의 차]");
		System.out.println("[자릿수]:"+numCount);
		System.out.println("[입력]:"+result );
		//System.out.println("[출력]:"+getDifference(result,numCount) );
		System.out.println("[출력]:"+getDifference_otherSolve(result,numCount) );
		System.out.println("----------------------------------");
		
	}
	
	/*
	 *  가장 큰 숫자와 가장 작은 숫자를 제거하는 기능 . 
	 *  매개변수: String inputData - 입력데이터(숫자열) . 
	 *  리턴: String - 가장 큰 숫자와 가장 작은 숫자를 제거한 숫자열
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
	  * 가장 큰 수와 가장 작은 수의 차를 계산하는 기능 . 
	  * 매개변수: String removedStr  가장 큰 숫자와 가장 작은 숫자를 제거한 숫자열 . 
	  * 매개변수: int digit  입력데이터(자릿수) . 
	  * 리턴: int  가장 큰 수와 가장 작은 수의 차
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
//			//정렬 accending (가장 작은수 뽑기위함)
//			Collections.sort(arrList);
//			String removedStrSort="";
//			for(String strArr : arrList) {
//				removedStrSort += strArr;
//			}
//			//System.out.println("removedStrSort :"+removedStrSort);
//			
//			//정렬 decending (가장큰수 뽁기위함)
//			Collections.reverse(arrList);
//			String removedStrSort2="";
//			for(String strArr : arrList) {
//				removedStrSort2 += strArr;
//			}
//			
//		 return Integer.parseInt(removedStrSort2.substring(0, digit)) - Integer.parseInt(removedStrSort.substring(0, digit));
//	 }
	 
	 
	 /*
	  * getDifference을 오른차순 정렬하나로만 min, max값을 추출한다. 
	  * 
	  * 가장 큰 수와 가장 작은 수의 차를 계산하는 기능 . 
	  * 매개변수: String removedStr  가장 큰 숫자와 가장 작은 숫자를 제거한 숫자열 . 
	  * 매개변수: int digit  입력데이터(자릿수) . 
	  * 리턴: int  가장 큰 수와 가장 작은 수의 차
	  * 
	  */
	 public static int getDifference_otherSolve(String removedStr, int digit) {
		 
			char[] arrChar = null;
			
			arrChar = removedStr.toCharArray();
			Arrays.sort(arrChar); //오름차순 
			
			String minV="";
			for(int i=0; i < digit; i++) { //오름차순 정렬된 값을 뒷자릿수 부터 자릿수만큼 최소값 만든다.
				minV += arrChar[i];
			}
			
			String maxV="";
			for(int i = arrChar.length-1 ; i > (arrChar.length-1) - digit ; i--) { //오름차순 정렬된 값을 앞자리부터 자릿수만큼 최대값 만든다.
				maxV += arrChar[i];
			}
			
		 return Integer.parseInt(maxV) - Integer.parseInt(minV);
	 }

}
