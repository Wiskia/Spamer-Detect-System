/**
 * @author SXU.ZSC
 *
 */
package com.sxu.Vector.LDA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import jgibblda.Inferencer;
import jgibblda.LDACmdOption;
import jgibblda.Model;

public class LDA {
	/**
	 *调用LDAjar包，实现LDA主题表示算法
	 *输入：经分词去糙后的一条评论文本
	 *输出：LDA主题分布
	 *维度大小:100
	 **/
		public static void test() throws CmdLineException{
			//这里定义了一个option类的对象,同时实例化了LDACmdOption里所有的变量
			LDACmdOption option = new LDACmdOption(); 
			option.setEst(false);
			option.setEstc(true);
			option.setDir("D:\\javashit\\SDS\\LDAdata\\");
			option.setDfile("newdocs.dat");
			option.setModelName("model-final");
			CmdLineParser parser = new CmdLineParser(option);
	        //以下是对option这个对象进行各种操作
				parser.parseArgument();
				Inferencer inferencer = new Inferencer();
				inferencer.init(option);				
				Model newModel = inferencer.inference();			
//				for (int i = 0; i < newModel.phi.length; ++i){//输出结果
//					//phi: K * V
//					System.out.println("-----------------------\ntopic" + i  + " : ");
//					for (int j = 0; j < 10; ++j){
//						System.out.println(inferencer.globalDict.id2word.get(j) + "\t" + newModel.phi[i][j]);
//					}
//				}
		}
						
		public static void showHelp(CmdLineParser parser){
			System.out.println("LDA [options ...] [arguments...]");//输出
			parser.printUsage(System.out);
		}
		
		public  static void writer(String Str,String path) throws IOException{			 
	        RandomAccessFile randomFile = new RandomAccessFile(path, "rw");
	        // 文件长度，字节数
	        long fileLength = randomFile.length();
	        // 将写文件指针移到文件尾。
	        randomFile.seek(fileLength);	 
	        randomFile.write(("\r\n"+Str).getBytes("GB2312"));
            randomFile.close();            
	    }
		
		public  static void WriteFirstLine(String Str,String path) throws IOException{			 
	        RandomAccessFile randomFile = new RandomAccessFile(path, "rw");
	        // 文件长度，字节数
	        long fileLength = randomFile.length();
	        // 将写文件指针移到文件尾。
	        randomFile.seek(fileLength);	 
	        randomFile.write((Str).getBytes("GB2312"));
            randomFile.close();            
	    }
		
		public  static String readlastline(String path) throws IOException{
			String str1 = null;
	        String str2 = null;
			try {
	            String encoding="GBK";
	            File file=new File(path);
	            if(file.isFile() && file.exists()){ 
	                InputStreamReader read = new InputStreamReader(
	                new FileInputStream(file),encoding);
	                BufferedReader bufferedReader = new BufferedReader(read);
	                while ((str1 = bufferedReader.readLine()) != null){
	                	str2 = str1;
	                }
	                read.close();
	                
	    }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
			return str2;
		}
				
		public static void main(String[] args) throws CmdLineException{
			LDA.test();
		}
}
