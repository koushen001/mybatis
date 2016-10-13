package com.cike.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.cike.po.User;
import com.cike.po.UserCustom;
import com.cike.po.UserQueryVo;

public class UserMapperTest {
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
		SqlSession sqlSession = sessionFactory.openSession();
		// 创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}

	@Test
	public void testFindUserByName() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		// 创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = userMapper.findUserByName("%小明%");
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void testInsertUser() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		// 创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setAddress("广州");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setUsername("周星驰");
		userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testFindUserList() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		// 创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 构造查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setUsername("小明");
		userQueryVo.setUserCustom(userCustom);
		List<User> users = userMapper.findUserList(userQueryVo);
		sqlSession.close();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void testFindUserCount() throws Exception {
		SqlSession sqlSession = sessionFactory.openSession();
		// 创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 构造查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setUsername("小明");
		userQueryVo.setUserCustom(userCustom);
		int count = userMapper.findUserCount(userQueryVo);
		sqlSession.close();
		System.out.println(count);
	}
}
