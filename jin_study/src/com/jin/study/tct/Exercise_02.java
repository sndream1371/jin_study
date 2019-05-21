package com.jin.study.tct;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 * 
 * �Է����� �����Ǵ� �޸������ ������ ������ ����. �� ���������� ����. �� �����̸��� �빮�� ��A��, ��B��, ��C�� 3�������� �����ȴ�.
 * �̸� �޸� ���¹�ȣ �����̸� �ܾ�
 *  HONG 123-001-2345 A 23000 
 *  KIM 03-002-6766 B 14000
 *  PARK 09712-003-55432 C 5400 
 *  MOON 09143-001-4322 A 10000
    KIM 020-001-1998 A 1200 
    HONG 02267-003-12788 C 63000
     KIM 091-001-2511 A 8900


2. ����� �̸��� �Է����� �־����� �� �ش� ����� ��� �޸� ���¸� ã�� �� �ܾ��� ���� ���Ѵ�. [�Էµ� ����̸�] KIM
[�޸������ �ܾ� �հ�] 14000 + 1200 + 8900 = 24100
3. ���ະ �޸������ �ܾ� ���� ���� ū ������ �̸��� �˻��Ѵ�. �� ���ະ �޸�������ܾ� ���� ������ ���� ����.
A������ �޸���� �ܾ� �� : 23000 + 10000 + 1200 + 8900 = 43100 B������ �޸���� �ܾ� �� : 14000 C������ �޸���� �ܾ� �� : 5400 + 63000 = 68400
[�޸���� �ܾ� ���� ���� ū ����] C
�䱸����
1. �Է����� �����Ǵ� �޸���� ������ �̿��Ͽ� �����׼���2������ ������ �Էµ� ����� �޸������ �ܾ� �հ踦 ���ϴ� ����� �����Ͻÿ�
2. �Է����� �����Ǵ� �޸���� ������ �̿��Ͽ� �����׼���3������ ������ �޸������ �ܾ� ���� ���� ū ������ �̸��� �˻��ϴ� ����� �����Ͻÿ�.
����
1. �޸������ �ܾװ�� (5��) 2. �޸������ �ܾ� ���� ���� ū ���� �˻� (5��)

 */
public class Exercise_02 {

	public static void main(String[] argv) {
		
		System.out.println("account sum :"+accSum());
		System.out.println("bank account sum :"+bankAccountSum());

	}

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
		
		//Key������ Value�� ã�� �ݺ��� -> max�� ã��
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

	
	public static int accSum() {
		List<String> list = fileReader();
		String [] arrAcc= null;
		int sum=0;
		for(String obj : list) {
			arrAcc = obj.split("\\t");
			if(arrAcc != null) {
				if(arrAcc[0].equals("KIM")) sum += Integer.parseInt(arrAcc[3]);
			}
		}
		
		//System.out.println("KIM sum >"+sum);
		return sum;
	}
	
	public static List<String> fileReader() {
        //���� ��ü ����
        Path path = Paths.get("C:\\Users\\sndre\\Documents\\TCT_EAD CNS����\\test_data\\java_input_data.txt");
        // ĳ���ͼ� ����
        Charset cs = StandardCharsets.UTF_8;
        //���� ������� ����Ʈ
        List<String> list = new ArrayList<String>();
        try{
            list = Files.readAllLines(path,cs);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        //just print
        for(String readLine : list){
            System.out.println(readLine);
        }
        
        return list;

	}
		
	
}
