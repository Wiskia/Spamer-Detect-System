/**
 * 
 */
/**
 * @author SXU.ZSC
 *
 */
package com.sxu.Similarity;

public  class  Similarity{
	/**
	 *欧式距离算法，
	 *计算测试点到各个聚类中心的距离
	 *维度大小：200
	 **/
    public static  float[] Sim(float [] a,float [] b ,float [] c){
	
    	float sumXYdiff[]= new float[2];
	    float[][]diff=new float[2][a.length];	
	    for(int i=0;i<b.length;i++){
		    diff[0][i]= (( a[i]-b[i] )*( a[i]-b[i]));
	    }
	    for(int i=0;i<c.length;i++){
		    diff[1][i]=(( a[i]-c[i] )*( a[i]-c[i]));
	    }
	    for(int i=0;i<2;i++){
	        for(int j=0;j<200;j++){		 
		        sumXYdiff[i]+=diff[i][j];
	        }
	    }
	    sumXYdiff[0]=(float) (1.0/(1.0+Math.sqrt(sumXYdiff[0])/Math.sqrt(200)));
	    sumXYdiff[1]=(float) (1.0/(1.0+Math.sqrt(sumXYdiff[1])/Math.sqrt(200)));
	    return sumXYdiff;
    }
}
