package com.minnano.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import com.minnano.model.PointBean;

public interface PointDao {
	public void insert(PointBean pointbean);
	public int show(HashMap<String, Object> show);
	public String avg(PointBean pointbean);
	public String confirm(PointBean pointbean);
	public void update(PointBean pointbean);
}
