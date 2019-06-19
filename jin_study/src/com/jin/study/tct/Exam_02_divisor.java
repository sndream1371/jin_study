package com.jin.study.tct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/*
 * 약수 구하기
 * 
 * 입력한 값의 약수를 계산하여 ArrayList로 반환한다.
 */
public class Exam_02_divisor {

	public static void main(String[] argv) {
		
		// 2-1 , int X의 약수 구하기
	    // 예 > 7 을 넣으면 [1,7]
		Scanner scan = new Scanner(System.in);
        System.out.println("약수를 구할 숫자를 입력하세요.");
        
        // num=입력받는값, a=나누는값
        int num = scan.nextInt();
        int a;
 
		for (a = 1; a <= num; a++) {
			if ((num % a) == 0) {
				System.out.println(a);
			}
		}
		scan.close();
		
		/// 2- 2. int x[]의 약수를 구하고 그중 중복 숫자 제거한 LIST
	    /// 예 > {7, 3, 6, 12 }   > 결과는 [1, 2, 3, 4, 6, 7 , 12]
		
		int[] arrNum= {7,3,6,12};
		
		divisor(arrNum);
		
	}
	
	public static ArrayList<Integer> divisor(int[] num) {
		
		ArrayList<Integer> arrInt = new ArrayList<Integer>();
		ArrayList<Integer> arrIntResult = new ArrayList<Integer>();
		
		for(int i=0; i < num.length; i++) {
			for(int j=1; j<= num[i]; j++) {
				if(num[i]%j == 0) { //인수
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
		Collections.sort(arrIntResult); //오름차순정렬
		System.out.println("After sort arr Reuslt >"+arrIntResult );
		
		return arrIntResult;
	}
}