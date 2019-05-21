package com.jin.study.tct.model;

public class MovieInfo {
	
	private String movieName;
	private String movieStartTime;
	private int movieRunTime;
	private int movieReadyTime;
	private int movieCount;
	
	public int getMovieCount() {
		return movieCount;
	}
	public void setMovieCount(int movieCount) {
		this.movieCount = movieCount;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieStartTime() {
		return movieStartTime;
	}
	public void setMovieStartTime(String movieStartTime) {
		this.movieStartTime = movieStartTime;
	}
	public int getMovieRunTime() {
		return movieRunTime;
	}
	public void setMovieRunTime(int movieRunTime) {
		this.movieRunTime = movieRunTime;
	}
	public int getMovieReadyTime() {
		return movieReadyTime;
	}
	public void setMovieReadyTime(int movieReadyTime) {
		this.movieReadyTime = movieReadyTime;
	}
	

}
