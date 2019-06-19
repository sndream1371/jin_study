package com.jin.study.tct;

import java.util.ArrayList;
import java.util.List;

import com.jin.study.tct.model.MovieInfo;


public class Movie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�ʱⵥ���� �Է�
//		List<MovieInfo> list = new ArrayList<MovieInfo>();
//		MovieInfo info = new MovieInfo();
//		info.setMovieName("believer");
//		info.setMovieStartTime("08:25");
//		info.setMovieRunTime(96);
//		info.setMovieReadyTime(24);
//		list.add(0,info);
//		
//		MovieInfo info1 = new MovieInfo(); // ��ü�� �ٷλ����ؼ� add�ؾ��Ѵ�.
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
		
		//�Էµ����� �ι�°
		List<MovieInfo> list = new ArrayList<MovieInfo>();
		MovieInfo info = new MovieInfo();
		info.setMovieName("hereditary");
		info.setMovieStartTime("09:00");
		info.setMovieRunTime(120);
		info.setMovieReadyTime(25);
		list.add(0,info);
		
		MovieInfo info1 = new MovieInfo(); // ��ü�� �ٷλ����ؼ� add�ؾ��Ѵ�.
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
		System.out.println("[��� ��Ȳ�� ���� �� ��Ƚ��]");
		List<MovieInfo> disList = getShowingFrequency(list);
		for(int i=0; i < disList.size(); i++) {
			System.out.println("��ȭ��:"+disList.get(i).getMovieName() +", ��Ƚ��:" +disList.get(i).getMovieCount() );
		}
		System.out.println("-----------------------------------");
		String inputTime="11:15";
		System.out.println("[�� ��� ���� ��ȭ���]");
		System.out.println("[�Է½ð�]:"+inputTime);
		System.out.print("[��ȭ���]:");
		List<String> readyList = getPendingMovieList(list,inputTime);
		for(int i=0; i < readyList.size(); i++) {
			System.out.print(readyList.get(i));
		}
		
		System.out.println("\n-----------------------------------");
	}
	
	/*
	 * ���� : ��� ��ȭ�� ���� �� ��Ƚ���� ����ϴ� ��� .
	 *  �Ű�����: List<MovieInfo> inputData 
	 *  �Էµ�����(��ȭ �� ����) . 
	 *  ����: List<MovieInfo> 
	 *  ��� ��ȭ�� ���� �� ��Ƚ�� (MovieInfo�� showingFrequency�ʵ忡 ��Ƚ�� ����)
	 */
	public static List<MovieInfo> getShowingFrequency(List<MovieInfo> inputData){
	
		int startMin=0, hh=0, mm=0;
		int oneDayMin = 23*60 + 59; //�Ϸ縦 24�ð��� ������ (�������� 23:59�а��� �Ϸ��� �����ؼ� 11�� * 60�� + 59��
		int movieCnt=0 , runTime=0, readyTime;
		for(int i=0; i < inputData.size(); i++) {
			//System.out.println("name :"+inputData.get(i).getMovieName());
			hh = Integer.parseInt((inputData.get(i).getMovieStartTime()).substring(0, 2));
			mm = Integer.parseInt((inputData.get(i).getMovieStartTime()).substring(3, 5));
			startMin = hh*60 + mm; //���۽ð�  String to int
			runTime=inputData.get(i).getMovieRunTime();
			readyTime=inputData.get(i).getMovieReadyTime();
			
			System.out.println("a >"+(oneDayMin-startMin)+" b >"+ (runTime+readyTime) );
			movieCnt = (oneDayMin-startMin)/(runTime+readyTime); //24�ð�(min) - �󿵽����� / �󿵽ð�+�󿵴��ð�
			if((oneDayMin-startMin)%(runTime+readyTime) != 0 ) movieCnt++; //�������� ������������ ������ 23:59���̳׿� �ѹ��� ���Ҽ� �����Ƿ� �߰��Ѵ�.
			
			//System.out.println("hh:"+hh+" mm:"+mm +" startMin:"+startMin+" movieCnt:"+movieCnt+" oneDayMin:"+oneDayMin +" runTime:"+runTime+" readyTime:"+readyTime);
			
			inputData.get(i).setMovieCount( movieCnt );
		}
		
		return inputData;
	}
	
	
	/*
	 * ���� : �Է��� �ð��� �󿵴�� ���� ��ȭ����� �˻��ϴ� ��� . 
	 * �Ű�����: List<MovieInfo> inputData 
	 * �Էµ�����(��ȭ �� ����) . 
	 * �Ű�����: String time - �Էµ�����(�Է� �ð�) . 
	 * ����: List<String> - �󿵴�� ���� ��ȭ���
	 * 
	 */
	public static List<String> getPendingMovieList(List<MovieInfo> inputData, String time){
		
		List<String> list = new ArrayList<String>();
		int inputTime=0;
		int startMin=0, hh=0, mm=0;
		int oneDayMin = 24*60; //�Ϸ縦 24�ð��� ������ (�������� 23:59�а��� �Ϸ��� �����ؼ� 1������
		int movieCnt=0 , runTime=0, readyTime;
		int cmpTime1=0, cmpTime2=0;
		inputTime = Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3,5)); // 12:01 -> min���� ȯ��
		for(int i=0; i < inputData.size(); i++) {
			hh = Integer.parseInt((inputData.get(i).getMovieStartTime()).substring(0, 2));
			mm = Integer.parseInt((inputData.get(i).getMovieStartTime()).substring(3, 5));
			startMin = hh*60 + mm; //���۽ð�  String to int
			runTime=inputData.get(i).getMovieRunTime();
			readyTime=inputData.get(i).getMovieReadyTime();
			
			cmpTime1 = inputTime - startMin; //�Է½ð� - ���۽ð� -> ó�� �󿵽ð����� �Է¹��� �ð����� min���� ��� 
			cmpTime2 = cmpTime1 % (runTime+readyTime); //�Է½ð������� �󿵽ð�+���ð��� ������ �ð��� ���Ѵ�.
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
