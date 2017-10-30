package com.avc.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyExample implements InvocationHandler {
	
	private Object target=null; //���ǵĶ���

	/**
	 * ��������������ʵ����Ĵ����ϵ
	 * @param target ��ʵ����
	 * @return �������
	 * */
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	/**
	 * �������߼�
	 * @param proxy �������
	 * @param method ��ǰ���ȵķ���
	 * @param args ��ǰ�����Ĳ���
	 * @return ����������
	 * @throws Throwable �쳣
	 * */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("��������߼�����");
		System.out.println("�ڵ�����ʵ����֮ǰ�ķ���");
		Object obj = method.invoke(target, args); //�൱�ڵ���sayHello����
		System.out.println("�ڵ�����ʵ����֮��ķ���");
		return obj;
	}

}
