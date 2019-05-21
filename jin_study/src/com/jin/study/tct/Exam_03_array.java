package com.jin.study.tct;

import java.util.ArrayList;

public class Exam_03_array {

	public static void main(String[] argv) {
		//문자열 a123adfa67ad786a7df67a6df87a6d87f6a78676786 를입력 받음
		// 3-1 : 문자열 중에서 숫자만 남길것
        //숫자 최대 길이를 넘지 않는 N *N  LIST 만들것 
        //길이 초과된 숫자는 필요 없음
        //3-2. 위 만들어진 배열에서 같은 숫자끼리 붙어 있으면 0으로 치환 할것
		
		
		String strSample="a122adfa67ad786a7df67a6df87a6d87f6a78676786";
		
	    String onlyNum= strSample.replaceAll("[^0-9]", "");
	    System.out.println("num >"+onlyNum + " leng >"+onlyNum.length());
		
	    ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> arrList = convertStringToArraylist(onlyNum);
	    
	    int charCnt=0;
	    for(int i=0; i < 5; i++) {
	    	matrix.add(new ArrayList());
	    	for(int j = 0; j < 5; j++) {
	    		matrix.get(i).add( arrList.get(charCnt++) ); //N*N LIST 생헝
	    	}
		}
	    
	    //매트릭스 2차월배열 출력해 보기
		for (int i = 0; i < matrix.size(); i++) {
		    int edgeCount = matrix.get(i).size();
		    for (int j = 0; j < edgeCount; j++) {
		        Integer endVertex = matrix.get(i).get(j);
		        //System.out.printf("Vertex %d is connected to vertex %d%n", startVertex, endVertex);
		        System.out.printf(i +" " + j+"=[%d] ", endVertex);
		    }
		    System.out.printf("\n");
		}
		System.out.println("-----------------------------------------");
	    
		ArrayList<ArrayList<Integer>> matrix2 = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> arrList2 = convertStringToArraylist(onlyNum);
	    int charCnt2=0;
	    for(int i=0; i < 5; i++) {
	    	matrix2.add(new ArrayList());
	    	for(int j = 0; j < 5; j++) {
	    		matrix2.get(i).add( arrList2.get(charCnt2++) ); //N*N LIST 생헝
	    	}
		}
	    //매트릭스 2차월배열 출력해 보기
	    ArrayList<ArrayList<Integer>> resultMatrix2 = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < matrix2.size(); i++) {
		    int edgeCount = matrix2.get(i).size();
		    for (int j = 0; j < edgeCount; j++) {
		        //System.out.println("lll >"+matrix2.get(i).get(j));
		    	
		    	//col열 처리 (컬럼의 좌우열 비교하여 같으면 임시 arrayList에 0입력
		    	resultMatrix2.add(new ArrayList());
		        int nextIdx = j+1, prevIdx = j-1;
		        if(j == 0) { //첫인자
		        	if( matrix2.get(i).get(j) == matrix2.get(i).get(nextIdx) ) resultMatrix2.get(i).add(0);
		        	else resultMatrix2.get(i).add(matrix2.get(i).get(j));
		        }else if(j != 0 && j+1 != edgeCount ) { //중간인자
		        	if( matrix2.get(i).get(j) == matrix2.get(i).get(nextIdx) ) resultMatrix2.get(i).add(0);
		        	else if( matrix2.get(i).get(j) == matrix2.get(i).get(prevIdx) ) resultMatrix2.get(i).add(0);
		        	else resultMatrix2.get(i).add(matrix2.get(i).get(j));
		        }else { //마지막인자
		        	if( matrix2.get(i).get(j) == matrix2.get(i).get(prevIdx) ) resultMatrix2.get(i).add(0);
		        	else resultMatrix2.get(i).add(matrix2.get(i).get(j));
		        }
		        
		        //row열 처리(row열 비교하여 같으면 임시 arrayList 0 입력, 단, 이미 0인 값은 제외처리)
			    int rowNextIdx = i+1, rowPrevIdx = i-1;
			    if(i == 0) { //row의 첫번째 열
			    	if( resultMatrix2.get(i).get(j) == 0 || matrix2.get(i).get(j) == matrix2.get(rowNextIdx).get(j) ) resultMatrix2.get(i).set(j,0);
		        	else resultMatrix2.get(i).set(j,matrix2.get(i).get(j));
			    }else if(i != 0 && i+1 != matrix2.size() ) { //row의 중간째 열
			    	if(  resultMatrix2.get(i).get(j) == 0 || matrix2.get(i).get(j) == matrix2.get(rowNextIdx).get(j) ) resultMatrix2.get(i).set(j,0);
		        	else if(  resultMatrix2.get(i).get(j) == 0 || matrix2.get(i).get(j) == matrix2.get(rowPrevIdx).get(j) ) resultMatrix2.get(i).set(j,0);
		        	else resultMatrix2.get(i).set(j,matrix2.get(i).get(j));
			    }else { //row의 마지막 열
			    	if(  resultMatrix2.get(i).get(j) == 0 || matrix2.get(i).get(j) == matrix2.get(rowPrevIdx).get(j) ) resultMatrix2.get(i).set(j,0);
		        	else resultMatrix2.get(i).set(j,matrix2.get(i).get(j));
			    }
		    }
		    
	
		}
		
	    //인접한 인자가 같을경우 결과 출력해보기
		for (int i = 0; i < resultMatrix2.size(); i++) {
		    int edgeCount = resultMatrix2.get(i).size();
		    for (int j = 0; j < edgeCount; j++) {
		        Integer endVertex = resultMatrix2.get(i).get(j);
		        System.out.printf(i +"," + j+"=[%d] ", endVertex);
		    }
		    System.out.printf("\n");
		}
		
	    
	    
	}
	
	public static ArrayList<Integer> convertStringToArraylist(String str) {
	    ArrayList<Integer> charList = new ArrayList<Integer>();      
	    for(int i = 0; i<str.length();i++){
	        charList.add( Integer.parseInt(str.charAt(i)+""));
	    }
	    return charList;
	}
	
}