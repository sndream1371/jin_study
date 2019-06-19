package com.jin.study.tct;

import java.util.ArrayList;
import java.util.List;

import com.jin.study.tct.model.MovieInfo;


public class Movie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//초기데이터 입력
//		List<MovieInfo> list = new ArrayList<MovieInfo>();
//		MovieInfo info = new MovieInfo();
//		info.setMovieName("believer");
//		info.setMovieStartTime("08:25");
//		info.setMovieRunTime(96);
//		info.setMovieReadyTime(24);
//		list.add(0,info);
//		
//		MovieInfo info1 = new MovieInfo(); // 객체를 다로생성해서 add해야한다.
//		info1.setMovieName("detective");
//		info1.setMovieStartTime("09:00");
//		info1.setMovieRunTime(116);
//		info1.setMovieReadyTime(24);
//		list.add(1,info1);
//		
//		MovieInfo info2 = new MovieInfo();
//		info2.setMovieName("hereditary");
//		info2.setMovieStartTime("10:10");
//		info2.setMovieRunTime(127);
//		info2.setMovieReadyTime(23);
//		list.add(2,info2);
//		
//		MovieInfo info3 = new MovieInfo();
//		info3.setMovieName("burning");
//		info3.setMovieStartTime("08:15");
//		info3.setMovieRunTime(148);
//		info3.setMovieReadyTime(22);
//		list.add(3,info3);
//		
//		MovieInfo info4 = new MovieInfo();
//		info4.setMovieName("welcome");
//		info4.setMovieStartTime("09:40");
//		info4.setMovieRunTime(94);
//		info4.setMovieReadyTime(16);
//		list.add(4,info4);
		
		//입력데이터 두번째
		List<MovieInfo> list = new ArrayList<MovieInfo>();
		MovieInfo info = new MovieInfo();
		info.setMovieName("hereditary");
		info.setMovieStartTime("09:00");
		info.setMovieRunTime(120);
		info.setMovieReadyTime(25);
		list.add(0,info);
		
		MovieInfo info1 = new MovieInfo(); // 객체를 다로생성해서 add해야한다.
		info1.setMovieName("welcome");
		info1.setMovieStartTime("11:10");
		info1.setMovieRunTime(94);
		info1.setMovieReadyTime(16);
		list.add(1,info1);
		
		MovieInfo info2 = new MovieInfo();
		info2.setMovieName("detective");
		info2.setMovieStartTime("09:00");
		info2.setMovieRunTime(115);
		info2.setMovieReadyTime(25);
		list.add(2,info2);
		
		MovieInfo info3 = new MovieInfo();
		info3.setMovieName("believer");
		info3.setMovieStartTime("10:30");
		info3.setMovieRunTime(95);
		info3.setMovieReadyTime(20);
		list.add(3,info3);
		
		MovieInfo info4 = new MovieInfo();
		info4.setMovieName("burning");
		info4.setMovieStartTime("08:40");
		info4.setMovieRunTime(140);
		info4.setMovieReadyTime(30);
		list.add(4,info4);
		
		System.out.println("-----------------------------------");
		System.out.println("[모든 영황의 일일 총 상영횟수]");
		List<MovieInfo> disList = getShowingFrequency(list);
		for(int i=0; i < disList.size(); i++) {
			System.out.println("영화명:"+disList.get(i).getMovieName() +", 상영횟수:" +disList.get(i).getMovieCount() );
		}
		System.out.println("-----------------------------------");
		String inputTime="11:15";
		System.out.println("[상영 대기 중인 영화목록]");
		System.out.println("[입력시각]:"+inputTime);
		System.out.print("[영화목록]:");
		List<String> readyList = getPendingMovieList(list,inputTime);
		for(int i=0; i < readyList.size(); i++) {
			System.out.print(readyList.get(i));
		}
		
		System.out.println("\n-----------------------------------");
	}
	
	/*
	 * 구현 : 모든 영화의 일일 총 상영횟수를 계산하는 기능 .
	 *  매개변수: List<MovieInfo> inputData 
	 *  입력데이터(영화 상영 정보) . 
	 *  리턴: List<MovieInfo> 
	 *  모든 영화의 일일 총 상영횟수 (MovieInfo의 showingFrequency필드에 상영횟수 저장)
	 */
	public static List<MovieInfo> getShowingFrequency(List<MovieInfo> inputData){
	
		int startMin=0, hh=0, mm=0;
		int oneDayMin = 23*60 + 59; //하루를 24시간을 분으로 (문제에서 23:59분가지 하루라고 정의해서 11시 * 60분 + 59분
		int movieCnt=0 , runTime=0, readyTime;
		for(int i=0; i < inputData.size(); i++) {
			//System.out.println("name :"+inputData.get(i).getMovieName());
			hh = Integer.parseInt((inputData.get(i).getMovieStartTime()).substring(0, 2));
			mm = Integer.parseInt((inputData.get(i).getMovieStartTime()).substring(3, 5));
			startMin = hh*60 + mm; //시작시간  String to int
			runTime=inputData.get(i).getMovieRunTime();
			readyTime=inputData.get(i).getMovieReadyTime();
			
			System.out.println("a >"+(oneDayMin-startMin)+" b >"+ (runTime+readyTime) );
			movieCnt = (oneDayMin-startMin)/(runTime+readyTime); //24시간(min) - 상영시작일 / 상영시간+상영대기시간
			if((oneDayMin-startMin)%(runTime+readyTime) != 0 ) movieCnt++; //나머지가 나눠떨이지지 않으면 23:59분이네에 한번더 상영할수 있으므로 추가한다.
			
			//System.out.println("hh:"+hh+" mm:"+mm +" startMin:"+startMin+" movieCnt:"+movieCnt+" oneDayMin:"+oneDayMin +" runTime:"+runTime+" readyTime:"+readyTime);
			
			inputData.get(i).setMovieCount( movieCnt );
		}
		
		return inputData;
	}
	
	
	/*
	 * 구현 : 입력한 시각에 상영대기 중인 영화목록을 검색하는 기능 . 
	 * 매개변수: List<MovieInfo> inputData 
	 * 입력데이터(영화 상영 정보) . 
	 * 매개변수: String time - 입력데이터(입력 시각) . 
	 * 리턴: List<String> - 상영대기 중인 영화목록
	 * 
	 */
	public static List<String> getPendingMovieList(List<MovieInfo> inputData, String time){
		
		List<String> list = new ArrayList<String>();
		int inputTime=0;
		int startMin=0, hh=0, mm=0;
		int oneDayMin = 24*60; //하루를 24시간을 분으로 (문제에서 23:59분가지 하루라고 정의해서 1분을뺌
		int movieCnt=0 , runTime=0, readyTime;
		int cmpTime1=0, cmpTime2=0;
		inputTime = Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3,5)); // 12:01 -> min으로 환산
		for(int i=0; i < inputData.size(); i++) {
			hh = Integer.parseInt((inputData.get(i).getMovieStartTime()).substring(0, 2));
			mm = Integer.parseInt((inputData.get(i).getMovieStartTime()).substring(3, 5));
			startMin = hh*60 + mm; //시작시간  String to int
			runTime=inputData.get(i).getMovieRunTime();
			readyTime=inputData.get(i).getMovieReadyTime();
			
			cmpTime1 = inputTime - startMin; //입력시간 - 시작시간 -> 처음 상영시간부터 입력받은 시간까지 min으로 계산 
			cmpTime2 = cmpTime1 % (runTime+readyTime); //입력시간까지의 상영시간+대기시간의 나머지 시간을 구한다.
			int modTime = cmpTime2 - runTime;
			if( modTime >0 && modTime < (readyTime -1)) {
				list.add(inputData.get(i).getMovieName()+" ");
			}
//			System.out.println("oneDayMin:"+oneDayMin+" startMin:"+startMin+" inputTime:"+inputTime+
//					" runTime:"+runTime+
//					" readyTime:"+readyTime+
//					" cmpTime1:"+cmpTime1+
//					" cmpTime2:"+cmpTime2+
//					" cmpTime2 - runTime:"+(cmpTime2 - runTime));
			
		}
		
		return list;
	}

}
