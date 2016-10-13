package com.cike.po;

import java.util.List;

public class UserQueryVo {
	//用户信息
	private User user;
	
	//自定义user的扩展对象
	private UserCustom userCustom;
	//存储多个id
	private List<Integer> ids;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	
}
