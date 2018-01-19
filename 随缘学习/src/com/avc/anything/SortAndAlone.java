package com.avc.anything;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
/**
 * @author AmVilCres
 * @desc 
 * @date 2017��11��9��
 */
/*
 * ��������ѧУ����һЩͬѧһ����һ���ʾ���飬Ϊ��ʵ��Ŀ͹��ԣ������ü����������N��1��1000֮������������N��1000����
 * ���������ظ������֣�ֻ����һ������������ͬ����ȥ������ͬ������Ӧ�Ų�ͬ��ѧ����ѧ�š�Ȼ���ٰ���Щ����С��������
 * �����źõ�˳��ȥ��ͬѧ�����顣����Э��������ɡ�ȥ�ء��롰���򡱵Ĺ�����
 
	 
	Input Param 
	     n               ����������ĸ���     
	 inputArray      n�����������ɵ����� 
	     
	Return Value
	     OutputArray    ����������������
 * */
import java.util.Scanner;
public class SortAndAlone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] inputArray = new int[n];
		ArrayList<Integer> list = new  ArrayList<>();
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] =sc.nextInt();
			if(!list.contains(inputArray[i]))
				list.add(inputArray[i]);
		}
		list.sort(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = iterator.next();
			System.out.println(integer);
		}
	}
}
