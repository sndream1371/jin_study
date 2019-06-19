package com.jin.study.tct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 *
 * 문자열 압축
 *  
 * 입력받은 문자열을 대문자를 소문자로 변환한다.
 * 알파벳 순서대로 정렬하고 알파벳 다음 갯수를 입력한다.  ex) aaaACCCcbbbB - > a4b4c4
 * 
 */
public class Exam_01 {

	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input value >>>");
		
		String msg = sc.nextLine(); //키보드 문자입력
		System.out.println("Input message >"+msg);
		
		char[] arrChar = null;
		ArrayList<String> arrList = new ArrayList<String>();
		
		arrChar = (msg.toLowerCase()).toCharArray();  //소문자로 변환후 array로 입력함
		
		for(int i=0; i < arrChar.length; i++) {
			//System.out.println("array >"+arrChar[i]);
			arrList.add( arrChar[i]+"" ); //String.valueOf()
		}
		
		Collections.sort(arrList); //입력값 정렬 , 주석시 입력순서대로 문자열 압축해서 카운드, 주석해제시 전체문자열 sort해서 문자별로 카운트
		
		int cnt=0;
		String display="", tempStr="";
		
		for(String data : arrList) {
			
			//System.out.println("tempStr >"+tempStr);
			if(!tempStr.equals(data)) {
				tempStr = data;
				
				for(int j=0; j < arrList.size(); j++) {
					//System.out.println("Final result sort strArr :"+strArr+" arrList(j):"+arrList.get(j));
					if( data.equals(arrList.get(j))) {
						display = cnt++ + "";
					}
				}
				display = data + cnt;
				System.out.print(display);
				cnt=0;
			}
		}
		
		
	}
}
