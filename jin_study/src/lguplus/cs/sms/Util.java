package lguplus.cs.sms;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {
	
	Logger log = LoggerFactory.getLogger(Util.class);

    public String toDayYYYYMMDD(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
        log.info("Today=" + strToday);

        return strToday;
    }
    
    //현재시간 리턴
    public String toHH() {
    	
    	//SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
    	SimpleDateFormat format1 = new SimpleDateFormat ( "HH" );    			
    	Date time = new Date();
    			
    	return format1.format(time);
    }
    
    //월요일 ,Not월요일인지 체크
    public boolean checkMonday() {
    	
        Calendar oCalendar = Calendar.getInstance( );  // 현재 날짜/시간 등의 각종 정보 얻기
                              // 1    2     3    4     5    6    7
        final String[] week = { "일", "월", "화", "수", "목", "금", "토" };

        log.info("현재 요일: " + week[oCalendar.get(Calendar.DAY_OF_WEEK) - 1] + "요일");
        
        String weekName = week[oCalendar.get(Calendar.DAY_OF_WEEK) - 1];
        
        return  weekName.equals("월") ? true : false;
    }
    
    
    
    
}






