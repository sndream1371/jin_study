package com.jin.study.tct.denseranking;

public class DenseRankRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] studentPint = {{10210,80},{10211,77},{10212,55},{10213,66},{10214,77},{10215,99},{10216,30},{10217,10}};
		
		DenseRank denseRank = new DenseRank();
		denseRank.rank(studentPint);

	}

}
