package com.yuan.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yuan.bean.User;

//@Repository
public interface UserDao {
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public User findUserByName(String username);
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int add(User user);
	
	/**
	 * @param queryMap
	 * @return
	 */
	public List<User> findList(Map<String,Object> queryMap);
	
	/**
	 * 
	 * @param queryMap
	 * @return
	 */
	public int getTotal(Map<String, Object> queryMap);
	
	/**
	 * 修改信息
	 * @param user
	 * @return
	 */
	public int edit(User user);
	
	/**
	 * 根据id删除数据
	 * @param ids
	 * @return
	 */
	public int delete(String ids);

}
