package lguplus.cs.sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SMSContentInfo {

	Util util = new Util();
	
	//오늘이 휴일 또는 공휴일인지 확인
	//휴일, 공휴일이면 True 리턴 아니면 false 리턴
	public boolean isHoliday() {
		boolean cnt = false;
		String sql = "";
		
		sql = "select count(1) cnt from TB_SMS_HOLIDAY_CHECK where holiday_flag = '1' and holiday_info = '" + util.toDayYYYYMMDD() +"'"; //현재일 yyyy-mm-dd 형태
		//sql = "select count(1) cnt from TB_SMS_HOLIDAY_CHECK where holiday_flag = '1' and holiday_info = '2019-06-30'"; //공휴일 테스트 true로 리턴확인함
		
		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubeSeoul();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            System.out.println("cnt");
            System.out.println("============================================");
            
            while(rs.next()){
                cnt = rs.getBoolean(1); //1부터 시작
                System.out.println(cnt);
            }
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB 연결을 종료한다.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
                System.out.println("DB 연결을 종료하였습니다.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
	
		return cnt;
	}
	
	//BS 응대율 통계조회
	public String staticHomeBS() {
		
		String result = "";
		SMSContentSQL contentSQL = new SMSContentSQL();
		String sql = contentSQL.sql_BS;
		
		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubeSeoul();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            System.out.println("HOME BS send content");
//            System.out.println("============================================");
            
            while(rs.next()){
            	result = rs.getString(1); //1부터 시작
                System.out.println(result);
            }
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB 연결을 종료한다.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
                System.out.println("DB 연결을 종료하였습니다.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
	
		return result;
	}
	
	
	//모바일 모전담 이관 조회 
	//모바일 -> 부산DB 접속
	public String staticMobileTRN() {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		sql = contentSQL.sql_PM_TRN;
		
		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubePusan(); //모바일은 부산DB 조회
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            System.out.println("Mobile TRN send content");
//            System.out.println("============================================");
            
            while(rs.next()){
            	result = rs.getString(1); //1부터 시작
                System.out.println(result);
            }
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB 연결을 종료한다.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
                System.out.println("DB 연결을 종료하였습니다.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	
	//HOME U+ SHOP 
	//HOME -> 서울DB 접속
	public String staticHomeUSHOP() {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		sql = contentSQL.sql_USHOP;
		
		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubeSeoul(); //HOME 서울DB 조회
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            System.out.println("U+SHOP send content");
//            System.out.println("============================================");
            
            while(rs.next()){
            	result = rs.getString(1); //1부터 시작
                System.out.println(result);
            }
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB 연결을 종료한다.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
                System.out.println("DB 연결을 종료하였습니다.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	
	//HOME HS_30분 수신인용(이범영)
	//HOME -> 서울DB 접속
	public String staticHomeHS30() {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		Util util = new Util();
		if( util.checkMonday() ) { //월요일
			sql = contentSQL.sql_HS_30_Monday;
		}else {
			sql = contentSQL.sql_HS_30_NOT_Monday;
		}
		
		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubeSeoul(); //HOME 서울DB 조회
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            System.out.println("HS_30 send content");
            System.out.println("============================================");
            
            while(rs.next()){
            	result = rs.getString(1); //1부터 시작
                System.out.println(result);
            }
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB 연결을 종료한다.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
                System.out.println("DB 연결을 종료하였습니다.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	
	//모바일 응대율
	//모바일 -> 부산DB 접속
	public String staticMobilePM() {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		sql = contentSQL.sql_PM_PM;
		
		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubePusan(); //모바일 부산DB 조회
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            System.out.println("Mobile PM send content");
//            System.out.println("============================================");
            
            while(rs.next()){
            	result = rs.getString(1); //1부터 시작
                System.out.println(result);
            }
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB 연결을 종료한다.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
                System.out.println("DB 연결을 종료하였습니다.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	//모바일 대리점 호전환(ARS에서)
	//모바일 -> 부산DB 접속
	public String staticMobilePMAgency() {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		sql = contentSQL.sql_PM_PM_AGENCY;
		
		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubePusan(); //모바일 부산DB 조회
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            System.out.println("Mobile PM Agency send content");
//            System.out.println("============================================");
            
            while(rs.next()){
            	result = rs.getString(1); //1부터 시작
                System.out.println(result);
            }
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB 연결을 종료한다.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
                System.out.println("DB 연결을 종료하였습니다.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	
	//HOME 응대율
	//HOME -> 서울DB 접속
	public String staticHomeHS() {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		sql = contentSQL.sql_PM_HS;
		
		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubeSeoul(); //HOME 서울DB 조회
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            System.out.println("HS send content");
//            System.out.println("============================================");
            
            while(rs.next()){
            	result = rs.getString(1); //1부터 시작
                System.out.println(result);
            }
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB 연결을 종료한다.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
                System.out.println("DB 연결을 종료하였습니다.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	
	
	
}
