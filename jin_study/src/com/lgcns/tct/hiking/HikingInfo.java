package com.lgcns.tct.hiking;

public class HikingInfo {
	
	private int topPoint;	// 상위지점
	private int subPoint;   // 하위지점
	
	public int getTopPoint() {
		return topPoint;
	}

	public void setTopPoint(int topPoint) {
		this.topPoint = topPoint;
	}

	public int getSubPoint() {
		return subPoint;
	}

	public void setSubPoint(int subPoint) {
		this.subPoint = subPoint;
	}

	
	/**
	 * @param topPoint
	 * @param subPoint
	 */
	public HikingInfo(int topPoint, int subPoint) {
		super();
		this.topPoint = topPoint;
		this.subPoint = subPoint;
	}

	public HikingInfo() {
		// TODO Auto-generated constructor stub
	}

}
