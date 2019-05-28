package com.lgcns.tct.account;

import java.util.Arrays;
import java.util.List;


public class AccountRun {
	
	public static String name;
	
    public static void main(String[] args) {    	
		// 제공 데이터 세트2를 실행하려면 loadData에서 제공 데이터 세트1을 주석 처리하고 제공 데이터 세트2를 주석 해제하여 실행
    	List<AccountInfo> inputData = loadData();  
    	printInput(inputData);
    	Account account = new Account();
    	
    	// 휴면계좌의 잔액 합계를 구하는 기능
    	int totalBalance = account.getTotalBalance(inputData, name);
    	printTotalBalance(totalBalance);
    	
    	// 휴면계좌의 잔액 합이 가장 큰 은행의 이름을 검색하는 기능
    	String bankName = account.getBankName(inputData);
    	printBankName(bankName);
    }

    private static List<AccountInfo> loadData() {
    	
		//////////////////////////////////
		// 제공 데이터 세트 1
		/////////////////////////////////
    	
//    	List<AccountInfo> inputData = Arrays.asList(
//    			new AccountInfo("HONG", "123-001-2345", "A", 23000),
//    			new AccountInfo("KIM", "03-002-6766", "B", 14000),
//    			new AccountInfo("PARK", "09712-003-55432", "C", 5400),
//    			new AccountInfo("MOON", "09143-001-4322", "A", 10000),
//    			new AccountInfo("KIM", "020-001-1998", "A", 1200),
//    			new AccountInfo("HONG", "02267-003-12788", "C", 63000),
//    			new AccountInfo("KIM", "091-001-2511", "A", 8900)
//		);
//    	
//    	name = "KIM";
    		
    	
		//////////////////////////////////
		// 제공 데이터 세트 2
		/////////////////////////////////    	
    	
    	List<AccountInfo> inputData = Arrays.asList(
    			new AccountInfo("JANG", "12-123-1325", "A", 33000),
    			new AccountInfo("HONG", "04-022-1266", "A", 25000),
    			new AccountInfo("JANG", "09-103-4432", "B", 5500),
    			new AccountInfo("RYU", "83-013-3422", "A", 15000),
    			new AccountInfo("RYU", "02-001-1958", "C", 13500),
    			new AccountInfo("MOON", "02-124-1589", "B", 33000),
    			new AccountInfo("KIM", "19-121-2511", "C", 20500)	
		);
		
		name = "RYU";
   	
    	return inputData;
    	
	}    


    private static void printInput(List<AccountInfo> inputData){
        printLineInitial();
        System.out.println("이름\t휴면 계좌번호\t은행이름\t잔액");
        for(AccountInfo accountInfo : inputData){
        	System.out.println(accountInfo.getName() +"\t" + accountInfo.getDormantAccountNum() + "\t" +accountInfo.getBankName() + "\t" + accountInfo.getBalance());
        }
        printLine();
    }
    
    private static void printTotalBalance(int totalBalance) {       	
    	System.out.println("[휴면계좌의 잔액]");
    	System.out.println("[입력된 사람이름]: "+name);
    	System.out.print("[휴면계좌의 잔액 합계]: ");
    	if(totalBalance == 0){
    		System.out.println("결과값이 없습니다.");
    	}else{
    		System.out.println(totalBalance);
    	}
    	printLine();    	
    } 

    
    private static void printBankName(String bankName) {       	
    	System.out.print("[휴면계좌의 잔액 합이 가장 큰 은행]: ");
    	if(bankName == ""){
    		System.out.println("결과값이 없습니다.");
    	}else{
    		System.out.println(bankName);
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

