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
	private String myAuthor;
	private String myTime;
	
	public DataItem(){
		
	}
	
	public DataItem(int myId, String myTitle, String myContent, String myAuthor, String myTime) {
		super();
		this.myId = myId;
		this.myTitle = myTitle;
		this.myContent = myContent;
		this.myAuthor = myAuthor;
		this.myTime = myTime;
	}

	public DataItem(String myTitle, String myContent, String myAuthor, String myTime) {
		this.myTitle = myTitle;
		this.myContent = myContent;
		this.myAuthor = myAuthor;
		this.myTime = myTime;
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

	public String getMyAuthor() {
		return myAuthor;
	}

	public void setMyAuthor(String myAuthor) {
		this.myAuthor = myAuthor;
	}

	public String getMyTime() {
		return myTime;
	}

	public void setMyTime(String myTime) {
		this.myTime = myTime;
	}
	
	
	
	
}
