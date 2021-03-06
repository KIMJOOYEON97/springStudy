package com.kh.spring.menu.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.spring.menu.model.vo.Menu;

public interface MenuDao {

	List<Menu> selectMenuList();

	List<Menu> selectMenuListByType(Map<String, Object> param);

	int insertMenu(Menu menu);

	Menu selectMenu(int id);

	int updateMenu(Menu menu);

	int deleteMenu(String id);

}
