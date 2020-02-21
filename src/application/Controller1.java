/**
 * @author SXU.ZSC
 *
 */
package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.sxu.Vector.Segmentation.Filepro;
import com.sxu.Vector.main.Process;
import com.sxu.Crawler.InfoSpider;
import com.sxu.Similarity.Similarity;
import com.sxu.UserData.User;;

public class Controller1 implements Initializable {
	/**
	 *事务响应配置，
	 *开始分析、导入文件、预处理、分析用户等步骤实现，以及结果展示
	 **/
	//开始分析
	@FXML
	   private Button start;

	//导入文件
	   @FXML
	   private Button input;
	   
	   //预处理
	   @FXML
	   private Button pro;
	   
	   //结果显示区
	   @FXML
	   private TextArea textarea;
	   
	   //文件路径输入框
	   @FXML
	   private TextField address;
	   
	   //文件路径
	   public static String Path = "";
	   //用户
	   public static ArrayList<User> user = new ArrayList<User>();
	   //用户名
	   public static ArrayList<String> username = new ArrayList<String>();

       //	   提醒窗口
	   public void AlertWindow(String p_header, String p_message,String p_content){
	        Alert _alert = new Alert(Alert.AlertType.INFORMATION);
	        Group root = new Group();
	        Scene scene  = new Scene(root,200.0,200.0);
	        _alert.setTitle(p_header);
	        _alert.setHeaderText(p_message);
	        _alert.setContentText(p_content);
	        Stage d_stage = new Stage();
	        d_stage.setHeight(200);
	        d_stage.setWidth(200);
	        d_stage.setScene(scene);
			_alert.initOwner(d_stage);
	        _alert.show();
	    }
	   
	   //导入文件事件
	   public void InputAction(ActionEvent evt) throws IOException, Exception {

		   Path = address.getText();
	        
	           AlertWindow("文件导入","文件导入成功！","文件路径为："+Path);
	   }
	   
	   //预处理事件
	public void ProAction(ActionEvent evt) throws Exception {
		   if(Path != ""){
	        	 String encoding="gbk";
	             File file=new File(Path);
	                 InputStreamReader read = new InputStreamReader(
	                 new FileInputStream(file),encoding);
	                 BufferedReader bufferedReader = new BufferedReader(read);
	                 String str= "";
	                 str = bufferedReader.readLine();
	                 while (str != null){
	                	 System.out.println(str);
	                	 String[] all = str.split(";");
	                	 if(username.contains(all[0])==false){
	                		 username.add(all[0]);
	                		 User newuser = new User();
	                		 newuser.text.add(Filepro.pro(all[2]));
	                		 newuser.setName(all[0]);
	                		 newuser.setPd(InfoSpider.demo(all[1]));
	                		 user.add(newuser);
	                	 }
	                	 else {
	                		 for(int i = 0;i<user.size();i++){
	                			 if(user.get(i).url == all[0]){
	                				 user.get(i).text.add(Filepro.pro(all[2]));
	                			 }
	                		 }
	                	 };
	                	 str = bufferedReader.readLine();
	                 }
	                 bufferedReader.close();
	        AlertWindow("预处理","预处理完成！","发现"+username.size()+"个用户");
	    }
	   }

