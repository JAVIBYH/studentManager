package com.yuan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuan.bean.User;
import com.yuan.dao.TestMabatisSpringMapper;
import com.yuan.service.TestMabatisSpringService;

@Service("testMabatisSpringService")
@Transactional
public class TestMabatisSpringServiceImpl implements TestMabatisSpringService{

	//注入Mapper对象
	@Resource
	private TestMabatisSpringMapper testMapper;
	
	@Override
	public void saveUser(User user) {
		testMapper.insertUser(user);
		//模拟异常，测试事务
		//int i = 10/0;
		testMapper.insertUser(user);
		
	}

}
