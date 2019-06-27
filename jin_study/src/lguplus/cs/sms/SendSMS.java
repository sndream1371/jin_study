package lguplus.cs.sms;

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
		
		bizGubun = "BS"; //"HS_30"; //for test ���� ������ ����ô� �����ڸ� �̿��Ѵ�.
				
		smsUserList(senderList, bizGubun);
				

	}

	//SMS���� ����ڸ� ���Ͽ��� �о�� ����� ������ ó���Ѵ�.
	public static void smsUserList(List<String> list, String gubun) {
		
		String [] senderInfo= null;

		for(String data : list) {
			
			senderInfo = data.split("\\,"); //������ ","(�޸�)
			
			if( "".equals(senderInfo[0].trim()) || senderInfo[0].contains("#") ) { //��ĭ ������, "#"�� ������ �����Ѵ�.
				System.out.println("# �ּ��� �˻��Ǿ� SKIP...");
				continue;
			}
			
			System.out.println("[�̸�]"+ senderInfo[0]+" [Mobile]"+senderInfo[1] +" [����Ÿ��]"+senderInfo[2]);
			
			String sendType = ( !"".equals(senderInfo[2]) ? senderInfo[2].toUpperCase() : senderInfo[2] ); //����Ÿ���� null�� �ƴϸ� �빮�ڷ� ��ȯ
			
			if( !sendType.equals(gubun.toUpperCase()) ) { //���Ͽ� �о��� �۽ű��а� �����ڿ��� ������ �۽ű����� ���� ��츸 �������� ó��
				System.out.println("�۽ű��� ����� �ƴմϴ�.");
				continue;
			}

			SMSContentInfo conInfo = new SMSContentInfo();
			
			switch(sendType) {
				case "PM": 
							System.out.println("PM ������� ��ȸ , SMS���� ���̺� Insert");
							break;
				
				case "BS": 
							conInfo.staticHomeBS();
							System.out.println("BS ������� ��ȸ , SMS���� ���̺� Insert");
							break;
				
				case "TRN": 
							System.out.println("TRN ������� ��ȸ , SMS���� ���̺� Insert");
							break;
				
				case "USHOP":
							System.out.println("USHOP ������� ��ȸ , SMS���� ���̺� Insert");
							break;
				
				case "HS_30":
							System.out.println("HS_30 ������� ��ȸ , SMS���� ���̺� Insert");
							break;
				
				default: 
							System.out.println("���� ��� ���� ����");
							break;
			
			}
			
			
		}
		
	}

	
	

		
	
}
