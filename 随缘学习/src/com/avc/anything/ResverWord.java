package com.avc.anything;

import java.util.Scanner;

/**
 * @author AmVilCres
 * @desc 
 * @date 2017��11��1��
 */
public class ResverWord {
	public static void main(String[] args) {
		//String str = "hello xiao mi";
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ�����ӣ�");
		String str = sc.nextLine();
		sc.close();
		String[] strArr = str.split(" +");
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<strArr.length; i++) {
			strArr[i] = sb.append(strArr[i]).reverse().toString();
			sb = new StringBuilder();
		}
		
		for(int i=0; i<strArr.length; i++) {
			sb.append(strArr[i]+" ");
		}		
		System.out.println(sb.reverse().toString().trim());
	}
}

