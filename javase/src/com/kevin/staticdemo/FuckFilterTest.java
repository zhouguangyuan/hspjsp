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
		System.out.println("���췽��");
	}

	private static classA s1 = new classA("��̬��Ա����1");

	private classA f1 = new classA("��ͨ��Ա����1");

	{
		System.out.println("��������1");
	}

	static {
		System.out.println("��̬��1");
	}

	{
		System.out.println("��������2");
	}

	private classA f2 = new classA("��ͨ��Ա����2");

	private static classA s2 = new classA("��̬��Ա����2");

	static {
		System.out.println("��̬��2");
	}

}

// ֻ��������
class classA {
	classA(String desc) {
		System.out.println(desc);
	}
}
