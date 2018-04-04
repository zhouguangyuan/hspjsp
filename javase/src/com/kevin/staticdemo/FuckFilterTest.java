package com.kevin.staticdemo;


public class FuckFilterTest {

	public void shunxu() {
		classB b = new classB();
		System.out.println("-------------------");
		classB b2 = new classB();
	}

}

class classB {

	public classB() {
		System.out.println("构造方法");
	}

	private static classA s1 = new classA("静态成员变量1");

	private classA f1 = new classA("普通成员变量1");

	{
		System.out.println("构造代码块1");
	}

	static {
		System.out.println("静态块1");
	}

	{
		System.out.println("构造代码块2");
	}

	private classA f2 = new classA("普通成员变量2");

	private static classA s2 = new classA("静态成员变量2");

	static {
		System.out.println("静态块2");
	}

}

// 只用作测试
class classA {
	classA(String desc) {
		System.out.println(desc);
	}
}
