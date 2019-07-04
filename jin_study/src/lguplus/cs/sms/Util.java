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
    
    //����ð� ����
    public String toHH() {
    	
    	//SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
    	SimpleDateFormat format1 = new SimpleDateFormat ( "HH" );    			
    	Date time = new Date();
    			
    	return format1.format(time);
    }
    
    //������ ,Not���������� üũ
    public boolean checkMonday() {
    	
        Calendar oCalendar = Calendar.getInstance( );  // ���� ��¥/�ð� ���� ���� ���� ���
                              // 1    2     3    4     5    6    7
        final String[] week = { "��", "��", "ȭ", "��", "��", "��", "��" };

        log.info("���� ����: " + week[oCalendar.get(Calendar.DAY_OF_WEEK) - 1] + "����");
        
        String weekName = week[oCalendar.get(Calendar.DAY_OF_WEEK) - 1];
        
        return  weekName.equals("��") ? true : false;
    }
    
    
    
    
}






