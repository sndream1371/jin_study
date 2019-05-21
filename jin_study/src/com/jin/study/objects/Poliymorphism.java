package com.jin.study.objects;


public class Poliymorphism {

	private void f() {
		System.out.println("base class");
	}

	public static void main(String[] argv) {
		Poliymorphism po = new Derived();
		po.f();
	}

	class Derived extends Poliymorphism {
		public void f() {
			System.out.println("sub class");
		}
	}
}

//No enclosing instance of type Poliymorphism is accessible. Must qualify the allocation with an enclosing 
//instance of type Poliymorphism (e.g. x.new A() where x is an instance of Poliymorphism).