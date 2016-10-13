package com.cike.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cike.po.User;

public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		// 创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 根据id查询用户
		User user = sqlSession.selectOne("test.findUserById", id);
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> findUserByName(String username) {
		// 创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> users = sqlSession.selectList("test.findUserByName", username);
		sqlSession.close();
		return users;
	}

	@Override
	public void insertUser(User user) throws Exception {
		// 创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

}
