package lguplus.cs.sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SMSInsertInfo {

	
	/*
	 * SMS �ܹ� EAI ���� ���̺� INSERT 
	 * �Ķ���� : �۽��� ����� ��ȭ��ȣ(12�ڸ�)
	 *         �۽��� �޼���
	 *         �۽ű��� (TRN,USHOP, �Է¾��ϸ� ����������)�� ���� ���� ��ȭ��ȣ ����
	 */
	public String insertSMSTable(String senderTelNum, String smsMessage, String sendType, Connection conn) {
		
		String result = "";
		SMSInsertSQL insertSQL = new SMSInsertSQL();
		String sql = insertSQL.InsertSMS();
		
		String replyNumber = ReplyNo(sendType); //�۽ű��п����� ������ȭ��ȣ ���� TRN,USHOP, Others..
		
//		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        
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
            // DB ������ �����Ѵ�.
            try{
                //if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
//                if ( conn != null ){conn.close(); }
                System.out.println("PreparedStatement ������ �ݳ��߽��ϴ�.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
	
		return result;
	}
	
	
	/*
	 * MMS �幫 EAI ���� ���̺� INSERT 
	 * �Ķ���� : �۽��� ����� ��ȭ��ȣ(12�ڸ�)
	 *         �۽��� �޼���
	 *         �۽ű��� (TRN,USHOP, �Է¾��ϸ� ����������)�� ���� ���� ��ȭ��ȣ ����
	 */
	public String insertMMSTable(String senderTelNum, String smsMessage, String sendType, Connection conn) {
		
		String result = "";
		SMSInsertSQL insertSQL = new SMSInsertSQL();
		String sql = insertSQL.InsertMMS();
		
		String replyNumber = ReplyNo(sendType); //�۽ű��п����� ������ȭ��ȣ ���� TRN,USHOP, Others..
		
//		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        
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
            // DB ������ �����Ѵ�.
            try{
                //if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
//                if ( conn != null ){conn.close(); }
                System.out.println("PreparedStatement ������ �ݳ��߽��ϴ�.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
	
		return result;
	}
	
	
	//����Ÿ�Կ� ���� ������ȭ��ȣ ����
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
