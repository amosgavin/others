/**
 * 
 */
package com.avc.interceptor;

import java.lang.reflect.Method;

/**
 * @author AmVilCres
 * @desc 
 * @date 2017��10��30��
 */
public class MyInterceptor implements Interceptor {

	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		System.err.println("���䷽��ǰ�߼�");
		return false;  //�����䱻��������ԭ�з���
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("ȡ���˱��������ķ���");
	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("���䷽�����߼�");
	}

}
