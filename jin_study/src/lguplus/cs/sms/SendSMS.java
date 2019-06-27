package lguplus.cs.sms;

import java.util.ArrayList;
import java.util.List;

/*
 * SMS 송신대상 사용자 정보를 file에서 읽어 각 송신구분에 맞게 SMS전송 테이블에 Insert처리
 * 송신구분에 따라 보내는 내용이 다름(5가지 형태) : PM , BS, TRN, USHOP, HS_30
 * 
 */
public class SendSMS {
	
	static String bizGubun = "";
	
	public SendSMS(String gubun) {
		this.bizGubun = gubun;
	}

	public static void main(String[] argv) {
		
		List<String> senderList = new ArrayList<String>();
		
		//주말,공휴일 테이블 조회후 True이면 SMS 전송 X
		SMSContentInfo contentInfo = new SMSContentInfo();
		if( contentInfo.isHoliday() ) {
			System.out.println("오늘은 공휴일 입니다. SMS 발송이 대상일이 아닙니다.!");
			return; //공휴일이면 더이상 프로세스 진행 안함
		}
		
//		FileHandler fileHandler = new FileHandler("D:/개발/1. 통합발송(SMS) VB-JAVA로 전환/sender_list.txt"); //무명인,010022879727,HS_30 형태
		FileHandler fileHandler = new FileHandler("D:/sender_list.txt"); //무명인,010022879727,HS_30 형태
		senderList = fileHandler.fileReader();
		
		bizGubun = "USHOP";  //for test 실제 스케쥴 적용시는 생성자를 이용한다. //전송 구분 코드: HS_30, PM, TRN, USHOP, BS
				
		smsUserList(senderList, bizGubun);
				

	}

	//SMS보낼 사용자를 파일에서 읽어온 사용자 정보를 처리한다.
	public static void smsUserList(List<String> list, String gubun) {
		
		String [] senderInfo= null;

		for(String data : list) {
			
			senderInfo = data.split("\\,"); //구분자 ","(콤마)
			
			if( "".equals(senderInfo[0].trim()) || senderInfo[0].contains("#") ) { //빈칸 개행줄, "#"들어간 정보는 무시한다.
				System.out.println("# 주석이 검색되어 SKIP...");
				continue;
			}
			
			System.out.println("[이름]"+ senderInfo[0]+" [Mobile]"+senderInfo[1] +" [전송타입]"+senderInfo[2]);
			
			String senderTelNum = senderInfo[1]; //SMS 보낼사람의 모바일 전화번호(12자리)
			String sendType = ( !"".equals(senderInfo[2]) ? senderInfo[2].toUpperCase() : senderInfo[2] ); //전송타입이 null이 아니면 대문자로 전환
			
			if( !sendType.equals(gubun.toUpperCase()) ) { //파일에 읽어들어 송신구분과 생성자에서 설정한 송신구분이 같을 경우만 다음로직 처리
				System.out.println("송신구분 대상이 아닙니다.");
				continue;
			}

			SMSContentInfo conInfo = new SMSContentInfo();
			SMSInsertInfo insertInfo = new SMSInsertInfo();
			String smsMessage = "";
			
			switch(sendType) {
				case "PM": 
							System.out.println("PM 통계정보 조회 , SMS전송 테이블 Insert");
							smsMessage = conInfo.staticMobilePM() + conInfo.staticMobilePMAgency() + conInfo.staticHomeBS();
//							insertInfo.insertMMSTable(senderTelNum, smsMessage, sendType); //장문 MMS
							break;
				
				case "BS": 
							System.out.println("BS 통계정보 조회 , SMS전송 테이블 Insert");
							smsMessage = conInfo.staticHomeBS();
//							insertInfo.insertMMSTable(senderTelNum, smsMessage, sendType); //장문 MMS
							break;
				
				case "TRN": 
							System.out.println("TRN 통계정보 조회 , SMS전송 테이블 Insert");
							smsMessage = conInfo.staticMobileTRN();
//							insertInfo.insertSMSTable(senderTelNum, smsMessage, sendType);  //단문 SMS
							break;
				
				case "USHOP":
							System.out.println("USHOP 통계정보 조회 , SMS전송 테이블 Insert");
							smsMessage = conInfo.staticHomeUSHOP();
//							insertInfo.insertSMSTable(senderTelNum, smsMessage, sendType); //단문 SMS
							break;
				
				case "HS_30":
							System.out.println("HS_30 통계정보 조회 , SMS전송 테이블 Insert");
							smsMessage = conInfo.staticHomeHS30();
//							insertInfo.insertMMSTable(senderTelNum, smsMessage, sendType); //장문 MMS
							break;
				
				default: 
							System.out.println("전송 대상 구분 없슴");
							break;
			
			}
			
			
		}
		
	}

	
	

		
	
}
