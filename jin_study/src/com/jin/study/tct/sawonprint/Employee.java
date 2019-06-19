package com.jin.study.tct.sawonprint;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 사원정보 출력
 * 주어진 정보를 이용하여 사원정보를 출력하는 프로그램
 * 
 * 부서명, 사원번호,사원명으로 구성된 사원정보 출력
 * 출력순서는 부서코드의 오름차순으로 정렬
 * 동일부서의 사원정보는 사원번호의 오름차순으로 정렬
 * 
 * 해결방법 : 2차원 array를 sort를 구현함
 * 
 * 동시 2개의 정렬을 해야하는데 구현을 못함(하나씩만 정렬함)
 * 
[출력결과]
--department-------------------
    10   영업팀
    20   구매팀
    30   개발팀
    40   운영팀
--employee-------------------4
 59545   최선명    10
 23561   박선주    20
 37123   김길동    10
 33777   이기주    30

--Result sort before-------------
   영업팀 59545   최선명    10
   구매팀 23561   박선주    20
   영업팀 37123   김길동    10
   개발팀 33777   이기주    30

--Result sort After-------------------
   영업팀 37123   김길동    10
   영업팀 59545   최선명    10
   구매팀 23561   박선주    20
   개발팀 33777   이기주    30

 */
public class Employee {

	String[][] print(String[][] department, String[][] employee){
		
		String[][] result = new String[4][4]; //[행 row][열 col]
		
		System.out.println("--department-------------------");
		printOut(department);
		
		System.out.println("--employee-------------------"+ employee.length);
		printOut(employee);

		//정보정렬
		for(int row=0; row < employee.length; row++){
			//System.out.println("out >"+employee[row][2]+ " >"+department[row][0]+" >"+departName(employee[row][2],department));
			result[row][0] = departName(employee[row][2],department); //부서명
			result[row][1] = employee[row][0]; //사원번호
			result[row][2] = employee[row][1]; //사원명
			result[row][3] = employee[row][2]; //사원의 부서코드
		}
		
		System.out.println("--Result sort before-------------");
		printOut(result);
		System.out.println("--Result sort After-------------------");
		sortArrayDepart(result); //부서코드정렬 오름차순
		//sortArrayEmpNo(result);  //사원번호 정렬 오름차순
		printOut(result);
		
		return result;
	}
	
	//부서코드입력 -> 부서명 리턴
	String departName(String deptCd,String[][] deptArr) {
		
		String result="";
		for(int row=0; row < deptArr.length; row++){
			if( deptCd.equals(deptArr[row][0]) ){
				result=deptArr[row][1];
			}
		}
		
		return result;
	}
	
	//N*N 배열 출력
	public void printOut(String[][] cube) {
		
		System.out.println();
		for(int row=0; row < cube.length; row++){
			for(int col=0; col < cube[row].length; col++){
				System.out.printf("%6s", cube[row][col]);
			}
			System.out.println();
		}
	}
	
	   //부서코드 정렬
	   public void sortArrayDepart(String[][] arr)
	    {
	        Arrays.sort(arr, new Comparator<String[]>() {
	            public int compare(String[] arr1, String[] arr2) {
	            	
                                                                        //A.compareTo(B) 일 때 A<B 인 경우는 음수를 리턴하고, A=B일 때는 0을 리턴하고, A>B일 때 양수를 리턴한다
	                if( ((Comparable)arr2[3]).compareTo(arr1[3]) < 0 ){  //부서코드로 정렬  <- arr2 , arr1 위치를 바꾸면 asc, desc 가된다.  
	                    return 1;
	                }
	                else if( ((Comparable)arr2[3]).compareTo(arr1[3]) == 0 ){
	                	if( ((Comparable)arr2[1]).compareTo(arr1[1]) < 0 ) return 1; //사원번호로 비교 정렬
	                	else return -1;
	                }
	                else { 
	                	return -1;
	                }
	            }
	        });
	    }

	   //사원번호 정렬
	   public void sortArrayEmpNo(String[][] arr)
	    {
	        Arrays.sort(arr, new Comparator<String[]>() {
	            public int compare(String[] arr1, String[] arr2) {
	                if( ((Comparable)arr1[1]).compareTo(arr2[1]) < 0 )  //사원번호 정렬
	                    return 1;
	                else
	                    return -1;
	            }
	        });
	    }


}





