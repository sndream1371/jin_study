package uplus;

import java.util.Calendar;
import java.util.Date;

public class FutureWorkThread extends Thread {
	
	public static void main(String[] argv) {
		
		try {
			FutureWorkThread fwt = new FutureWorkThread(2019,6,21,11,2);
			fwt.run();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
	}

	
	private int mYear, mMonth, mDay, mHour, mMinute;

	public FutureWorkThread(int year, int month, int day, int hour, int minute) {

		mYear = year;
		mMonth = month;
		mDay = day;
		mHour = hour;
		mMinute = minute;

	}

	@Override

	public void run() {
		
		try {

			System.out.println("--start--");
			sleep(timeUntil(mYear, mMonth, mDay, mHour, mMinute));
			//sleep(5000);

			System.out.println("--after sleep--");
			
			// 작업을 수행한다.
			work();

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void work() {

		System.out.println("i'm working!");

	}

	public long timeUntil(int year, int month, int day, int hour, int minute) {

		Date now = new Date();
		Calendar calUntil = Calendar.getInstance();
		calUntil.set(Calendar.YEAR, year);
		calUntil.set(Calendar.MONTH, month - 1);
		calUntil.set(Calendar.DAY_OF_WEEK, day);
		calUntil.set(Calendar.HOUR_OF_DAY, hour);
		calUntil.set(Calendar.MINUTE, minute);
		calUntil.set(Calendar.SECOND, 0);
		Date until = calUntil.getTime();

		System.out.println(" until.getTime() : "+ until.getTime() +" now.getTime() :"+now.getTime());
		long sleep = until.getTime() - now.getTime();

		System.out.println("sleep :"+ sleep);
		return sleep;

	}
	

}
