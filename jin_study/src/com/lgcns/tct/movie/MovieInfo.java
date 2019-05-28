package com.lgcns.tct.movie;

public class MovieInfo {
	private String name;	//영화명
	private String firstScreeningTime;	//첫 회 상영시각
	private int showtimes;	//상영시간
	private int screeningWaitTime;	//상영대기시간
	private int showingFrequency;	//일일 상영 횟수
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstScreeningTime() {
		return firstScreeningTime;
	}

	public void setFirstScreeningTime(String firstScreeningTime) {
		this.firstScreeningTime = firstScreeningTime;
	}

	public int getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(int showtimes) {
		this.showtimes = showtimes;
	}

	public int getScreeningWaitTime() {
		return screeningWaitTime;
	}

	public void setScreeningWaitTime(int screeningWaitTime) {
		this.screeningWaitTime = screeningWaitTime;
	}

	public int getShowingFrequency() {
		return showingFrequency;
	}

	public void setShowingFrequency(int showingFrequency) {
		this.showingFrequency = showingFrequency;
	}
		
	/**
	 * @param name
	 * @param showingFrequency
	 */
	public MovieInfo(String name, int showingFrequency) {
		super();
		this.name = name;
		this.showingFrequency = showingFrequency;
	}

	/**
	 * @param name
	 * @param firstScreeningTime
	 * @param showtimes
	 * @param screeningWaitTime
	 */
	public MovieInfo(String name, String firstScreeningTime, int showtimes, int screeningWaitTime) {
		super();
		this.name = name;
		this.firstScreeningTime = firstScreeningTime;
		this.showtimes = showtimes;
		this.screeningWaitTime = screeningWaitTime;
	}

	public MovieInfo() {
		// TODO Auto-generated constructor stub
	}

}
