package com.kh.spring.menu.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.menu.model.vo.Menu;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<Menu> selectMenuList() {
		// TODO Auto-generated method stub
		return session.selectList("menu.selectMenuList");
	}

	@Override
	public List<Menu> selectMenuListByType(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return session.selectList("menu.selectMenuListByType",param);
	}

	@Override
	public int insertMenu(Menu menu) {
		// TODO Auto-generated method stub
		return session.insert("menu.insertMenu",menu);
	}

	@Override
	public Menu selectMenu(int id) {
		// TODO Auto-generated method stub
		return session.selectOne("menu.selectMenu",id);
	}

	@Override
	public int updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		log.debug("MenuDaoImpl");
		log.debug("menu={}",menu);
		
		return  session.update("menu.updateMenu",menu);

	}

	@Override
	public int deleteMenu(String id) {
		// TODO Auto-generated method stub
		return session.update("menu.deleteMenu",id);
	}
}
