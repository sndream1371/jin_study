package lguplus.cs.sms;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/*
 * SMS �۽Ŵ�� ����� ������ file���� �о� �� �۽ű��п� �°� SMS���� ���̺� Insertó��
 * �۽ű��п� ���� ������ ������ �ٸ�(5���� ����) : PM , BS, TRN, USHOP, HS_30
 * 
 */
public class SendSMS {
	
	static String bizGubun = "";
	
	public SendSMS(String gubun) {
		this.bizGubun = gubun;
	}

	public static void main(String[] argv) {
		
		List<String> senderList = new ArrayList<String>();
		
		//�ָ�,������ ���̺� ��ȸ�� True�̸� SMS ���� X
		SMSContentInfo contentInfo = new SMSContentInfo();
		if( contentInfo.isHoliday() ) {
			System.out.println("������ ������ �Դϴ�. SMS �߼��� ������� �ƴմϴ�.!");
			return; //�������̸� ���̻� ���μ��� ���� ����
		}
		
//		FileHandler fileHandler = new FileHandler("D:/����/1. ���չ߼�(SMS) VB-JAVA�� ��ȯ/sender_list.txt"); //������,010022879727,HS_30 ����
		FileHandler fileHandler = new FileHandler("D:/sender_list.txt"); //������,010022879727,HS_30 ����
		senderList = fileHandler.fileReader();
		
		bizGubun = "HS_30";  //for test ���� ������ ����ô� �����ڸ� �̿��Ѵ�. //���� ���� �ڵ�: HS_30, PM, TRN, USHOP, BS, ALL�� ��� �޼��� ������.
				
		smsUserList(senderList, bizGubun);
				

	}

	//SMS���� ����ڸ� ���Ͽ��� �о�� ����� ������ ó���Ѵ�.
	public static void smsUserList(List<String> list, String gubun) {
		
		String [] senderInfo= null;
		
		DBHandler dbHandler = new DBHandler();
		
		Connection connHome = null;
		Connection connMobile = null;
		
		//����Ÿ�Ժ� DB���� �б�, DB1�� ������ ������ ���� ó���� ����
		if( "PM".equals(bizGubun) ) {
			connHome = dbHandler.getHomeSeoulDBConn();
			connMobile = dbHandler.getMobileBusanDBConn();
			
		}else if( "BS".equals(bizGubun) ) {
			connHome = dbHandler.getHomeSeoulDBConn();
		}else if( "TRN".equals(bizGubun) ) {
			connMobile = dbHandler.getMobileBusanDBConn();
		}else if( "USHOP".equals(bizGubun) ) {
			connHome = dbHandler.getHomeSeoulDBConn();
		}else if( "HS_30".equals(bizGubun) ) {
			connHome = dbHandler.getHomeSeoulDBConn();
		}else {
			System.out.println("�۽� ���а��� �����ϴ�. ���������� 3��° �Ķ���� ������ Ȯ�� �ٶ��ϴ�.");
			return;
		}
		
		try {
			for(String data : list) {
				
				senderInfo = data.split("\\,"); //������ ","(�޸�)
				
				if( "".equals(senderInfo[0].trim()) || senderInfo[0].contains("#") ) { //��ĭ ������, "#"�� ������ �����Ѵ�.
					System.out.println("# �ּ��� �˻��Ǿ� SKIP...");
					continue;
				}
				
				System.out.println("[�̸�]"+ senderInfo[0]+" [Mobile]"+senderInfo[1] +" [����Ÿ��]"+senderInfo[2]);
				
				String senderTelNum = senderInfo[1]; //SMS ��������� ����� ��ȭ��ȣ(12�ڸ�)
				String sendType = ( !"".equals(senderInfo[2]) ? senderInfo[2].toUpperCase() : senderInfo[2] ); //����Ÿ���� null�� �ƴϸ� �빮�ڷ� ��ȯ
				
				if( !sendType.equals(gubun.toUpperCase()) ) { //���Ͽ� �о��� �۽ű��а� �����ڿ��� ������ �۽ű����� ���� ��츸 �������� ó��
					System.out.println("�۽ű��� ����� �ƴմϴ�.");
					continue;
				}

				SMSContentInfo conInfo = new SMSContentInfo();
				SMSInsertInfo insertInfo = new SMSInsertInfo();
				String smsMessage = "";
				
				switch(sendType) {
					case "PM": 
								System.out.println("PM ������� ��ȸ , SMS���� ���̺� Insert");
								smsMessage = conInfo.staticMobilePM(connMobile) + conInfo.staticMobilePMAgency(connMobile) + conInfo.staticHomeHS(connHome);
//								insertInfo.insertMMSTable(senderTelNum, smsMessage, sendType, connHome); //�幮 MMS
								break;
					
					case "BS": 
								System.out.println("BS ������� ��ȸ , SMS���� ���̺� Insert");
								smsMessage = conInfo.staticHomeBS(connHome);
								//System.out.println("SMS MSG :"+smsMessage);
								insertInfo.insertMMSTable(senderTelNum, smsMessage, sendType, connHome); //�幮 MMS
								break;
					
					case "TRN": 
								System.out.println("TRN ������� ��ȸ , SMS���� ���̺� Insert");
								smsMessage = conInfo.staticMobileTRN(connMobile);
//								insertInfo.insertSMSTable(senderTelNum, smsMessage, sendType, connHome);  //�ܹ� SMS
								break;
					
					case "USHOP":
								System.out.println("USHOP ������� ��ȸ , SMS���� ���̺� Insert");
								smsMessage = conInfo.staticHomeUSHOP(connHome);
								insertInfo.insertSMSTable(senderTelNum, smsMessage, sendType, connHome); //�ܹ� SMS
								break;
					
					case "HS_30":
								System.out.println("HS_30 ������� ��ȸ , SMS���� ���̺� Insert");
								smsMessage = conInfo.staticHomeHS30(connHome);
								insertInfo.insertMMSTable(senderTelNum, smsMessage, sendType, connHome); //�幮 MMS
								break;
					
					case "ALL":
//								insertInfo.insertMMSTable(senderTelNum, conInfo.staticMobilePM(connMobile) + conInfo.staticMobilePMAgency(connMobile) + conInfo.staticHomeBS(connHome), sendType, connHome); //PM , �幮 MMS
//								insertInfo.insertMMSTable(senderTelNum, conInfo.staticHomeBS(connHome), sendType, connHome); 	   //BS, �幮 MMS
//								insertInfo.insertSMSTable(senderTelNum, conInfo.staticMobileTRN(connMobile), sendType, connHome);  //TRN, �ܹ� SMS
//								insertInfo.insertSMSTable(senderTelNum, conInfo.staticHomeUSHOP(connHome), sendType, connHome);  //USHOP, �ܹ� SMS
//								insertInfo.insertMMSTable(senderTelNum, conInfo.staticHomeHS30(connHome), sendType, connHome);   //HS_30, �幮 MMS
					default: 
								System.out.println("���� ��� ���� ����");
								break;
				
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {		
				if( connHome != null) connHome.close(); //DB close
				System.out.println("HOME DB Close...");
				
				if( connMobile != null) connMobile.close(); //DB close
				System.out.println("Mobile DB Close...");
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}

		
		
	}


		
	
}
