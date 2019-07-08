package lguplus.cs.sms;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * SMS 송신대상 사용자 정보를 file에서 읽어 각 송신구분에 맞게 SMS전송 테이블에 Insert처리
 * 송신구분에 따라 보내는 내용이 다름(5가지 형태) : PM , BS, TRN, USHOP, HS_30
 * 
 */
public class SendSMS {
	
	static Logger log = LoggerFactory.getLogger(SendSMS.class);
	

	public static void main(String[] argv) {
		
		if( argv.length != 2) { //옵션 갯수를 2개 받는다.
			log.info("1 param :전송구분 코드 [HS_30, PM, TRN, USHOP, BS], 2 param 전송 대상자 (filePath - ex) D:/senderList_manual.txt");
			return;
		}
		
//		execProcess("BS");  //local for test (로컬에서 테스트)  :전송 구분 코드: HS_30, PM, TRN, USHOP, BS, ALL은 모두 메세지 보낸다.
		
		execProcess(argv[0], argv[1]); //옵션 받은 정보로 호출
		
	}
	
	//수작업 처리시 사용하는 메소드
	public static void execProcess(String bizGubun, String filePath) {
		
		List<String> senderList = new ArrayList<String>();
		
		//주말,공휴일 테이블 조회후 True이면 SMS 전송 X
//		SMSContentInfo contentInfo = new SMSContentInfo();
//		if( contentInfo.isHoliday() ) {
//			log.info("오늘은 공휴일 입니다. SMS 발송이 대상일이 아닙니다.!");
//			return; //공휴일이면 더이상 프로세스 진행 안함
//		}
		
		FileHandler fileHandler = new FileHandler(filePath); //filePath : D:/sender_list_manual.txt
		senderList = fileHandler.fileReader();
		
		log.info("bizGubun > "+bizGubun);
		smsUserList(senderList, bizGubun);
		
	}

	//스케쥴에서 요청해서 처리하는 메소드
	public static void execProcess(String bizGubun) {
		
		List<String> senderList = new ArrayList<String>();
		
		//주말,공휴일 테이블 조회후 True이면 SMS 전송 X
		SMSContentInfo contentInfo = new SMSContentInfo();
		if( contentInfo.isHoliday() ) {
			log.info("오늘은 공휴일 입니다. SMS 발송이 대상일이 아닙니다.!");
			return; //공휴일이면 더이상 프로세스 진행 안함
		}
		
//		FileHandler fileHandler = new FileHandler("D:/개발/1. 통합발송(SMS) VB-JAVA로 전환/sender_list.txt"); //무명인,010022879727,HS_30 형태
		FileHandler fileHandler = new FileHandler("D:/sender_list.txt"); //무명인,010022879727,HS_30 형태
		senderList = fileHandler.fileReader();
		
		//bizGubun = "BS";  //for test 실제 스케쥴 적용시는 생성자를 이용한다. //전송 구분 코드: HS_30, PM, TRN, USHOP, BS, ALL은 모두 메세지 보낸다.

		log.info("bizGubun > "+bizGubun);
		smsUserList(senderList, bizGubun);
		
	}
	
	//SMS보낼 사용자를 파일에서 읽어온 사용자 정보를 처리한다.
	public static void smsUserList(List<String> list, String bizGubun) {
		
		String [] senderInfo= null;
		
		DBHandler dbHandler = new DBHandler();
		
		Connection connHome = null;
		Connection connMobile = null;
		
		try {
			
			//전송타입별 DB접근 분기, DB1번 접속후 여러번 파일 처리를 위함
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
				log.info("송신 구분값이 없습니다. 파일정보의 3번째 파라미터 정보를 확인 바랍니다.");
				return;
			}
			
			for(String data : list) {
				
				senderInfo = data.split("\\,"); //구분자 ","(콤마)
				
				if( "".equals(senderInfo[0].trim()) || senderInfo[0].contains("#") ) { //빈칸 개행줄, "#"들어간 정보는 무시한다.
					log.info("# 주석이 검색되어 SKIP...");
					continue;
				}
				
				log.info("[이름]"+ senderInfo[0]+" [Mobile]"+senderInfo[1] +" [전송타입]"+senderInfo[2]);
				
				String senderTelNum = senderInfo[1]; //SMS 보낼사람의 모바일 전화번호(12자리)
				String sendType = ( !"".equals(senderInfo[2]) ? senderInfo[2].toUpperCase() : senderInfo[2] ); //전송타입이 null이 아니면 대문자로 전환
				
				if( !sendType.equals(bizGubun.toUpperCase()) ) { //파일에 읽어들어 송신구분과 생성자에서 설정한 송신구분이 같을 경우만 다음로직 처리
					log.info("송신구분 대상이 아닙니다.");
					continue;
				}

				SMSContentInfo conInfo = new SMSContentInfo();
				SMSInsertInfo insertInfo = new SMSInsertInfo();
				String smsMessage = "";
				
				switch(sendType) {
					case "PM": 
								log.info("PM 통계정보 조회 , SMS전송 테이블 Insert");
								smsMessage = conInfo.staticMobilePM(connMobile) + conInfo.staticMobilePMAgency(connMobile) + conInfo.staticHomeHS(connHome) + conInfo.staticHomeHSJoin(connHome);
								insertInfo.insertMMSTable(senderTelNum, smsMessage, sendType, connHome); //장문 MMS
								break;
					
					case "BS": 
								log.info("BS 통계정보 조회 , SMS전송 테이블 Insert");
								smsMessage = conInfo.staticHomeBS(connHome);
								//log.info("SMS MSG :"+smsMessage);
								insertInfo.insertMMSTable(senderTelNum, smsMessage, sendType, connHome); //장문 MMS
								break;
					
					case "TRN": 
								log.info("TRN 통계정보 조회 , SMS전송 테이블 Insert");
								smsMessage = conInfo.staticMobileTRN(connMobile);
								insertInfo.insertSMSTable(senderTelNum, smsMessage, sendType, connHome);  //단문 SMS
								break;
					
					case "USHOP":
								log.info("USHOP 통계정보 조회 , SMS전송 테이블 Insert");
								smsMessage = conInfo.staticHomeUSHOP(connHome);
								insertInfo.insertSMSTable(senderTelNum, smsMessage, sendType, connHome); //단문 SMS
								break;
					
					case "HS_30":
								log.info("HS_30 통계정보 조회 , SMS전송 테이블 Insert");
								smsMessage = conInfo.staticHomeHS30(connHome);
								insertInfo.insertMMSTable(senderTelNum, smsMessage, sendType, connHome); //장문 MMS
								break;
					
					case "ALL": //5가지 전송타입을 한번에 전송한다. 사용 X
								insertInfo.insertMMSTable(senderTelNum, conInfo.staticMobilePM(connMobile) + conInfo.staticMobilePMAgency(connMobile) + conInfo.staticHomeBS(connHome), sendType, connHome); //PM , 장문 MMS
								insertInfo.insertMMSTable(senderTelNum, conInfo.staticHomeBS(connHome), sendType, connHome); 	   //BS, 장문 MMS
								insertInfo.insertSMSTable(senderTelNum, conInfo.staticMobileTRN(connMobile), sendType, connHome);  //TRN, 단문 SMS
								insertInfo.insertSMSTable(senderTelNum, conInfo.staticHomeUSHOP(connHome), sendType, connHome);  //USHOP, 단문 SMS
								insertInfo.insertMMSTable(senderTelNum, conInfo.staticHomeHS30(connHome), sendType, connHome);   //HS_30, 장문 MMS
					default: 
								log.info("전송 대상 구분 없슴");
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
