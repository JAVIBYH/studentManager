package com.yuan.dao;

import java.util.List;
import java.util.Map;

import com.yuan.bean.Student;

/**
 * 学生
 * @author hjw
 *
 */
public interface StudentDao {
	
	public Student findByUserName(String username);
	public int add(Student student);
	public int edit(Student student);
	public int delete(String ids);
	public List<Student> findList(Map<String,Object> queryMap);
	public List<Student> findAll();
	public int getTotal(Map<String,Object> queryMap);
	
	
}
