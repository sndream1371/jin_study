package com.jin.study.tct.javabasic;

import javax.swing.text.ChangedCharSetException;

/*
 * IP �ּ� �˾ƺ���
 * 
 * 32bit�� IP�ּҸ� �Է����� �޾� 8�ڸ��� ��� 10������ �ٲ� ���
 * 
 * [���࿹��]
 * 11001011100001001110010110000000
 * IP �ּ�: 203.132.229.128
 * 
 * 11001011100001001110010110000000
 * IP �ּ�: 203.132.229.128
 * 
 */
public class IpAddressChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String binary = "11001011100001001110010110000000";
		System.out.println(chageDecimal(binary));
	}
	
	public static String chageDecimal(String input) {

		return Integer.parseInt(input.substring(0,8),2)+"."+Integer.parseInt(input.substring(8,16),2) +"."+Integer.parseInt(input.substring(16,24),2) +"."+Integer.parseInt(input.substring(24,32),2);
		
	}

}
