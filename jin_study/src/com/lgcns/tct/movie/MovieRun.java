package com.lgcns.tct.movie;

import java.util.Arrays;
import java.util.List;

public class MovieRun {

	public static String time;
	
    public static void main(String[] args) {    	
		// 제공 데이터 세트2를 실행하려면 loadData에서 제공 데이터 세트1을 주석 처리하고 제공 데이터 세트2를 주석 해제하여 실행
    	List<MovieInfo> inputData = loadData();
    	printInput(inputData);
    	Movie movie = new Movie();
    	
    	// 모든 영화의 일일 총 상영횟수를 계산하는 기능
    	List<MovieInfo> showingFrequency = movie.getShowingFrequency(inputData);
    	printShowingFrequency(showingFrequency);
    	
    	// 입력한 시간에 상영대기 중인 영화목록을 검색하는 기능
    	List<String> pendingMovieList = movie.getPendingMovieList(inputData, time);
    	printPendingMovieList(pendingMovieList);
    }

    private static List<MovieInfo> loadData() {
    	
    	
		//////////////////////////////////
		// 제공 데이터 세트 1
		/////////////////////////////////
  
//    	List<MovieInfo> inputData = Arrays.asList(
//    			new MovieInfo("believer", "08:25", 96, 24),
//    			new MovieInfo("detective", "09:00", 116, 24),
//    			new MovieInfo("hereditary", "10:10", 127, 23),
//    			new MovieInfo("burning", "08:15", 148, 22),
//    			new MovieInfo("welcome", "09:40", 94, 16)
//		);
//    	
//    	time = "22:24";
    	
		//////////////////////////////////
		// 제공 데이터 세트 2
		/////////////////////////////////    
    	
    	List<MovieInfo> inputData = Arrays.asList(
    			new MovieInfo("hereditary", "09:00", 120, 25),
    			new MovieInfo("welcome", "11:10", 94, 16),
    			new MovieInfo("detective", "09:00", 115, 25),
    			new MovieInfo("believer", "10:30", 95, 20),
    			new MovieInfo("burning", "08:40", 140, 30)
		);
		
		time = "11:15";
    	
    	return inputData;
	}    
    
    private static void printInput(List<MovieInfo> inputData){
        printLineInitial();     
        System.out.println("영화명\t\t 첫 회차 상영 시작시각\t 상영시간(분)\t 상영대기시간(분)");
        for(MovieInfo movieInfo : inputData){
        	System.out.println(movieInfo.getName() + " \t " + movieInfo.getFirstScreeningTime() + " \t\t " + movieInfo.getShowtimes() + " \t\t " + movieInfo.getScreeningWaitTime());
        }
        printLine();
    }
    
    private static void printShowingFrequency(List<MovieInfo> showingFrequency) {   
    	System.out.println("[모든 영화의 일일 총 상영횟수] ");
    	if(showingFrequency == null){
    		System.out.println("결과값이 없습니다.");
    	}else{    		
    		for(MovieInfo movieInfo : showingFrequency){
            	System.out.println("영화명: "+movieInfo.getName() + ", 상영횟수:  " + movieInfo.getShowingFrequency() + "회");
            }
    	}
    	printLine();    	
    } 
    
    private static void printPendingMovieList(List<String> pendingMovieList) {   
    	System.out.println("[상영대기 중인 영화목록] ");
    	System.out.println("[입력시각]: "+time);
    	System.out.print("[영화목록]: ");
    	if(pendingMovieList == null){
    		System.out.println("결과값이 없습니다.");
    	}else{    		
    		for(String name : pendingMovieList){
    			System.out.print(name + " ");
    		}
    		System.out.println();
    	}
    	printLine();      	
    } 
    
    private static void printLineInitial(){
    	System.out.println("[초기 입력 데이터]");
    }

	private static void printLine(){
		System.out.println("--------------------------------------------------------------------");
	}  
}

