package com.jin.study.tct;


/*
 * 
 * �������� : �ڿ����� ���� �����Ͽ� ���Ѱ�  ex) 1���ڽ� + 2���ڽ� + 3���ڽ� + 4���ڽ� +5���ڽ� = 55
 * 
 * �������� : �ڿ����� ������ �� ����� �����Ѱ� ex) (1+2+3+4+5)�� ���� = 225
 * 
 */
public class SquareSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int input=5;
		
		int output = sumOfSquare(input) - squareOfsum(input);
		System.out.println("1���� "+input+"���� �������հ� ���������� ���� ���� �����?"+ output);
	}
	
	//��������
	public static int squareOfsum(int inputNum) {
		int sum = 0;
		
		for(int i = 1  ; i <= inputNum; i++) {
			sum += i*i;
		}
		
		return sum;
	}
	
	//��������
	public static int sumOfSquare(int inputNum) {
		int sum = 0;
		for(int i = 1  ; i <= inputNum; i++) {
			sum += i;
		}
		
		return sum*sum;
	}
	

}
