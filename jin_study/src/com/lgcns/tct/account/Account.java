package com.lgcns.tct.account;

import java.util.List;

public class Account {	
	
	/**
	 * 휴면계좌의 잔액 합계를 구하는 기능
	 *
     * @param		inputData		List		입력데이터(휴면계좌 정보)
     * @param		name			String		입력데이터(사람이름)
     * @return						int 		휴면계좌의 잔액 합계
	 */
	public int getTotalBalance(List<AccountInfo> inputData, String name) {
		int totalBalance = 0;
		////////////////////////여기부터 구현 (1) ---------------->
		for(AccountInfo data : inputData){
			String account_name = data.getName();
			if(account_name.equals(name)){
				totalBalance = totalBalance + data.getBalance();
			}
		}
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return totalBalance;
	}
	
	/**
	 * 휴면계좌의 잔액 합이 가장 큰 은행의 이름을 검색하는 기능
	 *
     * @param		inputData		List		입력데이터(휴면계좌 정보)
     * @return						String 		휴면계좌의 잔액 합이 가장 큰 은행
	 */
	public String getBankName(List<AccountInfo> inputData) {
		String bankName = "";
		////////////////////////여기부터 구현 (2) ---------------->
		//int[] balances = {0,0,0};
		int[] balances = new int[3];
		
		for(AccountInfo data : inputData){
			String bank = data.getBankName();
			switch(bank){
			case "A":
				balances[0] += data.getBalance();
				break;
			case "B":
				balances[1] += data.getBalance();
				break;
			case "C":
				balances[2] += data.getBalance();
				break;
			}
		}
		
		int max = 0;
		
		for(int i = 0 ; i < balances.length ; i++){
			if(balances[i] > max){
				max = balances[i];
				if(i == 0){
					bankName = "A";
				}else if(i ==1){
					bankName = "B";
				}else{
					bankName = "C";
				}
			}
		}
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return bankName;
	}

}