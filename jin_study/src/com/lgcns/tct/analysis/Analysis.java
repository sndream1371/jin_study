package com.lgcns.tct.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Analysis {	
	
	/**
	 * 주문취소 비율이 가장 큰 고객 검색 기능
	 *
     * @param		inputData		List			입력 데이터(상품판매정보)
     * @return						String			주문취소 비율이 가장 큰 고객
	 */
	public String getCustomerId(List<SalesInfo> inputData) {
		String customerId = "";
		HashMap<String, AnalysisInfo> customerMap = new HashMap<>();
		
		////////////////////////여기부터 구현 (1) ---------------->
		for(SalesInfo data : inputData){
			AnalysisInfo info = null;
			if(customerMap.keySet().contains(data.getId())){
				info = customerMap.get(data.getId());
			}else{
				info = new AnalysisInfo();
			}
			
			switch(data.getStatus()){
			case 0:
				info.setConfirmCount(info.getConfirmCount() + 1);
				break;
			case 1:
				info.setCancleCount(info.getCancleCount() + 1);
				break;
			case 2:
				info.setChangeCount(info.getChangeCount() + 1);
				break;
			}
			
			info.setTotalCount(info.getTotalCount() + 1);
			
			customerMap.put(data.getId(), info);			
		}
		
		double max = 0;
		for(String key : customerMap.keySet()){
			
			AnalysisInfo info = customerMap.get(key);
			
			double percent = Math.round((info.getCancleCount() / info.getTotalCount() ) * 100);

			if(max < percent){
				max = percent;
				customerId = key;
			}
		}
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return customerId;
	}
	
	/**
	 * 주문취소 또는 교환 비율이 40% 이상인 상품 검색 기능
	 *
     * @param		inputData		List			입력 데이터(상품판매정보)
     * @return						List			주문취소 또는 교환 비율이 40% 이상인 상품 목록
	 */
	public List<String> getProductList(List<SalesInfo> inputData) {
		List<String> productList = null;
		////////////////////////여기부터 구현 (2) ---------------->
		productList = new ArrayList<>();
		HashMap<String, AnalysisInfo> productMap = new HashMap<>();

		for(SalesInfo data : inputData){
			AnalysisInfo info = null;
			if(productMap.keySet().contains(data.getProduct())){
				info = productMap.get(data.getProduct());
			}else{
				info = new AnalysisInfo();
			}
			
			switch(data.getStatus()){
			case 0:
				info.setConfirmCount(info.getConfirmCount() + 1);
				break;
			case 1:
				info.setCancleCount(info.getCancleCount() + 1);
				break;
			case 2:
				info.setChangeCount(info.getChangeCount() + 1);
				break;
			}
			
			info.setTotalCount(info.getTotalCount() + 1);
			
			productMap.put(data.getProduct(), info);			
		}
		
		for(String key : productMap.keySet()){
			
			AnalysisInfo info = productMap.get(key);
			
			double canclePercent = Math.round((info.getCancleCount() / info.getTotalCount() ) * 100);
			double changePercent = Math.round((info.getChangeCount() / info.getTotalCount() ) * 100);

			if(canclePercent >= 40 || changePercent >= 40){
				productList.add(key);
			}
		}
		
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return productList;
	}

}