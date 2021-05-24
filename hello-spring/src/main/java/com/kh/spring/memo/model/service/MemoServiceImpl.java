package com.kh.spring.memo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.memo.model.dao.MemoDao;
import com.kh.spring.memo.model.vo.Memo;

import lombok.extern.slf4j.Slf4j;
/**
 *  의존주입 받은 객체는 우리가 작성한 
 *  MemoController, MemoServiceImpl, MemoDaoImpl타입 객체가 아닌
 *  proxy 객체이다. => 앞에서 대리인 역할을 한다.
 *  
 *  1. jdk동적 proxy - interface구현체 ex)Service, Dao
 *  2. cglib - interface구현체 아닌 경우 ex)Controller
 * @author rojoo
 *
 */
@Slf4j
@Service
public class MemoServiceImpl implements MemoService {

	@Autowired
	private MemoDao memoDao;
	
	@Override
	public int insertMemo(Memo memo) {
		return memoDao.insertMemo(memo);
	}

	@Override
	public List<Memo> selectMemoList() {
		// TODO Auto-generated method stub
		log.debug("memoDao={}",memoDao.getClass()); //memoDao=class com.sun.proxy.$Proxy39
		return memoDao.selectMemoList();
	}

	@Override
	public int deleteMemo(int no) {
		// TODO Auto-generated method stub
		return memoDao.deleteMemo(no);
	}

}
