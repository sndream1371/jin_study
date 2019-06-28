package lguplus.cs.sms;


/*
 * SMS에서 발송할 테이블 정보조회
 * 
 */
public class SMSContentSQL {

//	String sql_PM_HS  = null; //"모바일 응대율 + 	모바일 대리점 호전환(ARS에서) +	홈 응대율"
//	String sql_BS     = null; //BS 응대율
//	String sql_TRN    = null; //모바일 모전담 이관
//	String sql_USHOP  = null; //홈 U+ Shop
//	String sql_HS_30  = null; //HS_30분 수신인용(이범영)

	
            
	//모바일 응대율
	String sql_PM_PM =
			"SELECT \'■모바일 CS\'||chr(10)||\'1.누적: \'||  "+
			"to_char(MS_total_in,\'Fm999,999\')||\'(\'||decode(MS_total_real_in,0,0,round(MS_total_an/decode(MS_total_real_in,0,1,MS_total_real_in)*100,1))||\'%)\'||chr(10)||  "+
			"\' - 일반 \'||to_char(ilvan_in,\'Fm999,999\')||ilvan_per||chr(10)|| "+
			"\' - 5G \'||to_char(highval_in,\'Fm999,999\')||highval_per||chr(10)|| "+
			"\' - 5G 전환 \'||to_char(highval_tran_in,\'Fm999,999\')||highval_tran_per||chr(10)|| "+
			"\' - 초고ARPU \'||to_char(arpu_in,\'Fm999,999\')||arpu_per||chr(10)||  "+
			"\' - 이전상담사 \'||to_char(preemp_in,\'Fm999,999\')||preemp_per||chr(10)||  "+
			"\' - 선택약정 \'||to_char(promiss_in,\'Fm999,999\')||promiss_per||chr(10)||  "+
			"\' - 통화품질 \'||to_char(tong_in,\'Fm999,999\')||tong_per||chr(10)||  "+
			"\' - SAVE \'||to_char(save_in,\'Fm999,999\')||save_per||chr(10)||  "+
			"\' - 분실 \'||to_char(loss_in,\'Fm999,999\')||loss_per||chr(10)||  "+
			"\' - 파손 \'||to_char(dam_in,\'Fm999,999\')||dam_per||chr(10)||chr(10)  "+
			"FROM (  "+
			"     SELECT SUM(ilvan_in) ilvan_in, SUM(ilvan_an) ilvan_an, \'(\'||decode(SUM(ilvan_in),0,0,round(SUM(ilvan_an)/SUM(ilvan_in)*100,1))||\'%)\' ilvan_per,  "+
			"            SUM(highval_in) highval_in, SUM(highval_an) highval_an, \'(\'||decode(SUM(highval_in),0,0,round(SUM(highval_an)/SUM(highval_in)*100,1))||\'%)\' highval_per,  "+
			"            SUM(highval_tran_in) highval_tran_in, SUM(highval_tran_an) highval_tran_an, \'(\'||decode(SUM(highval_tran_in),0,0,round(SUM(highval_tran_an)/SUM(highval_tran_in)*100,1))||\'%)\' highval_tran_per,  "+
			"            SUM(arpu_in) arpu_in, SUM(arpu_an) arpu_an, \'(\'||decode(SUM(arpu_in),0,0,round(SUM(arpu_an)/SUM(arpu_in)*100,1))||\'%)\' arpu_per,  "+
			"            SUM(preemp_in) preemp_in, SUM(preemp_an) preemp_an, \'(\'||decode(SUM(preemp_real_in),0,0,round(SUM(preemp_an)/SUM(preemp_real_in)*100,1))||\'%)\' preemp_per,  "+
			"            SUM(promiss_in) promiss_in, SUM(promiss_an) promiss_an, \'(\'||decode(SUM(promiss_in),0,0,round(SUM(promiss_an)/SUM(promiss_in)*100,1))||\'%)\' promiss_per,  "+
			"            SUM(tong_in) tong_in, SUM(tong_an) tong_an, \'(\'||decode(SUM(tong_in),0,0,round(SUM(tong_an)/SUM(tong_in)*100,1))||\'%)\' tong_per,  "+
			"            SUM(save_in) save_in, SUM(save_an) save_an, \'(\'||decode(SUM(save_in),0,0,round(SUM(save_an)/SUM(save_in)*100,1))||\'%)\' save_per,  "+
			"            SUM(loss_in) loss_in, SUM(loss_an) loss_an, \'(\'||decode(SUM(loss_in),0,0,round(SUM(loss_an)/SUM(loss_in)*100,1))||\'%)\' loss_per,  "+
			"            SUM(dam_in) dam_in, SUM(dam_an) dam_an, \'(\'||decode(SUM(dam_in),0,0,round(SUM(dam_an)/SUM(dam_in)*100,1))||\'%)\' dam_per,  "+
			"            SUM(ilvan_in)+SUM(highval_in)+SUM(highval_tran_in)+SUM(arpu_in)+SUM(preemp_in)+SUM(promiss_in)+SUM(tong_in)+SUM(save_in)+SUM(loss_in)+SUM(dam_in) MS_total_in,  "+
			"            SUM(ilvan_in)+SUM(highval_in)+SUM(highval_tran_in)+SUM(arpu_in)+SUM(preemp_real_in)+SUM(promiss_in)+SUM(tong_in)+SUM(save_in)+SUM(loss_in)+SUM(dam_in) MS_total_real_in,  "+
			"            SUM(ilvan_an)+SUM(highval_an)+SUM(highval_tran_an)+SUM(arpu_an)+SUM(preemp_an)+SUM(promiss_an)+SUM(tong_an)+SUM(save_an)+SUM(loss_an)+SUM(dam_an) MS_total_an  "+
			"     FROM (  "+
			"         select nvl(sum(orgenter_count),0) ilvan_in, nvl(sum(distribute_count),0) ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly >= \'09\'  "+
			"           and end_hourly <= \'18\'  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4101,4102,4103,4104,4105,4106,4131,4132,4133,4134,4135,4136,4291,4292,4293,4294,4295,4296)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, nvl(sum(orgenter_count),0) highval_in, nvl(sum(distribute_count),0) highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly >= \'09\'  "+
			"           and end_hourly <= \'18\'  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4671,4672,4673,4674,4675,4676)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, nvl(sum(orgenter_count),0) highval_tran_in, nvl(sum(distribute_count),0) highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly >= \'09\'  "+
			"           and end_hourly <= \'18\'  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4691,4692,4693,4694,4695,4696)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, nvl(sum(orgenter_count),0) arpu_in, nvl(sum(distribute_count),0) arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly >= \'09\'  "+
			"           and end_hourly <= \'18\'  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4591,4592,4593,4594,4595,4596)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, nvl(sum(orgenter_count),0) preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly >= \'09\'  "+
			"           and end_hourly <= \'18\'  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4631)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, nvl(sum(orgenter_count),0) preemp_real_in, nvl(sum(distribute_count),0) preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly >= \'09\'  "+
			"           and end_hourly <= \'18\'  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4631,4632)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, nvl(sum(orgenter_count),0) promiss_in, nvl(sum(distribute_count),0) promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly >= \'09\'  "+
			"           and end_hourly <= \'18\'  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4331,4332,4333,4334,4335,4336)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, nvl(sum(orgenter_count),0) tong_in, nvl(sum(distribute_count),0) tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly >= \'09\'  "+
			"           and end_hourly <= \'18\'  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4301,4302,4303,4304,4305,4306,4311,4312,4313,4314,4315,4316)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, nvl(sum(orgenter_count),0) save_in, nvl(sum(distribute_count),0) save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly >= \'09\'  "+
			"           and end_hourly <= \'18\'  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4471,4472,4473,4474,4475,4476,4461,4462,4463,4464,4465,4466,4361,4362,4363,4364,4365,4366,4491,4492,4493,4494,4495,4496,4391,4392,4393,4394,4395,4396,4891,4892,4893,4894,4895,4896)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, nvl(sum(orgenter_count),0) loss_in, nvl(sum(distribute_count),0) loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly >= \'09\'  "+
			"           and end_hourly <= \'18\'  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4431,4432,4433,4434,4435,4436)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, nvl(sum(orgenter_count),0) dam_in, nvl(sum(distribute_count),0) dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly >= \'09\'  "+
			"           and end_hourly <= \'18\'  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4441,4442,4443,4444,4445,4446)  "+
			"     )  "+
			")  "+
			"UNION ALL  "+
			"SELECT \'2.\'||to_char(sysdate-1/24,\'hh24\')||\'시대 :\'||  "+
			"to_char(MS_total_in,\'Fm999,999\')||\'(\'||decode(MS_total_real_in,0,0,round(MS_total_an/decode(MS_total_real_in,0,1,MS_total_real_in)*100,1))||\'%)\'||chr(10)||  "+
			"\' - 일반 \'||to_char(ilvan_in,\'Fm999,999\')||ilvan_per||chr(10)||  "+
			"\' - 5G \'||to_char(highval_in,\'Fm999,999\')||highval_per||chr(10)|| "+
			"\' - 5G 전환 \'||to_char(highval_tran_in,\'Fm999,999\')||highval_tran_per||chr(10)|| "+
			"\' - 초고ARPU \'||to_char(arpu_in,\'Fm999,999\')||arpu_per||chr(10)||  "+
			"\' - 이전상담사 \'||to_char(preemp_in,\'Fm999,999\')||preemp_per||chr(10)||  "+
			"\' - 선택약정 \'||to_char(promiss_in,\'Fm999,999\')||promiss_per||chr(10)||  "+
			"\' - 통화품질 \'||to_char(tong_in,\'Fm999,999\')||tong_per||chr(10)||  "+
			"\' - SAVE \'||to_char(save_in,\'Fm999,999\')||save_per||chr(10)||  "+
			"\' - 분실 \'||to_char(loss_in,\'Fm999,999\')||loss_per||chr(10)||  "+
			"\' - 파손 \'||to_char(dam_in,\'Fm999,999\')||dam_per||chr(10)||chr(10)  "+
			"FROM (  "+
			"     SELECT SUM(ilvan_in) ilvan_in, SUM(ilvan_an) ilvan_an, \'(\'||decode(SUM(ilvan_in),0,0,round(SUM(ilvan_an)/SUM(ilvan_in)*100,1))||\'%)\' ilvan_per,  "+
			"            SUM(highval_in) highval_in, SUM(highval_an) highval_an, \'(\'||decode(SUM(highval_in),0,0,round(SUM(highval_an)/SUM(highval_in)*100,1))||\'%)\' highval_per,  "+
			"            SUM(highval_tran_in) highval_tran_in, SUM(highval_tran_an) highval_tran_an, \'(\'||decode(SUM(highval_tran_in),0,0,round(SUM(highval_tran_an)/SUM(highval_tran_in)*100,1))||\'%)\' highval_tran_per,  "+
			"            SUM(arpu_in) arpu_in, SUM(arpu_an) arpu_an, \'(\'||decode(SUM(arpu_in),0,0,round(SUM(arpu_an)/SUM(arpu_in)*100,1))||\'%)\' arpu_per,  "+
			"            SUM(preemp_in) preemp_in, SUM(preemp_an) preemp_an, \'(\'||decode(SUM(preemp_real_in),0,0,round(SUM(preemp_an)/SUM(preemp_real_in)*100,1))||\'%)\' preemp_per,  "+
			"            SUM(promiss_in) promiss_in, SUM(promiss_an) promiss_an, \'(\'||decode(SUM(promiss_in),0,0,round(SUM(promiss_an)/SUM(promiss_in)*100,1))||\'%)\' promiss_per,  "+
			"            SUM(tong_in) tong_in, SUM(tong_an) tong_an, \'(\'||decode(SUM(tong_in),0,0,round(SUM(tong_an)/SUM(tong_in)*100,1))||\'%)\' tong_per,  "+
			"            SUM(save_in) save_in, SUM(save_an) save_an, \'(\'||decode(SUM(save_in),0,0,round(SUM(save_an)/SUM(save_in)*100,1))||\'%)\' save_per,  "+
			"            SUM(loss_in) loss_in, SUM(loss_an) loss_an, \'(\'||decode(SUM(loss_in),0,0,round(SUM(loss_an)/SUM(loss_in)*100,1))||\'%)\' loss_per,  "+
			"            SUM(dam_in) dam_in, SUM(dam_an) dam_an, \'(\'||decode(SUM(dam_in),0,0,round(SUM(dam_an)/SUM(dam_in)*100,1))||\'%)\' dam_per,  "+
			"            SUM(ilvan_in)+SUM(highval_in)+SUM(highval_tran_in)+SUM(arpu_in)+SUM(preemp_in)+SUM(promiss_in)+SUM(tong_in)+SUM(save_in)+SUM(loss_in)+SUM(dam_in) MS_total_in,  "+
			"            SUM(ilvan_in)+SUM(highval_in)+SUM(highval_tran_in)+SUM(arpu_in)+SUM(preemp_real_in)+SUM(promiss_in)+SUM(tong_in)+SUM(save_in)+SUM(loss_in)+SUM(dam_in) MS_total_real_in,  "+
			"            SUM(ilvan_an)+SUM(highval_an)+SUM(highval_tran_an)+SUM(arpu_an)+SUM(preemp_an)+SUM(promiss_an)+SUM(tong_an)+SUM(save_an)+SUM(loss_an)+SUM(dam_an) MS_total_an  "+
			"     FROM (  "+
			"         select nvl(sum(orgenter_count),0) ilvan_in, nvl(sum(distribute_count),0) ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4101,4102,4103,4104,4105,4106,4131,4132,4133,4134,4135,4136,4291,4292,4293,4294,4295,4296)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, nvl(sum(orgenter_count),0) highval_in, nvl(sum(distribute_count),0) highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4671,4672,4673,4674,4675,4676)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, nvl(sum(orgenter_count),0) highval_tran_in, nvl(sum(distribute_count),0) highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4691,4692,4693,4694,4695,4696)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, nvl(sum(orgenter_count),0) arpu_in, nvl(sum(distribute_count),0) arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4591,4592,4593,4594,4595,4596)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, nvl(sum(orgenter_count),0) preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4631)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, nvl(sum(orgenter_count),0) preemp_real_in, nvl(sum(distribute_count),0) preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4631,4632)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, nvl(sum(orgenter_count),0) promiss_in, nvl(sum(distribute_count),0) promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4331,4332,4333,4334,4335,4336)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, nvl(sum(orgenter_count),0) tong_in, nvl(sum(distribute_count),0) tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4301,4302,4303,4304,4305,4306,4311,4312,4313,4314,4315,4316)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, nvl(sum(orgenter_count),0) save_in, nvl(sum(distribute_count),0) save_an, 0 loss_in, 0 loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4471,4472,4473,4474,4475,4476,4461,4462,4463,4464,4465,4466,4361,4362,4363,4364,4365,4366,4491,4492,4493,4494,4495,4496,4391,4392,4393,4394,4395,4396,4891,4892,4893,4894,4895,4896)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, nvl(sum(orgenter_count),0) loss_in, nvl(sum(distribute_count),0) loss_an, 0 dam_in, 0 dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4431,4432,4433,4434,4435,4436)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 highval_in, 0 highval_an, 0 highval_tran_in, 0 highval_tran_an, 0 arpu_in, 0 arpu_an, 0 preemp_in, 0 preemp_real_in, 0 preemp_an, 0 promiss_in, 0 promiss_an, 0 tong_in, 0 tong_an, 0 save_in, 0 save_an, 0 loss_in, 0 loss_an, nvl(sum(orgenter_count),0) dam_in, nvl(sum(distribute_count),0) dam_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (4441,4442,4443,4444,4445,4446)  "+
			"     )  "+
			") ";
	
	
	//모바일 대리점 호전환(ARS에서)
	String sql_PM_PM_AGENCY =
			"select \'■모바일 매장전환\'||chr(10)||  "+
			"\'1.누적: \'||to_char(sum(trn+ars),\'Fm999,999\')||chr(10)||  "+
			"\' -전환: \'||to_char(sum(trn),\'Fm999,999\')||chr(10)||  "+
			"\' -ARS이용: \'||to_char(sum(ars),\'Fm999,999\')||chr(10)||chr(10)  "+
			"from (  "+
			"    select nvl(sum(TOTQTY),0) trn, 0 ars  "+
			"    from IPIVRADM.STT_SERVICE_HISTORY  "+
			"    where AUDIT_DATE = to_char(sysdate,\'yyyymmdd\')  "+
			"      and HISTORY_CODE like \'%7112725400%\'  "+
			"    union all  "+
			"    select 0 trn, nvl(sum(TOTQTY),0) ars  "+
			"    from IPIVRADM.STT_SERVICE_HISTORY  "+
			"    where AUDIT_DATE = to_char(sysdate,\'yyyymmdd\')  "+
			"      and HISTORY_CODE like \'%7112725500%\'  "+
			")  "+
			"union all  "+
			"select \'2.\'||to_char(sysdate-1/24,\'hh24\')||\'시대 : \'||to_char(sum(trn+ars),\'Fm999,999\')||chr(10)||  "+
			"\' -전환: \'||to_char(sum(trn),\'Fm999,999\')||chr(10)||  "+
			"\' -ARS이용: \'||to_char(sum(ars),\'Fm999,999\')||chr(10)||chr(10)  "+
			"from (  "+
			"    select nvl(sum(TOTQTY),0) trn, 0 ars  "+
			"    from IPIVRADM.STT_SERVICE_HISTORY  "+
			"    where AUDIT_DATE = to_char(sysdate,\'yyyymmdd\')  "+
			"      and AUDIT_TIME >= to_char(sysdate-1/24,\'hh24\')||\'00\'  "+
			"      and AUDIT_TIME <= to_char(sysdate-1/24,\'hh24\')||\'59\'  "+
			"      and HISTORY_CODE like \'%7112725400%\'  "+
			"    union all  "+
			"    select 0 trn, nvl(sum(TOTQTY),0) ars  "+
			"    from IPIVRADM.STT_SERVICE_HISTORY  "+
			"    where AUDIT_DATE = to_char(sysdate,\'yyyymmdd\')  "+
			"      and AUDIT_TIME >= to_char(sysdate-1/24,\'hh24\')||\'00\'  "+
			"      and AUDIT_TIME <= to_char(sysdate-1/24,\'hh24\')||\'59\'  "+
			"      and HISTORY_CODE like \'%7112725500%\'  "+
			") ";
	
	
	//HOME 응대율
	String sql_PM_HS =
			"SELECT \'■홈 CS\'||chr(10)||\'1.누적: \'||  "+
			"to_char(CS_total_in,\'Fm999,999\')||\'(\'||decode(CS_total_in,0,0,round(CS_total_an/decode(CS_total_in,0,1,CS_total_in)*100,1))||\'%)\'||chr(10)||  "+
			"\' - 일반 \'||to_char(ilvan_in,\'Fm999,999\')||ilvan_per||chr(10)||  "+
			"\' - 이전설치 \'||to_char(ejeon_in,\'Fm999,999\')||ejeon_per||chr(10)||  "+
			"\' - 기술 \'||to_char(kisul_in,\'Fm999,999\')||kisul_per||chr(10)||  "+
			"\' - 해지방어 \'||to_char(haeji_in,\'Fm999,999\')||haeji_per||chr(10)||chr(10)  "+
			"FROM (  "+
			"     SELECT SUM(ilvan_in) ilvan_in, SUM(ilvan_an) ilvan_an, \'(\'||decode(SUM(ilvan_in),0,0,round(SUM(ilvan_an)/SUM(ilvan_in)*100,1))||\'%)\' ilvan_per,  "+
			"            SUM(ejeon_in) ejeon_in, SUM(ejeon_an) ejeon_an, \'(\'||decode(SUM(ejeon_in),0,0,round(SUM(ejeon_an)/SUM(ejeon_in)*100,1))||\'%)\' ejeon_per,  "+
			"            SUM(kisul_in) kisul_in, SUM(kisul_an) kisul_an, \'(\'||decode(SUM(kisul_in),0,0,round(SUM(kisul_an)/SUM(kisul_in)*100,1))||\'%)\' kisul_per,  "+
			"            SUM(haeji_in) haeji_in, SUM(haeji_an) haeji_an, \'(\'||decode(SUM(haeji_in),0,0,round(SUM(haeji_an)/SUM(haeji_in)*100,1))||\'%)\' haeji_per,  "+
			"            SUM(ilvan_in)+SUM(ejeon_in)+SUM(kisul_in)+SUM(haeji_in) CS_total_in,  "+
			"            SUM(ilvan_an)+SUM(ejeon_an)+SUM(kisul_an)+SUM(haeji_an) CS_total_an  "+
			"     FROM (  "+
			"         select nvl(sum(orgenter_count),0) ilvan_in, nvl(sum(distribute_count),0) ilvan_an, 0 ejeon_in, 0 ejeon_an, 0 kisul_in, 0 kisul_an, 0 haeji_in, 0 haeji_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly >= \'09\'  "+
			"           and end_hourly <= \'18\'  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (5101,5102,5103,5104,5105,5111,5112,5113,5114,5115,5121,5122,5123,5124,5125)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, nvl(sum(orgenter_count),0) ejeon_in, nvl(sum(distribute_count),0) ejeon_an, 0 kisul_in, 0 kisul_an, 0 haeji_in, 0 haeji_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly >= \'09\'  "+
			"           and end_hourly <= \'18\'  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (5701,5702,5703,5704,5705,5751,5752,5753,5754,5755,5791,5792,5793,5794,5795)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 ejeon_in, 0 ejeon_an, nvl(sum(orgenter_count),0) kisul_in, nvl(sum(distribute_count),0) kisul_an, 0 haeji_in, 0 haeji_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly >= \'09\'  "+
			"           and end_hourly <= \'18\'  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (5201,5202,5203,5204,5205,5211,5212,5213,5214,5215,5221,5222,5223,5224,5225)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 ejeon_in, 0 ejeon_an, 0 kisul_in, 0 kisul_an, nvl(sum(orgenter_count),0) haeji_in, nvl(sum(distribute_count),0) haeji_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly >= \'09\'  "+
			"           and end_hourly <= \'18\'  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (5401,5402,5403,5404,5405,5411,5412,5413,5414,5415,5421,5422,5423,5424,5425,5431,5432,5433,5434,5435)  "+
			"     )  "+
			")  "+
			"UNION ALL  "+
			"SELECT \'2.\'||to_char(sysdate-1/24,\'hh24\')||\'시대 :\'||  "+
			"to_char(CS_total_in,\'Fm999,999\')||\'(\'||decode(CS_total_in,0,0,round(CS_total_an/decode(CS_total_in,0,1,CS_total_in)*100,1))||\'%)\'||chr(10)||  "+
			"\' - 일반 \'||to_char(ilvan_in,\'Fm999,999\')||ilvan_per||chr(10)||  "+
			"\' - 이전설치 \'||to_char(ejeon_in,\'Fm999,999\')||ejeon_per||chr(10)||  "+
			"\' - 기술 \'||to_char(kisul_in,\'Fm999,999\')||kisul_per||chr(10)||  "+
			"\' - 해지방어 \'||to_char(haeji_in,\'Fm999,999\')||haeji_per||chr(10)||chr(10)  "+
			"FROM (  "+
			"     SELECT SUM(ilvan_in) ilvan_in, SUM(ilvan_an) ilvan_an, \'(\'||decode(SUM(ilvan_in),0,0,round(SUM(ilvan_an)/SUM(ilvan_in)*100,1))||\'%)\' ilvan_per,  "+
			"            SUM(ejeon_in) ejeon_in, SUM(ejeon_an) ejeon_an, \'(\'||decode(SUM(ejeon_in),0,0,round(SUM(ejeon_an)/SUM(ejeon_in)*100,1))||\'%)\' ejeon_per,  "+
			"            SUM(kisul_in) kisul_in, SUM(kisul_an) kisul_an, \'(\'||decode(SUM(kisul_in),0,0,round(SUM(kisul_an)/SUM(kisul_in)*100,1))||\'%)\' kisul_per,  "+
			"            SUM(haeji_in) haeji_in, SUM(haeji_an) haeji_an, \'(\'||decode(SUM(haeji_in),0,0,round(SUM(haeji_an)/SUM(haeji_in)*100,1))||\'%)\' haeji_per,  "+
			"            SUM(ilvan_in)+SUM(ejeon_in)+SUM(kisul_in)+SUM(haeji_in) CS_total_in,  "+
			"            SUM(ilvan_an)+SUM(ejeon_an)+SUM(kisul_an)+SUM(haeji_an) CS_total_an  "+
			"     FROM (  "+
			"         select nvl(sum(orgenter_count),0) ilvan_in, nvl(sum(distribute_count),0) ilvan_an, 0 ejeon_in, 0 ejeon_an, 0 kisul_in, 0 kisul_an, 0 haeji_in, 0 haeji_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (5101,5102,5103,5104,5105,5111,5112,5113,5114,5115,5121,5122,5123,5124,5125)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, nvl(sum(orgenter_count),0) ejeon_in, nvl(sum(distribute_count),0) ejeon_an, 0 kisul_in, 0 kisul_an, 0 haeji_in, 0 haeji_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (5701,5702,5703,5704,5705,5751,5752,5753,5754,5755,5791,5792,5793,5794,5795)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 ejeon_in, 0 ejeon_an, nvl(sum(orgenter_count),0) kisul_in, nvl(sum(distribute_count),0) kisul_an, 0 haeji_in, 0 haeji_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (5201,5202,5203,5204,5205,5211,5212,5213,5214,5215,5221,5222,5223,5224,5225)  "+
			"         union all  "+
			"         select 0 ilvan_in, 0 ilvan_an, 0 ejeon_in, 0 ejeon_an, 0 kisul_in, 0 kisul_an, nvl(sum(orgenter_count),0) haeji_in, nvl(sum(distribute_count),0) haeji_an  "+
			"         from re_queuestatl_h  "+
			"         where end_date = to_char(sysdate,\'yyyymmdd\')  "+
			"           and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+
			"           and call_type in (11,15)  "+
			"           and queue_id in (5401,5402,5403,5404,5405,5411,5412,5413,5414,5415,5421,5422,5423,5424,5425,5431,5432,5433,5434,5435)  "+
			"     )  "+
			") ";		
			
			
	//BS 응대율
	String sql_BS =
			"    SELECT  \'■기업 CS\'||chr(10)||\'1.누적: \'|| "+ 
			"             to_char(BS_total_in,\'Fm999,999\')||\'(\'||decode(BS_total_in,0,0,round(BS_total_an/decode(BS_total_in,0,1,BS_total_in)*100,1))||\'%)\'||chr(10)|| "+ 
			"            \' - 기업오피스 \'||to_char(office_in,\'Fm999,999\')||office_per||chr(10)|| "+ 
			"            \' - 웹하드/메시징 \'||to_char(account_in,\'Fm999,999\')||account_per||chr(10)|| "+ 
			"            \' - 전자결제 \'||to_char(webhard_in,\'Fm999,999\')||webhard_per||chr(10)|| "+ 
			"            \' - 소호일반 \'||to_char(soho_in,\'Fm999,999\')||soho_per||chr(10)||chr(10) "+ 
			"    FROM ( "+ 
			"         SELECT SUM(office_in) office_in, SUM(office_an) office_an, \'(\'||decode(SUM(office_in),0,0,round(SUM(office_an)/SUM(office_in)*100,1))||\'%)\' office_per,  "+ 
			"                SUM(account_in) account_in, SUM(account_an) account_an, \'(\'||decode(SUM(account_in),0,0,round(SUM(account_an)/SUM(account_in)*100,1))||\'%)\' account_per,  "+ 
			"                SUM(webhard_in) webhard_in, SUM(webhard_an) webhard_an, \'(\'||decode(SUM(webhard_in),0,0,round(SUM(webhard_an)/SUM(webhard_in)*100,1))||\'%)\' webhard_per,  "+ 
			"                SUM(soho_in) soho_in, SUM(soho_an) soho_an, \'(\'||decode(SUM(soho_in),0,0,round(SUM(soho_an)/SUM(soho_in)*100,1))||\'%)\' soho_per,  "+ 
			"                SUM(office_in)+SUM(account_in)+SUM(webhard_in)+SUM(soho_in) BS_total_in,  "+ 
			"                SUM(office_an)+SUM(account_an)+SUM(webhard_an)+SUM(soho_an) BS_total_an  "+ 
			"         FROM (  "+ 
			"             select nvl(sum(orgenter_count),0) office_in, nvl(sum(distribute_count),0) office_an, 0 account_in, 0 account_an, 0 webhard_in, 0 webhard_an, 0 soho_in, 0 soho_an  "+ 
			"             from re_queuestatl_h  "+ 
			"             where end_date = to_char(sysdate,\'yyyymmdd\')  "+ 
			"               and end_hourly >= \'09\'  "+ 
			"               and end_hourly <= \'18\'  "+ 
			"               and call_type in (11,15)  "+ 
			"               and queue_id in (386300,386310,386340,397600,386399,386318,386200,386210,386220,386299,386260)  "+ 
			"             union all  "+ 
			"             select 0 office_in, 0 office_an, nvl(sum(orgenter_count),0) account_in, nvl(sum(distribute_count),0) account_an, 0 webhard_in, 0 webhard_an, 0 soho_in, 0 soho_an  "+ 
			"             from re_queuestatl_h  "+ 
			"             where end_date = to_char(sysdate,\'yyyymmdd\')  "+ 
			"               and end_hourly >= \'09\'  "+ 
			"               and end_hourly <= \'18\'  "+ 
			"               and call_type in (11,15)  "+ 
			"               and queue_id in (386700,386720,386910,386530,386549)  "+ 
			"             union all  "+ 
			"             select 0 office_in, 0 office_an, 0 account_in, 0 account_an, nvl(sum(orgenter_count),0) webhard_in, nvl(sum(distribute_count),0) webhard_an, 0 soho_in, 0 soho_an  "+ 
			"             from re_queuestatl_h  "+ 
			"             where end_date = to_char(sysdate,\'yyyymmdd\')  "+ 
			"               and end_hourly >= \'09\'  "+ 
			"               and end_hourly <= \'18\'  "+ 
			"               and call_type in (11,15)  "+ 
			"               and queue_id in (386810,386820,386830,386960,386970,386980,386860,386870,386819,386829,386839,386840,386850)  "+ 
			"             union all  "+ 
			"             select 0 office_in, 0 office_an, 0 account_in, 0 account_an, 0 webhard_in, 0 webhard_an, nvl(sum(orgenter_count),0) soho_in, nvl(sum(distribute_count),0) soho_an  "+ 
			"             from re_queuestatl_h  "+ 
			"             where end_date = to_char(sysdate,\'yyyymmdd\')  "+ 
			"               and end_hourly >= \'09\'  "+ 
			"               and end_hourly <= \'18\'  "+ 
			"               and call_type in (11,15)  "+ 
			"               and queue_id in (387510,387520,388800)  "+ 
			"         )  "+ 
			"    )  "+ 
			"    UNION ALL  "+ 
			"    SELECT \'2.\'||to_char(sysdate-1/24,\'hh24\')||\'시대 :\'||  "+ 
			"    to_char(BS_total_in,\'Fm999,999\')||\'(\'||decode(BS_total_in,0,0,round(BS_total_an/decode(BS_total_in,0,1,BS_total_in)*100,1))||\'%)\'||chr(10)|| "+ 
			"    \' - 기업오피스 \'||to_char(office_in,\'Fm999,999\')||office_per||chr(10)|| "+ 
			"    \' - 웹하드/메시징 \'||to_char(account_in,\'Fm999,999\')||account_per||chr(10)|| "+ 
			"    \' - 전자결제 \'||to_char(webhard_in,\'Fm999,999\')||webhard_per||chr(10)|| "+ 
			"    \' - 소호일반 \'||to_char(soho_in,\'Fm999,999\')||soho_per||chr(10)||chr(10) "+ 
			"    FROM (  "+ 
			"         SELECT SUM(office_in) office_in, SUM(office_an) office_an, \'(\'||decode(SUM(office_in),0,0,round(SUM(office_an)/SUM(office_in)*100,1))||\'%)\' office_per,  "+ 
			"                SUM(account_in) account_in, SUM(account_an) account_an, \'(\'||decode(SUM(account_in),0,0,round(SUM(account_an)/SUM(account_in)*100,1))||\'%)\' account_per,  "+ 
			"                SUM(webhard_in) webhard_in, SUM(webhard_an) webhard_an, \'(\'||decode(SUM(webhard_in),0,0,round(SUM(webhard_an)/SUM(webhard_in)*100,1))||\'%)\' webhard_per,  "+ 
			"                SUM(soho_in) soho_in, SUM(soho_an) soho_an, \'(\'||decode(SUM(soho_in),0,0,round(SUM(soho_an)/SUM(soho_in)*100,1))||\'%)\' soho_per,  "+ 
			"                SUM(office_in)+SUM(account_in)+SUM(webhard_in)+SUM(soho_in) BS_total_in,  "+ 
			"                SUM(office_an)+SUM(account_an)+SUM(webhard_an)+SUM(soho_an) BS_total_an  "+ 
			"         FROM (  "+ 
			"             select nvl(sum(orgenter_count),0) office_in, nvl(sum(distribute_count),0) office_an, 0 account_in, 0 account_an, 0 webhard_in, 0 webhard_an, 0 soho_in, 0 soho_an  "+ 
			"             from re_queuestatl_h  "+ 
			"             where end_date = to_char(sysdate,\'yyyymmdd\')  "+ 
			"               and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+ 
			"               and call_type in (11,15)  "+ 
			"               and queue_id in (386300,386310,386340,397600,386399,386318,386200,386210,386220,386299,386260)  "+ 
			"             union all  "+ 
			"             select 0 office_in, 0 office_an, nvl(sum(orgenter_count),0) account_in, nvl(sum(distribute_count),0) account_an, 0 webhard_in, 0 webhard_an, 0 soho_in, 0 soho_an  "+ 
			"             from re_queuestatl_h  "+ 
			"             where end_date = to_char(sysdate,\'yyyymmdd\')  "+ 
			"               and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+ 
			"               and call_type in (11,15)  "+ 
			"               and queue_id in (386700,386720,386910,386530,386549)  "+ 
			"             union all  "+ 
			"             select 0 office_in, 0 office_an, 0 account_in, 0 account_an, nvl(sum(orgenter_count),0) webhard_in, nvl(sum(distribute_count),0) webhard_an, 0 soho_in, 0 soho_an  "+ 
			"             from re_queuestatl_h  "+ 
			"             where end_date = to_char(sysdate,\'yyyymmdd\')  "+ 
			"               and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+ 
			"               and call_type in (11,15)  "+ 
			"               and queue_id in (386810,386820,386830,386960,386970,386980,386860,386870,386819,386829,386839,386840,386850)  "+ 
			"             union all  "+ 
			"             select 0 office_in, 0 office_an, 0 account_in, 0 account_an, 0 webhard_in, 0 webhard_an, nvl(sum(orgenter_count),0) soho_in, nvl(sum(distribute_count),0) soho_an  "+ 
			"             from re_queuestatl_h  "+ 
			"             where end_date = to_char(sysdate,\'yyyymmdd\')  "+ 
			"               and end_hourly = to_char(sysdate-1/24,\'hh24\')  "+ 
			"               and call_type in (11,15)  "+ 
			"               and queue_id in (387510,387520,388800)  "+ 
			"         )  "+ 
			"    ) ";	

	
	//모바일 모전담 이관
	String sql_PM_TRN =
			"select  "+ 
			"\'홈이관 \'||  "+ 
			"\'서울 \' || sum(decode(location,\'서울\',cnt,0) ) ||\' \'||  "+ 
			"\'부산1 \'|| sum(decode(location,\'부산1\',cnt,0) ) ||\' \'||  "+ 
			"\'부산2 \'|| sum(decode(location,\'부산2\',cnt,0) ) ||\' \'||  "+ 
			"\'대구 \' || sum(decode(location,\'대구\',cnt,0) ) ||\' \'||  "+ 
			"\'광주 \' || sum(decode(location,\'광주\',cnt,0) ) ||\' \'||  "+ 
			"\'대전 \' || sum(decode(location,\'대전\',cnt,0) ) ||\' \'||  "+ 
			"\'전체 \' || sum(cnt) 이관건수  "+ 
			"from (  "+ 
			"     select  "+ 
			"     DECODE(SUBSTR(b.tenant_id,1,2),\'31\',\'서울\',\'33\',\'부산1\',\'34\',\'부산2\',\'35\',\'대구\',\'36\',\'광주\',\'37\',\'대전\') location,  "+ 
			"     count(*)  cnt "+ 
			"     from ot_callstat a, ma_employeegrp b  "+ 
			"     where event_starttime >= to_char(sysdate,\'yyyymmdd\')  "+ 
			"     and event_starttime < to_char(sysdate,\'yyyymmddhh24mi\')  "+ 
			"     and a.queue_id in (\'4979\')  "+ 
			"     and a.employee_dn = a.queue_id  "+ 
			"     and a.STEMPLOYEEGRP_ID = b.employeegrp_id  "+ 
			"     group by substr(a.event_starttime,0,8),b.tenant_id,a.queue_id  "+ 
			") ";
	

