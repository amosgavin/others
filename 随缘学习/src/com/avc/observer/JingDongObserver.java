package com.avc.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author AmVilCres
 * @desc 
 * @date 2017��10��30��
 */
public class JingDongObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		String product = (String)arg;
		System.out.println("�����²�Ʒ��"+product+"��������");
	}

}
