package lguplus.cs.sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SMSContentInfo {

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
            
            System.out.println("cnt");
            System.out.println("============================================");
            
            while(rs.next()){
                cnt = rs.getBoolean(1); //1���� ����
                System.out.println(cnt);
            }
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
        }finally{
            // DB ������ �����Ѵ�.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
                System.out.println("DB ������ �����Ͽ����ϴ�.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
	
		return cnt;
	}
	
	//BS ������ �����ȸ
	public String staticHomeBS() {
		
		String result = "";
		SMSContentSQL contentSQL = new SMSContentSQL();
		String sql = contentSQL.sql_BS;
		
		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubeSeoul();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            System.out.println("HOME BS send content");
//            System.out.println("============================================");
            
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
                if ( conn != null ){conn.close(); }
                System.out.println("DB ������ �����Ͽ����ϴ�.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
	
		return result;
	}
	
	
	//����� ������ �̰� ��ȸ 
	//����� -> �λ�DB ����
	public String staticMobileTRN() {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		sql = contentSQL.sql_PM_TRN;
		
		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubePusan(); //������� �λ�DB ��ȸ
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            System.out.println("Mobile TRN send content");
//            System.out.println("============================================");
            
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
                if ( conn != null ){conn.close(); }
                System.out.println("DB ������ �����Ͽ����ϴ�.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	
	//HOME U+ SHOP 
	//HOME -> ����DB ����
	public String staticHomeUSHOP() {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		sql = contentSQL.sql_USHOP;
		
		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubeSeoul(); //HOME ����DB ��ȸ
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            System.out.println("U+SHOP send content");
//            System.out.println("============================================");
            
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
                if ( conn != null ){conn.close(); }
                System.out.println("DB ������ �����Ͽ����ϴ�.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	
	//HOME HS_30�� �����ο�(�̹���)
	//HOME -> ����DB ����
	public String staticHomeHS30() {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		Util util = new Util();
		if( util.checkMonday() ) { //������
			sql = contentSQL.sql_HS_30_Monday;
		}else {
			sql = contentSQL.sql_HS_30_NOT_Monday;
		}
		
		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubeSeoul(); //HOME ����DB ��ȸ
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            System.out.println("HS_30 send content");
            System.out.println("============================================");
            
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
                if ( conn != null ){conn.close(); }
                System.out.println("DB ������ �����Ͽ����ϴ�.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	
	//����� ������
	//����� -> �λ�DB ����
	public String staticMobilePM() {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		sql = contentSQL.sql_PM_PM;
		
		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubePusan(); //����� �λ�DB ��ȸ
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            System.out.println("Mobile PM send content");
//            System.out.println("============================================");
            
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
                if ( conn != null ){conn.close(); }
                System.out.println("DB ������ �����Ͽ����ϴ�.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	//����� �븮�� ȣ��ȯ(ARS����)
	//����� -> �λ�DB ����
	public String staticMobilePMAgency() {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		sql = contentSQL.sql_PM_PM_AGENCY;
		
		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubePusan(); //����� �λ�DB ��ȸ
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            System.out.println("Mobile PM Agency send content");
//            System.out.println("============================================");
            
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
                if ( conn != null ){conn.close(); }
                System.out.println("DB ������ �����Ͽ����ϴ�.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	
	//HOME ������
	//HOME -> ����DB ����
	public String staticHomeHS() {
		
		String result = "", sql = "";
		
		SMSContentSQL contentSQL = new SMSContentSQL();
		sql = contentSQL.sql_PM_HS;
		
		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
            DBHandler dbHandler = new DBHandler();
        	
            conn = dbHandler.getConnectionCubeSeoul(); //HOME ����DB ��ȸ
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
//            System.out.println("HS send content");
//            System.out.println("============================================");
            
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
                if ( conn != null ){conn.close(); }
                System.out.println("DB ������ �����Ͽ����ϴ�.");
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
	
		return result;
	}
	
	
	
	
}
