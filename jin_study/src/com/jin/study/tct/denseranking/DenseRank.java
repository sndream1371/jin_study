package com.jin.study.tct.denseranking;

import java.util.Arrays;
import java.util.Comparator;

/*
 * �л� �������� ������ ���� ������� ��ŷ�� ���ϴ� ���α׷�
 * 
 * ������ ���� ������� ��ŷ�� ���Ѵ�.(������ ��� �״��� ������ �������� �ʴ´�.)
 * ������ ��ŷ �������� �й��� ������������ ���
 * 
 * �ذ��� : 2���� array�� sort�� ������
 * 
 * ���� 2���� ����
 * 
 * ���
 * 
 * --input-------------------

 10210    80
 10211    77
 10212    55
 10213    66
 10214    77
 10213    77
 10212    77
 10215    99
 10216    30
 10217    10
--������ ������ result-------------------

 10215    99
 10210    80
 10211    77
 10212    77
 10213    77
 10214    77
 10213    66
 10212    55
 10216    30
 10217    10
--��ŷ �߰��� ���� result-------------------

 10215    99     1
 10210    80     2
 10211    77     3
 10212    77     3
 10213    77     3
 10214    77     3
 10213    66     4
 10212    55     5
 10216    30     6
 10217    10     7

*/

public class DenseRank {

	public static int[][] rank(int [][] input){
		
		//System.out.println("input.length >"+input.length +" input[0].length >"+input[0].length);
		int[][] temp = new int[input.length][input[0].length+1]; //��-�� ���� (��ũ�� �߰��ϱ� ���ؼ� +1�� ��)
		
		System.out.println("--input-------------------");
		printOut(input);
		
		System.out.println("--������ ������ result-------------------");
		sortArrayPoint(input);
		printOut(input);
		
		//��ŷ �߰�
		int rank=1;
		for(int row=0; row < input.length; row++){
			
			temp[row][0] = input[row][0]; //�й�
			temp[row][1] = input[row][1]; //����
			
			if(row+1 < input.length) { // row+1�� �ؼ� �ش� ������������ ó���ϱ�����
				if(input[row][1] == input[row+1][1]){
					temp[row][2] = rank;
				}else {
					temp[row][2] = rank++;
				}
			}else {
				temp[row][2] = rank++;
			}
		}
		
		System.out.println("--��ŷ �߰��� ���� result-------------------");
		printOut(temp);		
		
		return temp;
	}
	
	
	//N*N �迭 ȭ�����
	public static void printOut(int[][] cube) {
		
		System.out.println();
		for(int row=0; row < cube.length; row++){
			for(int col=0; col < cube[row].length; col++){
				System.out.printf("%6s", cube[row][col]);
			}
			System.out.println();
		}
	}
	
    //����, �й� ������ ����
    public static void sortArrayPoint(int[][] arr)
    {
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                //if( ((Comparable)arr2[0]).compareTo(arr1[0]) < 0 )  // 0��° �й�, 1��° ����  , ���ڿ��� compareTo�� �̿��Ѵ�.
            	
            	//System.out.println("arr1[1] :"+arr1[1] +" arr2[1] :"+arr2[1]);
            	int ret=0;
            	if( arr1[1] < arr2[1] ) { //ù��° ���� ������ ���� ��������
            		ret = 1;
            	}else if( arr1[1] == arr2[1] ){
            		//System.out.println("arr1[0] >"+arr1[0] +" arr2[0] >"+arr2[0]);
					if (arr1[0] > arr2[0]){ //�ι�° ���� �й����� ���� ��������
						ret = 1;
					}else {
						ret = -1;
					}
					
				}else {
					ret = -1;
				}

				return ret;
            }               
        });
    }

	   


}





