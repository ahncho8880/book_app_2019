package com.minnano.myapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.minnano.model.BoardBean;
import com.minnano.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
   
/*forward
redirect 브라우저 재요청, 파라미터 정보 저장 안됨.*/
   @Autowired
   BoardService boardService;
   
   Logger logger = LoggerFactory.getLogger(BoardController.class);
     
      //게시판 글쓰기 클릭 시
      @RequestMapping(value="/write_report",method = RequestMethod.GET)
      public String inwrite(HttpServletResponse response,@RequestParam("booknum") int booknum,@RequestParam("eid") String eid, @RequestParam("logon") boolean logon, Model model){
         if(logon){
            logger.info("write_report >> true");
            int BBSCount = boardService.write_IdNumCount();   //전체 게시판 개수
            System.out.println("BBSCount>>>>>>>"+BBSCount);            
            System.out.println("booknum>>>>>>>"+booknum);
        
            model.addAttribute("eId", eid);
            model.addAttribute("ebNum", booknum);
            model.addAttribute("eNum",BBSCount+1);
            
            return "book/report";
         }
         
         response.setContentType("text/html; charset=UTF-8"); 
         try {   
            PrintWriter out = response.getWriter();
            out.println("<script>alert('you need login'); location.href='dologin'; </script>");
            out.flush();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         return "forward:dologin";
      }
         
       //글쓰기
      @RequestMapping(value = "/write_post", method = RequestMethod.POST)
      public String writePost(BoardBean bean, Model model, RedirectAttributes attr){
         System.out.println("write_post 호출 >>>>>>>>>"+bean.toString());
         
         int count = boardService.write(bean);
         System.out.println("write count>>>"+count);
         
         attr.addAttribute("num", bean.getEbNum());
         attr.addAttribute("pagenum", 1);
         attr.addAttribute("contentnum", 10);
         
         return "redirect:bookinfoAction";   
      }
      @RequestMapping(value="/drop_post",method = RequestMethod.POST)
      public String dropPost(@RequestParam("num") int eNum, @RequestParam("ebNum") int ebNum,RedirectAttributes attr){
         
         int ret = boardService.drop_BBS(eNum);
         System.out.println("deleted BBS number>>>"+ret);
         
         attr.addAttribute("num", ebNum);
         attr.addAttribute("pagenum", 1);
         attr.addAttribute("contentnum", 10);         
         return "redirect:bookinfoAction";
      }
      //글 수정하기
      @RequestMapping(value="/modify", method=RequestMethod.GET)
      public String update(@RequestParam("num") int num,Model model){
         System.out.println("modify 호출get.>>>>>>>>>");
         BoardBean bean = boardService.listOne(num);
         model.addAttribute("detailBean",bean);
         //model.addAttribute("이름",넘길 값);
         //detailBean이름으로 bean값을 넣는다
         
         return "book/bbs_modify";
      }
      
      //글 수정하기
      @RequestMapping(value="/modify_post", method=RequestMethod.POST)
      public String modifyPost(BoardBean bean, RedirectAttributes rttr){
         System.out.println("modify 호출 post.>>>>>>>>>");

         int ret = boardService.modify(bean);
         if(ret == 1){
            rttr.addFlashAttribute("msg","success");
         }
         rttr.addAttribute("num", bean.getEbNum());
         rttr.addAttribute("pagenum", 1);
         rttr.addAttribute("contentnum", 10);
         return "redirect:bookinfoAction";         
      }
      
      //사용자가 쓴 글 보기
      @RequestMapping(value="/read",method = RequestMethod.GET)
      public String readBook(@RequestParam("booknum") String booknum, HttpSession session,HttpServletResponse response, @RequestParam("num") int num, @RequestParam("logon") boolean logon, Model model){

         System.out.println("read num=" + num);
         logger.info("logon=> "+logon);
         
         if(logon){
            BoardBean bean = boardService.listOne(num);
            model.addAttribute("detailBean",bean);
            
            if (bean.geteContent() != null) {          
               bean.seteContent(bean.geteContent().replaceAll("\r\n", "<br>"));
            }
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
}