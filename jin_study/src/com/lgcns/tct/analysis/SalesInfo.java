package com.lgcns.tct.analysis;

public class SalesInfo {

	private int num; // 주문번호
	private String id; // 고객아이디
	private String product; // 주문상품
	private int status; // 상태코드
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @param num
	 * @param id
	 * @param product
	 * @param status
	 */
	public SalesInfo(int num, String id, String product, int status) {
		super();
		this.num = num;
		this.id = id;
		this.product = product;
		this.status = status;
	}

	public SalesInfo() {}

}
