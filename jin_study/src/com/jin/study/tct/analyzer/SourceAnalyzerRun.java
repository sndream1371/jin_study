package com.jin.study.tct.analyzer;


public class SourceAnalyzerRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sourceanalyzer sa = new Sourceanalyzer("c:/Test/tct_files/");
		
		System.out.println("-------------Result---------------");
		System.out.println("���� ���� :"+sa.getJavaFileCount() );
		System.out.println("----------------------------------");
		System.out.println("���� ���� :"+sa.getProblemFileCount() );
		System.out.println("----------------------------------");
	}

}
