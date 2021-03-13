package com.minnano.model;

public class PointBean {
	private String pId;
	private int pbNum;
	private int pScore;
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public int getPbNum() {
		return pbNum;
	}
	public void setPbNum(int pbNum) {
		this.pbNum = pbNum;
	}
	public int getpScore() {
		return pScore;
	}
	public void setpScore(int pScore) {
		this.pScore = pScore;
	}
	@Override
	public String toString() {
		return "PointBean [pId=" + pId + ", pbNum=" + pbNum + ", pScore=" + pScore + "]";
	}
	
	
}
