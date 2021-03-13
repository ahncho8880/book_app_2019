package com.minnano.service;

import java.util.List;
import com.minnano.model.BoardBean;

public interface BoardService {
	
	public List<BoardBean> list(int booknum,int pagenum, int contentnum);
	
	
	   public int Calltestcount(int booknum);
	   
	   public BoardBean listOne(int num);
	   public int modify(BoardBean bean);   //수정하기
	   public int write(BoardBean bean);
	   public int write_IdNumCount();
	   public int drop_BBS(int eNum);
	
}
