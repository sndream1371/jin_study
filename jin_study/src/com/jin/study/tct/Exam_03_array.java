package com.jin.study.tct;

import java.util.ArrayList;

public class Exam_03_array {

	public static void main(String[] argv) {
		//���ڿ� a123adfa67ad786a7df67a6df87a6d87f6a78676786 ���Է� ����
		// 3-1 : ���ڿ� �߿��� ���ڸ� �����
        //���� �ִ� ���̸� ���� �ʴ� N *N  LIST ����� 
        //���� �ʰ��� ���ڴ� �ʿ� ����
        //3-2. �� ������� �迭���� ���� ���ڳ��� �پ� ������ 0���� ġȯ �Ұ�
		
		
		String strSample="a122adfa67ad786a7df67a6df87a6d87f6a78676786";
		
	    String onlyNum= strSample.replaceAll("[^0-9]", "");
	    System.out.println("num >"+onlyNum + " leng >"+onlyNum.length());
		
	    ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> arrList = convertStringToArraylist(onlyNum);
	    
	    int charCnt=0;
	    for(int i=0; i < 5; i++) {
	    	matrix.add(new ArrayList());
	    	for(int j = 0; j < 5; j++) {
	    		matrix.get(i).add( arrList.get(charCnt++) ); //N*N LIST ����
	    	}
		}
	    
	    //��Ʈ���� 2�����迭 ����� ����
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
	    		matrix2.get(i).add( arrList2.get(charCnt2++) ); //N*N LIST ����
	    	}
		}
	    //��Ʈ���� 2�����迭 ����� ����
	    ArrayList<ArrayList<Integer>> resultMatrix2 = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < matrix2.size(); i++) {
		    int edgeCount = matrix2.get(i).size();
		    for (int j = 0; j < edgeCount; j++) {
		        //System.out.println("lll >"+matrix2.get(i).get(j));
		    	
		    	//col�� ó�� (�÷��� �¿쿭 ���Ͽ� ������ �ӽ� arrayList�� 0�Է�
		    	resultMatrix2.add(new ArrayList());
		        int nextIdx = j+1, prevIdx = j-1;
		        if(j == 0) { //ù����
		        	if( matrix2.get(i).get(j) == matrix2.get(i).get(nextIdx) ) resultMatrix2.get(i).add(0);
		        	else resultMatrix2.get(i).add(matrix2.get(i).get(j));
		        }else if(j != 0 && j+1 != edgeCount ) { //�߰�����
		        	if( matrix2.get(i).get(j) == matrix2.get(i).get(nextIdx) ) resultMatrix2.get(i).add(0);
		        	else if( matrix2.get(i).get(j) == matrix2.get(i).get(prevIdx) ) resultMatrix2.get(i).add(0);
		        	else resultMatrix2.get(i).add(matrix2.get(i).get(j));
		        }else { //����������
		        	if( matrix2.get(i).get(j) == matrix2.get(i).get(prevIdx) ) resultMatrix2.get(i).add(0);
		        	else resultMatrix2.get(i).add(matrix2.get(i).get(j));
		        }
		        
		        //row�� ó��(row�� ���Ͽ� ������ �ӽ� arrayList 0 �Է�, ��, �̹� 0�� ���� ����ó��)
			    int rowNextIdx = i+1, rowPrevIdx = i-1;
			    if(i == 0) { //row�� ù��° ��
			    	if( resultMatrix2.get(i).get(j) == 0 || matrix2.get(i).get(j) == matrix2.get(rowNextIdx).get(j) ) resultMatrix2.get(i).set(j,0);
		        	else resultMatrix2.get(i).set(j,matrix2.get(i).get(j));
			    }else if(i != 0 && i+1 != matrix2.size() ) { //row�� �߰�° ��
			    	if(  resultMatrix2.get(i).get(j) == 0 || matrix2.get(i).get(j) == matrix2.get(rowNextIdx).get(j) ) resultMatrix2.get(i).set(j,0);
		        	else if(  resultMatrix2.get(i).get(j) == 0 || matrix2.get(i).get(j) == matrix2.get(rowPrevIdx).get(j) ) resultMatrix2.get(i).set(j,0);
		        	else resultMatrix2.get(i).set(j,matrix2.get(i).get(j));
			    }else { //row�� ������ ��
			    	if(  resultMatrix2.get(i).get(j) == 0 || matrix2.get(i).get(j) == matrix2.get(rowPrevIdx).get(j) ) resultMatrix2.get(i).set(j,0);
		        	else resultMatrix2.get(i).set(j,matrix2.get(i).get(j));
			    }
		    }
		    
	
		}
		
	    //������ ���ڰ� ������� ��� ����غ���
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