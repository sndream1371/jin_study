package com.jin.study.tct;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.jin.study.tct.model.SalesInfo;

public class Analysis {

	public static void main(String[] args) {

		List<SalesInfo> salesInfolist = new ArrayList<SalesInfo>();
		
		//data file�� ����
		List<String> listFile = fileReader();
		String arrObj[] = null;
		
		for(String obj : listFile) {
			arrObj = obj.split(" ");
			
			SalesInfo info = new SalesInfo(); //�Ź� ��ü�� ������tj array�� add�ؾ��Ѵ�.	
			info.setOrderNum( Integer.parseInt(arrObj[0]));
			info.setCustom(arrObj[1]);
			info.setProduct(arrObj[2]);
			info.setStatusCode(arrObj[3]);
			salesInfolist.add(0,info);	
		}
		
		System.out.println("-------------------------------------");
		System.out.println("[�ֹ���� ������ ���� ū��]:"+getCustomerId(salesInfolist));
		System.out.println("-------------------------------------");
		System.out.println("[�ֹ���� �Ǵ� ��ȯ ������ 40% �̻��� ��ǰ]:"+getProductList(salesInfolist));
		System.out.println("-------------------------------------");
	}

	/*
	 * ���� : �ֹ���� ������ ���� ū �� �˻� ��� . 
	 * �Ű�����: List<SalesInfo> inputData 
	 * �Է� ������(��ǰ�Ǹ�����) . 
	 * ����: String - �ֹ���� ������ ���� ū ��
	 * 
	 */
	 public static String getCustomerId(List<SalesInfo> inputData) {
		 String result="";
		 
		 for(int i=0; i <inputData.size(); i++) {
			 for(int k=1; k <inputData.size(); k++) {
				 if(inputData.get(i).getCustom().equals(inputData.get(k).getCustom())) { //���̸��� ������
					 if("1".equals(inputData.get(i).getStatusCode())) { //�ֹ����:1
						result= inputData.get(i).getCustom();
					 }
				 }
			 }
		 }
		 
		 return result;
	 }
	 
	 
	 
	 /*
	  * ���� : �ֹ���� �Ǵ� ��ȯ ������ 40% �̻��� ��ǰ �˻� ��� . 
	  * �Ű�����: List<SalesInfo> inputData 
	  * �Է� ������(��ǰ�Ǹ�����) . 
	  * ����: List<String> - �ֹ���� �Ǵ� ��ȯ ������ 40% �̻��� ��ǰ ���
	  */
	 public static List<String> getProductList(List<SalesInfo> inputData){
		List<String> listResult = new ArrayList<String>();
		
		int prodCount=0, statusCount=0;
		 for(int i=0; i < inputData.size(); i++) {
			 for(int k=1; k <inputData.size(); k++) {
				 System.out.println("i:"+inputData.get(i).getProduct() +" k:"+inputData.get(k).getProduct());
				 if(inputData.get(i).getProduct().equals(inputData.get(k).getProduct())) { //���̸��� ������
					 prodCount++;
					 if("1".equals(inputData.get(i).getStatusCode()) || "2".equals(inputData.get(i).getStatusCode())) { //�ֹ����:1
						 statusCount++;
					 }
				 }
			 }
		 }
		 
		return listResult;
	 }
	 
	 
	public static List<String> fileReader() {
        //���� ��ü ����
        Path path = Paths.get("C:/Users/sndre/Documents/TCT_EAD CNS����/test_data/java_input_tct_2018_4.txt");
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
