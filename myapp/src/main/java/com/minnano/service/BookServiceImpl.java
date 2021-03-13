package com.minnano.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minnano.dao.BookDao;
import com.minnano.model.BookBean;
import com.minnano.myapp.MainController;

@Service
public class BookServiceImpl implements BookService {

	Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	@Autowired
	private BookDao bookdao;
	
	@Override
	public List<BookBean> booklist() {
		return bookdao.bookinfo();
	}

	@Override
	public List<BookBean> newbookList() {
		// TODO Auto-generated method stub
		logger.info("adbc2");
		return bookdao.newbookinfo();
	}

	@Override
	public List<BookBean> bestbookList() {
		// TODO Auto-generated method stub
		return bookdao.bestbookinfo();
	}

	@Override
	public List<BookBean> topbookList() {
		// TODO Auto-generated method stub
		return bookdao.topbookinfo();
	}

	@Override
	public List<BookBean> selectBook(int num) {
		// TODO Auto-generated method stub
		return bookdao.select_book(num);
	}

	@Override
	public List<BookBean> bookSearch(BookBean bookbean) {
		// TODO Auto-generated method stub
		return bookdao.search_book(bookbean);
	}

	@Override
	public List<BookBean> allnew_book() {
		// TODO Auto-generated method stub
		return bookdao.allnew_book();
	}

	@Override
	public List<BookBean> all_hitbook() {
		// TODO Auto-generated method stub
		return bookdao.allhit_book();
	}

	@Override
	public List<BookBean> allcatagory_book(int genre) {
		// TODO Auto-generated method stub
		return bookdao.allcatagory_book(genre);
	}

}
