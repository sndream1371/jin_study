package com.jin.study.tct;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 
 * 입력으로 제공되는 휴면계좌의 정보는 다음과 같다. ※ 동명이인은 없다. ※ 은행이름은 대문자 “A”, “B”, “C” 3개만으로 구성된다.
 * 이름 휴면 계좌번호 은행이름 잔액
[INPUT FILE 내용] - java_input_data.txt

HONG	123-001-2345	A	23000
KIM	03-002-6766	B	14000
PARK	9712341234	C	5400
MOON	12-1234-1234	A	10000
KIM	535-234-2344	A	1200
HONG	2345-2345-234	C	63000
KIM	234-445-452	A	8900


2. 사람의 이름이 입력으로 주어졌을 때 해당 사람의 모든 휴면 계좌를 찾아 그 잔액의 합을 구한다. [입력된 사람이름] KIM
[휴면계좌의 잔액 합계] 14000 + 1200 + 8900 = 24100

3. 은행별 휴면계좌의 잔액 합이 가장 큰 은행의 이름을 검색한다. ※ 은행별 휴면계좌의잔액 합이 동일한 경우는 없다.
A은행의 휴면계좌 잔액 합 : 23000 + 10000 + 1200 + 8900 = 43100 B은행의 휴면계좌 잔액 합 : 14000 C은행의 휴면계좌 잔액 합 : 5400 + 63000 = 68400
[휴면계좌 잔액 합이 가장 큰 은행] C
요구사항
1. 입력으로 제공되는 휴면계좌 정보를 이용하여 “문항설명2”에서 설명한 입력된 사람의 휴면계좌의 잔액 합계를 구하는 기능을 구현하시오
2. 입력으로 제공되는 휴면계좌 정보를 이용하여 “문항설명3”에서 설명한 휴면계좌의 잔액 합이 가장 큰 은행의 이름을 검색하는 기능을 구현하시오.
배점
1. 휴면계좌의 잔액계산 (5점) 2. 휴면계좌의 잔액 합이 가장 큰 은행 검색 (5점)

 */
public class Exercise_02 {

	public static void main(String[] argv) {
		
		System.out.println("account sum :"+personAccountSum("KIM")); //사람의 이름이 입력으로 주어졌을 때 휴면 계좌를 찾아 그 잔액의 합
		System.out.println("bank account sum :"+bankAccountSum());

	}

	//은행별 휴면계좌의 잔액 합이 가장 큰 은행의 이름을 검색
	public static String bankAccountSum() {
		List<String> list = fileReader();
		String [] arrAcc= null;
		HashMap<String, Integer> sum = new HashMap<String,Integer>();
		int sum1=0,sum2=0,sum3=0;
		for(String obj : list) {
			arrAcc = obj.split("\\t");
			if(arrAcc != null) {
				if("A".equals(arrAcc[2])) sum.put(arrAcc[2], sum1 += Integer.parseInt(arrAcc[3]));
				else if("B".equals(arrAcc[2])) sum.put(arrAcc[2], sum2 += Integer.parseInt(arrAcc[3]));
				else if("C".equals(arrAcc[2])) sum.put(arrAcc[2], sum3 += Integer.parseInt(arrAcc[3]));
			}
		}
		
		//Key값으로 Value를 찾는 반복문 -> max값 찾기
		int max=0;
		String maxKey="";
		for (String key : sum.keySet()) {
			Integer value = sum.get(key);
			if(value > max) {
				maxKey = key;
			}
		    System.out.println("Key = " + key + ", Value = " + value);
		}


		//System.out.println("KIM sum >"+sum);
		return maxKey;
	}

	
	//사람의 이름이 입력으로 주어졌을 때 휴면 계좌를 찾아 그 잔액의 합
	public static int personAccountSum(String person) {
		List<String> list = fileReader();
		String [] arrAcc= null;
		int sum=0;
		for(String data: list) {
			arrAcc = data.split("\\t");
			if(arrAcc != null) {
				if(arrAcc[0].equals(person)) sum += Integer.parseInt(arrAcc[3]);
			}
		}
		
		//System.out.println("KIM sum >"+sum);
		return sum;
	}
	
	public static List<String> fileReader() {
		
        //파일 객체 생성
        Path path = Paths.get("C:\\Users\\sndre\\Documents\\TCT_EAD CNS시험\\test_data\\java_input_data.txt");
        
        // 캐릭터셋 지정
        Charset cs = StandardCharsets.UTF_8;
        
        //파일 내용담을 리스트
        List<String> list = new ArrayList<String>();
        
        try{
            list = Files.readAllLines(path,cs);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        //just print
//        for(String readLine : list){
//            System.out.println(readLine);
//        }
        
        return list;

	}
		
	
}
