package com.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import com.dao.UserDao;
import com.pojo.User;

public class UserListAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private User user;
	private ArrayList<User> userList;
	private String userId;

	public String list() {
		UserDao userDao = new UserDao();
		userList = userDao.list();
		user = userList.get(0);
		if (userList != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String update() {
		UserDao userDao = new UserDao();
		boolean flag = userDao.update(user);
		if (flag) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String add() {
		UserDao userDao = new UserDao();
		boolean flag = userDao.add(user.getUserId(), user.getUserName(),user.getPassword(), user.getType());
		if(flag) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}

	

	public String current() {
		UserDao userDao = new UserDao();
		user = userDao.queryByUserId(userId);
		if (user != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String delete() {
		UserDao userDao = new UserDao();
		boolean flag = userDao.delete(user);
		if (flag) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
