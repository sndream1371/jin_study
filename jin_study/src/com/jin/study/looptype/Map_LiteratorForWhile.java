package com.jin.study.looptype;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/*
 * Map�� �̿��� entrySet, keySet ���
 * 
 */
public class Map_LiteratorForWhile {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>(); 
		
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4"); 
		
		// Pattern 1 : entrySet�� �̿��� Enhanced For-Loops
		for( Map.Entry<String, String> elem : map.entrySet() ){ 
			System.out.println( "key : " + elem.getKey() + ", value : " + elem.getValue()); 
		}
		
		// Pattern 2 : keySet�� �̿��� Enhanced For-Loops 
		for( String key : map.keySet() ){
			System.out.println( "key : " + key + ", value : " + map.get(key)); 
		}
	
		//TODO
		// Pattern 3 : Iterator�� �̿��� While-Loops
		Iterator<String> keys = map.keySet().iterator(); 
		while( keys.hasNext() ){ 
			String key = keys.next(); 
			System.out.println( "key : " + key + ", value : " + map.get(key));
		}
	}


}
