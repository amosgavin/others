package com.avc.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author AmVilCres
 * @desc ����
 * @date 2017��10��30��
 */
public class ProductList extends Observable {
	
	private List<String> productList = null; //��Ʒ�б�
	
	private static ProductList instance; //��Ψһʵ��
	
	private ProductList() {}  //���췽��˽�л�
	
	/**
	 * ��ȡΨһ��ʵ��
	 * @return ��Ʒ�б�Ψһʵ��
	 * */
	public static ProductList getInstance() {
		if(null==instance) {
			instance = new ProductList();
			instance.productList = new ArrayList<String>();
		}
		
		return instance;
	}
	
	/**
	 * ���ӹ۲���(���̽ӿ�)
	 * @param observer �۲���
	 * */
	public void addProductObserver(Observer observer) {
		this.addObserver(observer);
	}
	
	/**
	 * ������Ʒ
	 * */
	public void addProduct(String newProduct) {
		productList.add(newProduct);
		System.out.println("��Ʒ�б����˱仯");
		this.setChanged(); //��֪�۲��߱��۲��߷����˱仯
		this.notifyObservers(newProduct);
	}
}
