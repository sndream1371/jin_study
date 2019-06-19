package com.jin.study.tct.denseranking;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 학생 정보에서 점수가 높음 순서대로 랭킹을 구하는 프로그램
 * 
 * 점수가 높은 순서대로 랭킹을 구한다.(동점일 경우 그다음 순위는 누락되지 않는다.)
 * 동일한 랭킹 내에서는 학번의 오름차순으로 출력
 * 
 * 해결방법 : 2차원 array를 sort를 구현함
 * 
 * 동시 2개의 정렬
 * 
 * 결과
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
--점수로 정렬후 result-------------------

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
--랭킹 추가후 정렬 result-------------------

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
		int[][] temp = new int[input.length][input[0].length+1]; //행-열 순서 (랭크를 추가하기 위해서 +1을 함)
		
		System.out.println("--input-------------------");
		printOut(input);
		
		System.out.println("--점수로 정렬후 result-------------------");
		sortArrayPoint(input);
		printOut(input);
		
		//랭킹 추가
		int rank=1;
		for(int row=0; row < input.length; row++){
			
			temp[row][0] = input[row][0]; //학번
			temp[row][1] = input[row][1]; //점수
			
			if(row+1 < input.length) { // row+1을 해서 해당 범위내에서만 처리하기위함
				if(input[row][1] == input[row+1][1]){
					temp[row][2] = rank;
				}else {
					temp[row][2] = rank++;
				}
			}else {
				temp[row][2] = rank++;
			}
		}
		
		System.out.println("--랭킹 추가후 정렬 result-------------------");
		printOut(temp);		
		
		return temp;
	}
	
	
	//N*N 배열 화면출력
	public static void printOut(int[][] cube) {
		
		System.out.println();
		for(int row=0; row < cube.length; row++){
			for(int col=0; col < cube[row].length; col++){
				System.out.printf("%6s", cube[row][col]);
			}
			System.out.println();
		}
	}
	
    //점수, 학번 순으로 정렬
    public static void sortArrayPoint(int[][] arr)
    {
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                //if( ((Comparable)arr2[0]).compareTo(arr1[0]) < 0 )  // 0번째 학번, 1번째 점수  , 문자열은 compareTo를 이용한다.
            	
            	//System.out.println("arr1[1] :"+arr1[1] +" arr2[1] :"+arr2[1]);
            	int ret=0;
            	if( arr1[1] < arr2[1] ) { //첫번째 정렬 점수로 정렬 오름차순
            		ret = 1;
            	}else if( arr1[1] == arr2[1] ){
            		//System.out.println("arr1[0] >"+arr1[0] +" arr2[0] >"+arr2[0]);
					if (arr1[0] > arr2[0]){ //두번째 정렬 학번으로 정렬 오름차순
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





