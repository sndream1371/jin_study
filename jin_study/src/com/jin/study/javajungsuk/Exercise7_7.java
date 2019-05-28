package com.jin.study.javajungsuk;

class Parent {
	int x = 100;

	Parent() {
		this(200);
		System.out.println("--2--Parent() this(200)");
	}

	Parent(int x) {
		System.out.println("--1--Parent(int x) this(200)");
		this.x = x;
	}

	int getX() {
		System.out.println("--5--Parent getX()");
		return x;
	}
}

class Child extends Parent {
	int x = 3000;

	Child() {
		this(1000);
		System.out.println("--4--Child()");
	}

	Child(int x) {
		System.out.println("--3--Child(int x)");
		this.x = x;
	}
}

class Exercise7_7 {
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println("x=" + c.getX());
	}
}