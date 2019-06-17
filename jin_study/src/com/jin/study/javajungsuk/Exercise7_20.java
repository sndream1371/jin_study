package com.jin.study.javajungsuk;

/*
 * 이스턴스 메서드: 인스턴스 메서드의 경우는 참조변수의 타입에 관계없이 항상 실제 인스턴스의 메서드가 호출 
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
		System.out.println("p.x = " + p.x); //부모의 멤버변수가 실행됨
		p.method(); //자식의 메소드가 실행됨 (좀 이해안됨) call by reference
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


