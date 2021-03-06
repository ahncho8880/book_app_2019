package com.minnano.myapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.minnano.dao.BoardDao;
import com.minnano.model.BoardBean;
import com.minnano.model.PointBean;
import com.minnano.service.BoardService;

@Controller
public class BookController {
	
	Logger logger = LoggerFactory.getLogger("BookController");
	
	@Autowired
	private BoardService boardService;

	//占쏙옙 占쏙옙 占쏙옙占쏙옙
	/*@RequestMapping(value="/read",method = RequestMethod.GET)
	public String readBook(HttpSession session, HttpServletResponse response, @RequestParam("num") int num, @RequestParam("booknum") String booknum, @RequestParam("logon") boolean logon, Model model){
		System.out.println("aaaaaaaaaaaa");
		System.out.println("read num=" + num);
		logger.info("logon=> "+logon);
		if(logon){
			BoardBean bean = boardService.listOne(num);
			model.addAttribute("detailBean",bean);
			System.out.println(bean.toString());
			return "book/bookReadPage";			
		}
		try {
			session.setAttribute("booknum", booknum);
			session.setAttribute("go", "goread");
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('you need login');  location.href='dologin'; </script>");
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main/login";
	}
*/
	//占쏘떤 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 占쏙옙
	//http://localhost:8088/book/home
	/*@RequestMapping("home")
	public String Info(){
		
		return "forward:book/list";
	}*/
	//占쏙옙占쏙옙占싶몌옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 forward
	
/*	@RequestMapping("list")
	public String list(HttpServletRequest request){
	
		Pagination pagination = new Pagination();
		String pagenum = request.getParameter("pagenum");
		String contentnum = request.getParameter("contentnum");
		int cpagenum = getIntParam(request, "pagenum");
		int ccontentnum = getIntParam(request, "contentnum");
		
		//int cpagenum = Integer.parseInt(pagenum);
		//int ccontentnum = Integer.parseInt(contentnum);
		cpagenum =(cpagenum == 0? 1: cpagenum);		
		ccontentnum = (ccontentnum == 0? 10: ccontentnum);
		
		pagination.setTotalcount(boardService.Calltestcount());	//占쏙옙체 占쌉시깍옙 占쏙옙占쏙옙占쏙옙 占쏙옙칭占싼댐옙.
		pagination.setPagenum(cpagenum-1);				//占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙체占쏙옙 占쏙옙칭占싼댐옙.
		pagination.setContentnum(ccontentnum);		//占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏘개占쏙옙 占쌉시깍옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙칭占싼댐옙.
		pagination.setCurrentblock(cpagenum);		//占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙占� 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙호占쏙옙 占쏙옙占쌔쇽옙 占쏙옙칭占싼댐옙.
		pagination.setLastblock(pagination.getTotalcount());	//占쏙옙占쏙옙占쏙옙 占쏙옙占� 占쏙옙호占쏙옙 占쏙옙체 占쌉시깍옙 占쏙옙占쏙옙 占쏙옙占쌔쇽옙 占쏙옙칭占싼댐옙.
		
		pagination.prevnext(cpagenum);	//占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙호占쏙옙 화占쏙옙표占쏙옙 占쏙옙타占쏙옙占쏙옙 占쏙옙占싼댐옙.
		pagination.setStartPage(pagination.getCurrentblock());	//占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占� 占쏙옙호占쏙옙 占쏙옙占싼댐옙.
		pagination.setEndPage(pagination.getLastblock(), pagination.getCurrentblock());
		//占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙構占� 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占� 占쏙옙호占쏙옙 占쏙옙占싼댐옙.

		 List<BoardBean> testlist = boardService.list(pagination.getPagenum()*10, pagination.getContentnum());

		request.setAttribute("list", testlist);
		request.setAttribute("page", pagination);
		return "book/book_info";
	}*/
	
	//책 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占썩본占쏙옙占쏙옙占쏙옙 占쏙옙타占쏙옙 占쌉시깍옙 占썩본 占쏙옙占쏙옙
	/*private int getIntParam(HttpServletRequest request, String key) {
		int ret = 0;
		
		try {
			ret = Integer.parseInt(request.getParameter(key));
		} catch (Exception ex) {
			ret = 0;
		}
		
		return ret;
	}*/
	
	//책 占쏙옙占쏙옙 占쏙옙占쏙옙
/*	@RequestMapping(value="/bookinfo", method=RequestMethod.GET)
	public String bookinfo(Model model){
		
		List<BoardBean> boards = boardService.list();
		
		System.out.println("board"+boards.toString());
		model.addAttribute("boardList",boards);
		return "book/book_info";
	}*/
	

/*	@RequestMapping(value="/bookinfo", method=RequestMethod.GET)
	public String boardList(HttpServletRequest request, BoardBean boardbean,
							 Model model) throws Exception{
		
		//HttpServletRequest request,
		//List<BoardBean> boards = boardService.list();
		//@ModelAttribute("boardbean")
		List<BoardBean> boards = boardService.getArticle(boardbean);
		model.addAttribute("boardList",boards);
		
		return "book/book_info";
	}*/
	
}
