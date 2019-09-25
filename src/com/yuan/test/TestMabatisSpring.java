package com.yuan.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuan.bean.User;
import com.yuan.dao.TestMabatisSpringMapper;
import com.yuan.service.TestMabatisSpringService;

public class TestMabatisSpring {
	
	@Test
	public void test() throws Exception{
		//1.加载spring配置
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.获取对象
		//TestMabatisSpringMapper testMabatisSpringMapper = (TestMabatisSpringMapper)ac.getBean("testMabatisSpringMapper");
		TestMabatisSpringService testMabatisSpringService = (TestMabatisSpringService)ac.getBean("testMabatisSpringService");
		//3.调用方法
		/*User user1 = new User();
		user1.setUsername("测试一号");
		user1.setPassword("123");
		testMabatisSpringMapper.insertUser(user1);*/
		/*User user2 = new User();
		user2.setUsername("测试二号");
		user2.setPassword("456");
		testMabatisSpringMapper.insertUser(user2);*/
		User user3 = new User();
		user3.setUsername("测试三号");
		user3.setPassword("789");
		testMabatisSpringService.saveUser(user3);
		
		
		
		
		
	}
	

}
