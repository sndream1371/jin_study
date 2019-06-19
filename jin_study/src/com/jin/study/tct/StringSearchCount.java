package com.jin.study.tct;


/*
 * ���ڿ��� ��ū�� �־����� ���ڿ��� ��ū�� ���Ե� �� Ƚ���� ���ϴ� ���α׷�
 * 
 * ���࿹��
 *  abcdefabcdefabc / abc = 3
 *  cbcbcbc /cbc = 3   <--SPLIT�Լ��� �̿��Ұ�� 2���� ���� (�ߺ� �˻� �Ұ���)
 */
public class StringSearchCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String data = "cbcbcbc"; //���ڿ�
		String inputData ="cbc"; //�Է°�
		
		System.out.println("���ڿ� ���Ե� �Է� ī��Ʈ:"+ wordCount(data,inputData));
		
	}
	
	public static int wordCount(String data,String inputData) {
		char[] arrChar = data.toCharArray();
		int inputCharSize = inputData.length();
		
		String compStr="";
		int cnt=0;
		for(int i=0; i < arrChar.length; i++) {
			
			for(int j=0; j < inputCharSize ; j++) { //�Է°� ���� ���̸�ŭ ���� �ܾ �����. (�Է¹��� 3�ڸ��� 3�ڸ����ڿ� ����)
				
				if(j+i < arrChar.length) {  //���ڿ� ��ü���̸� ������ �ȵǱ� ������
					compStr += arrChar[j + i]; // i�� ���Ѱ� ���� ���ڸ� ������������
				}
			}
			
			if(inputData.equals(compStr)) {
				cnt++;
			}
			
			//System.out.println("count >"+cnt);
			
			compStr=""; //���ҹ��� �ʱ�ȭ
		}
		
		return cnt;
	}

}
