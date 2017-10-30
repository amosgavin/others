package com.avc.interceptor.link;

import java.lang.reflect.Method;

import com.avc.interceptor.Interceptor;

/**
 * @author AmVilCres
 * @desc 
 * @date 2017��10��30��
 */
public class Interceptor1 implements Interceptor {

	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("������  1 �� before����");
		return true;
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("������  1 �� around����");
	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("������  1 �� after����");
	}

}
