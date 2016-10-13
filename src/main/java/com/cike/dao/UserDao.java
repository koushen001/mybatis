package com.cike.dao;

import java.util.List;

import com.cike.po.User;

public interface UserDao {
	// 根据id查询用户信息
	public User findUserById(int id) throws Exception;

	// 根据username模糊查询
	public List<User> findUserByName(String username) throws Exception;
	
	//增加用户
	public void insertUser(User user) throws Exception;
}
