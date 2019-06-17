package com.jin.study.arraylist;

/*
 * ArrayList�� �̿��� 2���� �迭 �Է��� ���
 * ArrayList�� �̿��� �������� �������� ������ �Ѵ�.
 * 
 * 
 */
import java.util.*; 
public class Arraylist_2D { 
    public static void main(String[] args) 
    { 
        int n = 3; 
  
        // Here aList is an ArrayList of ArrayLists 
        ArrayList<ArrayList<Integer> > aList = new ArrayList<ArrayList<Integer> >(n); 
  
        // Create n lists one by one and append to the  
        // master list (ArrayList of ArrayList) 
        ArrayList<Integer> a1 = new ArrayList<Integer>(); 
        a1.add(1); 
        a1.add(2); 
        aList.add(a1); 
  
        ArrayList<Integer> a2 = new ArrayList<Integer>(); 
        a2.add(5); 
        aList.add(a2); 
  
        ArrayList<Integer> a3 = new ArrayList<Integer>(); 
        a3.add(10); 
        a3.add(20); 
        a3.add(30); 
        aList.add(a3);
        
        //Collections.sort(a3, new AscendingInteger()); //Integer �������� ����
        
        ArrayList<Integer> a4 = new ArrayList<Integer>(); 
        a4.add(66); 
        a4.add(44); 
        a4.add(33);
        a4.add(22); 
        a4.add(99); 
        a4.add(88);
        aList.add(a4); 
        
        //Collections.sort(a4); //�������� ���� (���ڰ� �����ͺ��� ����)
        Collections.sort(a4, new AscendingInteger()); //Integer �������� ����
  
        for (int i = 0; i < aList.size(); i++) { 
            for (int j = 0; j < aList.get(i).size(); j++) { 
                System.out.print(aList.get(i).get(j) + " "); 
            } 
            System.out.printf("\n"); 
        } 
        
    } 
} 


//ArrayList�� ��������(ū������ �������� ����) Integer���� �����Ѵ�.
class AscendingInteger implements Comparator<Integer> {
	@Override
	public int compare(Integer a, Integer b) {
		return b.compareTo(a);
	}
}

//ArrayList�� ��������(ū������ �������� ����) String���� �����Ѵ�.
class AscendingString implements Comparator<String> {
	@Override
	public int compare(String a, String b) {
		return b.compareTo(a);
	}
}

