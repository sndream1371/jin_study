package com.jin.study.collection.arraylist;

import java.util.*;

/*
 * Array to ArrayList conversion(º¯È¯)
 * 
 * 
 */
public class ArrayToArrayList {
	public static void main(String[] args) {

		/* Array Declaration and initialization */
		String citynames[] = { "Agra", "Mysore", "Chandigarh", "Bhopal" };

		/* Array to ArrayList conversion */
		// ArrayList<String> citylist= new ArrayList<String>(Arrays.asList(citynames));
		ArrayList<String> citylist = new ArrayList<String>(Arrays.asList("Agra", "Mysore", "Chandigarh", "Bhopal"));

		/* Adding new elements to the converted List */
		citylist.add("New City2");
		citylist.add("New City3");

		/* Final ArrayList content display using for */
		for (String str : citylist) {
			System.out.println(str);
		}
		
		//---------------------------------------------------------------------------
		// int type Array to ArrayList conversion
		//---------------------------------------------------------------------------
		Integer score[] = {10, 30, 20, 100, 90, 50, 88};
		ArrayList<Integer> scorelist = new ArrayList<Integer>(Arrays.asList(score));
		
		for (Integer scoreValue : scorelist) {
			System.out.println(scoreValue);
		}
	}
}