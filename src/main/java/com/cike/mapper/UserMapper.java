package com.cike.mapper;

import java.util.List;

import com.cike.po.User;
import com.cike.po.UserQueryVo;

public interface UserMapper {
	// 根据id查询用户信息
	public User findUserById(int id) throws Exception;

	// 根据用户名称查询用户
	public List<User> findUserByName(String username) throws Exception;

	// 插入用户
	public void insertUser(User user) throws Exception;

	// 删除用户
	public void deleteUser(int id) throws Exception;

	// 修改用户
	public void updateUser(User user) throws Exception;

	// 通过包装类型查询用户信息
	public List<User> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	// 通过包装类型查询用户信息数
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
}
