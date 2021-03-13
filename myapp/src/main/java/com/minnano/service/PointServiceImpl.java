package com.minnano.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minnano.dao.PointDao;
import com.minnano.model.PointBean;

@Service
public class PointServiceImpl implements PointService {
	@Autowired
	PointDao pointDao;
	
	@Override
	public void insert_point(PointBean pointbean) {
		// TODO Auto-generated method stub
		pointDao.insert(pointbean);
	}


	@Override
	public int show_point(HashMap<String, Object> show) {
		// TODO Auto-generated method stub
		return pointDao.show(show);
	}


	@Override
	public String avg_point(PointBean pointbean) {
		// TODO Auto-generated method stub
		return pointDao.avg(pointbean);
	}


	@Override
	public String confirm_point(PointBean pointbean) {
		// TODO Auto-generated method stub
		return pointDao.confirm(pointbean);
	}


	@Override
	public void update_point(PointBean pointbean) {
		// TODO Auto-generated method stub
		pointDao.update(pointbean);
	}
}
