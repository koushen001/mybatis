package com.cike.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.cike.po.User;

public class UserDaoImplTest {
	private SqlSessionFactory sessionFactory;

	// 创建工厂
	@Before
	public void init() throws IOException {
		// 配置文件
		String resource = "SqlMapConfig.xml";
		// 加载配置文件到输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		UserDao userDao = new UserDaoImpl(sessionFactory);
		User user = userDao.findUserById(1);
		System.out.println(user);
	}
	@Test
	public void testFindUserByName() throws Exception {
		UserDao userDao = new UserDaoImpl(sessionFactory);
		List<User> users = userDao.findUserByName("%小明%");
		for (User user : users) {
			System.out.println(user);
		}
	}

}
