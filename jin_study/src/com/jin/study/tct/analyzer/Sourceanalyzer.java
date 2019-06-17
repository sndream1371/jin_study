package com.jin.study.tct.analyzer;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sourceanalyzer {
	
	File path = null;

	//생성자
	Sourceanalyzer(){
		
	}
	
	//생성자
	Sourceanalyzer(String filePath){
		System.out.println("Sourceanalyzer ..  생성자");
		
		path = new File(filePath);
	}

	//File로 정보를 읽어들여 List<String>형태로 반환한다.
	public List<String> readFile(File file){

		List<String> result = new ArrayList<String>();
		
		try {
			System.out.println("file path >"+file.getAbsolutePath());

			URI fileName = URI.create("file:///"+file.getCanonicalPath().replaceAll("\\\\", "/"));
			
			//자바 8로 파일정보를 읽는다.
			try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
				result = lines.collect(Collectors.toList());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		System.out.println("file content start========================================");
//		System.out.println(result);
//		System.out.println("file content end========================================");
		
		return result;
	}
	
	//영향도를 분석하는 메소드(구현)
	void analyze(String dirName, String pattern) {
		
		System.out.println("-----------------------------");
		System.out.println("전체소스갯수:"+ getJavaFileCount() );
	}
	
	
	//전체 소스 개수를 반환하는 메소드(구현)
	int getJavaFileCount() {
		int result=0;
		
		//File path = new File(Filepath); //생성자로 뺌

		String files[] = path.list();	
		for(int i=0 ; i<files.length ; i++){
			//System.out.println(files[i]);
			result++;
		}
		
		return result;
	}
	
	
	//문제 소스 개수를 반환하는 메소드(구현)
	int getProblemFileCount() {
		int patternCnt=0;
        
        List<String> fileList = new ArrayList<String>();
        
        //file read
		File files[] = path.listFiles(); // list();	
		for(int i=0 ; i<files.length ; i++){
			System.out.println(files[i].getAbsoluteFile());
			fileList = readFile(files[i].getAbsoluteFile());
			
			if( fileList.size() > 0) { //파일 내용이 존재하면
				
				//List<String>에 들어가 문자열을 정규식 패턴으로 검색
				for(int j=0 ; j < fileList.size(); j++) {
					//System.out.println("file list >>"+fileList.get(j));
			    	Pattern p = Pattern.compile("bbb"); //정규식 패턴을 담고
					Matcher m = p.matcher(fileList.get(j)); 

					while (m.find()) { //패턴에 맞는 m 매처가 있다면
						//System.out.println(m.group()); //그것에 접근
						patternCnt++;
					}
					
				}
			}
		}

    
		return patternCnt;
		
	}

	
	//소스 전체 Line 수를 반화는 메소드
	int getTotalLineCount() {
		int result=0;
		
		return result;
	}
	
	//검색된 패턴수를 반환하는 메소드(구현)
	int getPatternCount() {
		int result=0;
		
		return result;
	}
	
	
	
}


