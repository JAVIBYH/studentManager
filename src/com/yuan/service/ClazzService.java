package com.yuan.service;

import java.util.List;
import java.util.Map;

import com.yuan.bean.Clazz;

/**
 * 班级管理 
 * @author hjw
 *
 */
public interface ClazzService {
	
	public int add(Clazz clazz);
	public int edit(Clazz clazz);
	public int delete(String ids);
	public List<Clazz> findList(Map<String,Object> queryMap);
	public List<Clazz> findAll();
	public int getTotal(Map<String,Object> queryMap);
	
	
}
