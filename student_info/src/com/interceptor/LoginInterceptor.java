package com.interceptor;

import java.util.Map;

import com.action.LoginAction;
import com.pojo.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
//判断用户是否登录的拦截器
public class LoginInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> session = invocation.getInvocationContext().getSession();
//		User user = (User)session.get("user");
		String user = (String) session.get("user");
		if(user != null) {
			invocation.invoke();
		}else {
			ActionSupport action = (ActionSupport) invocation.getAction();
			if(action != null && action instanceof LoginAction) {
				invocation.invoke();
			}else {
				return "login";
			}
		}
		return null;
	}
}
