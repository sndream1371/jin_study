package lguplus.cs.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBHandler {
	
	Logger log = LoggerFactory.getLogger(DBHandler.class);
	
	public Connection homeSeoulDBConn;
	public Connection mobileBusanDBConn;
	public Connection homeSeoulDBClose;
	public Connection mobileBusanDBlose;

	
	public Connection getHomeSeoulDBConn() throws Exception{
		this.homeSeoulDBConn = getConnectionCubeSeoul();
		return homeSeoulDBConn;
	}

	public Connection getMobileBusanDBConn()  throws Exception{
		this.mobileBusanDBConn = getConnectionCubePusan();
		return mobileBusanDBConn;
	}

	public Connection getHomeSeoulDBClose() {
		return homeSeoulDBClose;
	}


	public void setHomeSeoulDBClose() {
		try {
			homeSeoulDBConn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}


	public Connection getMobileBusanDBlose() {
		return mobileBusanDBlose;
	}


	public void setMobileBusanDBlose() {
		try {
			mobileBusanDBlose.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	//Ȩ ���＾��
	public Connection getConnectionCubeSeoul()
    {
        Connection conn = null;
        try {
        	
            String user = "CTIAPP"; 
            String pw = "hdbcti1$";
            //String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String url = "jdbc:oracle:thin:@172.25.23.40:1521:PUCTIHO";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            log.info("Database�� ����Ǿ����ϴ�.\n");
            
        } catch (ClassNotFoundException cnfe) {
            log.info("DB ����̹� �ε� ���� :"+cnfe.toString());
        } catch (SQLException sqle) {
            log.info("DB ���ӽ��� : "+sqle.toString());
        } catch (Exception e) {
            log.info("Unkonwn error");
            e.printStackTrace();
        }
        return conn;     
    }

    
	//����� �λ�
    public Connection getConnectionCubePusan()
    {
        Connection conn = null;
        try {
        	
            String user = "CTIAPP"; 
            String pw = "mdbcti1$";
            //String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String url = "jdbc:oracle:thin:@172.25.33.40:1521:PUCTIMO";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            log.info("Database�� ����Ǿ����ϴ�.\n");
            
        } catch (ClassNotFoundException cnfe) {
            log.info("DB ����̹� �ε� ���� :"+cnfe.toString());
        } catch (SQLException sqle) {
            log.info("DB ���ӽ��� : "+sqle.toString());
        } catch (Exception e) {
            log.info("Unkonwn error");
            e.printStackTrace();
        }
        return conn;     
    }


}
