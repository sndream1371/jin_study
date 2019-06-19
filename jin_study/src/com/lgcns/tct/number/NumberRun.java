package com.lgcns.tct.number;

public class NumberRun {

	public static int digit;
    public static void main(String[] args) {    	
		// 제공 데이터 세트2를 실행하려면 loadData에서 제공 데이터 세트1을 주석 처리하고 제공 데이터 세트2를 주석 해제하여 실행
    	String inputData = loadData();
    	Number number = new Number();
    	
    	// 가장 큰 숫자와 가장 작은 숫자를 제거하는 기능
    	String removedStr = number.getRemovedStr(inputData);
    	printRemovedStr(inputData, removedStr);
    	
    	// 가장 큰 수와 가장 작은 수의 차를 계산하는 기능
    	int difference = number.getDifference(removedStr, digit);
    	printDifference(removedStr, difference);
    }

    private static String loadData() { 
    	
		//////////////////////////////////
		// 제공 데이터 세트 1
		/////////////////////////////////
    	
//    	String inputData = "368581382";
//    	digit = 3;
    	
		//////////////////////////////////
		// 제공 데이터 세트 2
		/////////////////////////////////    	
    	
    	String inputData = "167693923391";
    	digit = 4;
    	
    	return inputData;
	}
    
    
    private static void printRemovedStr(String inputData, String removedStr) {   
    	System.out.println("[가장 큰 숫자와 가장 작은 숫자를 제거한 숫자열] ");
    	System.out.println("[입력]: "+inputData);
    	System.out.print("[출력]: ");
    	if(removedStr == ""){
    		System.out.println("결과값이 없습니다.");
    	}else{    		
    		System.out.println(removedStr);
    	}
    	printLine();      	
    } 
    
    private static void printDifference(String removedStr, int difference) {   
    	System.out.println("[가장 큰 수와 가장 작은 수의 차] ");
    	System.out.println("[자릿수]: "+digit);
    	System.out.print("[입력]: ");
    	if(removedStr == ""){
    		System.out.println("결과값이 없습니다.");
    	}else{    		
    		System.out.println(removedStr);
    	}
    	System.out.print("[출력]: ");
    	if(difference == 0){
    		System.out.println("결과값이 없습니다.");
    	}else{    		
    		System.out.println(difference);
    	}
    	printLine();      	
    } 

	private static void printLine(){
		System.out.println("--------------------------------------------------------------------");
	}  
}

