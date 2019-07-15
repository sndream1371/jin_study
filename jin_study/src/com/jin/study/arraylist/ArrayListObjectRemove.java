package com.jin.study.arraylist;

import java.util.ArrayList;
import java.util.List;


/*
 * ArrayList remove 처리 Index로 삭제하는법과 Object로 삭제하는법
 * 
 * Object로 삭제시 Obect에 반드시 equals메소드를 정의해야한다.
 * 
 * equals의 메소드는 이클립스에서 자동생성 지원한다.(private 선언후 생성)
 * 
 */
public class ArrayListObjectRemove {
	
    public static void main(String[] args) 
    {
    	//Index 방식으로 List 목록 지우기
    	//ListRemoveIndex();
    	
    	//Object 방식으로 List 목록 지우기
    	ListRemoveObject();
    	
    }
    
    
    public static void ListRemoveIndex () {
    	
    	 
        List<String> strList = new ArrayList<String>();
        strList.add("one");
        strList.add("two");
        strList.add("three");
 
        for (String str : strList) {
            System.out.println(str);
        }
 
        strList.remove(1); // two 제거
        System.out.println("## String 리스트에서 1번째 인덱스의 object 를 제거 한 뒤 ###");
 
        for (String str : strList) {
            System.out.println(str);
         
        }
        
        System.out.println();
 
        List<UserInfo> UserInfoList = new ArrayList<UserInfo>();
        UserInfoList.add(new UserInfo("Tom", "Hawk"));
        UserInfoList.add(new UserInfo("홍", "길동"));
        UserInfoList.add(new UserInfo("Michael", "Jordan"));
 
        for (UserInfo UserInfo : UserInfoList) {
            System.out.println(UserInfo);
 
        }
        
        UserInfoList.remove(0);
 
        System.out.println("### UserInfo 리스트로부터 0번째 인덱스의 object 를 제거 한 뒤 ###");
        for (UserInfo UserInfo : UserInfoList) {
            System.out.println(UserInfo);
        }

    }

    
    public static void ListRemoveObject() {
    	 List<String> strList = new ArrayList<String>();
         strList.add("one");
         strList.add("two");
         strList.add("three");
  
         for (String str : strList) {
             System.out.println(str);
         }
         
         strList.remove("two"); // two 제거
         System.out.println("## String 리스트에서 two object 를 제거 한 뒤 ###");
  
         for (String str : strList) {
             System.out.println(str);
         }
         
         System.out.println();
  
         List<UserInfo> userList = new ArrayList<UserInfo>();
         userList.add(new UserInfo("Tom", "Hawk"));
         userList.add(new UserInfo("홍", "길동"));
         userList.add(new UserInfo("Michael", "Jordan"));
  
         for (UserInfo user : userList) {
             System.out.println(user);
         }
         
         userList.remove(new UserInfo("홍", "길동"));
  
         System.out.println("### User 리스트로부터 홍길동 object 를 제거 한 뒤 ###");
         for (UserInfo user : userList) {
             System.out.println(user);
         }

    }
    
}
