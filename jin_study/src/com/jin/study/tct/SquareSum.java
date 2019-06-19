package com.jin.study.tct;


/*
 * 
 * 제곱의합 : 자연수를 각각 제곱하여 더한것  ex) 1의자승 + 2의자승 + 3의자승 + 4의자승 +5의자승 = 55
 * 
 * 합의제곱 : 자연수를 더한후 그 결과를 제곱한것 ex) (1+2+3+4+5)의 제곱 = 225
 * 
 */
public class SquareSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int input=5;
		
		int output = sumOfSquare(input) - squareOfsum(input);
		System.out.println("1부터 "+input+"까지 제곱의합과 합의제곱의 차에 대한 결과는?"+ output);
	}
	
	//제곱의합
	public static int squareOfsum(int inputNum) {
		int sum = 0;
		
		for(int i = 1  ; i <= inputNum; i++) {
			sum += i*i;
		}
		
		return sum;
	}
	
	//합의제곱
	public static int sumOfSquare(int inputNum) {
		int sum = 0;
		for(int i = 1  ; i <= inputNum; i++) {
			sum += i;
		}
		
		return sum*sum;
	}
	

}
