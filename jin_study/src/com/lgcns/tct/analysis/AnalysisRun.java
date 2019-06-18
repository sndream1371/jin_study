package com.lgcns.tct.analysis;

import java.util.Arrays;
import java.util.List;

/*
 * 목록으로 제공되는 상품판매정보 목록을 이용하여 주문취소나 교환이 가장 많은 회원과 상품을 검색하는 프로그램을 작성하시오
 */
public class AnalysisRun {
	
    public static void main(String[] args) {    	
		// 제공 데이터 세트2를 실행하려면 loadData에서 제공 데이터 세트1을 주석 처리하고 제공 데이터 세트2를 주석 해제하여 실행
    	List<SalesInfo> inputData = loadData();  
    	printInput(inputData);
    	Analysis analysis = new Analysis();
    	
    	// 주문취소 비율이 가장 큰 고객 검색 기능
    	String customerId = analysis.getCustomerId(inputData);
    	printCustomerId(customerId);
    	
    	// 주문취소 또는 교환 비율이 40% 이상인 상품 검색 기능
    	List<String> productList = analysis.getProductList(inputData);
    	printProductList(productList);
    	
    }

    private static List<SalesInfo> loadData() {
    	
		//////////////////////////////////
		// 제공 데이터 세트 1
		/////////////////////////////////
    	
    	List<SalesInfo> inputData = Arrays.asList(
    			new SalesInfo(1, "HONG", "P1", 0),
    			new SalesInfo(2, "PARK", "P2", 1),
    			new SalesInfo(3, "KANG", "P1", 2),
    			new SalesInfo(4, "HONG", "P2", 2),
    			new SalesInfo(5, "PARK", "P3", 0),
    			new SalesInfo(6, "HONG", "P3", 1),
    			new SalesInfo(7, "PARK", "P2", 0),
    			new SalesInfo(8, "PARK", "P3", 1),
    			new SalesInfo(9, "SHIN", "P1", 0),
    			new SalesInfo(10, "SHIN", "P2", 2)
		);
    		
    	
		//////////////////////////////////
		// 제공 데이터 세트 2
		/////////////////////////////////    	
    	
    	/*List<SalesInfo> inputData = Arrays.asList(
    			new SalesInfo(1, "PARK", "P1", 2),
    			new SalesInfo(2, "KANG", "P2", 1),
    			new SalesInfo(3, "SHIN", "P2", 2),
    			new SalesInfo(4, "HONG", "P3", 0),
    			new SalesInfo(5, "SHIN", "P3", 1),
    			new SalesInfo(6, "PARK", "P1", 0),
    			new SalesInfo(7, "SHIN", "P1", 1),
    			new SalesInfo(8, "KANG", "P1", 2),
    			new SalesInfo(9, "HONG", "P2", 1),
    			new SalesInfo(10, "HONG", "P2", 2)
		);*/
   	
    	
    	return inputData;
    	
	}    


    private static void printInput(List<SalesInfo> inputData){
        printLineInitial();
        System.out.println("주문번호\t고객아이디\t주문상품\t상태코드");
        for(SalesInfo salesInfo : inputData){
        	System.out.println(salesInfo.getNum()+"\t"+salesInfo.getId()+"\t"+salesInfo.getProduct()+"\t"+salesInfo.getStatus());
        }
        printLine();
    }
    
    private static void printCustomerId(String customerId) {       	
    	System.out.print("[주문취소 비율이 가장 큰 고객]: ");       	    	
    	if(customerId == ""){
    		System.out.println("결과값이 없습니다.");
    	}else{
    		System.out.println(customerId);
    	}
    	printLine();    	
    } 
    
    private static void printProductList(List<String> productList) {       	
    	System.out.println("[주문취소 또는 교환 비율이 40% 이상인 상품]");       	    	
    	if(productList == null){
    		System.out.println("결과값이 없습니다.");
    	}else{
    		for(String product : productList){
    			System.out.print(product+" ");
    		}
    		System.out.println();
    	}
    	printLine();    	
    } 
    

	private static void printLine(){
		System.out.println("------------------------------------------------------------");
	}	
	
	private static void printLineInitial(){
    	System.out.println("[초기 입력 데이터]");
    }
    
    
}

