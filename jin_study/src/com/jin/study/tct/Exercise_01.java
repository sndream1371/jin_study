package com.jin.study.tct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 이번 연습 문제에서는 1~1000까지 369 게임 시 박수를 몇 번 치게 되는지 계산하는 프로그램을 작성한다.
※ 369 게임이란? 
1) 숫자를 1부터 차례대로 세면서 3, 6, 9가 나오면 그 개수만큼 박수를 치는 게임이다.
2) 10의 자리에서 369 숫자가 중복으로 겹칠 시에는 (ex. 33, 36, 39) 박수를 두 번 치게 된다.
3) 100의 자리에서 369 숫자가 중복으로 두 번 겹칠 시에는 (ex. 133, 169, 193) 박수를 두 번 치게 된다.
4) 100의 자리에서 369 숫자가 중복으로 세 번 겹칠 시에는 (ex. 333, 666, 699) 박수를 세 번 치게 된다.
<요구사항> 1 ~ 1000 까지 369 게임을 했을 때, 박수치는 횟수를 세어서 출력한다.
<작성할 파일> com.lgcns.exercise.triplegame.TripleGame의 countTriple() 메소드 작성

<실행 예시> 
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
