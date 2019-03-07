package com.jin.study.objects;

import java.util.Objects;

public class objectTest {

	public static void main(String[] args) {
	
		try {
		
			String strnull = null;
			String strspace = "";
			String strblank = " ";
			
			System.out.println("strnull ..>"+ Objects.toString(strnull)+"<");
			System.out.println("strspace ..>"+ Objects.toString(strspace)+"<");
			System.out.println("strblank ..>"+ Objects.toString(strblank)+"<");
			
			//Objects는 null일경우만 2번째 파라미터 리턴한다.
			System.out.println("strnull .2.>"+ Objects.toString(strnull,"second parameter val")+"<");
			System.out.println("strspace .2.>"+ Objects.toString(strspace,"second parameter val")+"<");
			System.out.println("strblank .2.>"+ Objects.toString(strblank,"second parameter val")+"<");
			
			if( Objects.isNull(strnull)) {
				System.out.println("strnull is null");
			}
			
			// "" 는 null이 아니다.
			if( Objects.isNull(strspace)) {
				System.out.println("strspace is null");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}

}
