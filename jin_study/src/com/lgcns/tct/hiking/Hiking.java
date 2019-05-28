package com.lgcns.tct.hiking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hiking {
	
	/**
	 * 등산객 수를 계산하는 기능
	 *
     * @param		inputData			List		입력데이터(등산로 정보)
     * @param		personInfo			HashMap		입력데이터(지점별 등산객 수 정보)
     * @return							int			등산객 수
	 */
	public int getNumberOfPeopleIsolated(List<HikingInfo> inputData, HashMap<Integer, Integer> personInfo) {
		int numberOfPeopleIsolated = 0;
		////////////////////////여기부터 구현 (1) ---------------->
		HashMap<Integer, Integer> childMap = new HashMap<>();
		
		HashMap<Integer, ArrayList<Integer>> parentMap = new HashMap<>();
		
		List<Integer> lastPosition = new ArrayList<>();
		
		for(HikingInfo data : inputData){
			if(data.getSubPoint() > 0){
				childMap.put(data.getSubPoint(), data.getTopPoint());
				ArrayList<Integer> parents = null;
				
				if(parentMap.keySet().contains(data.getTopPoint())){
					parents = parentMap.get(data.getTopPoint());
				}else{
					parents = new ArrayList<>();
				}
				
				parents.add(data.getSubPoint());
				
				parentMap.put(data.getTopPoint(), parents);
				
			}else if(data.getSubPoint() == 0){
				lastPosition.add(data.getTopPoint());
			}
		}
		
		for(Integer point : lastPosition){//끊어진 포인트
			if(!parentMap.keySet().contains(point)){//내려갈자리가 없음
				numberOfPeopleIsolated += personInfo.get(point);
				int pPoint = 0;
				int testPoint = point;
				while(pPoint > -1){
					pPoint = findCrackParents(childMap, parentMap, testPoint);
					if(pPoint != -1){
						numberOfPeopleIsolated += personInfo.get(pPoint);
						testPoint = pPoint;
					}
				}
			}
		}
		
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return numberOfPeopleIsolated;
	}
	
	public int findCrackParents(HashMap<Integer, Integer> childMap, HashMap<Integer, ArrayList<Integer>> parentMap, int point){
		if(childMap.keySet().contains(point)){
			int parentPoint = childMap.get(point);
			if(parentMap.keySet().contains(parentPoint) && parentMap.get(parentPoint).size() == 1){
				return parentPoint;
			}
		}
		
		return -1;
	}
	
	
	/**
	 * 유실된 등산로를 구하는 기능
	 *
     * @param		inputData			List		입력데이터(등산로 정보)
     * @return							List		유실된 등산로
	 */
	public List<HikingInfo> getLostHikingTrail(List<HikingInfo> inputData) {
		List<HikingInfo> lostHikingTrail = null;
		////////////////////////여기부터 구현 (2) ---------------->
		lostHikingTrail = new ArrayList<>();
		HashMap<Integer, Integer> childMap = new HashMap<>();
		
		HashMap<Integer, ArrayList<Integer>> parentMap = new HashMap<>();
		
		List<Integer> lastPosition = new ArrayList<>();
		
		int maxPoint = 0;
		
		for(HikingInfo data : inputData){
			if(data.getTopPoint() > maxPoint){
				maxPoint = data.getTopPoint();
			}
			if(data.getSubPoint() > 0){
				childMap.put(data.getSubPoint(), data.getTopPoint());
				ArrayList<Integer> parents = null;
				
				if(parentMap.keySet().contains(data.getTopPoint())){
					parents = parentMap.get(data.getTopPoint());
				}else{
					parents = new ArrayList<>();
				}
				
				parents.add(data.getSubPoint());
				
				parentMap.put(data.getTopPoint(), parents);
				
			}else if(data.getSubPoint() == 0){
				lastPosition.add(data.getTopPoint());
			}
		}
		
		int startPoint = 0;
		
		for(Integer point : lastPosition){//끊어진 포인트
			if(startPoint == 0){
				startPoint = point+1;
			}
			for(int i = startPoint ; i <= maxPoint ; i++){
				if(!childMap.keySet().contains(i)){//부모가 없는 포인트
					HikingInfo info = new HikingInfo();
					info.setTopPoint(point);
					info.setSubPoint(i);
					lostHikingTrail.add(info);
					
					startPoint = i + 1;
					break;
				}
			}
		}
		
		
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return lostHikingTrail;
	}
	
}