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
	private String key;
	private String strKey;

	

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
		boolean flag = userDao.delete(userId);
		if (flag) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String findClass() {
		UserDao userDao = new UserDao();
		userList = userDao.findClass(user.getKey(), user.getStrKey());
		user = userList.get(0);
		if (userList != null) {
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
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getStrKey() {
		return strKey;
	}

	public void setStrKey(String strKey) {
		this.strKey = strKey;
	}

}