	//홈 U+ Shop
	String sql_USHOP =
			"select \'▶7070 : \'||Ushop_in||\'(\'||decode(Ushop_in,0,0,round(Ushop_an/decode(Ushop_in,0,1,Ushop_in)*100,1))||\'%),\'||  "+
			"\'8-1 : \'||Ushop_tranin||\'(\'||decode(Ushop_tranin,0,0,round(Ushop_tranan/decode(Ushop_tranin,0,1,Ushop_tranin)*100,1))||\'%),\'||  "+
			"\'2846 : \'||power_in||\'(\'||decode(power_in,0,0,round(power_an/decode(power_in,0,1,power_in)*100,1))||\'%),\'||  "+
			"\'7171 : \'||employee_in||\'(\'||decode(employee_in,0,0,round(employee_an/decode(employee_in,0,1,employee_in)*100,1))||\'%)\'  "+
			"from (  "+
			"     select SUM(A) Ushop_in, SUM(B) Ushop_an, SUM(C) Ushop_tranin, SUM(D) Ushop_tranan, SUM(E) power_in, SUM(F) power_an, SUM(G) employee_in, SUM(H) employee_an  "+
			"     from (  "+
			"         select nvl(sum(orgenter_count),0) A, nvl(sum(distribute_count),0) B, 0 C, 0 D, 0 E, 0 F, 0 G, 0 H  "+
			"         from re_queuestatl_h  "+
			"         where END_DATE = to_char(sysdate,\'yyyymmdd\')  "+
			"           and END_HOURLY >= \'09\'  "+
			"           and END_HOURLY <= \'18\'  "+
			"           and CALL_TYPE in (11,15)  "+
			"           and QUEUE_ID in (5351,5352,5353,5354,5355)  "+
			"         union all  "+
			"         select 0 A, 0 B, nvl(sum(orgenter_count),0) C, nvl(sum(distribute_count),0) D, 0 F, 0 F, 0 G, 0 H  "+
			"         from re_queuestatl_h  "+
			"         where END_DATE = to_char(sysdate,\'yyyymmdd\')  "+
			"           and END_HOURLY >= \'09\'  "+
			"           and END_HOURLY <= \'18\'  "+
			"           and CALL_TYPE in (11,15)  "+
			"           and QUEUE_ID in (5311,5312,5313,5314,5315)  "+
			"         union all  "+
			"         select 0 A, 0 B, 0 C, 0 D, nvl(sum(orgenter_count),0) E, nvl(sum(distribute_count),0) F, 0 G, 0 H  "+
			"         from re_queuestatl_h  "+
			"         where END_DATE = to_char(sysdate,\'yyyymmdd\')  "+
			"           and END_HOURLY >= \'09\'  "+
			"           and END_HOURLY <= \'18\'  "+
			"           and CALL_TYPE in (11,15)  "+
			"           and QUEUE_ID in (5771,5772,5773,5774,5775)  "+
			"         union all  "+
			"         select 0 A, 0 B, 0 C, 0 D, 0 E, 0 F, nvl(sum(orgenter_count),0) G, nvl(sum(distribute_count),0) H  "+
			"         from re_queuestatl_h  "+
			"         where END_DATE = to_char(sysdate,\'yyyymmdd\')  "+
			"           and END_HOURLY >= \'09\'  "+
			"           and END_HOURLY <= \'18\'  "+
			"           and CALL_TYPE in (11,15)  "+
			"           and QUEUE_ID in (5761,5762,5763,5764,5765)  "+
			"     )  "+
			") ";
	
