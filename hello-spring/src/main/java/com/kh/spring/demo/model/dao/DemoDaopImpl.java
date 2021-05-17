package com.kh.spring.demo.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// Repository가 DAO
@Repository
public class DemoDaopImpl implements DemoDao {

	@Autowired
	private DemoDao demoDao;
	
}
