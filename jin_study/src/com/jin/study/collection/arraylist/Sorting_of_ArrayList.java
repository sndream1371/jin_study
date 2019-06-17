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
	   //Collections.sort(listofcountries); //String정렬이 숫자 한글 영문이 섞이면 이상함.(실행화일참고)
	   
	   Collections.sort(listofcountries, new AscendingString()); //오름차순(큰수부터 작은수로 정렬)

	   /* Sorted List*/
	   //The output List will be sorted alphabetically.
	   System.out.println("--------------- After Sorting ---------------");
	   for(String counter: listofcountries){
			System.out.println(counter);
		}
	}
}

//ArrayList로 내림차순(큰수부터 작은수로 정렬) Integer형을 정렬한다.
class AscendingInteger implements Comparator<Integer> {
	@Override
	public int compare(Integer a, Integer b) {
		return b.compareTo(a);
	}
}

//ArrayList로 내림차순(큰수부터 작은수로 정렬) String형을 정렬한다.
class AscendingString implements Comparator<String> {
	@Override
	public int compare(String a, String b) {
		return b.compareTo(a);
	}
}