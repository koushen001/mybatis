package com.cike.mapper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.cike.po.User;

public class CacheTest {
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
	public void testCache1() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 第一次查询id为1的用户
		User user = userMapper.findUserById(1);
		System.out.println(user);
		//中间修改用户要清空缓存，目的防止查询出脏数据
		user.setUsername("测试2");
		userMapper.updateUser(user);
		sqlSession.commit();
		// 第二次查询用户id为1的用户
		User user2 = userMapper.findUserById(1);
		System.out.println(user2);
		sqlSession.close();
	}
	@Test
	public void testCache2() throws Exception {
		SqlSession sqlSession1 = sessionFactory.openSession();
		SqlSession sqlSession2 = sessionFactory.openSession();
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		// 第一次查询id为1的用户
		User user = userMapper1.findUserById(1);
		System.out.println(user);
		sqlSession1.close();
		// 第二次查询用户id为1的用户
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);
		sqlSession2.close();
	}
}
