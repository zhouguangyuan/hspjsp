package com.kevin.staticdemo;

public class RAMTest {
	{
		price = 3.4;// ①--非静态语句块
	}

	public RAMTest(double price) {
		this.price = price;// ②--构造函数
	}

	double price = 2.0;// ③--声明语句并赋值
	
}
/*本例中对实例变量price的初始化有三处
执行顺序为：③中price变量声明[price=0.0]
--①中price变量赋值[price=3.4]
--③中price变量赋值[price=2.0]
--②中price构造函数赋值
需要注意的是，虽然非静态语句初始块中的price变量的赋值在声明之前，
但实际上执行的时候会先执行变量的声明，再按代码顺序执行变量值的赋值动作，
然后再进行构造函数对实例的初始化构造。这三种实例变量的初始化语句经过编译器处理后，
都会合并到构造器中去，其中定义变量语句转换得到的赋值语句、
初始化块中的语句转化得到的赋值语句，总是位于构造器的所有语句之前。
合并后两种赋值语句的顺序保持他们在源码中的顺序。*/
