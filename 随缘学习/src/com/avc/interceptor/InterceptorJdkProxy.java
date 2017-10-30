package com.avc.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author AmVilCres
 * @desc 
 * @date 2017��10��30��
 */
public class InterceptorJdkProxy implements InvocationHandler{
	private Object target; //��ʵ����
	private String interceptorClass; // ������ȫ�޶���
	
	public InterceptorJdkProxy(Object target,String interceptorClass) {
		this.target = target;
		this.interceptorClass = interceptorClass;
	}
	
	
	/**
	 * ��ί�ж��󲢷���һ�� ������ռλ��
	 * 
	 * @param target ��ʵ�Ķ���
	 * @return �������ռλ��
	 * */
	public static Object bind(Object target, String interceptorClass) {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), new InterceptorJdkProxy(target, interceptorClass));
	}
	
	
	/**
	 * ͨ�����������÷��������Ƚ�������������
	 * 
	 * @param proxy �������
	 * @param method  �����õķ���
	 * @param args �����Ĳ���
	 * */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(interceptorClass == null)
			return method.invoke(target, args);
		Object res = null;
		
		//ͨ����������������
		Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
		
		if(interceptor.before(proxy, target, method, args))
			res = method.invoke(target, args); //����ԭ�ж��󷽷�
		else {
			interceptor.around(proxy, target, method, args);
		}
		interceptor.after(proxy, target, method, args);
		
		return res;
	}
}
