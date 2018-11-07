package com.lex.util;

import java.util.Arrays;

public class CheckSignature {
	private static final String token="lex";
//	private static final String";
public static boolean checkSignature(String signature,String timestamp,String nonce,String echostr){
	String[] arr=new String[]{token,timestamp,nonce};
	//排序
    Arrays.sort(arr);
    //生成字符串
    StringBuffer content=new StringBuffer();
    for (int i = 0; i < arr.length; i++) {
		content.append(arr[i]);
	}
    //sha1加密
   String temp= Sha1.getSha1(content.toString());
   return signature.equals(temp);
}
}
