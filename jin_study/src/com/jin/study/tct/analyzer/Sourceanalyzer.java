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

	//������
	Sourceanalyzer(){
		
	}
	
	//������
	Sourceanalyzer(String filePath){
		System.out.println("Sourceanalyzer ..  ������");
		
		path = new File(filePath);
	}

	//File�� ������ �о�鿩 List<String>���·� ��ȯ�Ѵ�.
	public List<String> readFile(File file){

		List<String> result = new ArrayList<String>();
		
		try {
			System.out.println("file path >"+file.getAbsolutePath());

			URI fileName = URI.create("file:///"+file.getCanonicalPath().replaceAll("\\\\", "/"));
			
			//�ڹ� 8�� ���������� �д´�.
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
	
	//���⵵�� �м��ϴ� �޼ҵ�(����)
	void analyze(String dirName, String pattern) {
		
		System.out.println("-----------------------------");
		System.out.println("��ü�ҽ�����:"+ getJavaFileCount() );
	}
	
	
	//��ü �ҽ� ������ ��ȯ�ϴ� �޼ҵ�(����)
	int getJavaFileCount() {
		int result=0;
		
		//File path = new File(Filepath); //�����ڷ� ��

		String files[] = path.list();	
		for(int i=0 ; i<files.length ; i++){
			//System.out.println(files[i]);
			result++;
		}
		
		return result;
	}
	
	
	//���� �ҽ� ������ ��ȯ�ϴ� �޼ҵ�(����)
	int getProblemFileCount() {
		int patternCnt=0;
        
        List<String> fileList = new ArrayList<String>();
        
        //file read
		File files[] = path.listFiles(); // list();	
		for(int i=0 ; i<files.length ; i++){
			System.out.println(files[i].getAbsoluteFile());
			fileList = readFile(files[i].getAbsoluteFile());
			
			if( fileList.size() > 0) { //���� ������ �����ϸ�
				
				//List<String>�� �� ���ڿ��� ���Խ� �������� �˻�
				for(int j=0 ; j < fileList.size(); j++) {
					//System.out.println("file list >>"+fileList.get(j));
			    	Pattern p = Pattern.compile("bbb"); //���Խ� ������ ���
					Matcher m = p.matcher(fileList.get(j)); 

					while (m.find()) { //���Ͽ� �´� m ��ó�� �ִٸ�
						//System.out.println(m.group()); //�װͿ� ����
						patternCnt++;
					}
					
				}
			}
		}

    
		return patternCnt;
		
	}

	
	//�ҽ� ��ü Line ���� ��ȭ�� �޼ҵ�
	int getTotalLineCount() {
		int result=0;
		
		return result;
	}
	
	//�˻��� ���ϼ��� ��ȯ�ϴ� �޼ҵ�(����)
	int getPatternCount() {
		int result=0;
		
		return result;
	}
	
	
	
}


