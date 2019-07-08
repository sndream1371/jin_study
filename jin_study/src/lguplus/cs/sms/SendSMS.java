package lguplus.cs.sms;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * SMS �۽Ŵ�� ����� ������ file���� �о� �� �۽ű��п� �°� SMS���� ���̺� Insertó��
 * �۽ű��п� ���� ������ ������ �ٸ�(5���� ����) : PM , BS, TRN, USHOP, HS_30
 * 
 */
public class SendSMS {
	
	static Logger log = LoggerFactory.getLogger(SendSMS.class);
	

	public static void main(String[] argv) {
		
		if( argv.length != 2) { //�ɼ� ������ 2�� �޴´�.
			log.info("1 param :���۱��� �ڵ� [HS_30, PM, TRN, USHOP, BS], 2 param ���� ����� (filePath - ex) D:/senderList_manual.txt");
			return;
		}
		
//		execProcess("BS");  //local for test (���ÿ��� �׽�Ʈ)  :���� ���� �ڵ�: HS_30, PM, TRN, USHOP, BS, ALL�� ��� �޼��� ������.
		
		execProcess(argv[0], argv[1]); //�ɼ� ���� ������ ȣ��
		
	}
	
	//���۾� ó���� ����ϴ� �޼ҵ�
	public static void execProcess(String bizGubun, String filePath) {
		
		List<String> senderList = new ArrayList<String>();
		
		//�ָ�,������ ���̺� ��ȸ�� True�̸� SMS ���� X
//		SMSContentInfo contentInfo = new SMSContentInfo();
//		if( contentInfo.isHoliday() ) {
//			log.info("������ ������ �Դϴ�. SMS �߼��� ������� �ƴմϴ�.!");
//			return; //�������̸� ���̻� ���μ��� ���� ����
//		}
		
		FileHandler fileHandler = new FileHandler(filePath); //filePath : D:/sender_list_manual.txt
		senderList = fileHandler.fileReader();
		
		log.info("bizGubun > "+bizGubun);
		smsUserList(senderList, bizGubun);
		
	}

	//�����쿡�� ��û�ؼ� ó���ϴ� �޼ҵ�
	public static void execProcess(String bizGubun) {
		
		List<String> senderList = new ArrayList<String>();
		
		//�ָ�,������ ���̺� ��ȸ�� True�̸� SMS ���� X
		SMSContentInfo contentInfo = new SMSContentInfo();
		if( contentInfo.isHoliday() ) {
			log.info("������ ������ �Դϴ�. SMS �߼��� ������� �ƴմϴ�.!");
			return; //�������̸� ���̻� ���μ��� ���� ����
		}
		
//		FileHandler fileHandler = new FileHandler("D:/����/1. ���չ߼�(SMS) VB-JAVA�� ��ȯ/sender_list.txt"); //������,010022879727,HS_30 ����
		FileHandler fileHandler = new FileHandler("D:/sender_list.txt"); //������,010022879727,HS_30 ����
		senderList = fileHandler.fileReader();
		
		//bizGubun = "BS";  //for test ���� ������ ����ô� �����ڸ� �̿��Ѵ�. //���� ���� �ڵ�: HS_30, PM, TRN, USHOP, BS, ALL�� ��� �޼��� ������.

		log.info("bizGubun > "+bizGubun);
		smsUserList(senderList, bizGubun);
		
	}
	
