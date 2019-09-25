package com.yuan.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuan.bean.User;
import com.yuan.dao.UserDao;
import com.yuan.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User findUserByName(String username) {
		return userDao.findUserByName(username);
	}

	@Override
	public int add(User user) {
		return userDao.add(user);
	}

	@Override
	public List<User> findList(Map<String,Object> queryMap) {
		return userDao.findList(queryMap);
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		return userDao.getTotal(queryMap);
	}

	@Override
	public int edit(User user) {
		return userDao.edit(user);
	}

	@Override
	public int delete(String ids) {
		return userDao.delete(ids);
	}

}
