package com.jin.study;


public class Fibonacci {
	 
    public static void main(String[] args) {
        
    	try {
    		double  a1 = 1;
    		double  a2 = 1;
    		double  a3;
            
            System.out.println(a1);
            System.out.println(a2);
            
            for(int i=1; i<=100; i++){
                a3=a1+a2;
                System.out.println(i+2 + "    " + a3);
                a1=a2;
                a2=a3;
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
                
    }
}

