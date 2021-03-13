package com.minnano.myapp;

import javax.servlet.http.HttpSession;

public class Common {
	
	protected String getSession(HttpSession session, String key) {
		String ret = "";
		
		if (session == null || key == null) { 
			return ret;
		}
		
		ret = (String) session.getAttribute(key);
		if (ret == null) {
			ret = "";
		}
		
		return ret;
	}

}
