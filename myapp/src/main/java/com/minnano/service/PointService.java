package com.minnano.service;

import java.util.HashMap;

import com.minnano.model.PointBean;

public interface PointService {
	public void insert_point(PointBean pointbean);
	public int show_point(HashMap<String, Object> show);
	public String avg_point(PointBean pointbean);
	public String confirm_point(PointBean pointbean);
	public void update_point(PointBean pointbean);
}
