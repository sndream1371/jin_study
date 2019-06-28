package lguplus.cs.sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SMSInsertInfo {

	
	/*
	 * SMS 단문 EAI 전송 테이블에 INSERT 
	 * 파라미터 : 송신할 사용자 전화번호(12자리)
	 *         송신할 메세지
	 *         송신구분 (TRN,USHOP, 입력안하면 나머지전부)에 따른 응답 전화번호 설정
	 */
	public String insertSMSTable(String senderTelNum, String smsMessage, String sendType, Connection conn) {
		
		String result = "";
		SMSInsertSQL insertSQL = new SMSInsertSQL();
		String sql = insertSQL.InsertSMS();
		
		String replyNumber = ReplyNo(sendType); //송신구분에따른 응답전화번호 설정 TRN,USHOP, Others..
		
//		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        
        try {
//            DBHandler dbHandler = new DBHandler();
//            conn = dbHandler.getConnectionCubeSeoul();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, senderTelNum);
            pstm.setString(2, smsMessage);
            pstm.setString(3, replyNumber);
            int eu = pstm.executeUpdate();
            
            System.out.println("SMS Insert into table result : "+ eu);
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB 연결을 종료한다.
            try{
                //if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
//                if ( conn != null ){conn.close(); }
                System.out.println("PreparedStatement 정보를 반납했습니다.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
	
		return result;
	}
	
	
	/*
	 * MMS 장무 EAI 전송 테이블에 INSERT 
	 * 파라미터 : 송신할 사용자 전화번호(12자리)
	 *         송신할 메세지
	 *         송신구분 (TRN,USHOP, 입력안하면 나머지전부)에 따른 응답 전화번호 설정
	 */
	public String insertMMSTable(String senderTelNum, String smsMessage, String sendType, Connection conn) {
		
		String result = "";
		SMSInsertSQL insertSQL = new SMSInsertSQL();
		String sql = insertSQL.InsertMMS();
		
		String replyNumber = ReplyNo(sendType); //송신구분에따른 응답전화번호 설정 TRN,USHOP, Others..
		
//		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        
        try {
//            DBHandler dbHandler = new DBHandler();
//            conn = dbHandler.getConnectionCubeSeoul();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, senderTelNum);
            pstm.setString(2, smsMessage);
            pstm.setString(3, replyNumber);
            int eu = pstm.executeUpdate();
            
            System.out.println("MMS Insert into table result : "+ eu);
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB 연결을 종료한다.
            try{
                //if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
//                if ( conn != null ){conn.close(); }
                System.out.println("PreparedStatement 정보를 반납했습니다.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
	
		return result;
	}
	
	
	//전송타입에 따른 응답전화번호 설정
	public String ReplyNo(String sendType) {
	
		String replyNo = "";
		
		if ( "TRN".equals(sendType) ) {
			replyNo = "01080809210";
		}else if ( "USHOP".equals(sendType) ) {
			replyNo = "16447070";
		}else {
			replyNo = "01080802235";
		}
		
		return replyNo;
	}
	
	
}
