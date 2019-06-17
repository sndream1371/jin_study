package com.jin.study.javajungsuk;

/*
 * 
p.x = 100
Child Method..
c.x = 200
Child Method..
 *
 */
class Exercise7_20 {
	public static void main(String[] args) {
		Parent20 p = new Child20();
		Child20 c = new Child20();
		System.out.println("p.x = " + p.x); //�θ��� ��������� �����
		p.method(); //�ڽ��� �޼ҵ尡 ����� (�� ���ؾȵ�) call by reference
		System.out.println("c.x = " + c.x);
		c.method();
	}
}

class Parent20 {
	int x = 100;

	
	void method() {
		System.out.println("Parent Method");
	}
}

class Child20 extends Parent20 {
	int x = 200;
	void method() {
		System.out.println("Child Method..");
	}
}


