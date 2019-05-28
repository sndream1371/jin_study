package com.lgcns.tct.hiking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HikingRun {

	public static HashMap<Integer, Integer> personInfo;
	
    public static void main(String[] args) {    	
		// 제공 데이터 세트2를 실행하려면 loadData에서 제공 데이터 세트1을 주석 처리하고 제공 데이터 세트2를 주석 해제하여 실행
    	List<HikingInfo> inputData = loadData();
    	Hiking hiking = new Hiking();
    	
    	// 고립된 인원수를 구하는 기능
    	int numberOfPeopleIsolated = hiking.getNumberOfPeopleIsolated(inputData, personInfo);
    	printNumberOfPeopleIsolated(numberOfPeopleIsolated);
    	
    	// 유실된 등산로를 구하는 기능
    	List<HikingInfo> lostHikingTrail = hiking.getLostHikingTrail(inputData);
    	printLostHikingTrail(lostHikingTrail);
    }

    private static List<HikingInfo> loadData() {
    	
    	
		//////////////////////////////////
		// 제공 데이터 세트 1
		/////////////////////////////////
    	
    	List<HikingInfo> inputData = Arrays.asList(
    			new HikingInfo(1, 0),
    			new HikingInfo(1, 3),
    			new HikingInfo(1, 4),
    			new HikingInfo(2, 5),
    			new HikingInfo(2, 6),
    			new HikingInfo(3, 7),
    			new HikingInfo(3, 0),
    			new HikingInfo(4, 9),
    			new HikingInfo(5, 10),
    			new HikingInfo(6, 11),
    			new HikingInfo(6, 12),
    			new HikingInfo(7, 13),
    			new HikingInfo(8, 14),
    			new HikingInfo(9, 0),
    			new HikingInfo(10, -1),
    			new HikingInfo(11, -1),
    			new HikingInfo(12, -1),
    			new HikingInfo(12, -1),
    			new HikingInfo(13, -1),
    			new HikingInfo(14, -1),
    			new HikingInfo(15, -1)
		);
    	
    	{
    		personInfo = new HashMap<Integer, Integer>();
    		personInfo.put(1, 10);
    		personInfo.put(2, 8);
    		personInfo.put(3, 7);
    		personInfo.put(4, 5);
    		personInfo.put(5, 11);
    		personInfo.put(6, 9);
    		personInfo.put(7, 2);
    		personInfo.put(8, 5);
    		personInfo.put(9, 6);
    	}
    	
		//////////////////////////////////
		// 제공 데이터 세트 2
		/////////////////////////////////
    	/*
    	List<HikingInfo> inputData = Arrays.asList(
    			new HikingInfo(1, 0),
                new HikingInfo(1, 3),
                new HikingInfo(1, 4),
                new HikingInfo(2, 5),
                new HikingInfo(2, 6),
                new HikingInfo(3, 7),
                new HikingInfo(3, 8),
                new HikingInfo(4, 0),
                new HikingInfo(4, 10),
                new HikingInfo(5, 11),
                new HikingInfo(5, 12),
                new HikingInfo(6, 13),
                new HikingInfo(7, 0),
                new HikingInfo(8, 15),
                new HikingInfo(9, 16),
                new HikingInfo(10, 17),
                new HikingInfo(10, 18),
                new HikingInfo(11, -1),
                new HikingInfo(12, -1),
                new HikingInfo(13, -1),
                new HikingInfo(14, -1),
                new HikingInfo(15, -1),
                new HikingInfo(16, -1),
                new HikingInfo(17, -1),
                new HikingInfo(18, -1)
		);
   	
	   	{
	   		personInfo = new HashMap<Integer, Integer>();
	   		personInfo.put(1, 15);
	   		personInfo.put(2, 30);
	   		personInfo.put(3, 23);
	   		personInfo.put(4, 50);
	   		personInfo.put(5, 17);
	   		personInfo.put(6, 10);
	   		personInfo.put(7, 20);
	   		personInfo.put(8, 21);
	   		personInfo.put(9, 30);
	   		personInfo.put(10, 8);
	   	}*/
    	
    	return inputData;
	}    
    

    private static void printNumberOfPeopleIsolated(int numberOfPeopleIsolated) {   
    	System.out.print("[하위지점으로 이동할 수 없는 지점의 전체 등산객 수]: ");
    	if(numberOfPeopleIsolated == 0){
    		System.out.println("결과값이 없습니다.");
    	}else{    		
    		System.out.println(numberOfPeopleIsolated+"명");
    	}
    	printLine();    	
    } 
    
    private static void printLostHikingTrail(List<HikingInfo> lostHikingTrail) {   
    	System.out.println("[유실된 등산로]");
    	if(lostHikingTrail == null){
    		System.out.println("결과값이 없습니다.");
    	}else{    		
    		for(HikingInfo hikingInfo : lostHikingTrail){
    			System.out.println("(상위지점"+hikingInfo.getTopPoint()+"-하위지점"+hikingInfo.getSubPoint()+")");
    		}
    	}
    	printLine();    	
    }  
	private static void printLine(){
		System.out.println("--------------------------------------------------------------------");
	}  
}

