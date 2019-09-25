package com.yuan.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuan.bean.Clazz;
import com.yuan.dao.ClazzDao;
import com.yuan.service.ClazzService;

/**
 * 班级管理
 * @author hjw
 *
 */
@Service
public class ClazzServiceImpl implements ClazzService {

	@Autowired
	private ClazzDao clazzDao;
	
	@Override
	public int add(Clazz clazz) {
		return clazzDao.add(clazz);
	}

	@Override
	public int edit(Clazz clazz) {
		return clazzDao.edit(clazz);
	}

	@Override
	public int delete(String ids) {
		return clazzDao.delete(ids);
	}

	@Override
	public List<Clazz> findList(Map<String, Object> queryMap) {
		return clazzDao.findList(queryMap);
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		return clazzDao.getTotal(queryMap);
	}

	@Override
	public List<Clazz> findAll() {
		return clazzDao.findAll();
	}

}
