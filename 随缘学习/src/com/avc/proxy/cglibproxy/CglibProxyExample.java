package com.avc.proxy.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @desc  CGLIB������Ҫ�ṩ�ӿڣ�ֻҪһ���ǳ��������ʵ�ִ���
 * */
public class CglibProxyExample implements MethodInterceptor{

	/**
	 * ����CGLIB�������
	 * @param cls  Class��
	 * @return Class���CGLIB�������
	 * */
	public Object getProxy(Class cls) {
		//CGLIB enhancer ��ǿ�����
		Enhancer enhancer = new Enhancer();
		
		//������ǿ����
		enhancer.setSuperclass(cls);
		
		//��������߼�����Ϊ��ǰ����Ҫ��ǰ����ʵ��MethodInterceptor
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("������ʵ����֮ǰ");
		//CGLIB���������ʵ����ķ���
		Object res = methodProxy.invokeSuper(proxy, args);
		System.out.println("������ʵ����֮��");
		return res;
	}
	
	
}
