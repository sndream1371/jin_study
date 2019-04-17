package com.jin.study.tct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exam_01 {

	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input value >>>");
		String msg = sc.nextLine(); //키보드 문자입력
		System.out.println("Input message >"+msg);
		
		char[] arrChar = null;
		ArrayList<String> arrList = new ArrayList<String>();
		
		arrChar = msg.toCharArray();
		
		for(int i=0; i < arrChar.length; i++) {
			System.out.println("array >"+arrChar[i]);
			arrList.add(arrChar[i]+"");
		}
		
		Collections.sort(arrList);
		int cnt=0;
		String display="", tempStr="";
		
		for(String strArr : arrList) {
			
			//System.out.println("tempStr >"+tempStr);
			if(!tempStr.equals(strArr)) {
				tempStr = strArr;
				
				for(int j=0; j < arrList.size(); j++) {
					//System.out.println("Final result sort strArr :"+strArr+" arrList(j):"+arrList.get(j));
					if( strArr.equals(arrList.get(j))) {
						display = cnt++ + "";
					}
				}
				display = strArr + cnt;
				//System.out.println(display);
				System.out.print(display);
				cnt=0;
			}
		}
		
		
	}
}
