package com.jin.study.tct;


/*
 * 문자열과 토큰이 주어질때 문자열에 토큰이 포함된 총 횟수를 구하는 프로그램
 * 
 * 실행예시
 *  abcdefabcdefabc / abc = 3
 *  cbcbcbc /cbc = 3   <--SPLIT함수를 이용할경우 2개만 나옴 (중복 검색 불가함)
 */
public class StringSearchCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String data = "cbcbcbc"; //문자열
		String inputData ="cbc"; //입력값
		
		System.out.println("문자열 포함된 입력 카운트:"+ wordCount(data,inputData));
		
	}
	
	public static int wordCount(String data,String inputData) {
		char[] arrChar = data.toCharArray();
		int inputCharSize = inputData.length();
		
		String compStr="";
		int cnt=0;
		for(int i=0; i < arrChar.length; i++) {
			
			for(int j=0; j < inputCharSize ; j++) { //입력값 문자 길이만큼 비교할 단어를 만든다. (입력문자 3자리면 3자리문자열 추출)
				
				if(j+i < arrChar.length) {  //문자열 전체길이를 넘으면 안되기 때문에
					compStr += arrChar[j + i]; // i를 더한건 다음 문자를 가져오기위함
				}
			}
			
			if(inputData.equals(compStr)) {
				cnt++;
			}
			
			//System.out.println("count >"+cnt);
			
			compStr=""; //비교할문자 초기화
		}
		
		return cnt;
	}

}
