package com.jin.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMerge {

	public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("a", "a");
        map1.put("b", "b");
        map1.put("c", "c");
        
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("d", "d");
        map2.put("e", "e");
        map2.put("f", "f");
        
        map1.putAll(map2); //¸Ê¿¡ Ãß°¡
        
        System.out.println(map1); //{a=a, b=b, c=c, d=d, e=e, f=f}
        //--List merge-------------------------------------------------------------
        List<String> list1 = new ArrayList<String>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        
        List<String> list2 = new ArrayList<String>();
        list2.add("d");
        list2.add("e");
        list2.add("f");
        
        list1.addAll(list2);
        
        System.out.println(list1); //[a, b, c, d, e, f]

        //-------------------------------------------------------------------------
        Map<String,String> inmap = new HashMap<String,String>();
        
        for(int k=0; k<10; k++) {
        	inmap.put(k+"","value"+k);
        }
        
        List<Map> listmap = new ArrayList<Map>();
        for(int i=0; i<10; i++) {
        	listmap.add(i, inmap);
        }
        System.out.println("listmap >>>"+listmap);

        List<List> listmap2 = new ArrayList<List>();
        for(int i=0; i<5; i++) {
        	listmap2.add(i, listmap);
        }
        System.out.println("listmap 222>>>"+listmap2);        
        
        
        
        List<String> list = new ArrayList<String>();
        for(int i=0; i<20; i++) {
        	list.add("AAA"+i);
        }	
        
        Map<Integer, List> map3 = new HashMap<Integer, List>();
        
        map3.put(1, list);
        
        System.out.println("mpa3 >>"+map3);
    }
}


