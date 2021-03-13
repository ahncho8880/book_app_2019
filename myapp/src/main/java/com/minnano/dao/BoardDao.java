package com.minnano.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.minnano.model.BoardBean;

public interface BoardDao {
	// public List<BoardBean> listAll();

	public BoardBean listOne(int num);

	public List<BoardBean> testlist(@Param("bookNum") int bookNum, @Param("pageNum") int pageNum,
			@Param("contentNum") int contentNum);

	public int testcount(int booknum);

	public int modify(BoardBean bean);

	public int write(BoardBean bean);

	public int write_IdNumCount();

	public int drop(int eNum);

}
