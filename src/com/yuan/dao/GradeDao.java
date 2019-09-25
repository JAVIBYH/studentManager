package com.yuan.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yuan.bean.Grade;

/**
 * 年级
 * @author hjw
 */
public interface GradeDao {
	
	public int add(Grade grade);
	public int edit(Grade grade);
	public int delete(String ids);
	public List<Grade> findList(Map<String,Object> queryMap);
	public List<Grade> findAll();
	public int getTotal(Map<String,Object> queryMap);
	
}
