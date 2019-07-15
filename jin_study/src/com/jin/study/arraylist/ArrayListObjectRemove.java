package com.jin.study.arraylist;

import java.util.ArrayList;
import java.util.List;


/*
 * ArrayList remove ó�� Index�� �����ϴ¹��� Object�� �����ϴ¹�
 * 
 * Object�� ������ Obect�� �ݵ�� equals�޼ҵ带 �����ؾ��Ѵ�.
 * 
 * equals�� �޼ҵ�� ��Ŭ�������� �ڵ����� �����Ѵ�.(private ������ ����)
 * 
 */
public class ArrayListObjectRemove {
	
    public static void main(String[] args) 
    {
    	//Index ������� List ��� �����
    	//ListRemoveIndex();
    	
    	//Object ������� List ��� �����
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
 
        strList.remove(1); // two ����
        System.out.println("## String ����Ʈ���� 1��° �ε����� object �� ���� �� �� ###");
 
        for (String str : strList) {
            System.out.println(str);
         
        }
        
        System.out.println();
 
        List<UserInfo> UserInfoList = new ArrayList<UserInfo>();
        UserInfoList.add(new UserInfo("Tom", "Hawk"));
        UserInfoList.add(new UserInfo("ȫ", "�浿"));
        UserInfoList.add(new UserInfo("Michael", "Jordan"));
 
        for (UserInfo UserInfo : UserInfoList) {
            System.out.println(UserInfo);
 
        }
        
        UserInfoList.remove(0);
 
        System.out.println("### UserInfo ����Ʈ�κ��� 0��° �ε����� object �� ���� �� �� ###");
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
         
         strList.remove("two"); // two ����
         System.out.println("## String ����Ʈ���� two object �� ���� �� �� ###");
  
         for (String str : strList) {
             System.out.println(str);
         }
         
         System.out.println();
  
         List<UserInfo> userList = new ArrayList<UserInfo>();
         userList.add(new UserInfo("Tom", "Hawk"));
         userList.add(new UserInfo("ȫ", "�浿"));
         userList.add(new UserInfo("Michael", "Jordan"));
  
         for (UserInfo user : userList) {
             System.out.println(user);
         }
         
         userList.remove(new UserInfo("ȫ", "�浿"));
  
         System.out.println("### User ����Ʈ�κ��� ȫ�浿 object �� ���� �� �� ###");
         for (UserInfo user : userList) {
             System.out.println(user);
         }

    }
    
}
