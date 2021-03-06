package com.jin.study.quiz;

import java.util.*;

public class WordCounting {
	
	/*
	 * 1.입력
		아래 내용을 가진 텍스트파일을 미리 만들어 두고, 
		프로그램을 실행하면 파일 내용을 읽어들인다(출처: Wikipedia).
		As the country became embroiled in a domestic crisis, the first government was dislodged and succeeded by several different administrations. Bolikango served as Deputy Prime Minister in one of the new governments before a partial state of stability was reestablished in 1961. He mediated between warring factions in the Congo and briefly served once again as Deputy Prime Minister in 1962 before returning to the parliamentary opposition. After Joseph-Desire Mobutu took power in 1965, Bolikango became a minister in his government. Mobutu soon dismissed him but appointed him to the political bureau of the Mouvement Populaire de la Revolution. Bolikango left the bureau in 1970. He left Parliament in 1975 and died seven years later. His grandson created the Jean Bolikango Foundation in his memory to promote social progress. The President of the Congo posthumously awarded Bolikango a medal in 2005 for his long career in public service.
				
	   2.출력
		구분자(Separator)는 마침표 '.', 쉼표 ',', 공백 ' ' 이다.
		가장 많이 나온 순서대로 단어 10개와 그 단어의 빈도를 출력한다.
		빈도가 같은 단어들 사이의 순서는 무시한다.
		
		in 12
		the 10
		Bolikango 5
		a 4
		of 4
		and 3
		to 3
		his 3
		became 2
		government 2
	 * 
	 * 
	 *  ArrayList 오름차순 내림차순 정렬 
	 * 
	 */
	public static void main(String[] argv) {
		String inputMsg="As the country became embroiled in a domestic crisis, the first government was dislodged and succeeded by several different administrations. Bolikango served as Deputy Prime Minister in one of the new governments before a partial state of stability was reestablished in 1961. He mediated between warring factions in the Congo and briefly served once again as Deputy Prime Minister in 1962 before returning to the parliamentary opposition. After Joseph-Desire Mobutu took power in 1965, Bolikango became a minister in his government. Mobutu soon dismissed him but appointed him to the political bureau of the Mouvement Populaire de la Revolution. Bolikango left the bureau in 1970. He left Parliament in 1975 and died seven years later. His grandson created the Jean Bolikango Foundation in his memory to promote social progress. The President of the Congo posthumously awarded Bolikango a medal in 2005 for his long career in public service.";

		Map<String, Integer> hMap = new HashMap<>();
		inputMsg=inputMsg.replaceAll("[^0-9a-zA-Z ]","" ); //숫자 영문자를 제외한 나머지 문자를 삭제 (단어 카운트를 위함)
		System.out.println("After replaceAll >"+inputMsg);
		
		String[] arrInputMsg =inputMsg.split(" "); //공백으로 단어 구분
		Arrays.sort(arrInputMsg); //오름차순 정렬
		//System.out.println(arrInputMsg);
		
		int cnt=1;
		for(int i=0; i < arrInputMsg.length; i++) {
			if(arrInputMsg.length > i+1) {
				if(arrInputMsg[i].equals(arrInputMsg[i+1])) { //정렬된 문자를 앞뒤 순서대로 비교하여 같으면 카운트 +1 한다.
					cnt++;
				}else {
					hMap.put(arrInputMsg[i], cnt);
					cnt=1;
				}
			}
			
		}
		
		List<String> keySetList = new ArrayList<>(hMap.keySet());
		
		//ArrayList 내림차순 //
		Collections.sort(keySetList, new Comparator<String>() {
			@Override
	        public int compare(String o1, String o2) {
	        	return hMap.get(o2).compareTo(hMap.get(o1));
	        }
		});
	     
		//ArrayList 오름차순 //
		//Collections.sort(keySetList, (o1, o2) -> (hMap.get(o1).compareTo(hMap.get(o2))));
		
		
		//결과 출력
		int disCnt =0;
		for(String key : keySetList) {
			disCnt++;
			if( disCnt == 11 ) { //10개까지만 출력
				break;
			}else {
				System.out.println(String.format("Key : %s, Value : %s", key, hMap.get(key)));
			}
		}
		
		System.out.println("-----------------------------------------------------------------");
	
	}

}
