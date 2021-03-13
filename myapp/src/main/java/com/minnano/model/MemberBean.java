package com.minnano.model;

public class MemberBean {
	private String mID;
	private String mPasswd;
	private String mName;
	
	public String getmID() {
		return mID;
	}
	public void setmID(String mID) {
		this.mID = mID;
	}
	public String getmPasswd() {
		return mPasswd;
	}
	public void setmPasswd(String mPasswd) {
		this.mPasswd = mPasswd;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	@Override
	public String toString() {
		return "MemberBean [mID=" + mID + ", mPasswd=" + mPasswd + ", mName=" + mName + "]";
	}
	
	
}
