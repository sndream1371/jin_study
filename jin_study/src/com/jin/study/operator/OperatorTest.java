package com.jin.study.operator;

public class OperatorTest {

	public static void main(String[] argv) {
		int a = 10;
		boolean b = false;
		if ((b == true) || (a++ == 10)) {  //���ǹ��� ���ϰ��� 1�����Ѵ�.
			System.out.println("Equal " + a);
		} else {
			System.out.println("Not equal! " + a);
		}
	}
}
