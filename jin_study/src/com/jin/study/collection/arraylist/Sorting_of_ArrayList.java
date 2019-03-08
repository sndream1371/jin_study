package com.jin.study.collection.arraylist;

import java.util.*;
public class Sorting_of_ArrayList{

	public static void main(String args[]){
	   ArrayList<String> listofcountries = new ArrayList<String>();
	   listofcountries.add("India");
	   listofcountries.add("US");
	   listofcountries.add("China");
	   listofcountries.add("Denmark");
	   listofcountries.add("한국");
	   listofcountries.add("일본");
	   listofcountries.add("미국");
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
	   listofcountries.add("태국");
	   listofcountries.add("가나");
	   listofcountries.add("캐나다333");
	   listofcountries.add("캐나다");
	   
	   /*Unsorted List*/
	   System.out.println("Before Sorting:");
	   for(String counter: listofcountries){
			System.out.println(counter);
		}

	   /* Sort statement*/
	   Collections.sort(listofcountries); //String정렬이 숫자 한글 영문이 섞이면 이상함.(실행화일참고)
	   
	   //Collections.reverse(listofcountries); //역정렬이나 String경우 역정렬이 이상함. 실행결과 참고

	   /* Sorted List*/
	   //The output List will be sorted alphabetically.
	   System.out.println("--------------- After Sorting ---------------");
	   for(String counter: listofcountries){
			System.out.println(counter);
		}
	}
}