package com.avc.proxy.jdkproxy;

public class TestJdkProxy {
	public static void main(String[] args) {
		JDKProxyExample jdk = new JDKProxyExample();
		
		//�󶨹�ϵ����Ϊ���ڽӿ�HelloWorld�£����������������HelloWord proxy
		HelloWorld proxy = (HelloWorld)jdk.bind(new HelloWorldImpl());
		
		//��ʱHelloWorld�����Ѿ���һ���������������������߼�����invoke����
		proxy.sayHello();
	}
}
