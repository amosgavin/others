package com.avc.interceptor;

import java.lang.reflect.Method;

/**
 * @author AmVilCres
 * 
 * <p>
 * 	�ýӿڶ�����3��������before��around��after
 * 	<li>3�������Ĳ���Ϊ��proxy�������target��ʵ�Ķ���method������args���з�������</li>
 * 	<li>before��������booleanֵ��������ʵ����ǰ���á�������trueʱ��������ʵ����ķ�����������falseʱ�������around����</li>
 * 	<li>�ڷ�����ʵ���󷽷�����around����ִ��֮�󣬵���after����</li>
 * </p>
 */
public interface Interceptor {
	public boolean before(Object proxy, Object target, Method method, Object[] args);
	public void around(Object proxy, Object target, Method method, Object[] args);
	public void after(Object proxy, Object target, Method method, Object[] args);
}