	//HS_30분 수신인용(이범영) 월요일Only
	String sql_HS_30_Monday  = 
			"select \'▶홈:H가입\'||HGA_in||\'(\'||decode(HGA_in,0,0,ROUND((HGA_an/decode(HGA_in,0,1,HGA_in))*100,1))||\'%),\'||  "+
					"       \'MI가입\'||MIGA_in||\'(\'||decode(MIGA_in,0,0,ROUND((MIGA_an/decode(MIGA_in,0,1,MIGA_in))*100,1))||\'%),\'||  "+
					"       \'MT가입\'||MTGA_in||\'(\'||decode(MTGA_in,0,0,ROUND((MTGA_an/decode(MTGA_in,0,1,MTGA_in))*100,1))||\'%)\'  "+
					"from (   "+
					"     select SUM(K) HGA_in, SUM(L) HGA_an, SUM(M) MIGA_in, SUM(N) MIGA_an, SUM(O) MTGA_in, SUM(P) MTGA_an  "+
					"     from (  "+
					"         select nvl(sum(orgenter_count),0) K,nvl(sum(distribute_count),0) L,0 M,0 N,0 O,0 P  "+
					"         from re_queuestatl_h  "+
					"         where END_DATE = to_char(sysdate,\'yyyymmdd\')  "+
					"           and END_HOURLY >= \'09\'  "+
					"           and END_HOURLY <= \'18\'  "+
					"           and CALL_TYPE in (11,15)  "+
					"           and QUEUE_ID in (305301,305302,305303,305304,305305)  "+
					"         union all  "+
					"         select 0 K,0 L,nvl(sum(enter_count),0) M,0 N,0 O,0 P  "+
					"         from re_queuestatl_h  "+
					"         where END_DATE = to_char(sysdate,\'yyyymmdd\')  "+
					"           and END_HOURLY >= \'09\'  "+
					"           and END_HOURLY <= \'18\'  "+
					"           and CALL_TYPE in (11,15)  "+
					"           and QUEUE_ID in (5924)  "+
					"         union all  "+
					"         select 0 K,0 L,0 M,nvl(sum(distribute_count),0) N,0 O,0 P  "+
					"         from re_queuestatl_h  "+
					"         where END_DATE = to_char(sysdate,\'yyyymmdd\')  "+
					"           and END_HOURLY >= \'09\'  "+
					"           and END_HOURLY <= \'18\'  "+
					"           and CALL_TYPE in (11,15)  "+
					"           and QUEUE_ID in (5380,5381,5382,5383,5384,5385,5370,5371,5372,5373,5374,5375,5360,5361,5362,5363,5364,5365,  "+
					"                             5710,5711,5712,5713,5714,5715,5720,5721,5722,5723,5724,5725,  "+
					"                             5730,5731,5732,5733,5734,5735)  "+
					"         union all  "+
					"             select 0 K,0 L,0 M,0 N,nvl(sum(enter_count),0) O,0 P  "+
					"             from re_queuestatl_h  "+
					"             where END_DATE = to_char(sysdate,\'yyyymmdd\')  "+
					"               and END_HOURLY >= \'09\'  "+
					"               and END_HOURLY <= \'18\'  "+
					"               and CALL_TYPE in (11,15)  "+
					"               and QUEUE_ID in (5925)  "+
					"             union all  "+
					"             select 0 K,0 L,0 M,0 N,0 O,nvl(sum(distribute_count),0) P  "+
					"             from re_queuestatl_h  "+
					"             where END_DATE = to_char(sysdate,\'yyyymmdd\')  "+
					"               and END_HOURLY >= \'09\'  "+
					"               and END_HOURLY <= \'18\'  "+
					"               and CALL_TYPE in (11,15)  "+
					"               and QUEUE_ID in (5391,5392,5393,5394,5395)  "+
					"         )  "+
					"    ) ";			
			
