package com.kh.spring.menu.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.menu.model.dao.MenuDao;
import com.kh.spring.menu.model.vo.Menu;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> selectMenuList() {
		// TODO Auto-generated method stub
		return menuDao.selectMenuList();
	}

	@Override
	public List<Menu> selectMenuListByType(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return menuDao.selectMenuListByType(param);
	}

	@Override
	public int insertMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.insertMenu(menu);
	}

	@Override
	public Menu selectMenu(int id) {
		// TODO Auto-generated method stub
		return menuDao.selectMenu(id);
	}

	@Override
	public int updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		return  menuDao.updateMenu(menu);
	}
}
