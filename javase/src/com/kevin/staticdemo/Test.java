package com.kevin.staticdemo;

public class Test { // 1.��һ����׼��������
	public static void main(String[] args) {
		new Test(); // 4.���Ĳ���newһ���࣬����new֮ǰҪ�������������
	}

	static int num = 4; // 2.�ڶ�������̬�����;�̬�����ļ���˳���ɱ�д�Ⱥ����
	{
		num += 3;
		System.out.println("b"); // 5.���岽������˳�������������飬��������д�ӡ
	}
	int a = 5; // 6.������������˳����ر���
	{ // ��Ա����������
		System.out.println("c"); // 7.���߲�������˳���ӡc
	}

	Test() { // ��Ĺ��캯�������ĸ�����
		System.out.println("d"); // 8.�ڰ˲��������ع��캯������ɶ���Ľ���
	}

	static { // 3.����������̬�飬Ȼ��ִ�о�̬����飬��Ϊ��������ʴ�ӡa
		System.out.println("a");
	}

	static void run() // ��̬���������õ�ʱ��ż���// ע�⿴��eû�м���
	{
		System.out.println("e");
	}
}
