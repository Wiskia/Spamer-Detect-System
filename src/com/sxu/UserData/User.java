/**
 * @author SXU.ZSC
 *
 */
package com.sxu.UserData;

import java.util.ArrayList;

public class User {
	/**
	 *用户类，
	 *用于封装用户评论和行为属性值
	 **/
	public String url = "";
    public String name = "";
    public String property = "";
    public  ArrayList<String> text = new ArrayList<String>();
    public double pd = 0;
    public double pt = 0;
    public String getUrl() {
	    return url;
    }
    public void setUrl(String url) {
	    this.url = url;
    }

    public String getName() {
	    return name;
    }
    public void setName(String name) {
	    this.name = name;
    }
    public ArrayList<String> getText() {
	    return text;
    }
    public void setText(ArrayList<String> text) {
	    this.text = text;
    }
    public double getPd() {
	    return pd;
    }
    public void setPd(double pd) {
    	this.pd = pd;
    }
    public double getPt() {
	    return pt;
    }
    public void setPt(double pt) {
    	this.pt = pt;
    }

}
