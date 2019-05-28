package com.lgcns.tct.account;

public class AccountInfo {
	private String name; // 이름
	private String dormantAccountNum; // 휴면 계좌번호
	private String bankName; // 은행 이름
	private int balance; // 잔액
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDormantAccountNum() {
		return dormantAccountNum;
	}

	public void setDormantAccountNum(String dormantAccountNum) {
		this.dormantAccountNum = dormantAccountNum;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * @param name
	 * @param dormantAccountNum
	 * @param bankName
	 * @param balance
	 */
	public AccountInfo(String name, String dormantAccountNum, String bankName, int balance) {
		super();
		this.name = name;
		this.dormantAccountNum = dormantAccountNum;
		this.bankName = bankName;
		this.balance = balance;
	}

	public AccountInfo() {
		// TODO Auto-generated constructor stub
	}

	
	public String toString() {
		return "name ="+name+" bankName="+bankName+" balance="+balance;
	}
}
