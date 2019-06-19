package com.jin.study.tct.sawonprint;

import java.util.Arrays;
import java.util.Comparator;

/*
 * ������� ���
 * �־��� ������ �̿��Ͽ� ��������� ����ϴ� ���α׷�
 * 
 * �μ���, �����ȣ,��������� ������ ������� ���
 * ��¼����� �μ��ڵ��� ������������ ����
 * ���Ϻμ��� ��������� �����ȣ�� ������������ ����
 * 
 * �ذ��� : 2���� array�� sort�� ������
 * 
 * ���� 2���� ������ �ؾ��ϴµ� ������ ����(�ϳ����� ������)
 * 
[��°��]
--department-------------------
    10   ������
    20   ������
    30   ������
    40   ���
--employee-------------------4
 59545   �ּ���    10
 23561   �ڼ���    20
 37123   ��浿    10
 33777   �̱���    30

--Result sort before-------------
   ������ 59545   �ּ���    10
   ������ 23561   �ڼ���    20
   ������ 37123   ��浿    10
   ������ 33777   �̱���    30

--Result sort After-------------------
   ������ 37123   ��浿    10
   ������ 59545   �ּ���    10
   ������ 23561   �ڼ���    20
   ������ 33777   �̱���    30

 */
public class Employee {

	String[][] print(String[][] department, String[][] employee){
		
		String[][] result = new String[4][4]; //[�� row][�� col]
		
		System.out.println("--department-------------------");
		printOut(department);
		
		System.out.println("--employee-------------------"+ employee.length);
		printOut(employee);

		//��������
		for(int row=0; row < employee.length; row++){
			//System.out.println("out >"+employee[row][2]+ " >"+department[row][0]+" >"+departName(employee[row][2],department));
			result[row][0] = departName(employee[row][2],department); //�μ���
			result[row][1] = employee[row][0]; //�����ȣ
			result[row][2] = employee[row][1]; //�����
			result[row][3] = employee[row][2]; //����� �μ��ڵ�
		}
		
		System.out.println("--Result sort before-------------");
		printOut(result);
		System.out.println("--Result sort After-------------------");
		sortArrayDepart(result); //�μ��ڵ����� ��������
		//sortArrayEmpNo(result);  //�����ȣ ���� ��������
		printOut(result);
		
		return result;
	}
	
	//�μ��ڵ��Է� -> �μ��� ����
	String departName(String deptCd,String[][] deptArr) {
		
		String result="";
		for(int row=0; row < deptArr.length; row++){
			if( deptCd.equals(deptArr[row][0]) ){
				result=deptArr[row][1];
			}
		}
		
		return result;
	}
	
	//N*N �迭 ���
	public void printOut(String[][] cube) {
		
		System.out.println();
		for(int row=0; row < cube.length; row++){
			for(int col=0; col < cube[row].length; col++){
				System.out.printf("%6s", cube[row][col]);
			}
			System.out.println();
		}
	}
	
	   //�μ��ڵ� ����
	   public void sortArrayDepart(String[][] arr)
	    {
	        Arrays.sort(arr, new Comparator<String[]>() {
	            public int compare(String[] arr1, String[] arr2) {
	            	
                                                                        //A.compareTo(B) �� �� A<B �� ���� ������ �����ϰ�, A=B�� ���� 0�� �����ϰ�, A>B�� �� ����� �����Ѵ�
	                if( ((Comparable)arr2[3]).compareTo(arr1[3]) < 0 ){  //�μ��ڵ�� ����  <- arr2 , arr1 ��ġ�� �ٲٸ� asc, desc ���ȴ�.  
	                    return 1;
	                }
	                else if( ((Comparable)arr2[3]).compareTo(arr1[3]) == 0 ){
	                	if( ((Comparable)arr2[1]).compareTo(arr1[1]) < 0 ) return 1; //�����ȣ�� �� ����
	                	else return -1;
	                }
	                else { 
	                	return -1;
	                }
	            }
	        });
	    }

	   //�����ȣ ����
	   public void sortArrayEmpNo(String[][] arr)
	    {
	        Arrays.sort(arr, new Comparator<String[]>() {
	            public int compare(String[] arr1, String[] arr2) {
	                if( ((Comparable)arr1[1]).compareTo(arr2[1]) < 0 )  //�����ȣ ����
	                    return 1;
	                else
	                    return -1;
	            }
	        });
	    }


}





