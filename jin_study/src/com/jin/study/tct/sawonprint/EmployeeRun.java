package com.jin.study.tct.sawonprint;

public class EmployeeRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] department = {{"10","영업팀"},{"20","구매팀"},{"30","개발팀"},{"40","운영팀"}};
		String[][] employee = {{"59545","최선명","10"},{"23561","박선주","20"},{"37123","김길동","10"},{"33777","이기주","30"}};
		
		Employee emp = new Employee();
		emp.print(department, employee);
		

	}

}