	   //分析事件
	   public void StartAction(ActionEvent evt) throws Exception {
		   double [] a= {-0.01009725, 0.008057383, -0.0022450215, -0.0106030945, 0.0020162447, -0.0023339358, -0.0019571676, 0.005702399, 0.005757648, 0.011849235, -0.013347835, -0.0031704549, -0.0069771605, 0.0028085583, 0.0016641946, -0.009443924, 2.3031878E-4, 0.006995033, 0.013246372, -0.010478979, -0.013637484, -0.005358749, 7.713113E-4, -0.003872634, 0.0095418, 0.0037115458, -0.009326561, -0.0012584173, -0.008744178, -0.009252416, -0.0046385345, -0.0029028803, -0.005338515, 0.004555651, -0.009468921, 0.008126756, -0.016187688, -0.006133163, 7.129647E-4, -0.011840376, 0.0067457403, 0.010033429, -0.014680789, 0.003141634, 0.0056241406, -0.004707594, -0.0016563648, -0.009305293, 0.003571516, 0.0061313636, -0.013461217, 0.0049255015, -0.016591718, 0.003239386, 0.004754003, 0.013753271, -0.010964753, 0.008833947, 0.014712877, 0.008660085, -0.011981518, -7.1489846E-4, -0.0017064485, 0.0031430644, 0.008202799, 0.0057720407, 0.0036913846, -0.0016028371, 0.015727378, 0.0025990081, 0.00190666, -0.005424273, -0.011040614, -0.007774401, 0.013730618, 0.002208465, 0.0016213605, 0.0059638135, 1.9244522E-4, 0.0012931448, -0.013156828, -0.012920561, -0.010438706, 3.0989698E-4, 0.0010503682, 1.5932288E-4, 0.0077072037, -0.005084686, -0.0040591382, 0.0020720875, -0.0021509062, 0.015646964, 0.0034892913, 0.002635957, 0.005186968, 0.008257481, 0.014971037, -0.0027534035, -0.009867042, 0.0044683646, 9.174312E-4, 9.174312E-4, 0.008256881, 9.174312E-4, 9.174312E-4, 9.174312E-4, 0.006422018, 9.174312E-4, 9.174312E-4, 0.008256881, 9.174312E-4, 9.174312E-4, 0.006422018, 0.0045871558, 0.37706423, 0.0027522936, 0.006422018, 9.174312E-4, 9.174312E-4, 0.0045871558, 9.174312E-4, 9.174312E-4, 0.0045871558, 0.0027522936, 0.0027522936, 9.174312E-4, 0.0045871558, 0.008256881, 9.174312E-4, 0.0027522936, 9.174312E-4, 9.174312E-4, 0.0045871558, 9.174312E-4, 9.174312E-4, 9.174312E-4, 0.0045871558, 0.0027522936, 9.174312E-4, 9.174312E-4, 0.38990825, 0.0027522936, 9.174312E-4, 9.174312E-4, 9.174312E-4, 9.174312E-4, 0.0045871558, 9.174312E-4, 9.174312E-4, 9.174312E-4, 0.0027522936, 9.174312E-4, 9.174312E-4, 9.174312E-4, 9.174312E-4, 9.174312E-4, 0.0045871558, 9.174312E-4, 9.174312E-4, 0.011926605, 0.0027522936, 9.174312E-4, 9.174312E-4, 9.174312E-4, 9.174312E-4, 9.174312E-4, 0.006422018, 0.0045871558, 9.174312E-4, 9.174312E-4, 9.174312E-4, 9.174312E-4, 9.174312E-4, 0.0045871558, 9.174312E-4, 9.174312E-4, 9.174312E-4, 0.006422018, 9.174312E-4, 9.174312E-4, 0.01559633, 0.0045871558, 9.174312E-4, 9.174312E-4, 9.174312E-4, 9.174312E-4, 9.174312E-4, 9.174312E-4, 9.174312E-4, 9.174312E-4, 9.174312E-4, 0.0045871558, 0.0027522936, 9.174312E-4, 9.174312E-4, 9.174312E-4, 0.008256881, 9.174312E-4, 9.174312E-4, 9.174312E-4};
		   double [] b= {-0.030674497, -0.011073479, 0.013195272, -0.008979691, -0.018962404, -4.6010353E-4, -0.01023822, 0.0055863494, -0.021479357, 0.015277272, -0.005175689, -0.009262696, 0.001079509, 0.009484648, -0.009385897, -0.0074566575, -0.0070116236, -0.004700184, 0.019368028, -0.029601578, 0.010360819, 0.008427132, -0.013920361, 0.0038358823, -0.0023933928, 0.0076601906, -0.008316389, -0.0042846883, 0.031794004, -0.028611124, 0.012185882, -0.008955549, 0.0061506005, 0.014083211, 0.026399782, -0.002923638, -0.018944537, -0.024545345, 0.013787161, -0.008255887, -0.018626995, -0.022118712, -0.010421702, 0.01778793, -0.0072210827, 0.045891885, -0.011681548, -0.008515639, 0.009157881, 0.002413401, -0.008068598, -0.012452371, -2.4432963E-4, -0.009504992, 0.0025331336, 0.009985197, -0.0032664924, -0.02361339, 0.018738953, 0.020981014, -0.0020234047, -0.011187124, -0.021931196, -0.014959147, 1.7952881E-4, 8.445718E-5, 0.003235696, -0.01856659, -0.018701859, 0.004054705, -0.007896016, -0.015988275, 0.002840466, -0.0050514503, 0.005715145, 0.0126319425, 0.013033336, 0.028027538, 0.014233181, -0.0057881856, -0.0046359836, -0.010727599, -0.023528766, 0.02989212, -0.0011509474, -0.03553014, 0.009179498, 0.021909118, -0.022845343, 0.015243346, 0.0026002794, 0.022423677, -0.03748025, -4.795924E-4, 0.00589798, 0.0045782076, 0.022541653, 0.014242987, -0.02126267, -0.015606074, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0121951215, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0121951215, 0.0040650405, 0.0121951215, 0.0040650405, 0.0040650405, 0.0040650405, 0.0121951215, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0121951215, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0121951215, 0.0040650405, 0.0040650405, 0.0040650405, 0.0121951215, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0121951215, 0.0040650405, 0.0040650405, 0.020325202, 0.0040650405, 0.0040650405, 0.101626016, 0.0121951215, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0121951215, 0.0040650405, 0.0040650405, 0.0040650405, 0.0121951215, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0121951215, 0.0040650405, 0.020325202, 0.0040650405, 0.3292683, 0.0040650405, 0.0121951215, 0.0121951215, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0040650405, 0.0121951215, 0.020325202};
		   float[] vec = new float[a.length];
		   float[] c = new float[200];
		   float[] d = new float[200];
		   
		   for(int i=0;i<a.length;i++){
			   c[i] = (float)a[i];
			   d[i] = (float)b[i];
		   }
    		   String vector = "";
    		   for(int j = 0;j<user.size();j++){
    		   for(int i = 0;i<user.get(j).text.size();i++){
	        	vec = Process.StringProcess(user.get(j).text.get(i));
	            float[] dot = Similarity.Sim(vec,c,d);
	        	float simlar=(float) (dot[0]/(dot[0]+dot[1]));
	        	if(simlar>0.48) user.get(j).pt++;
    		   }
    		   user.get(j).pt = user.get(j).pt/user.get(j).text.size();
    		   if(user.get(j).pt>0.49) {
    			   if(user.get(j).pd<2){
    				   user.get(j).property = "水军用户";
    			   }
    			   else user.get(j).property = "正常用户";
    		   }
    		   else user.get(j).property = "正常用户";
	        vector = vector+""+user.get(j).name+"用户属性："+user.get(j).property+"\n"+"p值："+user.get(j).pt+"\n"+"q值："+user.get(j).pd+"\n";
	        textarea.setText(vector);
    		   }
    	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub		
	}
}   
