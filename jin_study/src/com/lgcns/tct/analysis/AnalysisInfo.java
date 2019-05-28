package com.lgcns.tct.analysis;

public class AnalysisInfo {
	private double confirmCount = 0;
	private double cancleCount = 0;
	private double changeCount = 0;
	private double totalCount = 0;
	
	
	public AnalysisInfo() {
		super();
		// TODO Auto-generated constructor stub
		this.confirmCount = 0;
		this.cancleCount = 0;
		this.changeCount = 0;
		this.totalCount = 0;
	}


	public double getConfirmCount() {
		return confirmCount;
	}


	public void setConfirmCount(double confirmCount) {
		this.confirmCount = confirmCount;
	}


	public double getCancleCount() {
		return cancleCount;
	}


	public void setCancleCount(double cancleCount) {
		this.cancleCount = cancleCount;
	}


	public double getChangeCount() {
		return changeCount;
	}


	public void setChangeCount(double changeCount) {
		this.changeCount = changeCount;
	}


	public double getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(double totalCount) {
		this.totalCount = totalCount;
	}
	
	
	
	
}
