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
		
		//data file로 읽음
		List<String> listFile = fileReader();
		String arrObj[] = null;
		
		for(String obj : listFile) {
			arrObj = obj.split(" ");
			
			SalesInfo info = new SalesInfo(); //매번 객체를 생성해tj array에 add해야한다.	
			info.setOrderNum( Integer.parseInt(arrObj[0]));
			info.setCustom(arrObj[1]);
			info.setProduct(arrObj[2]);
			info.setStatusCode(arrObj[3]);
			salesInfolist.add(0,info);	
		}
		
		System.out.println("-------------------------------------");
		System.out.println("[주문취소 비율이 가장 큰고객]:"+getCustomerId(salesInfolist));
		System.out.println("-------------------------------------");
		System.out.println("[주문취소 또는 교환 비율이 40% 이상인 상품]:"+getProductList(salesInfolist));
		System.out.println("-------------------------------------");
	}

	/*
	 * 구현 : 주문취소 비율이 가장 큰 고객 검색 기능 . 
	 * 매개변수: List<SalesInfo> inputData 
	 * 입력 데이터(상품판매정보) . 
	 * 리턴: String - 주문취소 비율이 가장 큰 고객
	 * 
	 */
	 public static String getCustomerId(List<SalesInfo> inputData) {
		 String result="";
		 
		 for(int i=0; i <inputData.size(); i++) {
			 for(int k=1; k <inputData.size(); k++) {
				 if(inputData.get(i).getCustom().equals(inputData.get(k).getCustom())) { //고객이름이 같으면
					 if("1".equals(inputData.get(i).getStatusCode())) { //주문취소:1
						result= inputData.get(i).getCustom();
					 }
				 }
			 }
		 }
		 
		 return result;
	 }
	 
	 
	 
	 /*
	  * 구현 : 주문취소 또는 교환 비율이 40% 이상인 상품 검색 기능 . 
	  * 매개변수: List<SalesInfo> inputData 
	  * 입력 데이터(상품판매정보) . 
	  * 리턴: List<String> - 주문취소 또는 교환 비율이 40% 이상인 상품 목록
	  */
	 public static List<String> getProductList(List<SalesInfo> inputData){
		List<String> listResult = new ArrayList<String>();
		
		int prodCount=0, statusCount=0;
		 for(int i=0; i < inputData.size(); i++) {
			 for(int k=1; k <inputData.size(); k++) {
				 System.out.println("i:"+inputData.get(i).getProduct() +" k:"+inputData.get(k).getProduct());
				 if(inputData.get(i).getProduct().equals(inputData.get(k).getProduct())) { //고객이름이 같으면
					 prodCount++;
					 if("1".equals(inputData.get(i).getStatusCode()) || "2".equals(inputData.get(i).getStatusCode())) { //주문취소:1
						 statusCount++;
					 }
				 }
			 }
		 }
		 
		return listResult;
	 }
	 
	 
	public static List<String> fileReader() {
        //파일 객체 생성
        Path path = Paths.get("C:/Users/sndre/Documents/TCT_EAD CNS시험/test_data/java_input_tct_2018_4.txt");
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
        for(String readLine : list){
            System.out.println(readLine);
        }
        
        return list;

	}
		
}
