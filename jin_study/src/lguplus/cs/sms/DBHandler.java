package lguplus.cs.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {
	
	public Connection dbConn;
    
    public Connection getConnectionCubeSeoul()
    {
        Connection conn = null;
        try {
        	
        	//VB��������
//            '���� ���ڿ��� �ۼ��Ѵ�.
//            strCnn = "Provider=MSDAORA.1;" & _
//                     "User ID=CTIAPP;password=hdbcti1$;" & _
//                     "Data Source=PUCTIHO;" '& _
                     
            String user = "CTIAPP"; 
            String pw = "hdbcti1$";
            //String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String url = "jdbc:oracle:thin:@172.25.23.40:1521:PUCTIHO";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Database�� ����Ǿ����ϴ�.\n");
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB ����̹� �ε� ���� :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB ���ӽ��� : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
        return conn;     
    }

    
    public Connection getConnectionCubePusan()
    {
        Connection conn = null;
        try {
        	
        	//VB��������
//            strCnn = "Provider=MSDAORA.1;" & _
//                    "User ID=CTIAPP;password=mdbcti1$;" & _
//                    "Data Source=PUCTIMO;" '& _
                     
            String user = "CTIAPP"; 
            String pw = "mdbcti1$";
            //String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String url = "jdbc:oracle:thin:@172.25.33.40:1521:PUCTIMO";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Database�� ����Ǿ����ϴ�.\n");
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB ����̹� �ε� ���� :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB ���ӽ��� : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
        return conn;     
    }


}
