package com.jin.study.tct.sawonprint;

public class EmployeeRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] department = {{"10","������"},{"20","������"},{"30","������"},{"40","���"}};
		String[][] employee = {{"59545","�ּ���","10"},{"23561","�ڼ���","20"},{"37123","��浿","10"},{"33777","�̱���","30"}};
		
		Employee emp = new Employee();
		emp.print(department, employee);
		

	}

}
