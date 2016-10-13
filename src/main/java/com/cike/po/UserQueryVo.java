package com.cike.po;

public class UserQueryVo {
	//用户信息
	private User user;
	
	//自定义user的扩展对象
	private UserCustom userCustom;

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
	
	
}
