package com.jin.study.quiz;

import java.util.*;

public class WordCounting {
	
	/*
	 * 1.�Է�
		�Ʒ� ������ ���� �ؽ�Ʈ������ �̸� ����� �ΰ�, 
		���α׷��� �����ϸ� ���� ������ �о���δ�(��ó: Wikipedia).
		As the country became embroiled in a domestic crisis, the first government was dislodged and succeeded by several different administrations. Bolikango served as Deputy Prime Minister in one of the new governments before a partial state of stability was reestablished in 1961. He mediated between warring factions in the Congo and briefly served once again as Deputy Prime Minister in 1962 before returning to the parliamentary opposition. After Joseph-Desire Mobutu took power in 1965, Bolikango became a minister in his government. Mobutu soon dismissed him but appointed him to the political bureau of the Mouvement Populaire de la Revolution. Bolikango left the bureau in 1970. He left Parliament in 1975 and died seven years later. His grandson created the Jean Bolikango Foundation in his memory to promote social progress. The President of the Congo posthumously awarded Bolikango a medal in 2005 for his long career in public service.
				
	   2.���
		������(Separator)�� ��ħǥ '.', ��ǥ ',', ���� ' ' �̴�.
		���� ���� ���� ������� �ܾ� 10���� �� �ܾ��� �󵵸� ����Ѵ�.
		�󵵰� ���� �ܾ�� ������ ������ �����Ѵ�.
		
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
	 *  ArrayList �������� �������� ���� 
	 * 
	 */
	public static void main(String[] argv) {
		String inputMsg="As the country became embroiled in a domestic crisis, the first government was dislodged and succeeded by several different administrations. Bolikango served as Deputy Prime Minister in one of the new governments before a partial state of stability was reestablished in 1961. He mediated between warring factions in the Congo and briefly served once again as Deputy Prime Minister in 1962 before returning to the parliamentary opposition. After Joseph-Desire Mobutu took power in 1965, Bolikango became a minister in his government. Mobutu soon dismissed him but appointed him to the political bureau of the Mouvement Populaire de la Revolution. Bolikango left the bureau in 1970. He left Parliament in 1975 and died seven years later. His grandson created the Jean Bolikango Foundation in his memory to promote social progress. The President of the Congo posthumously awarded Bolikango a medal in 2005 for his long career in public service.";

		Map<String, Integer> hMap = new HashMap<>();
		inputMsg=inputMsg.replaceAll("[^0-9a-zA-Z ]","" ); //���� �����ڸ� ������ ������ ���ڸ� ���� (�ܾ� ī��Ʈ�� ����)
		System.out.println("After replaceAll >"+inputMsg);
		
		String[] arrInputMsg =inputMsg.split(" "); //�������� �ܾ� ����
		Arrays.sort(arrInputMsg); //�������� ����
		//System.out.println(arrInputMsg);
		
		int cnt=1;
		for(int i=0; i < arrInputMsg.length; i++) {
			if(arrInputMsg.length > i+1) {
				if(arrInputMsg[i].equals(arrInputMsg[i+1])) { //���ĵ� ���ڸ� �յ� ������� ���Ͽ� ������ ī��Ʈ +1 �Ѵ�.
					cnt++;
				}else {
					hMap.put(arrInputMsg[i], cnt);
					cnt=1;
				}
			}
			
		}
		
		List<String> keySetList = new ArrayList<>(hMap.keySet());
		
		//ArrayList �������� //
		Collections.sort(keySetList, new Comparator<String>() {
			@Override
	        public int compare(String o1, String o2) {
	        	return hMap.get(o2).compareTo(hMap.get(o1));
	        }
		});
	     
		//ArrayList �������� //
		//Collections.sort(keySetList, (o1, o2) -> (hMap.get(o1).compareTo(hMap.get(o2))));
		
		
		//��� ���
		int disCnt =0;
		for(String key : keySetList) {
			disCnt++;
			if( disCnt == 11 ) { //10�������� ���
				break;
			}else {
				System.out.println(String.format("Key : %s, Value : %s", key, hMap.get(key)));
			}
		}
		
		System.out.println("-----------------------------------------------------------------");
	
	}

}
