package lguplus.cs.sms;

public class SMSInsertSQL {
	
	
	//SMS(단문 80바이트) EAI테이블에 입력
	public String InsertSMS() {
		
		String Insert_SMS =
				"INSERT INTO TB_SMS_SEND_SHORT  "+ 
				"(CTN, SMS_SEND_PHR, ONLN_YN, RPLY_NO,  "+ 
				" SEND_RSN_CD, APPL_DV_CD, DSTRB_DV_CD, SEND_FORM_CD,  "+ 
				" RTM_YN, SEND_RQST_DTTM, USER_ID, RGST_DTTM,  "+ 
				" LTPYM_YN, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID,  "+ 
				" APPLICATION_ID )  "+ 
				"VALUES  "+ 
				"( ?, ?, \'Y\', ?,  "+ 
				"\'CC104\', \'CCS\', \'7\', \'SMS\',  "+ 
				"\'Y\', sysdate, 771230004, sysdate,  "+ 
				"\'N\', sysdate, sysdate, 771230004,  "+ 
				"\'CTI\') ";
		
		return Insert_SMS;
	}

	
	//MMS EAI 테이블에 입력 
	public String InsertMMS() {
		
		String Insert_MMS =
				" INSERT INTO TB_SMS_SEND_LONG  "+
				" (CTN, SMS_SEND_PHR, ONLN_YN, RPLY_NO,  "+
				"  SEND_RSN_CD, APPL_DV_CD, DSTRB_DV_CD, SEND_FORM_CD,  "+
				"  RTM_YN, SEND_RQST_DTTM, USER_ID, RGST_DTTM,  "+
				"  LTPYM_YN, SYS_CREATION_DATE, SYS_UPDATE_DATE, OPERATOR_ID,  "+
				"  APPLICATION_ID, ENTR_NO )  "+
				" VALUES  "+
				"(?, ?, \'Y\', ?,  "+
				" \'CC104\', \'CCS\', \'7\', \'SMS\',  "+
				" \'Y\', sysdate, 771230004, sysdate,  "+
				" \'N\', sysdate, sysdate, 771230004,  "+
				" \'CTI\', 500067805019) ";
		
		return Insert_MMS;
	}
	
}
