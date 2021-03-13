package com.minnano.dao;

import java.util.List;

import com.minnano.model.BookBean;

public interface BookDao {
	public List<BookBean> bookinfo();
	public List<BookBean> select_book(int bNum);
	public List<BookBean> newbookinfo();
	public List<BookBean> bestbookinfo();
	public List<BookBean> topbookinfo();
	public List<BookBean> search_book(BookBean bookbean);
	public List<BookBean> allnew_book();
	public List<BookBean> allhit_book();
	public List<BookBean> allcatagory_book(int bGenre);
}
