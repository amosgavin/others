package com.avc.interceptor.link;

import java.lang.reflect.Method;

import com.avc.interceptor.Interceptor;

/**
 * @author AmVilCres
 * @desc 
 * @date 2017��10��30��
 */
public class Interceptor2 implements Interceptor {

	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("������  2 �� before����");
		return true;
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("������  2 �� around����");
	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("������  2 �� after����");
	}

}
