package com.kh.spring.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.demo.model.dao.DemoDao;
import com.kh.spring.demo.model.vo.Dev;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoDao demoDao;
	
	/**
	 * Spring AOP기술을 이용해서 Session객체 관리, 트랜젝션척리
	 */
	@Override
	public int insertDev(Dev dev) {
		//1. SqlSession객체 생성
		//2. dao업무요청
		//3. transaction처리
		//4. SqlSession반납
		return demoDao.insertDev(dev);
	}

	@Override
	public List<Dev> selectDevList() {
		// TODO Auto-generated method stub
		return demoDao.selectDevList();
	}

	@Override
	public Dev selectOneDev(int no) {
		// TODO Auto-generated method stub
		return demoDao.selectOneDev(no);
	}

	@Override
	public int updateDev(Dev dev) {
		// TODO Auto-generated method stub
		return demoDao.updateDev(dev);
	}

	@Override
	public int deleteDev(int no) {
		// TODO Auto-generated method stub
		return demoDao.deleteDev(no);
	}
	
	

}