	//HS_30분 수신인용(이범영) 월요일이외 다른주
	String sql_HS_30_NOT_Monday  = 
			"select \'▶홈:H가입\'||HGA_in||\'(\'||decode(HGA_in,0,0,ROUND((HGA_an/decode(HGA_in,0,1,HGA_in))*100,1))||\'%),\'||  "+
					"       \'MI가입\'||MIGA_in||\'(\'||decode(MIGA_in,0,0,ROUND((MIGA_an/decode(MIGA_in,0,1,MIGA_in))*100,1))||\'%),\'||  "+
					"       \'MT가입\'||MTGA_in||\'(\'||decode(MTGA_in,0,0,ROUND((MTGA_an/decode(MTGA_in,0,1,MTGA_in))*100,1))||\'%)\'  "+
					"from (   "+
					"     select SUM(K) HGA_in, SUM(L) HGA_an, SUM(M) MIGA_in, SUM(N) MIGA_an, SUM(O) MTGA_in, SUM(P) MTGA_an  "+
					"     from (  "+
					"         select nvl(sum(orgenter_count),0) K,nvl(sum(distribute_count),0) L,0 M,0 N,0 O,0 P  "+
					"         from re_queuestatl_h  "+
					"         where END_DATE = to_char(sysdate,\'yyyymmdd\')  "+
					"           and END_HOURLY >= \'09\'  "+
					"           and END_HOURLY <= \'18\'  "+
					"           and CALL_TYPE in (11,15)  "+
					"           and QUEUE_ID in (305301,305302,305303,305304,305305)  "+
					"         union all  "+
					"         select 0 K,0 L,nvl(sum(enter_count),0) M,0 N,0 O,0 P  "+
					"         from re_queuestatl_h  "+
					"         where END_DATE = to_char(sysdate,\'yyyymmdd\')  "+
					"           and END_HOURLY >= \'09\'  "+
					"           and END_HOURLY <= \'18\'  "+
					"           and CALL_TYPE in (11,15)  "+
					"           and QUEUE_ID in (5924)  "+
					"         union all  "+
					"         select 0 K,0 L,0 M,nvl(sum(distribute_count),0) N,0 O,0 P  "+
					"         from re_queuestatl_h  "+
					"         where END_DATE = to_char(sysdate,\'yyyymmdd\')  "+
					"           and END_HOURLY >= \'09\'  "+
					"           and END_HOURLY <= \'18\'  "+
					"           and CALL_TYPE in (11,15)  "+
					"           and QUEUE_ID in (5380,5381,5382,5383,5384,5385,5370,5371,5372,5373,5374,5375,5360,5361,5362,5363,5364,5365,  "+
					"                             5710,5711,5712,5713,5714,5715,5720,5721,5722,5723,5724,5725,  "+
					"                             5730,5731,5732,5733,5734,5735)  "+
					"         union all  "+
					"             select 0 K,0 L,0 M,0 N,nvl(sum(orgenter_count),0) O,0 P  "+
					"             from re_queuestatl_h  "+
					"             where END_DATE = to_char(sysdate,\'yyyymmdd\')  "+
					"               and END_HOURLY >= \'09\'  "+
					"               and END_HOURLY <= \'18\'  "+
					"               and CALL_TYPE in (11,15)  "+
					"               and QUEUE_ID in (5391,5392,5393,5394,5395)  "+
					"             union all  "+
					"             select 0 K,0 L,0 M,0 N,0 O,nvl(sum(distribute_count),0) P  "+
					"             from re_queuestatl_h  "+
					"             where END_DATE = to_char(sysdate,\'yyyymmdd\')  "+
					"               and END_HOURLY >= \'09\'  "+
					"               and END_HOURLY <= \'18\'  "+
					"               and CALL_TYPE in (11,15)  "+
					"               and QUEUE_ID in (5391,5392,5393,5394,5395)  "+
					"         )  "+
					"    ) ";
	
	
			
}