	//SMS���� ����ڸ� ���Ͽ��� �о�� ����� ������ ó���Ѵ�.
	public static void smsUserList(List<String> list, String bizGubun) {
		
		String [] senderInfo= null;
		
		DBHandler dbHandler = new DBHandler();
		
		Connection connHome = null;
		Connection connMobile = null;
		
		try {
			
			//����Ÿ�Ժ� DB���� �б�, DB1�� ������ ������ ���� ó���� ����
			if( "PM".equals(bizGubun) ) {
				connHome = dbHandler.getHomeSeoulDBConn();
				connMobile = dbHandler.getMobileBusanDBConn();
				
			}else if( "BS".equals(bizGubun) ) {
				connHome = dbHandler.getHomeSeoulDBConn();
			}else if( "TRN".equals(bizGubun) ) {
				connMobile = dbHandler.getMobileBusanDBConn();
				connHome = dbHandler.getHomeSeoulDBConn();
			}else if( "USHOP".equals(bizGubun) ) {
				connHome = dbHandler.getHomeSeoulDBConn();
			}else if( "HS_30".equals(bizGubun) ) {
				connHome = dbHandler.getHomeSeoulDBConn();
			}else {
				log.info("�۽� ���а��� �����ϴ�. ���������� 3��° �Ķ���� ������ Ȯ�� �ٶ��ϴ�.");
				return;
			}
			
			for(String data : list) {
				
				senderInfo = data.split("\\,"); //������ ","(�޸�)
				
				if( "".equals(senderInfo[0].trim()) || senderInfo[0].contains("#") ) { //��ĭ ������, "#"�� ������ �����Ѵ�.
					log.info("# �ּ��� �˻��Ǿ� SKIP...");
					continue;
				}
				
				log.info("[�̸�]"+ senderInfo[0]+" [Mobile]"+senderInfo[1] +" [����Ÿ��]"+senderInfo[2]);
				
				String senderTelNum = senderInfo[1]; //SMS ��������� ����� ��ȭ��ȣ(12�ڸ�)
				String sendType = ( !"".equals(senderInfo[2]) ? senderInfo[2].toUpperCase() : senderInfo[2] ); //����Ÿ���� null�� �ƴϸ� �빮�ڷ� ��ȯ
				
				if( !sendType.equals(bizGubun.toUpperCase()) ) { //���Ͽ� �о��� �۽ű��а� �����ڿ��� ������ �۽ű����� ���� ��츸 �������� ó��
					log.info("�۽ű��� ����� �ƴմϴ�.");
					continue;
				}

				SMSContentInfo conInfo = new SMSContentInfo();
				SMSInsertInfo insertInfo = new SMSInsertInfo();
				String smsMessage = "";
				
				switch(sendType) {
					case "PM": 
								log.info("PM ������� ��ȸ , SMS���� ���̺� Insert");
								smsMessage = conInfo.staticMobilePM(connMobile) + conInfo.staticMobilePMAgency(connMobile) + conInfo.staticHomeHS(connHome) + conInfo.staticHomeHSJoin(connHome);
								insertInfo.insertMMSTable(senderTelNum, smsMessage, sendType, connHome); //�幮 MMS
								break;
					
					case "BS": 
								log.info("BS ������� ��ȸ , SMS���� ���̺� Insert");
								smsMessage = conInfo.staticHomeBS(connHome);
								//log.info("SMS MSG :"+smsMessage);
								insertInfo.insertMMSTable(senderTelNum, smsMessage, sendType, connHome); //�幮 MMS
								break;
					
					case "TRN": 
								log.info("TRN ������� ��ȸ , SMS���� ���̺� Insert");
								smsMessage = conInfo.staticMobileTRN(connMobile);
								insertInfo.insertSMSTable(senderTelNum, smsMessage, sendType, connHome);  //�ܹ� SMS
								break;
					
					case "USHOP":
								log.info("USHOP ������� ��ȸ , SMS���� ���̺� Insert");
								smsMessage = conInfo.staticHomeUSHOP(connHome);
								insertInfo.insertSMSTable(senderTelNum, smsMessage, sendType, connHome); //�ܹ� SMS
								break;
					
					case "HS_30":
								log.info("HS_30 ������� ��ȸ , SMS���� ���̺� Insert");
								smsMessage = conInfo.staticHomeHS30(connHome);
								insertInfo.insertMMSTable(senderTelNum, smsMessage, sendType, connHome); //�幮 MMS
								break;
					
					case "ALL": //5���� ����Ÿ���� �ѹ��� �����Ѵ�. ��� X
								insertInfo.insertMMSTable(senderTelNum, conInfo.staticMobilePM(connMobile) + conInfo.staticMobilePMAgency(connMobile) + conInfo.staticHomeBS(connHome), sendType, connHome); //PM , �幮 MMS
								insertInfo.insertMMSTable(senderTelNum, conInfo.staticHomeBS(connHome), sendType, connHome); 	   //BS, �幮 MMS
								insertInfo.insertSMSTable(senderTelNum, conInfo.staticMobileTRN(connMobile), sendType, connHome);  //TRN, �ܹ� SMS
								insertInfo.insertSMSTable(senderTelNum, conInfo.staticHomeUSHOP(connHome), sendType, connHome);  //USHOP, �ܹ� SMS
								insertInfo.insertMMSTable(senderTelNum, conInfo.staticHomeHS30(connHome), sendType, connHome);   //HS_30, �幮 MMS
					default: 
								log.info("���� ��� ���� ����");
								break;
				
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {		
				if( connHome != null) connHome.close(); //DB close
				log.info("HOME DB Close...");
				
				if( connMobile != null) connMobile.close(); //DB close
				log.info("Mobile DB Close...");
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}

		
		
	}


		
	
}
