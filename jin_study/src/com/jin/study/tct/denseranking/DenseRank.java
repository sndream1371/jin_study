package com.jin.study.tct.denseranking;

import java.util.Arrays;
import java.util.Comparator;

/*
 * �л��������� ������ ���� ������� ��ŷ�� ���ϴ� ���α׷�
 * 
 * ������ ���� ������� ��ŷ�� ���Ѵ�.(������ ��� �״��� ������ �������� �ʴ´�.)
 * ������ ��ŷ �������� �й��� ������������ ���
 * 
 *  * �ذ��� : 2���� array�� sort�� ������
 * 
 * ���� 2���� ������ �ؾ��ϴµ� ������ ����(�ϳ����� ������)
 */
public class DenseRank {

	public static int[][] rank(int [][] input){
		
		int[][] temp = new int[8][3];
		
		System.out.println("--input-------------------");
		printOut(input);
		
		System.out.println("--������ ������ result-------------------");
		sortArrayPoint(input);
		printOut(input);
		
		//��ŷ �߰�
		int i=1;
		for(int row=0; row < input.length; row++){
			temp[row][0] = input[row][0]; //�й�
			temp[row][1] = input[row][1]; //����
			if(row+1 < input.length) { // row+1�� �ؼ� �ش� ������������ ó���ϱ�����
				if(input[row][1] == input[row+1][1]){
					temp[row][2] = i;
				}else {
					temp[row][2] = i++;
				}
			}else {
				temp[row][2] = i++;;
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





