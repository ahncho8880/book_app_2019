package com.minnano.myapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.minnano.model.BoardBean;
import com.minnano.model.BookBean;
import com.minnano.model.MemberBean;
import com.minnano.service.BoardService;
import com.minnano.service.BookService;
import com.minnano.service.BookServiceImpl;
import com.minnano.service.MemberService;
import com.minnano.service.PointService;

@Controller
public class MainController {

	Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private PointService pointService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String connectMain(Model model) {
		logger.info("abcd");
		List<BookBean> bookbean1 = bookService.newbookList();
		List<BookBean> bookbean2 = bookService.bestbookList();
		List<BookBean> bookbean3 = bookService.booklist();
	
		model.addAttribute("newbookinfo", bookbean1);
		model.addAttribute("hitbookinfo", bookbean2);
		model.addAttribute("topbookinfo", bookbean3);
		return "main/index";
	}
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(BookBean bookbean, Model model, HttpServletResponse response){
		System.out.println(bookbean.toString());
		List<BookBean> bookbean4 = bookService.bookSearch(bookbean);
		model.addAttribute("bookSearchList", bookbean4);
		return "search/searchResult";
	}
	@RequestMapping(value = "/dojoin", method = RequestMethod.GET)
	public String inNewAccountAction() {
		return "main/new_account";
	}

	@RequestMapping(value = "/dologin", method = RequestMethod.GET)
	public String inLoginAction() {
		return "main/login";
	}
	@RequestMapping(value="/bookinfoAction", method=RequestMethod.GET)
	public String bookpageAction(HttpSession session, @RequestParam("num") int booknum ,@RequestParam("pagenum") int pagenum,@RequestParam("contentnum") int contentnum, Model model){
		logger.info("bookpageAction");
		Pagination pagination = new Pagination();
		/*String pagenum = request.getParameter("pagenum");
		String contentnum = request.getParameter("contentnum");
		logger.info("bookpageAction2");
		
		int cpagenum = getIntParam(request, "pagenum");
		int ccontentnum = getIntParam(request, "contentnum");*/
		logger.info("bookpageAction3");
		System.out.println("pagenum:"+pagenum);
		System.out.println("contentnum:"+contentnum);
		System.out.println("num"+booknum);
		
		//int cpagenum = Integer.parseInt(pagenum);
		//int ccontentnum = Integer.parseInt(contentnum);

		//cpagenum =(cpagenum == 0? 1: cpagenum);		
		//ccontentnum = (ccontentnum == 0? 10: ccontentnum);
		
		pagination.setTotalcount(boardService.Calltestcount(booknum));	//전체 게시글 개수를 지칭한다.
		pagination.setPagenum(pagenum-1);				//현재 페이지를 페이지 객체에 지칭한다.
		pagination.setContentnum(contentnum);		//한 페이지에 몇개씩 게시글을 보여줄지 지칭한다.
		pagination.setCurrentblock(pagenum);		//현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지칭한다.
		pagination.setLastblock(pagination.getTotalcount());	//마지막 블록 번호를 전체 게시글 수를 통해서 지칭한다.
		
		pagination.prevnext(pagenum);	//현재 페이지 번호로 화살표를 나타낼지 정한다.
		pagination.setStartPage(pagination.getCurrentblock());	//시작 페이지를 페이지 블록 번호로 정한다.
		pagination.setEndPage(pagination.getLastblock(), pagination.getCurrentblock());
		//마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록 번호로 정한다.
		
		List<BoardBean> testlist = boardService.list(booknum, pagination.getPagenum()*10, pagination.getContentnum());
		 
		model.addAttribute("list", testlist);
		model.addAttribute("page", pagination);
		
		List<BookBean> bookbean = bookService.selectBook(booknum);
		System.out.println(bookbean.toString());
		model.addAttribute("bookinfo", bookbean);
		
	/*	String id=(String)session.getAttribute("LOGIN");
		logger.info("id==>"+id+", booknum===>"+booknum);
		if(id!=null) {
			logger.info("===========inelse");
			HashMap<String, Object> show = new HashMap<>();
			show.put("pId", id);
			show.put("pbNum", booknum);
			int mystar = pointService.show_point(show);
			
			model.addAttribute("star",mystar);
			System.out.println("별 갯수========"+mystar);
		}*/
		return "book/book_info";			
	}
	

	
	private int getIntParam(HttpServletRequest request, String key) {
		int ret = 0;
		
		try {
			ret = Integer.parseInt(request.getParameter(key));
		} catch (Exception ex) {
			ret = 0;
		}
		
		return ret;
	}
	
	@RequestMapping(value="/allnewbookNavi", method=RequestMethod.GET)
	public String allnew_book(Model model, HttpServletRequest request){
		List<BookBean> booksbean =bookService.allnew_book();
		logger.info(booksbean.toString());
		request.setAttribute("kind", "NEW BOOKS");
		model.addAttribute("bookSearchList", booksbean);
		
		return "search/searchResult";
	}
	@RequestMapping(value="/allhitbookNavi", method=RequestMethod.GET)
	public String allhit_book(Model model, HttpServletRequest request){
		List<BookBean> booksbean =bookService.all_hitbook();
		logger.info(booksbean.toString());
		request.setAttribute("kind", "HIT BOOKS");
		model.addAttribute("bookSearchList", booksbean);
		return "search/searchResult";
	}
	@RequestMapping(value="/allcatagorybookNavi", method=RequestMethod.GET)
	public String allcatagory_book(@RequestParam("bGenre") int bGenre, Model model, HttpServletRequest request){
		List<BookBean> booksbean = bookService.allcatagory_book(bGenre);
		logger.info(booksbean.toString());
		logger.info("bGenre"+bGenre);
		model.addAttribute("bookSearchList", booksbean);
		return "search/searchResult";
	}
	
	
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String NewAccountPost(MemberBean bean) {
		
		System.out.println("qqqq" + bean.toString());
		
		memberService.joinMember(bean);
		
		return "redirect:/main";
	}
}
