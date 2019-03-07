package com.jin.study.collection.arraylist;

import java.util.*;

public class Normal_way_of_ArrayList_initialization {
   public static void main(String args[]) {
	   ArrayList<String> books = new ArrayList<String>();
	   books.add("Java Book1");
	   books.add("Java Book2");
	   books.add("Java Book3");
	  System.out.println("Books stored in array list are: "+books);
	  
	  for(String str:books){
		  System.out.println("book list :"+str);
	  }
   }
}