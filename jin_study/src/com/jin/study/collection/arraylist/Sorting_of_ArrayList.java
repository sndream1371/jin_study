package com.jin.study.collection.arraylist;

import java.util.*;
public class Sorting_of_ArrayList{

	public static void main(String args[]){
	   ArrayList<String> listofcountries = new ArrayList<String>();
	   listofcountries.add("India");
	   listofcountries.add("US");
	   listofcountries.add("China");
	   listofcountries.add("Denmark");
	   listofcountries.add("�ѱ�");
	   listofcountries.add("�Ϻ�");
	   listofcountries.add("�̱�");
	   listofcountries.add("0001");
	   listofcountries.add("001");
	   listofcountries.add("000");
	   listofcountries.add("0");
	   listofcountries.add("00");
	   listofcountries.add("1");
	   listofcountries.add("11");
	   listofcountries.add("111");
	   listofcountries.add("1111");
	   listofcountries.add("2");
	   listofcountries.add("22");
	   listofcountries.add("222");
	   listofcountries.add("2222");
	   listofcountries.add("�±�");
	   listofcountries.add("����");
	   listofcountries.add("ĳ����333");
	   listofcountries.add("ĳ����");
	   
	   /*Unsorted List*/
	   System.out.println("Before Sorting:");
	   for(String counter: listofcountries){
			System.out.println(counter);
		}

	   /* Sort statement*/
	   //Collections.sort(listofcountries); //String������ ���� �ѱ� ������ ���̸� �̻���.(����ȭ������)
	   
	   Collections.sort(listofcountries, new AscendingString()); //��������(ū������ �������� ����)

	   /* Sorted List*/
	   //The output List will be sorted alphabetically.
	   System.out.println("--------------- After Sorting ---------------");
	   for(String counter: listofcountries){
			System.out.println(counter);
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