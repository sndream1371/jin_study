package com.lgcns.tct.number;

import java.util.Arrays;

public class Number {
	
	
	/**
	 * 가장 큰 숫자와 가장 작은 숫자를 제거하는 기능
	 *
     * @param		inputData		String		입력데이터(숫자열)
     * @return						String		가장 큰 숫자와 가장 작은 숫자를 제거한 숫자열
	 */
	public String getRemovedStr(String inputData) {
		String removedStr = "";
		char[] inputArr = inputData.toCharArray();
		char[] tmpInputArr = inputData.toCharArray(); 
		
		Arrays.sort(inputArr); //오름차순 정렬(작은숫자부터 정렬)

		char minCh = inputArr[0];
		char maxCh = inputArr[inputArr.length-1];
		for(char c : tmpInputArr){
			if(c != minCh && c != maxCh){
				removedStr += c;
			}
		}
		return removedStr;
	}
	
	
	
	/**
	 * 가장 큰 수와 가장 작은 수의 차를 계산하는 기능
	 *
     * @param		removedStr		String		가장 큰 숫자와 가장 작은 숫자를 제거한 숫자열
     * @param		digit			int			입력데이터(자릿수)
     * @return						int			가장 큰 수와 가장 작은 수의 차
	 */
	public int getDifference(String removedStr, int digit) {
		int difference = 0;
		char[] removedArr = removedStr.toCharArray();
		Arrays.sort(removedArr);  //오름차순 정렬(낮은숫자 부터)
		
		String str = String.valueOf(removedArr); //String로 형변환
		int min = Integer.parseInt(str.substring(0, digit));

		String maxStr = "";
		for(int i = removedArr.length-1; i > removedArr.length-digit-1; i--){
			maxStr += removedArr[i];
		}
		
		int max = Integer.parseInt(maxStr);  //int로 형변환
		
		difference = max - min;
		return difference;
	}
	
}