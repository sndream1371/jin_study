package com.jin.study.tct;


public class Exam_04_workday {

	public static void main(String[] argv) {
		//4. ��ٽð� ���ڿ� �Է� �޾� �ٹ��� �� ���ϱ�
		//4-1. ���� ��� [09:00~16:00#12:00~17:00#18:00~12:00]
	    //     �ٹ����� 2�� �̴�. �յ� �ð��� �� ���� ��� ���� ��
		
		String enterTime="09:00~16:00#12:00~17:00#18:00~12:00";
		
		String[] fromToTime = enterTime.split("\\#");
		String[] time;
		Integer first_time, second_time, worktime=0;
		float totTime=0;

		for(int i=0; i < fromToTime.length; i++) {
			time = fromToTime[i].split("\\~");
		
			first_time = Integer.parseInt(time[0].replaceAll(":00", ""));
			second_time = Integer.parseInt(time[1].replaceAll(":00", ""));
			
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