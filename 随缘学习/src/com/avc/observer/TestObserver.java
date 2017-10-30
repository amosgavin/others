package com.avc.observer;

/**
 * @author AmVilCres
 * @desc 
 * @date 2017��10��30��
 */
public class TestObserver {
	public static void main(String[] args) {
		ProductList productList = ProductList.getInstance();
		TaoBaoObserver baoObserver = new TaoBaoObserver();
		JingDongObserver dongObserver = new JingDongObserver();
		productList.addProductObserver(baoObserver);
		productList.addProductObserver(dongObserver);
		productList.addProduct("��Ƥ�»�");
	}
}
