package lguplus.cs.sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMSContentInfo {
	
	Logger log = LoggerFactory.getLogger(SMSContentInfo.class);

	Util util = new Util();
	
	//������ ���� �Ǵ� ���������� Ȯ��
	//����, �������̸� True ���� �ƴϸ� false ����
	public boolean isHoliday() {
		boolean cnt = false;
		String sql = "";
		
		sql = "select count(1) cnt from TB_SMS_HOLIDAY_CHECK where holiday_flag = '1' and holiday_info = '" + util.toDayYYYYMMDD() +"'"; //������ yyyy-mm-dd ����
		//sql = "select count(1) cnt from TB_SMS_HOLIDAY_CHECK where holiday_flag = '1' and holiday_info = '2019-06-30'"; //������ �׽�Ʈ true�� ����Ȯ����
		
		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubeSeoul();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            log.info("������ ��ȸ...");
            log.info("============================================");
            
            while(rs.next()){
                cnt = rs.getBoolean(1); //1���� ����
            }
            System.out.println(cnt);
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB ������ �����Ѵ�.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
                log.info("DB ������ �����Ͽ����ϴ�.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
	
		return cnt;
	}
	
	//BS ������ �����ȸ
	public String staticHomeBS(Connection conn) {
		
		String result = "";
		SMSContentSQL contentSQL = new SMSContentSQL();
		String sql = contentSQL.sql_BS;
		
		//Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
           // DBHandler dbHandler = new DBHandler();
           //conn = dbHandler.getConnectionCubeSeoul();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            log.info("HOME BS send content");
//            log.info("============================================");
            
            while(rs.next()){
            	result += rs.getString(1); //1���� ����
            }
            System.out.println(result);
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB ������ �����Ѵ�.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                //if ( conn != null ){conn.close(); }
                log.info("prepareStatement ���� �ݳ� �Ͽ����ϴ�.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
	
		return result;
	}
	
	
	//����� ������ �̰� ��ȸ 
	//����� -> �λ�DB ����
	public String staticMobileTRN(Connection conn) {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		sql = contentSQL.sql_PM_TRN;
		
//		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
//            DBHandler dbHandler = new DBHandler();
//            conn = dbHandler.getConnectionCubePusan(); //������� �λ�DB ��ȸ
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            log.info("Mobile TRN send content");
//            log.info("============================================");
            
            while(rs.next()){
            	result += rs.getString(1); //1���� ����
            }
            System.out.println(result);
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB ������ �����Ѵ�.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
//                if ( conn != null ){conn.close(); }
                log.info("PreparedStatement �ڿ� �ݳ�");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	
	//HOME U+ SHOP 
	//HOME -> ����DB ����
	public String staticHomeUSHOP(Connection conn) {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		sql = contentSQL.sql_USHOP;
		
//		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
//            DBHandler dbHandler = new DBHandler();
//            conn = dbHandler.getConnectionCubeSeoul(); //HOME ����DB ��ȸ
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            log.info("U+SHOP send content");
//            log.info("============================================");
            
            while(rs.next()){
            	result += rs.getString(1); //1���� ����
            }
            System.out.println(result);
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB ������ �����Ѵ�.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
//                if ( conn != null ){conn.close(); }
                log.info("PreparedStatement �ڿ� �ݳ�");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	
	//HOME HS_30�� �����ο�(�̹���)
	//HOME -> ����DB ����
	public String staticHomeHS30(Connection conn) {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		Util util = new Util();
		if( util.checkMonday() ) { //������
			sql = contentSQL.sql_HS_30_Monday;
		}else {
			sql = contentSQL.sql_HS_30_NOT_Monday;
		}
		
//		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
//            DBHandler dbHandler = new DBHandler();
//            conn = dbHandler.getConnectionCubeSeoul(); //HOME ����DB ��ȸ
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            log.info("HS_30 send content");
            log.info("============================================");
            
            while(rs.next()){
            	result = rs.getString(1); //1���� ����
                System.out.println(result);
            }
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB ������ �����Ѵ�.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
//                if ( conn != null ){conn.close(); }
                log.info("PreparedStatement �ڿ� �ݳ�");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	
	//����� ������
	//����� -> �λ�DB ����
	public String staticMobilePM(Connection conn) {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		sql = contentSQL.sql_PM_PM;
		
//		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
//            DBHandler dbHandler = new DBHandler();
//            conn = dbHandler.getConnectionCubePusan(); //����� �λ�DB ��ȸ
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            log.info("Mobile PM send content");
//            log.info("============================================");
            
            while(rs.next()){
            	result += rs.getString(1); //1���� ����
            }
            System.out.println(result);
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB ������ �����Ѵ�.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
//                if ( conn != null ){conn.close(); }
                log.info("PreparedStatement �ڿ� �ݳ�");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	//����� �븮�� ȣ��ȯ(ARS����)
	//����� -> �λ�DB ����
	public String staticMobilePMAgency(Connection conn) {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		sql = contentSQL.sql_PM_PM_AGENCY;
		
//		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
//            DBHandler dbHandler = new DBHandler();
//            conn = dbHandler.getConnectionCubePusan(); //����� �λ�DB ��ȸ
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            log.info("Mobile PM Agency send content");
//            log.info("============================================");
            
            while(rs.next()){
            	result += rs.getString(1); //1���� ����
            }
            System.out.println(result);
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB ������ �����Ѵ�.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
//                if ( conn != null ){conn.close(); }
                log.info("PreparedStatement �ڿ� �ݳ�");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	
	//HOME ������
	//HOME -> ����DB ����
	public String staticHomeHS(Connection conn) {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		sql = contentSQL.sql_PM_HS;
		
		//Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubeSeoul(); //HOME ����DB ��ȸ
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            log.info("HS send content");
//            log.info("============================================");
            
            while(rs.next()){
            	result += rs.getString(1); //1���� ����
            }
            System.out.println(result);
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB ������ �����Ѵ�.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                //if ( conn != null ){conn.close(); }
                log.info("PreparedStatement �ڿ� �ݳ�");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	
	
	
}
