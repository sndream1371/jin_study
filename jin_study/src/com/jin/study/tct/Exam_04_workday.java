package com.jin.study.tct;

/*
 * 	4. ��ٽð� ���ڿ� �Է� �޾� �ٹ��� �� ���ϱ�
 *  4-1. ���� ��� [09:00~16:00#12:00~17:00#18:00~12:00]	
 *     �ٹ����� 2�� �̴�. �յ� �ð��� �� ���� ��� ���� ��
 * 
 */
public class Exam_04_workday {

	public static void main(String[] argv) {

		String enterTime="09:00~16:00#12:00~17:00#18:00~12:00"; //��� �ð� ���ڿ� �Է°�
		
		String[] fromToTime = enterTime.split("\\#");
		String[] time;
		Integer first_time, second_time, worktime=0;
		float totTime=0;

		for(int i=0; i < fromToTime.length; i++) {
			time = fromToTime[i].split("\\~"); //Ư������ "\\"�� Ư������ �տ� �Է��Ѵ�.
		
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
		
		System.out.println("�ٹ��ϼ��� >"+totTime / 8);
		
		
		
	}
	
	
}