package com.cike.first;

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

/**
 * 入门程序
 * 
 * @author CIKE
 *
 */
public class MybatisFirst {
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

	// 测试根据id得到用户（得到单条记录）
	@Test
	public void testFindUserById() {
		// 通过SqlSessionFactory创建SqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		// 通过SqlSession操作数据库
		// 第一个参数：statement的位置，等于namespace+statement的id
		// 第二个参数：传入的参数
		User user = null;
		try {
			user = sqlSession.selectOne("test.findUserById", 1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭sqlSession
			sqlSession.close();
		}
		System.out.println(user);

	}

	// 测试根据username得到用户
	@Test
	public void testFindUserByName() {
		// 通过SqlSessionFactory创建SqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		// 通过SqlSession操作数据库
		// 第一个参数：statement的位置，等于namespace+statement的id
		// 第二个参数：传入的参数
		List<User> users = null;
		try {
			users = sqlSession.selectList("test.findUserByName", "%小明%");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭sqlSession
			sqlSession.close();
		}
		for (User user : users) {
			System.out.println(user);
		}

	}

	// 测试根据添加用户
	@Test
	public void testInsertUser() {
		// 通过SqlSessionFactory创建SqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		// 创建插入数据
		User user = new User();
		user.setAddress("广州");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setUsername("女侠");
		try {
			sqlSession.insert("test.insertUser", user);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭sqlSession
			sqlSession.close();
		}
		System.out.println("id=" + user.getId());
	}

	// 测试删除用户
	@Test
	public void testDeleteUser() {
		// 通过SqlSessionFactory创建SqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			sqlSession.insert("test.deleteUser", 28);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭sqlSession
			sqlSession.close();
		}
	}

	// 测试更新用户
	@Test
	public void testUpdateUser() {
		// 通过SqlSessionFactory创建SqlSession
		SqlSession sqlSession = sessionFactory.openSession();
		// 创建修改数据
		User user = new User();
		user.setAddress("广州");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setUsername("女侠27");
		user.setId(27);
		try {
			sqlSession.insert("test.updateUser", user);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭sqlSession
			sqlSession.close();
		}
	}
}
