/**
 * @author SXU.ZSC
 *
 */
package com.sxu.Vector.Segmentation;

import test.java.com.huaban.analysis.jieba.Demo;

public class Filepro {
	/**
	 *文本预处理程序，
	 *对一条文本进行分词去糙处理
	 **/
    public static String pro(String str) throws Exception{

            	String str1 = Demo.demo(str);
        		String str2 = StopWords.test(str1);	
//        		LDA.writer(str2, ProPath);
        		return str2;
 
    }
}
