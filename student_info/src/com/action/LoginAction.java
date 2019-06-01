package com.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private User user;             //定义user对象
	
    //执行登录的方法
	public String login() {
		UserDao userDao = new UserDao();
		User u = userDao.login(user.getUserId(), user.getPassword(),user.getType());
		if(u != null) {
			Map<String, Object> session = ServletActionContext.getContext().getSession();
			session.put("user", user.getUserId());
			ServletContext application = ServletActionContext.getServletContext();
			Map<String, Object> userMap = (Map<String, Object>) application.getAttribute("userMap");
			if(userMap == null) {
				userMap = new HashMap<String, Object>();
				userMap.put(user.getUserId(), user.getUserId());
				
			}else {
				userMap.put(user.getUserId(), user.getUserId());
				
			}
			application.setAttribute("userMap", userMap);
			
			
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	//执行注册的方法
	public String register() {
		UserDao userDao = new UserDao();
		boolean flag = userDao.register(user.getUserId(),  user.getUserName(),user.getPassword(), user.getType());
		if(flag) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
