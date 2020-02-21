/**
 * @author SXU.ZSC
 *
 */
package com.sxu.Vector.Segmentation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.io.BufferedWriter;

public class StopWords {
	/**
	 *去停用词算法，
	 *采用字符匹配，对照停用词表，去除停用词
	 **/
	public static final String stopWordTable = "StopWordTable.txt";
	public static Set stopWordSet ;
	String ifilePath;
	String ofilePath;
	String str = null;
	
    public void setStr(String str) {
		this.str = str;
	}

	public  void writer(String Str) throws IOException{
    	FileWriter filewriter = new FileWriter(ofilePath); 
        BufferedWriter writer = new BufferedWriter(filewriter);   
        writer.write(Str);  
        writer.flush();  
        writer.close();            
        } 
    
    public static void StopWords(){
			System.out.println("");
			try{
				//load stop words table.
				BufferedReader StopWordFileBr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(stopWordTable)), "GBK"));				
				stopWordSet= new HashSet<String>(); 
		        String stopWord = null;
		        for (; (stopWord = StopWordFileBr.readLine()) != null;) {
		            stopWordSet.add(stopWord);
		        }		        
//		        for(Object str:stopWordSet.toArray()){
//		        	System.out.println((String)str);
//		        }		      		        
			}catch (FileNotFoundException e) {
		        e.printStackTrace();
			}catch (Exception e) {
		        e.printStackTrace();
		    }
    	
    }
    public static String excludeStopWords(String[] text) {
        try{
        	for (int i = 0; i < text.length; i++) {
            if (stopWordSet.contains(text[i].trim())) {
                text[i]=null;
            }
        }
        StringBuffer finalStr = new StringBuffer();
        for (int i = 0; i < text.length; i++) {
            if (text[i] != null) {
                finalStr = finalStr.append(text[i].trim()).append(" ");
            }
        }
//		System.out.println(finalStr);
		return finalStr.toString();
    } catch (Exception e) {
        e.printStackTrace();
    }
        return null;
	}
    
    public static void main(String argv[]) throws Exception{
    	
        StopWords clean = new StopWords();
        clean.setStr("我 爱 中国 ， / 钓鱼 岛 是 中国 的");
        System.out.println(clean.str);
        String[] s = clean.str.split(" ");
//        for(int i=0;i<s.length;i++)
//        	System.out.println(s[i]);
        StopWords();
        String str = excludeStopWords(s);
        System.out.println(str);

    }
    
    public static String test(String str) {    	
        String[] s = str.split(" ");
        /*for(int i=0;i<s.length;i++)
        	System.out.println(s[i]);*/
        StopWords();
        return excludeStopWords(s);
//        System.out.println("去停用词后结果："+str1);
        

    }
}