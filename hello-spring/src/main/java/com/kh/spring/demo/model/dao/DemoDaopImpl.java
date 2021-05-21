package com.kh.spring.demo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.demo.model.vo.Dev;

// Repository가 DAO
@Repository
public class DemoDaopImpl implements DemoDao {

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertDev(Dev dev) {
		return session.insert("demo.insertDev",dev);
	}

	@Override
	public List<Dev> selectDevList() {
		// TODO Auto-generated method stub
		return session.selectList("demo.selectDevList");
	}

	@Override
	public Dev selectOneDev(int no) {
		// TODO Auto-generated method stub
		return session.selectOne("demo.selectOneDev",no);
	}

	@Override
	public int updateDev(Dev dev) {
		// TODO Auto-generated method stub
		return session.update("demo.updateDev",dev);
	}

	@Override
	public int deleteDev(int no) {
		// TODO Auto-generated method stub
		return session.delete("demo.deleteDev",no);
	}
	
}
