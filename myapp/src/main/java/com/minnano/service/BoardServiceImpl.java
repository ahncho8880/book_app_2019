package com.minnano.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minnano.dao.BoardDao;
import com.minnano.model.BoardBean;

@Service
public class BoardServiceImpl implements BoardService{

   @Autowired
   private BoardDao boardDao;
   //private BoardBean boardBean;
   
   //�Խ���
   @Override
   public List<BoardBean> list(int booknum, int pagenum, int contentnum) {
      return boardDao.testlist(booknum, pagenum, contentnum);
   }

   //�Խ��� �� ���� ��������
   @Override
   public int Calltestcount(int booknum){
      return boardDao.testcount(booknum);
   }
   
   //�̿��ڰ� �� �� �󼼺���
   @Override
   public BoardBean listOne(int num){
      return boardDao.listOne(num);
   }
   
   @Override
   public int modify(BoardBean bean){
      return boardDao.modify(bean);
   }

   @Override
   public int write(BoardBean bean){
      return boardDao.write(bean);
   }
   @Override
   public int write_IdNumCount(){
      return boardDao.write_IdNumCount();
   }
   
   @Override
   public int drop_BBS(int eNum){
      return boardDao.drop(eNum);
   }
}