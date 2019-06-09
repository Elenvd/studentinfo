package com.action;

import java.util.ArrayList;

import com.dao.DepartmentDao;
import com.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Department;

public class DepartmentListAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Department department;
	private ArrayList<Department> departmentList;
	private String id;
	private String key;
	private String strKey;

	

	public String list() {
		DepartmentDao departmentDao = new DepartmentDao();
		departmentList = departmentDao.list();
		department = departmentList.get(0);
		if(departmentList != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
		
	}
	 
	public String update() {
		DepartmentDao departmentDao = new DepartmentDao();
		boolean flag = departmentDao.update(department);
		if (flag) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String add() {
		DepartmentDao departmentDao = new DepartmentDao();
		boolean flag = departmentDao.add(department.getId(), department.getDepartmentName());
		if(flag) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	public String current() {
		DepartmentDao departmentDao = new DepartmentDao();
		department = departmentDao.queryById(id);
		if (department != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String delete() {
		DepartmentDao departmentDao = new DepartmentDao();
		boolean flag = departmentDao.delete(id);
		if (flag) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String findClass() {
		DepartmentDao departmentDao = new DepartmentDao();
		departmentList = departmentDao.findClass(department.getKey(), department.getStrKey());
		department = departmentList.get(0);
		if (departmentList != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
