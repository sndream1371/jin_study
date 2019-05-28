package com.lgcns.tct.movie;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	
	
	public int changeTimetoMin(String time){
		int min = 0;
		
		String thour = time.split("\\:")[0];
		String tmin = time.split("\\:")[1];
		
		min = Integer.parseInt(thour) * 60 + Integer.parseInt(tmin);
		
		return min;
	}
	
	
	/**
	 * 모든 영화의 일일 총 상영횟수를 계산하는 기능
	 *
     * @param		inputData			List		입력데이터(영화 상영 정보)
     * @return							List		모든 영화의 일일 총 상영횟수(MovieInfo의 showingFrequency필드에 상영횟수 저장)
	 */
	public List<MovieInfo> getShowingFrequency(List<MovieInfo> inputData) {
		List<MovieInfo> showingFrequency = null;
		////////////////////////여기부터 구현 (1) ---------------->
		int maxMin = 23*60+59;
		for(MovieInfo data : inputData){
			String startTime = data.getFirstScreeningTime();
			int startTimeMin = changeTimetoMin(startTime);
			double validRange = maxMin - startTimeMin;
			double totalTime = data.getShowtimes() + data.getScreeningWaitTime();
			
			data.setShowingFrequency((int)Math.ceil(validRange/totalTime));
		}
		
		showingFrequency = inputData;
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return showingFrequency;
	}
	
	
	/**
	 * 입력한 시각에 상영대기 중인 영화목록을 검색하는 기능
	 *
     * @param		inputData			List		입력데이터(영화 상영 정보)
     * @param		time				String		입력데이터(입력 시각)
     * @return							List		상영대기 중인 영화목록
	 */
	public List<String> getPendingMovieList(List<MovieInfo> inputData, String time) {
		List<String> pendingMovieList = null;
		////////////////////////여기부터 구현 (2) ---------------->
		pendingMovieList = new ArrayList<>();
		int currentMin = changeTimetoMin(time);
		for (MovieInfo data : inputData){
			String startTime = data.getFirstScreeningTime();
			int startTimeMin = changeTimetoMin(startTime);
			int totalTime = data.getShowtimes() + data.getScreeningWaitTime();
			int testTime = startTimeMin;
			while(testTime < 23*60+59){
				if(testTime < currentMin){
					if((testTime + data.getShowtimes()) <= currentMin &&  (testTime + data.getShowtimes() + data.getScreeningWaitTime()) > currentMin){
						pendingMovieList.add(data.getName());
						break;
					}else{
						testTime += data.getShowtimes() + data.getScreeningWaitTime();
					}
				}else{
					break;
				}
			}		
			
		}
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return pendingMovieList;
	}
	
}

