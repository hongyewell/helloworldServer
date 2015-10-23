package com.hongyewell.pojo;
/**
* @className:DataItem.java
* @classDescription:
* @author:yeye
* @createTime:2015年10月21日 下午8:44:56
*/
public class DataItem {
	private int myId;
	private String myTitle;
	private String myContent;
	
	public DataItem( String myTitle, String myContent) {
		this.myTitle = myTitle;
		this.myContent = myContent;
	}

	public int getMyId() {
		return myId;
	}

	public void setMyId(int myId) {
		this.myId = myId;
	}

	public String getMyTitle() {
		return myTitle;
	}

	public void setMyTitle(String myTitle) {
		this.myTitle = myTitle;
	}

	public String getMyContent() {
		return myContent;
	}

	public void setMyContent(String myContent) {
		this.myContent = myContent;
	}
}
