package com.minnano.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minnano.model.BookBean;
import com.minnano.model.MemberBean;
import com.minnano.service.BoardService;
import com.minnano.service.BookService;
import com.minnano.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	@Autowired
	BookService bookService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/aaa", method = RequestMethod.GET)
	public String test(Model model){
		List<BookBean> booksbean =bookService.allnew_book();
		logger.info(booksbean.toString());
		model.addAttribute("bookSearchList", booksbean);
		return "NewFile";
	}
	
	@RequestMapping(value="/b", method = RequestMethod.GET)
	public String tee(){
		return "main/navi";
	}
}
