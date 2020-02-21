/**
 * @author SXU.ZSC
 *
 */
package com.sxu.Vector.Word2Vec;

import java.io.IOException;
import java.util.Map;

import w2v.org.nlp.model.W2Vmodel;

public class Word2Vec {
	/**
	 *调用word2vec.jar包，word2vec文本内容表示算法，
	 *维度大小：100
	 *取值范围[0,1]
	 **/
	public static int m=0;
	@SuppressWarnings("unused")
	public static float[] test(String str) throws IOException {
		// TODO Auto-generated method stub
		int length = 100;
		int sum = 0;
		Map<String,float[]> w2vMap = W2Vmodel.word2Vector(str, length, 0);
//		Map<String,float[]> w2vMap = W2Vmodel.fileword2Vector(path1, length, 0);
		for ( Map.Entry<String,float[]>MyWord2Vector: w2vMap.entrySet()){
//			String word1=MyWord2Vector.getKey();
//			float[] Vector1=MyWord2Vector.getValue();
		    sum++;		
		}
//      System.out.println(sum);
		float[][]b=new float[sum][];
		int i=0;
		
		for ( Map.Entry<String,float[]>MyWord2Vector: w2vMap.entrySet()){
			String word2=MyWord2Vector.getKey();
			float[] Vector2=MyWord2Vector.getValue();
			b[i]=new float[Vector2.length];
			for(int j=0;j<Vector2.length;j++){
				b[i][j]=Vector2[j];
			}
		   m+=b[i].length;
		   i++;		  
		}
//	    float[] textVector=new float[m];
	    int row=0;
	    int column=0;
	    float[]sumVector=new float[100];
	    float[]averageVector=new float[100];
        for( column=0;column<100;column++){
	        for( row=0;row<b.length;row++)	{		
			    sumVector[column]+=b[row][column];
			    averageVector[column]=((sumVector[column]/sum)+1)/2;
		   
		    }
//	    System.out.print(averageVector[column]+"  ");	
        }
	return  averageVector;
    }
}
