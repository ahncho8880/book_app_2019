package com.minnano.service;

import java.util.List;

import com.minnano.model.BookBean;

public interface BookService {
	public List<BookBean> booklist();
	public List<BookBean> newbookList();
	public List<BookBean> bestbookList();
	public List<BookBean> topbookList();
	public List<BookBean> selectBook(int num);
	public List<BookBean> bookSearch(BookBean bookbean);
	public List<BookBean> allnew_book();
	public List<BookBean> all_hitbook();
	public List<BookBean> allcatagory_book(int bGenre);
}
