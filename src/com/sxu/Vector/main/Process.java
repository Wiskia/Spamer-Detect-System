/**
 * @author SXU.ZSC
 *
 */
package com.sxu.Vector.main;

import java.io.File;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import com.sxu.Vector.Word2Vec.Word2Vec;
import com.sxu.Vector.LDA.LDA;

public class Process {
	/**
	 *用户评论文本的主题和内容融合表示算法，
	 *LDA+Word2Vec
	 *维度大小：200
	 **/
	public static float[] StringProcess(String str) throws Exception {
		File newdocs = new File("D:\\javashit\\SDS\\LDAdata\\newdocs.dat");//存放用户评论的.dat文件
		float[] a= new float[100];
		a=Word2Vec.test(str);
//		for( int i=0;i<a.length;i++)
//		System.out.print(a[i]);
		LDA.WriteFirstLine("1", "D:\\javashit\\SDS\\LDAdata\\newdocs.dat");
		LDA.writer(str, "D:\\javashit\\SDS\\LDAdata\\newdocs.dat");
		LDA.test();
		String str3 = LDA.readlastline("D:\\javashit\\SDS\\LDAdata\\newdocs.dat.model-final.theta");//得到的LDA概率分布.theta文件
		String[] s = str3.split(" ");
		float[] b= new float[s.length];
		for(int i=0;i<s.length;i++)
			b[i] = Float.parseFloat(s[i]);
		newdocs.delete();
		float[] c = (float[]) ArrayUtils.addAll(a,b);
		return c;
	}
	
	public static void main(String[] args) throws Exception {  
		float[] v = Process.StringProcess("我为大众免费代言：大众车好！我是速腾车主，现在开速腾，我下辈子还买速腾，不仅仅因为速腾这车比较高级，而且速腾是辆高智能性好车。更重要的是，速腾把我造就成了一位有素质的高端人才。");
		System.out.println(Arrays.toString(v));
	}
}