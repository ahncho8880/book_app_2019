package com.minnano.myapp;

public class Pagination {

	private int totalcount;		//전체 게시물 개수
	private int pagenum;		//현재 페이지 번호
	private int contentnum=10;	//한 페이지에 몇개 표시할지
	private int startPage=1;	//현재 페이지 블록의 시작 페이지
	private int endPage=5;		//현재 페이지 블록의 마지막 페이지
	private boolean prev=false;	//이전 페이지로 가는 화살표
	private boolean next;		//다음 페이지로 가는 화살표
	private int currentblock;	//현재 페이지 블록
	private int lastblock;		//마지막 페이지 블록
	
	public void prevnext(int pagenum){
		if(pagenum>0 && pagenum < 6){
			setPrev(false);
			setNext(true);
		}
		else if(getLastblock() == getCurrentblock()){
			setPrev(true);
			setNext(false);
		}
		else {
			setPrev(true);
			setNext(true);
		}
	}
	//게시판에 몇 페이지까지 표시할지 계산하는 함수
	//전체 개수를 한 페이지에서 표시하는 페이지수로 나누어서 0보다 크면 totalpage를 증가시킴.
	public int calcpage(int totalcount, int contentnum){
		int totalpage = totalcount / contentnum;
		if(totalcount%contentnum > 0){
			totalpage++;
		}
		
		return totalpage;
	}
	
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getContentnum() {
		return contentnum;
	}
	public void setContentnum(int contentnum) {
		this.contentnum = contentnum;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int currentblock) {
		this.startPage = (currentblock*5)-4;
		//페이지 블록의 첫 번째 시작 페이지를 구하는 함수
		// 1  2  3  4  5
		// 6  7  8  9  10
		// 11 12 13
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int getlastblock, int getcurrentblock) {
		if(getlastblock == getcurrentblock){
			this.endPage = calcpage(getTotalcount(),getContentnum());
		}else {
			this.endPage = getStartPage()+4;
		}
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getCurrentblock() {
		return currentblock;
	}
	public void setCurrentblock(int pagenum) {
		//페이지 번호를 통해서 구한다.
		//페이지번호/페이지 그룹 안의 페이지 개수
		//	1p 1/5 => 0.2 0
		this.currentblock = pagenum/5;
		if(pagenum%5>0){
			this.currentblock++;
		}
	}
	public int getLastblock() {
		return lastblock;
	}
	public void setLastblock(int totalcount) { 
		this.lastblock = totalcount / (5*this.contentnum);
		if(totalcount%(5*this.contentnum)>0){
			this.lastblock++;
		}
	}
	
	
}
