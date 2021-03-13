package com.minnano.myapp;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.minnano.model.PointBean;
import com.minnano.service.PointService;

@RestController
public class RestMemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestMemberController.class);
	
	@Autowired
	private PointService pointService;
	
	@RequestMapping(value="/insert_point",method = RequestMethod.POST)
	public ResponseEntity<String> insert_point(@RequestBody PointBean pointbean) {
		
		System.out.println("====>insert_point called.....[" + pointbean.toString() +"]");
		
			String result = pointService.confirm_point(pointbean);
			System.out.println(result);
			if(result != null) {
				logger.info("if");
				pointService.update_point(pointbean);
			}else {
				logger.info("else");
				pointService.insert_point(pointbean);
			}
		
		ResponseEntity<String> entity = null;
		try {
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/show_point", method = RequestMethod.POST)
	public  ResponseEntity<String> show_point(@RequestBody PointBean pointbean, HttpServletRequest request, HttpSession session){
			HashMap<String, Object> show = new HashMap<>();
			show.put("pId", pointbean.getpId());
			show.put("pbNum", pointbean.getPbNum());
			String result = pointService.confirm_point(pointbean);
			int mystar=0;
			if(result!=null) {
				mystar = pointService.show_point(show);								
			}
			ResponseEntity<String> entity = null;
			try {
				entity = new ResponseEntity<String>("success",HttpStatus.OK);				
			}catch(Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
			session.setAttribute("star", mystar);
			return entity;
	}
	
	@RequestMapping(value="/avg_point", method = RequestMethod.POST)
	public  ResponseEntity<String> avg_point(@RequestBody PointBean pointbean, HttpServletRequest request, HttpSession session){
		String avgStar = pointService.avg_point(pointbean);
		logger.info("avgStar====="+avgStar);
		if(avgStar==null) {
			avgStar="0";
		}			
		ResponseEntity<String> entity = null;
		try {
			entity = new ResponseEntity<String>("success",HttpStatus.OK);				
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		session.setAttribute("avg", avgStar);
		return entity;
		
	}
}
