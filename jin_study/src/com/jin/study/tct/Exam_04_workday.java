package com.jin.study.tct;

/*
 * 	4. 출근시간 문자열 입력 받아 근무일 수 구하기
 *  4-1. 예를 들어 [09:00~16:00#12:00~17:00#18:00~12:00]	
 *     근무일은 2일 이다. 앞뒤 시간이 잘 못된 경우 빼야 함
 * 
 */
public class Exam_04_workday {

	public static void main(String[] argv) {

		String enterTime="09:00~16:00#12:00~17:00#18:00~12:00"; //출근 시간 문자열 입력값
		
		String[] fromToTime = enterTime.split("\\#");
		String[] time;
		Integer first_time, second_time, worktime=0;
		float totTime=0;

		for(int i=0; i < fromToTime.length; i++) {
			time = fromToTime[i].split("\\~"); //특수문자 "\\"를 특수문자 앞에 입력한다.
		
			first_time = Integer.parseInt(time[0].replaceAll(":00", ""));
			second_time = Integer.parseInt(time[1].replaceAll(":00", ""));
			
			System.out.println("first_time :"+first_time + " second_time:"+second_time);
			worktime = second_time - first_time;
			System.out.println("worktime :"+worktime);
			if(worktime >= 0 ) {
				totTime += worktime;
				System.out.println("totTime ::"+totTime);
			}
		}
		
		System.out.println("근무일수는 >"+totTime / 8);
		
		
		
	}
	
	
}